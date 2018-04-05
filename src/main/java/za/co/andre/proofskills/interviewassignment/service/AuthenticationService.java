package za.co.andre.proofskills.interviewassignment.service;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import za.co.andre.proofskills.interviewassignment.data.Login;
import za.co.andre.proofskills.interviewassignment.data.Token;
import za.co.andre.proofskills.interviewassignment.data.User;
import static za.co.andre.proofskills.interviewassignment.service.Constants.PATH_AUTH;
import static za.co.andre.proofskills.interviewassignment.service.Constants.PATH_ME;
import static za.co.andre.proofskills.interviewassignment.service.Constants.URL_BASE;

/**
 *
 * @author Andr&eacute; Labuschagn&eacute; <andre@ParanoidAndroid.co.za>
 */
@Service
public class AuthenticationService {

    private static final Logger LOG = Logger.getLogger(AuthenticationService.class.getName());

    public Token getToken(Login loginUser) throws AuthenticationException{
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Login> request = new HttpEntity<>(loginUser);
        String url = URL_BASE + PATH_AUTH; //this way the compiler optimise the concatination of strings
        ResponseEntity<Token> response = restTemplate.postForEntity(url, request, Token.class);
        LOG.log(Level.INFO, "Got the following from server:\n\t{0}", response.getBody());
        if (response.getStatusCode() == HttpStatus.OK) {
            return response.getBody();
        } else {
            StringBuilder sb = new StringBuilder("Error while calling ");
            sb.append(url).append(" : ").append(response.getStatusCode());            
            LOG.log(Level.SEVERE, sb.toString());
            throw new BadCredentialsException(sb.toString());
        }
    }

    public User getMe(Token token) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", token.toString());

        HttpEntity<String> entity = new HttpEntity<>("parameters", headers);

        String url = URL_BASE + PATH_ME; //this way the compiler optimise the concatination of strings
        ResponseEntity<User> response = restTemplate.exchange(url, HttpMethod.GET, entity, User.class);
        LOG.log(Level.INFO, "Got the following from server:\n\t{0}", response.getBody());
        if (response.getStatusCode() == HttpStatus.OK) {
            return response.getBody();
        } else {
            LOG.log(Level.SEVERE, "Error while calling {0}: {1}", new Object[]{url, response.getStatusCode()});
        }
        return null;
    }
}
