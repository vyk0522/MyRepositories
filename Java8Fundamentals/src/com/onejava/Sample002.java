package com.onejava;

import java.util.Arrays;
import java.util.List;

public class Sample002 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3);

        // Internal iterator
        // forEach takes lambda expression
        numbers.forEach(e -> System.out.println(e));
        // Using method references
        numbers.forEach(System.out::println);

        // e -> String.valueOf(e)  As a parameter
        // e -> e.toString()   As a target
        numbers.stream()
               .map(String::valueOf)
               .map(String::toString)
               .forEach(System.out::println);

        System.out.println(numbers.stream()
                                  .map(String::valueOf)
                                  .reduce("", String::concat));  //  (a, b) -> a.concat(b)
    }
}
