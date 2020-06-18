package com.onejava;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Sample005 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,1,2,3,4,5);
        compute(numbers);
    }

    // Given the numbers
    // Double even numbers
    // put that into list
    public static void compute(List<Integer> numbers){
        List<Integer> doubleOfEven = numbers.stream()
               .filter( e -> e % 2 == 0)
               .map( e -> e * 2)
               .collect(Collectors.toList());
        System.out.println(doubleOfEven);

        // To show the usage of Collectors.toSet()
        Set<Integer> uniqueDoubleOfEven = numbers.stream()
                .filter( e -> e % 2 == 0)
                .map( e -> e * 2)
                .collect(Collectors.toSet());
        System.out.println(uniqueDoubleOfEven);
    }
}
