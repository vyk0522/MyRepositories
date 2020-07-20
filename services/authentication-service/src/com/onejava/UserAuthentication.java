package com.onejava;

/*
This is the main API, it takes UserInput DTO and MethodType.
MethodType lets the client to use what kind of authentication they should use. Example: TokenAuthentication, LoginAuthentication
It provides default implementation as well. It gives means to client to have their own implementations
 */
public interface UserAuthentication {
    public boolean authenticateUser(UserDetails userInput, MethodType type);
}
