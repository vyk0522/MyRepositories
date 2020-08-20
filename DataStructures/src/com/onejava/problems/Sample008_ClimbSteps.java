package com.onejava.problems;

import java.util.Arrays;

public class Sample008_ClimbSteps {
    public static void main(String[] args) {
        int i = fibonacci1(9);
        int j = fibonacci2(9);
        int k = fibonacci3(9);
        System.out.print(i);
        System.out.print(" " + j);
        System.out.print(" " + k);
        System.out.println();

        int count = countNumberOfWaysToClimbOneOrTwoStepsAtATime(10);
        System.out.println(count);

        count = countNumberOfWaysToClimbOneOrTwoStepsAtATime2(10);
        System.out.println(count);
    }

    private static int countNumberOfWaysToClimbOneOrTwoStepsAtATime(int n) {
        int i = fibonacci1(n);
        int j = fibonacci1(n-1);
        return i + j;
    }

    private static int countNumberOfWaysToClimbOneOrTwoStepsAtATime2(int n) {
        return fibonacci1(n+1);
    }


    private static int fibonacci1(int n){
        if (n <= 1){
            return n;
        }
        return fibonacci1(n-2) + fibonacci1(n-1);
    }

    private static int fibonacci2(int n){
        int[] a = new int[n+1];
        a[0] = 0;
        a[1] = 1;
        for (int i = 2; i <= n; i++) {
            a[i] = a[i-1] + a[i-2];
        }
        System.out.println(Arrays.toString(a));
        return a[n];
    }

    private static int fibonacci3(int n){
        int a=0, b=1, c=0;
        if(n==0){
            return 0;
        }
        for (int i = 2; i <= n ; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return b;
    }


}
