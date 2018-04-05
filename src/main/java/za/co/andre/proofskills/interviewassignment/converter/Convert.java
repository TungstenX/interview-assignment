package za.co.andre.proofskills.interviewassignment.converter;

import za.co.andre.proofskills.interviewassignment.data.Login;

/**
 * Simple helper, thought there will be more, so all alone little helper...
 *
 * @author Andr&eacute; Labuschagn&eacute; <andre@ParanoidAndroid.co.za>
 */
public class Convert {

    public static Login Convert(org.springframework.security.core.Authentication a) {
        Login ret = new Login(a.getPrincipal().toString(), a.getCredentials().toString());
        return ret;
    }
}
