package com.onejava.extra;

import java.util.*;
import java.util.stream.Collectors;

public class Solution01 {
    public static void main(String[] args) {

       // int solution = solution("88");
       // System.out.println(solution);

        //System.out.println(solution2("aaaabbbb"));
        //System.out.println(solution2("ccaaffddecee"));

        int a[] = {5, 2, 4, 6, 3, 7};

        System.out.println(solution3(a));

    }

    public static int solution(String s){
        Set<Integer> numbers = new HashSet<>();

        for (int i = 0; i < s.length() -1; i++) {
            String token = s.substring(i, i + 2);
            numbers.add(Integer.parseInt(token));
        }
        return numbers.stream().max(Integer::compareTo).get();
    }

    public static int solution3(int[] a){
        List<Integer> result = Arrays.stream(a).boxed().sorted().collect(Collectors.toList());
        return result.get(0) + result.get(1);
    }

    public static int solution2(String s) {
        char[] chars = s.toCharArray();
        List<Character> list = new ArrayList<>();
        for (Character c : chars){
            list.add(c);
        }
        Map<Character, Integer> frequency = findFrequency(list);
        List<Integer> values = frequency.values().stream().sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        Queue<Integer> queue = new PriorityQueue(Comparator.reverseOrder());
        queue.addAll(values);
        int count = 0;

        while (! queue.isEmpty()) {
            Integer max = queue.poll();
            if (queue.isEmpty() ) {
                return count;
            }

            if (max.equals(queue.peek())) {
                if (max > 1) {
                    queue.add(max - 1);
                }
                count++;
            }
        }
        return count;

    }

    private static <X> Map<X, Integer> findFrequency(List<X> chars) {
        Map<X, Integer> map = new HashMap<>();
        for(X name : chars){
            Integer frequency = map.get(name);
            frequency = frequency == null ? 1 : ++frequency;
            map.put(name, frequency);
        }
        return map;
    }


}
