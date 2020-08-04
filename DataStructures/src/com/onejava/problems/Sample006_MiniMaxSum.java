package com.onejava.problems;

import java.util.Arrays;

public class Sample006_MiniMaxSum {
    public static void main(String[] args) {
        int[] a = {11,3,11,7,9,11};
        miniMaxSum(a);
        miniMaxSum2(a);
    }

    private static void miniMaxSum(int[] arr) {
        Arrays.sort(arr);
        int max = Arrays.stream(arr).skip(1).sum();
        // long max = Arrays.stream(arr).asLongStream().skip(1).sum();
        int min = Arrays.stream(arr).limit(4).sum();
        System.out.println(min + " " + max);
    }

    private static void miniMaxSum2(int[] arr) {
        Arrays.sort(arr);
        int min=0, max=0, n= arr.length;
        for (int i = 0; i < n ; i++) {
            if(i < n-1){
                min = min + arr[i];
            }
            if(i > 0){
                max = max + arr[i];
            }
        }
        System.out.println(min + " " + max);
    }
}
