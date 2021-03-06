package za.co.andre.proofskills.interviewassignment.spring;

import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import za.co.andre.proofskills.interviewassignment.converter.Convert;
import za.co.andre.proofskills.interviewassignment.data.Login;
import za.co.andre.proofskills.interviewassignment.data.Token;
import za.co.andre.proofskills.interviewassignment.service.AuthenticationService;

/**
 * Nice piece of magic to use the server to log in... ;-)
 *
 * @author Andr&eacute; Labuschagn&eacute; <andre@ParanoidAndroid.co.za>
 */
@Component
public class MyAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private AuthenticationService authenticationService;

    /**
     * Auth against the server
     *
     * @param a
     * @return
     * @throws AuthenticationException
     */
    @Override
    public Authentication authenticate(Authentication a) throws AuthenticationException {
        Login login = Convert.Convert(a);
        try {
            Token token = authenticationService.getToken(login);
            List<SimpleGrantedAuthority> ga;
            //Hard coded - sies!
            if (login.getUsername().toLowerCase().startsWith("pravin")) {
                ga = Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"), new SimpleGrantedAuthority("ROLE_ADMIN"));
            } else {
                ga = Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
            }
            return new MyAuthenticationToken(login.getUsername(), login.getPassword(), ga, token);
        } catch (BadCredentialsException e) {
            throw new UsernameNotFoundException(e.getMessage());
        }
    }

    /**
     * What we will tolerate ;-)
     *
     * @param type
     * @return
     */
    @Override
    public boolean supports(Class<?> type) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(type);
    }
}
