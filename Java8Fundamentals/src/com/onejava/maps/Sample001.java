package com.onejava.maps;

import java.util.*;
import java.util.stream.Collectors;

public class Sample001 {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("a", 2);
        map.put("b", 9);
        map.put("z", 3);
        map.put("c", 9);


        Set<String> strings = map.keySet();
        Collection<Integer> values = map.values();
        Set<Map.Entry<String, Integer>> entries = map.entrySet();

        List<String> result = entries.stream().filter(e -> e.getValue() > 2).map(e -> e.getKey()).sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println(result);

        String s = entries.stream().max(Comparator.comparing(Map.Entry::getValue)).map(Map.Entry::getKey).get();
        System.out.println(s);


    }

}
