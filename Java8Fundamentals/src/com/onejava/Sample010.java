package com.onejava;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Sample010 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        use(numbers.stream());

        System.out.println();
        // If you are source of the stream
        numbers.parallelStream()
               .forEach(System.out::print);

        System.out.println();
        use1(numbers.stream());
    }

    // It runs sequentially, not parallel as sequential() is the last one and takes the preference
    private static void use1(Stream<Integer> stream) {
        stream.parallel()
              .map(e -> e)
              .sequential()
              .forEach(System.out::print);
    }

    // If you are receiving the stream
    private static void use(Stream<Integer> stream) {
        stream.parallel()
              .forEach(System.out::print);
        System.out.println();
    }
}
