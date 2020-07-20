package com.onejava;

/*
It is one of the implementations of available Authentication.
It authenticates the user by checking valid username and valid password combination
 */
class LoginAuthentiation extends Authentication {

    @Override
    public boolean authenticate(UserDetails inputs) {
        if(inputs == null){
            return false;
        }
        if (! validate(inputs)){
            throw new RuntimeException("UserDetails Validation fails! ");
        }

        return "testuser".equals(inputs.getUserName()) && "testpassword".equals(inputs.getPassword());
    }
}
