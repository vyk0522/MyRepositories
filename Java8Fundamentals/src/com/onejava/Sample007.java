package com.onejava;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Sample007 {
        public static void main(String[] args) {
        // Start with 100, create a infinite series
        // Infinite stream can n't exist without laziness
        // Laziness can n't exist without no side effects
        // No side effects can n't exist without immutability
        // immutability -> No side effects --> Laziness --> Infinite stream
            Stream.iterate(100, e -> e +1);  // infinite of 100, 101, 102...

         // Given a number k, and a count n
         // Get the total of double of n even numbers
         // starting with k where sqrt of each number is > 20
        int k =121;
        int n=51;
        System.out.println(compute(k,n));


        // To get nth element from the list
            List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6);
            List<Integer> collect = integers.stream().skip(4).limit(1).collect(Collectors.toList());
            System.out.println(collect.get(0));

    }

    private static int compute(int k, int n) {
        return Stream.iterate(k, e -> e + 1) //unbounded, lazy
                     .filter(e -> e % 2 == 0) //unbounded, lazy
                     .filter(e -> Math.sqrt(e) > 20) //unbounded, lazy
                     .mapToInt(e -> e * 2) //unbounded, lazy
                     .limit(n) //sized, lazy
                     .sum(); //
    }
}
