package com.onejava;

import java.util.Arrays;
import java.util.List;

public class Sample008 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,2,3,5,4,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20);
        // Given an ordered list
        // Find the double of first even number greater than 3
        System.out.println(numbers.stream()
                                  .filter(e -> e > 3)
                                  .filter(e -> e % 2 ==0)
                                  .map(e -> e * 2)
                                  .findFirst()); //8

        // Characteristics of streams
        List<Integer> list = Arrays.asList(1,6,7,2,3,5,1,2,3,4,5,6);
        list.stream()
            .filter(e -> e % 2 == 0)
            .forEach(System.out::print); // 6, 2, 2, 4, 6

        System.out.println();

        // Sorted and distinct elements
        list.stream()
            .filter(e -> e % 2 == 0)
            .sorted()
            .distinct()
            .forEach(System.out::print);  //2, 4, 6
    }
}
