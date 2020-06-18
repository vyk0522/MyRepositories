package com.onejava;

import com.onejava.util.TimeIt;

import java.util.Arrays;
import java.util.List;

// To know the time taken to execute block of code
// When we used parallelStream
public class Sample004 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        TimeIt.code( () ->
        System.out.println(numbers.parallelStream()
               .filter(e -> e%2==0)
               .mapToInt(Sample004::compute)
               .sum()));

    }

    private static int compute(Integer number) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return number*2;
    }
}
