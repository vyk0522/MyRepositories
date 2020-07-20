package com.onejava;

/*
It is default implementation of User Authentication.
 */
public class UserAuthenticationImpl implements UserAuthentication {
    @Override
    public boolean authenticateUser(UserDetails userInput, MethodType type) {
        Authentication instance = AuthenticationFactory.getInstance(type);
        if (instance == null)
            throw new RuntimeException("Method type is not supported");

        return instance.authenticate(userInput);
    }
}
