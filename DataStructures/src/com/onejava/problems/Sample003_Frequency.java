package com.onejava.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Sample003_Frequency {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("aa", "bb", "aa", "cc", "bb", "aa", "dd", "bb");
        findFrequency(names);

        System.out.println(leastFrequentBird(Arrays.asList(1, 2, 3, 4, 5, 4, 3, 2, 1, 3, 4)));
    }

    private static <X> Map<X, Integer> findFrequency(List<X> names) {
        Map<X, Integer> map = new HashMap<>();
        for(X name : names){
            Integer frequency = map.get(name);
            frequency = frequency == null ? 1 : ++frequency;
            map.put(name, frequency);
        }
        System.out.println(map);
        return map;
    }

    private static Integer leastFrequentBird(List<Integer> list){
        Map<Integer, Integer> map = list.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.summingInt(e -> 1)));
        return map.keySet()
                .stream()
                .min((e1, e2) -> map.get(e2).compareTo(map.get(e1))).orElse(0);
    }

}
