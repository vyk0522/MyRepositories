package com.org;

public class Recursion {
    public static void main(String[] args) {
        System.out.println(calculate(5));
        System.out.println((int)calculateBurnableCandles(3,2));
        System.out.println((int)calculateBurnableCandles(5,5));
    }

    public static int calculate(int n){
        if(n < 2) return 1;
        return n * calculate(n-1);
    }

    public static double calculateBurnableCandles(int burnable, int residueNo){
        int nextBurnable = burnable/residueNo;
        double nextWhole = (double) burnable/residueNo;
        double unUsed =  nextWhole - nextBurnable;
        if (nextBurnable < 1)
            return 1 + unUsed;

        return burnable + unUsed + calculateBurnableCandles(nextBurnable, residueNo);
    }


}
