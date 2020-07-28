package com.onejava.sort;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] a = {7, 5, 2, 4, 3, 9, 1};
        sort(a);
        System.out.println(Arrays.toString(a));
    }

    public static void sort(int[] a) {
        int n = a.length;
        for (int i = 1; i < n; i++) {
            int item = a[i];
            int j = i;

            while(j > 0 && a[j-1] > item){
                a[j] = a[j-1];
                j--;
            }
            a[j] = item;
        }
    }
}
