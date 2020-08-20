package com.onejava.reflection;

import com.onejava.reflection.Model.BankAccount;

import java.lang.reflect.Modifier;

public class Sample001 {
    public static void main(String[] args) throws ClassNotFoundException {
        BankAccount account = new BankAccount();

        // Different ways to get the class instance
        Class<?> c = account.getClass();
        Class<?> c2 = Class.forName("com.onejava.reflection.Model.BankAccount"); // ClassNotFoundException
        Class<BankAccount> c3 = BankAccount.class;

        System.out.println(c.getSimpleName()); // Name of the class

        Class<?> superclass = c.getSuperclass(); // Returns its super class
        Class<?>[] interfaces = c.getInterfaces(); // Array of interfaces it implements
        int modifiers = c.getModifiers(); // To check whether the class is final, private, public etc..

        if(Modifier.isFinal(modifiers)){
            System.out.println("Class is final");
        }
        else if(Modifier.isPublic(modifiers)){
            System.out.println("Class is Public");
        }
    }
}
