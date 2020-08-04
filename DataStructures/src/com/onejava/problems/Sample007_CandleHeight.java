package com.onejava.problems;

public class Sample007_CandleHeight {
    public static void main(String[] args) {
        int[] a = {3,2,1,3};
        System.out.println(birthdayCakeCandles(a));
    }

    /*
    Count of max element in the list -- Max: 3 and Count: 2
     */
    private static int birthdayCakeCandles(int[] a) {
        int max = -1;
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            if(a[i] > max){
                max = a[i];
                count = 1;
            }
            else if(a[i] == max){
                count++;
            }
        }
        return count;
    }
}
