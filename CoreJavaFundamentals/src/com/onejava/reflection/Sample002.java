package com.onejava.reflection;

import com.onejava.reflection.Model.BankAccount;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/*
To illustrate method invocation using Reflection
 */
public class Sample002 {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        BankAccount account = new BankAccount("1234", 500);
        callGetIdMethod(account);
        callDepositMethod(account, "5678", 50);
        System.out.println("Balance and ID after callDepositMethod invocation: "
                + account.getBalance()+ ", id: " + account.getId());
    }

    private static void callGetIdMethod(Object obj) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<?> c = obj.getClass();
        Method m = c.getMethod("getBalance"); // NoSuchMethodException
        Object result = m.invoke(obj); // InvocationTargetException, IllegalAccessException
        System.out.println("Result: " + result);
    }

    /*
    We can pass method arguments by comma separating it. Order should be same as method signature
     */
    private static void callDepositMethod(Object obj, String id, int amount) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<?> c = obj.getClass();
        Method m = c.getMethod("deposit", String.class, int.class);
        Object result = m.invoke(obj, id, amount);
        System.out.println(result);
    }
}
