package com.onejava;

/*
It is one of the implementations of available Authentication.
It authenticates the user by checking whether the credential has only lower case characters
 */
class TokenAuthentication extends Authentication {
    @Override
    public boolean authenticate(UserDetails inputs) {
        if(inputs == null){
            return false;
        }
        if (! validate(inputs)){
            throw new RuntimeException("UserDetails Validation fails! ");
        }

        return inputs.getPassword().equals(inputs.getPassword().toLowerCase());
    }
}
