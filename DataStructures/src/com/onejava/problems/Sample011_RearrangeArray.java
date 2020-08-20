package com.onejava.problems;

import java.util.Arrays;

public class Sample011_RearrangeArray {
    public static void main(String[] args) {
        int a[] = {1, 2, 3,4, 5, 6,7};
        rearrangeArrayInMinMaxForm(a);
    }

    private static void rearrangeArrayInMinMaxForm(int[] a) {
        int n = a.length, i=0, j=n-1, k=0;
        int[] temp = new int[n];
        while(i < j){
            temp[k] = a[j];
            temp[k+1]= a[i];
            i++;
            j--;
            k= k+2;
        }
        if (a.length % 2 != 0){
            temp[k] = a[i];
        }
        a = temp.clone();
        System.out.println(Arrays.toString(a));
    }


}
