package com.onejava.sort;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] a = {7, 5, 2, 4, 3, 9, 1};
        sort(a);
        System.out.println(Arrays.toString(a));
    }

    public static void sort(int[] a){
        int n = a.length;
        for(int i = 0; i < n - 1; i++){
            for (int j = 0; j < n -1- i; j++) {
                if (a[j] > a[j+1]){
                    swap(a, j, j+1);
                }
            }

        }

    }

    private static void swap(int[] a, int i, int j){
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
