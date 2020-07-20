package com.org;

import com.onejava.MethodType;
import com.onejava.UserAuthenticationImpl;
import com.onejava.UserDetails;

public class client {
    public static void main(String[] args) {
        UserDetails user = new UserDetails("testuser", "testpassword");
        UserAuthenticationImpl userAuthentication = new UserAuthenticationImpl();
        boolean authenticUser = userAuthentication.authenticateUser(user, MethodType.LOGINMETHOD);
        System.out.println("User is authentic: " + authenticUser); // It should be true

        user = new UserDetails("testuser", "testpasswordd");
        authenticUser = userAuthentication.authenticateUser(user, MethodType.LOGINMETHOD);
        System.out.println("User is authentic: " + authenticUser); // It should be false

        user = new UserDetails("testuser", "testpassword&%$");
        authenticUser = userAuthentication.authenticateUser(user, MethodType.TOKENMETHOD);
        System.out.println("User is authentic: " + authenticUser); // It should be true

        user = new UserDetails("testuser", "testpasswordD");
        authenticUser = userAuthentication.authenticateUser(user, MethodType.TOKENMETHOD);
        System.out.println("User is authentic: " + authenticUser); // It should be false
    }
}
