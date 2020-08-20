package com.onejava.extra;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] a = {1,2,4}; // 1 3 4 4
        int[] b = {8, 9, 10, 8};
        int aLen = a.length;
        int bLen = b.length;

        int i=0, j=0;

        Arrays.sort(a);
        Arrays.sort(b);

        while(i < aLen && j < bLen){
            if(a[i] == b[j]){
                System.out.println(a[i]);
                i++;
                j++;
            }
            else if(a[i] < b[j]){
                i++;
            }
            else {
                j++;
            }
        }

        if (i < aLen){
            if (a[i] == b[j-1]){
                System.out.println(a[i]);
            }
        }

        else if(j < bLen){
            if (a[i-1] == b[j]){
                System.out.println(b[j]);
            }

        }

    }
}
