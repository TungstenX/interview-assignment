package za.co.andre.proofskills.interviewassignment.service;

import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import za.co.andre.proofskills.interviewassignment.data.Employee;
import za.co.andre.proofskills.interviewassignment.data.Login;
import za.co.andre.proofskills.interviewassignment.data.Token;
import za.co.andre.proofskills.interviewassignment.spring.AppConfig;

/**
 *
 * @author Andr&eacute; Labuschagn&eacute; <andre@ParanoidAndroid.co.za>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
public class EmployeeServiceTest {

    private static final Logger LOG = Logger.getLogger(EmployeeServiceTest.class.getName());
    private Login loginUser;
    @Autowired
    private AuthenticationService authenticationService;
    @Autowired
    private EmployeeService employeeService;

    public EmployeeServiceTest() {
    }

    @BeforeClass
    public static void setUpClass() {

    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        if (loginUser == null) {
            loginUser = new Login("pravin.gordhan", "pravin.gordhan");
        }
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testGetAll() {
        assertNotNull(authenticationService);
        Token token = authenticationService.getToken(loginUser);
        assertNotNull(token);
        Employee[] employees = employeeService.getAll(token);
        assertNotNull(employees);

    }

    @Test
    public void testFilter() {
        assertNotNull(authenticationService);
        Token token = authenticationService.getToken(loginUser);
        assertNotNull(token);
        Employee[] employees = employeeService.getAll(token);
        assertNotNull(employees);
        assertEquals(employees.length, 10);
        //Integer position,
//            Integer start_date_range, Integer user, String gender,
//            Integer birth_date_range, String email__contains
        //race
        employees = employeeService.filter(token, employees[0].getRace(), null, null, null, null, null, null);
        assertNotNull(employees);
        assertEquals(employees.length, 4);
        //posistion
        employees = employeeService.filter(token, null, employees[0].getPosition().getId(), null, null, null, null, null);
        assertNotNull(employees);
        assertEquals(employees.length, 5);
        //start_date_range     ???   
//        employees = employeeService.filter(token, null, employees[0].getPosition().getId(), null, null, null, null, null);
//        assertNotNull(employees);
//        assertEquals(employees.length, 5);
        //user
        employees = employeeService.filter(token, null, null, null, employees[0].getUser().getId(), null, null, null);
        assertNotNull(employees);
        assertEquals(employees.length, 1);
        //gender
        employees = employeeService.filter(token, null, null, null, null, employees[0].getGender(), null, null);
        assertNotNull(employees);
        assertEquals(employees.length, 8);
        //birthdayrange
//        employees = employeeService.filter(token, null, null, null, null, employees[0].getGender(), null, null);
//        assertNotNull(employees);
//        assertEquals(employees.length, 1);
        //Email constraint
        String ec = employees[0].getEmail().substring(0, employees[0].getEmail().indexOf("@"));
        employees = employeeService.filter(token, null, null, null, null, null, null, ec);
        assertNotNull(employees);
        assertEquals(employees.length, 1);
    }
}
