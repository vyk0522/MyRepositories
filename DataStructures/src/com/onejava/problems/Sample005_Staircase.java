package com.onejava.problems;

public class Sample005_Staircase {
    public static void main(String[] args) {
        staircase(5);
    }
    private static void staircase(int n) {
        for (int i = 1; i <= n; i++) {
            int k = n;
            while(k > i){
                System.out.print(" ");
                k--;
            }
            while(k >= 1){
                System.out.print("#");
                k--;
            }
            System.out.println();
        }

    }
}
