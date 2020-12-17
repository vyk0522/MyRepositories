package com.onejava.extra.url;

public class A {
    public static void main(String[] args) {
        System.out.println(m1());
    }

    static int m1(){
        try {
            int i= 10/0;
            return 1;
        }
        catch (ArithmeticException e){
            return 2;
        }
        finally {
            return 3;
        }
    }
}
