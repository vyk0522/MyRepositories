package com.onejava.generics;

public class Sample003 {
    public static void main(String[] args) {
        System.out.println(add(10, 20.0));
    }

    /*
    It accepts any data type which is Subclass to Number
     */
    private static <T extends Number> double add(T a, T b){
        return a.intValue() + b.intValue();
    }
}
