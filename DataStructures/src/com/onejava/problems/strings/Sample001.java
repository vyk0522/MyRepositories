package com.onejava.problems.strings;

import java.util.Arrays;

public class Sample001 {
    public static void main(String[] args) {
        System.out.println(camelCase("eclipseRCPExt"));
    }
    private static int camelCase(String s){
        String[] a = s.split("(?<=[a-z])(?=[A-Z])");
        String[] b = s.split("(?<=[a-z])(?=[A-Z])|(?<=[A-Z])(?=[A-Z][a-z])");
        System.out.println(Arrays.asList(a));
        System.out.println(Arrays.asList(b));
        return a.length;
    }
}
