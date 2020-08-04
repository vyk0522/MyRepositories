package com.com.org;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import static java.util.stream.Collectors.*;

public class Test {
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
