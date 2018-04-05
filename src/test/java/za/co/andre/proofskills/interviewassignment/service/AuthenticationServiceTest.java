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
import za.co.andre.proofskills.interviewassignment.data.Login;
import za.co.andre.proofskills.interviewassignment.data.Token;
import za.co.andre.proofskills.interviewassignment.data.User;
import za.co.andre.proofskills.interviewassignment.spring.AppConfig;

/**
 *
 * @author Andr&eacute; Labuschagn&eacute; <andre@ParanoidAndroid.co.za>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
public class AuthenticationServiceTest {

    private static final Logger LOG = Logger.getLogger(AuthenticationServiceTest.class.getName());
    private Login loginUser;
    @Autowired
    private AuthenticationService authenticationService;

    public AuthenticationServiceTest() {
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
    public void testGetToken() {
        assertNotNull(authenticationService);
        Token token = authenticationService.getToken(loginUser);
        assertNotNull(token);
    }
    
        @Test
    public void testGetMe() {
        assertNotNull(authenticationService);
        Token token = authenticationService.getToken(loginUser);
        assertNotNull(token);
        User user = authenticationService.getMe(token);
        assertNotNull(user);
    }
}
