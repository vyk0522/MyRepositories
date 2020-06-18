package com.onejava;

import java.util.Arrays;
import java.util.List;

public class Sample003 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        compute(numbers);

    }

    // Given the numbers
    // Double the even numbers
    // And total
    public static void compute(List<Integer> numbers){

        System.out.println(numbers.stream()
                                  .filter(e -> e % 2 == 0)
                                  .map( e -> e *2)
                                  .reduce(0, Integer::sum));

        System.out.println(numbers.stream()
                                  .filter( e -> e % 2 == 0)
                                  .mapToInt( e -> e * 2)
                                  .sum());


    }
}
