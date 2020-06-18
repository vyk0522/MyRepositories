package com.onejava;

import java.util.Arrays;
import java.util.List;

public class Sample009 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        System.out.println(numbers.stream()
                                  .filter(e -> e % 2 == 0)
                                  .mapToInt(e -> e * 2)
                                  .sum());
        // Concurrent code method1
        System.out.println(numbers.parallelStream()
                                  .filter(e -> e % 2 ==0)
                                  .mapToInt(e -> e * 2)
                                  .sum());

        // Concurrent code method2
        System.out.println(numbers.stream()
                                  .parallel()
                                  .filter(e -> e % 2 == 0)
                                  .mapToInt(e -> e * 2)
                                  .sum());

        numbers.stream()
               .parallel()
               .forEach(System.out::print); // unordered, concurrent

        System.out.println();

        numbers.stream()
               .parallel()
               .forEachOrdered(System.out::print); //ordered, concurrent
    }
}
