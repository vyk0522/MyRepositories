package com.onejava.extra;

import java.util.*;
import java.util.stream.Stream;

public class ST {
    public static void main(String[] args) {
        System.out.println(getMostVisited(5, Arrays.asList(5, 2, 1, 5)));

    }

    public static int getMostVisited(int n, List<Integer> sprints) {
        Map<Integer, Integer> map = new TreeMap<>(Collections.reverseOrder());

        // 2, 4, 1, 3
        for (int i = 0; i < sprints.size() -1; i++) {
            int start = sprints.get(i);
            int end = sprints.get(i+1);
            if(start > end){
                int tmp = end;
                end = start;
                start = tmp;
            }

            for (int j = start; j <= end ; j++) {
                Integer frequency = map.get(j);
                map.put(j, frequency== null ? 1 : frequency+ 1);
            }
        }
        map.put(3, 3);
        System.out.println(map);
        return map.entrySet().stream().max((entry1, entry2) -> entry1.getValue() > entry2.getValue() ? 1 : -1).get().getKey();

    }
}
