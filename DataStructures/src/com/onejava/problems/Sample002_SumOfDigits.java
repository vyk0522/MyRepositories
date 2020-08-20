package com.onejava.problems;

import java.util.Arrays;
import java.util.List;

public class Sample002_SumOfDigits {
    public static void main(String[] args) {
        int n = 522;
        int result = calculate(n);
        //System.out.println(result);
        List<Integer> integers = Arrays.asList(123456789, 114108089, 110110015, 121, 33, 44, 55, 66, 77, 88, 106108048);
        integers.stream().forEach(e-> System.out.println(findDigits(e)));
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

    private static int findDigits(Integer n){
        Integer temp = n;
        int count = 0;
        while(temp > 0){
            int result = temp % 10 ;
            if(result !=0 && n % result == 0){
                count++;
            }
            temp = temp / 10;
        }
        return count;
    }
}
