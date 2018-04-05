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
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import za.co.andre.proofskills.interviewassignment.data.Employee;
import za.co.andre.proofskills.interviewassignment.data.Profile;
import za.co.andre.proofskills.interviewassignment.data.Token;
import static za.co.andre.proofskills.interviewassignment.service.Constants.PATH_PROFILE;
import static za.co.andre.proofskills.interviewassignment.service.Constants.URL_BASE;

/**
 *
 * @author Andr&eacute; Labuschagn&eacute; <andre@ParanoidAndroid.co.za>
 */
@Service
public class MyProfileService {

    private static final Logger LOG = Logger.getLogger(MyProfileService.class.getName());

    public Profile getProfile(Token token) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", token.toString());

        HttpEntity<String> entity = new HttpEntity<>("parameters", headers);

        String url = URL_BASE + PATH_PROFILE; //this way the compiler optimise the concatination of strings
        ResponseEntity<Profile> response = restTemplate.exchange(url, HttpMethod.GET, entity, Profile.class);
        LOG.log(Level.INFO, "Got the following from server:\n\t{0}", response.getBody());
        if (response.getStatusCode() == HttpStatus.OK) {
            return response.getBody();
        } else {
            LOG.log(Level.SEVERE, "Error while calling {0}: {1}", new Object[]{url, response.getStatusCode()});
        }
        return null;
    }
}
