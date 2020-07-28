package com.onejava.sort;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] a = {7, 5, 2, 4, 3, 9, 1};
        sort(a);
        System.out.println(Arrays.toString(a));
    }

    private static void swap(int[] a, int i, int j){
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void sort(int[] a){
        int n = a.length;
        for (int i = 0; i < n -1 ; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (a[j] < a[min]){
                    min = j;
                }
            }
            swap(a, i, min);
        }
    }
}
