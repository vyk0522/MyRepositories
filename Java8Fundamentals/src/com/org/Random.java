package com.org;

import java.util.*;

public class Random {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(10,5,1,10,5));
        HashSet<Integer> set = new HashSet<>();
        list.removeIf(e -> ! set.add(e));
        System.out.println(list);


    }
}
