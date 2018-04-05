package za.co.andre.proofskills.interviewassignment.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import za.co.andre.proofskills.interviewassignment.service.AuthenticationService;
import za.co.andre.proofskills.interviewassignment.service.EmployeeService;
import za.co.andre.proofskills.interviewassignment.service.MyProfileService;

/**
 * The spring config class, creates 'em magic
 *
 * @author Andr&eacute; Labuschagn&eacute; <andre@ParanoidAndroid.co.za>
 */
@Configuration
@ComponentScan(basePackages = "za.co.andre.proofskills.interviewassignment")
public class AppConfig {

    @Bean
    public AuthenticationService authenticationService() {
        return new AuthenticationService();
    }

    @Bean
    public EmployeeService employeeService() {
        return new EmployeeService();
    }

    @Bean
    public MyProfileService myProfileService() {
        return new MyProfileService();
    }

    @Bean
    public SpringSecurityConfig springSecurityConfig() {
        return new SpringSecurityConfig();
    }
}
