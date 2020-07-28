package com.onejava.sort;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] a = {7, 5, 2, 4, 3, 9, 1};
        mergeSort(a);
        System.out.println(Arrays.toString(a));
    }

    public static void mergeSort(int[] a){
        int n = a.length;

        if(n < 2){
            return;
        }

        int mid = n / 2;
        int[] left = new int[mid];
        int[] right = new int[n-mid];

        for (int i = 0; i < mid ; i++) {
            left[i] = a[i];
        }

        for(int i = mid; i < n; i++){
            right[i-mid] = a[i];
        }

        mergeSort(left);
        mergeSort(right);
        merge(left, right, a);
    }

    public static void merge(int[] left, int[] right, int[] a){
        int nLeft = left.length;
        int nRight = right.length;
        int i=0, j=0, k=0;

        while (i < nLeft && j < nRight){
            if (left[i] <= right[j]){
                a[k] = left[i];
                k++;
                i++;
            }
            else{
                a[k] = right[j];
                k++;
                j++;
            }
        }

        while(i < nLeft){
            a[k] = left[i];
            k++;
            i++;
        }

        while(j < nRight){
            a[k] = right[j];
            k++;
            j++;
        }
    }
}
