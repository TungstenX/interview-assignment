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
import org.springframework.web.util.UriComponentsBuilder;
import za.co.andre.proofskills.interviewassignment.data.Employee;
import za.co.andre.proofskills.interviewassignment.data.Token;
import static za.co.andre.proofskills.interviewassignment.service.Constants.PATH_EMPLOYEE;
import static za.co.andre.proofskills.interviewassignment.service.Constants.URL_BASE;

/**
 * Service for employee related data
 *
 * @author Andr&eacute; Labuschagn&eacute; <andre@ParanoidAndroid.co.za>
 */
@Service
public class EmployeeService {

    private static final Logger LOG = Logger.getLogger(EmployeeService.class.getName());

    /**
     * Get all the employees
     *
     * @param token
     * @return
     */
    public Employee[] getAll(Token token) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", token.toString());

        HttpEntity<String> entity = new HttpEntity<>("parameters", headers);

        String url = URL_BASE + PATH_EMPLOYEE; //this way the compiler optimise the concatination of strings
        ResponseEntity<Employee[]> response = restTemplate.exchange(url, HttpMethod.GET, entity, Employee[].class);
        LOG.log(Level.INFO, "Got the following from server:\n\t{0}", response.getBody());
        if (response.getStatusCode() == HttpStatus.OK) {
            return response.getBody();
        } else {
            LOG.log(Level.SEVERE, "Error while calling {0}: {1}", new Object[]{url, response.getStatusCode()});
        }
        return null;
    }

    /**
     * Filter employees on the supplied information
     *
     * @param token
     * @param race
     * @param position
     * @param start_date_range
     * @param user
     * @param gender
     * @param birth_date_range
     * @param email__contains
     * @return
     */
    public Employee[] filter(Token token, String race, Integer position,
            Integer start_date_range, Integer user, String gender,
            Integer birth_date_range, String email__contains) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", token.toString());
        HttpEntity<String> entity = new HttpEntity<>("parameters", headers);

        String url = URL_BASE + PATH_EMPLOYEE; //this way the compiler optimise the concatination of strings

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url);
        if (race != null) {
            builder.queryParam("race", race);
        }
        if (position != null) {
            builder.queryParam("position", position);
        }
        if (start_date_range != null) {
            builder.queryParam("start_date_range", start_date_range);
        }
        if (user != null) {
            builder.queryParam("user", user);
        }
        if (gender != null) {
            builder.queryParam("gender", gender);
        }
        if (birth_date_range != null) {
            builder.queryParam("birth_date_range", birth_date_range);
        }
        if (email__contains != null) {
            builder.queryParam("email__contains", email__contains);
        }

        ResponseEntity<Employee[]> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, Employee[].class);
        LOG.log(Level.INFO, "Got the following from server:\n\t{0}", response.getBody());
        if (response.getStatusCode() == HttpStatus.OK) {
            return response.getBody();
        } else {
            LOG.log(Level.SEVERE, "Error while calling {0}: {1}", new Object[]{url, response.getStatusCode()});
        }
        return null;
    }
}
