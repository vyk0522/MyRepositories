package com.onejava;

/*
Both high level module and low level module depend on this abstract class
For new method of authentication, you need to extend this class.

 */
 abstract class Authentication {
     /*
     To do some kind of validation checks
      */
    public boolean validate(UserDetails inputs){
        // validation checks
        return true;
    }
    /*
    It is client specific authentication implementation
     */
    public abstract boolean authenticate(UserDetails inputs);
}
