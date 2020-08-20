package com.com.org;

import java.util.*;
import java.util.function.Function;

import static java.util.stream.Collectors.*;

public class Test {

    public static void main(String[] args) {
        ArrayList<Double> objects = new ArrayList<>();
        objects.add(1.0);
        objects.add(4.0);
        objects.add(16.0);
        Spliterator<Double> spliterator = objects.spliterator();
        while (spliterator.tryAdvance((n) -> System.out.print(" " + n)));
        System.out.println();
        spliterator = objects.spliterator();

        ArrayList<Double> gg = new ArrayList<>();
        while (spliterator.tryAdvance((n) -> gg.add(Math.sqrt(n))));
        spliterator = gg.spliterator();
        spliterator.forEachRemaining(n -> System.out.println(" " + n));


    }

    /*public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        List<String> names = Arrays.asList("aa", "bb", "aa", "cc", "bb", "aa", "dd", "bb");
        getFrequency(map, names);

        Map<String, Long> frequencyMap1 = names.stream().collect(groupingBy(e -> e, counting()));
        System.out.println(frequencyMap1);

        Map<String, Long> frequencyMap2 = names.stream().collect(groupingBy(Function.identity(), filtering(e -> e.contains("aa"),counting() )));
        System.out.print(frequencyMap2);


    }*/

    private static void getFrequency(Map<String, Integer> map, List<String> names) {
        for(String name : names){
            Integer frequency= map.get(name);
            frequency = frequency == null ? 1 : ++frequency;
            map.put(name, frequency);
        }
        System.out.println(map);
    }
}
