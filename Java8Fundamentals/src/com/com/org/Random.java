package com.com.org;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Random {
    public static void main(String[] args) {
        int[] a = {10, 12, 11, 15};
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));

        String s = "aa";

        for (int i = 1; i < a.length; i++) {
            int start = a[i-1];
            int required = start + 1;
            if (a[i] != required){
                System.out.println(required + " Is Missing");
            }

        }
    }
}
