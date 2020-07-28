package com.onejava.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Sample003_Frequency {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("aa", "bb", "aa", "cc", "bb", "aa", "dd", "bb");
        findFrequency(names);
    }

    private static void findFrequency(List<String> names) {
        Map<String, Integer> map = new HashMap<>();
        for(String name : names){
            Integer frequency = map.get(name);
            frequency = frequency == null ? 1 : ++frequency;
            map.put(name, frequency);
        }
        System.out.println(map);
    }
}
