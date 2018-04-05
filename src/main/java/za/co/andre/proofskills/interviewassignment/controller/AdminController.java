/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.andre.proofskills.interviewassignment.controller;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import za.co.andre.proofskills.interviewassignment.data.Employee;
import za.co.andre.proofskills.interviewassignment.data.Token;
import za.co.andre.proofskills.interviewassignment.helper.EmployeeComparator;
import za.co.andre.proofskills.interviewassignment.service.EmployeeService;
import za.co.andre.proofskills.interviewassignment.spring.MyAuthenticationToken;

/**
 *
 * @author Andr&eacute; Labuschagn&eacute; <andre@ParanoidAndroid.co.za>
 */
@Controller
public class AdminController {

    private static final Logger LOG = Logger.getLogger(AdminController.class.getName());
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/admin")
    public String admin(HttpServletRequest httpServletRequest, Model model) {
        try {
            Token token = getAuthToken();
            Employee[] employees = employeeService.getAll(token);
            Arrays.sort(employees, new EmployeeComparator());
            model.addAttribute("employees", employees);
            return "admin";
        } catch (AuthenticationException e) {
            LOG.log(Level.SEVERE, "Something when wrong: {0}", e.toString());
            model.addAttribute("ERROR", "Something when wrong: " + e.toString());
            return "login";
        }
    }
    
    @PostMapping("/filter")
    public String filter(HttpServletRequest httpServletRequest, Model model,
            @RequestParam(value = "race", required = false) String race,
            @RequestParam(value = "position", required = false) Integer position,
            @RequestParam(value = "start_date_range", required = false) Integer startDateRange,
            @RequestParam(value = "user", required = false) Integer userId,
            @RequestParam(value = "gender", required = false) String gender,
            @RequestParam(value = "birth_date_range", required = false) Integer birthDateRange,
            @RequestParam(value = "email__constraint", required = false) String emailConstraint) {
        try {
            if(emailConstraint != null && emailConstraint.isEmpty()) {
                emailConstraint = null;
            }
            Token token = getAuthToken();
            Employee[] employees = employeeService.filter(token, race, position, startDateRange, userId, gender, birthDateRange, emailConstraint);
            Arrays.sort(employees, new EmployeeComparator());
            model.addAttribute("employees", employees);
            return "admin";
        } catch (AuthenticationException e) {
            LOG.log(Level.SEVERE, "Something when wrong: {0}", e.toString());
            model.addAttribute("ERROR", "Something when wrong: " + e.toString());
            return "login";
        }
    }
    
    @PostMapping("/employee")
    public String filter(HttpServletRequest httpServletRequest, Model model,
            @RequestParam(value = "user") Integer userId) {
        try {
            Token token = getAuthToken();
            Employee[] employees = employeeService.filter(token, null, null, null, userId, null, null, null);
            if(employees != null && employees.length >= 1) {// oh boy this can be trouble if user id is not unique, but what is the probability? ¯\_(ツ)_/¯
                model.addAttribute("employee", employees[0]);
            }
            return "employee";
        } catch (AuthenticationException e) {
            LOG.log(Level.SEVERE, "Something when wrong: {0}", e.toString());
            model.addAttribute("ERROR", "Something when wrong: " + e.toString());
            return "login";
        }
    }

    private Token getAuthToken() throws AuthenticationException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication instanceof MyAuthenticationToken) {
            return ((MyAuthenticationToken) authentication).getToken();
        }
         throw new AuthenticationServiceException("Not authenticated, please log in again");
    }
}
