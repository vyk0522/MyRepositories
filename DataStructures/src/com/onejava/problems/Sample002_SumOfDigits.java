package com.onejava.problems;

public class Sample002_SumOfDigits {
    public static void main(String[] args) {
        int n = 522;
        int result = calculate(n);
        System.out.println(result);
    }
// 522 = 5 * 2 * 2 - 5 + 2 + 2 = 11
    private static int calculate(int n) {
        int sum =0;
        int product = 1;
        while(n > 0){
            int result = n % 10;
            sum = sum + result;
            product = product * result;
            n = n / 10;
        }
        return product - sum;
    }
}
