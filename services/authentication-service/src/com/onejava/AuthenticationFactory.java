package com.onejava;

/*
It provides Authentication instances based on given Method Type.
 */
class AuthenticationFactory {
    public static Authentication getInstance(MethodType type) {
        if(MethodType.LOGINMETHOD.equals(type)){
            return new LoginAuthentiation();
        }
        else if(MethodType.TOKENMETHOD.equals(type)){
            return new TokenAuthentication();
        }
       return null;
    }
}
