package za.co.andre.proofskills.interviewassignment.controller;

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
import za.co.andre.proofskills.interviewassignment.data.Profile;
import za.co.andre.proofskills.interviewassignment.data.Token;
import za.co.andre.proofskills.interviewassignment.service.MyProfileService;
import za.co.andre.proofskills.interviewassignment.spring.MyAuthenticationToken;

/**
 * The user controller - as you would have guess...
 *
 * @author Andr&eacute; Labuschagn&eacute; <andre@ParanoidAndroid.co.za>
 */
@Controller
public class UserController {

    private static final Logger LOG = Logger.getLogger(UserController.class.getName());
    @Autowired
    private MyProfileService myProfileService;

    /**
     * User page entry point, will get the profile of the logged in person
     *
     * @param httpServletRequest
     * @param model
     * @return
     */
    @GetMapping("/user")
    public String profile(HttpServletRequest httpServletRequest, Model model) {
        try {
            Token token = getAuthToken();
            Profile profile = myProfileService.getProfile(token);
            model.addAttribute("profile", profile);
            return "user";
        } catch (AuthenticationException e) {
            LOG.log(Level.SEVERE, "Something when wrong: {0}", e.toString());
            model.addAttribute("ERROR", "Something when wrong: " + e.toString());
            return "login";
        }
    }

    /**
     * This should go with it's twin to a base class... Another day...
     *
     * @return
     * @throws AuthenticationException
     */
    private Token getAuthToken() throws AuthenticationException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication instanceof MyAuthenticationToken) {
            return ((MyAuthenticationToken) authentication).getToken();
        }
        throw new AuthenticationServiceException("Not authenticated, please log in again");
    }
}
