/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.andre.proofskills.interviewassignment.converter;

import za.co.andre.proofskills.interviewassignment.data.Login;

/**
 *
 * @author Andr&eacute; Labuschagn&eacute; <andre@ParanoidAndroid.co.za>
 */
public class Convert {

    public static Login Convert(org.springframework.security.core.Authentication a) {
        Login ret = new Login(a.getPrincipal().toString(), a.getCredentials().toString());
        return ret;
    }
}
