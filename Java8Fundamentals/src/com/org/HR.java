package com.org;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class HR {
    public static void main(String[] args) {
        commonSubstring(Arrays.asList("ab", "cd", "ef", "A"), Arrays.asList("af", "ee", "ef", "az"));


    }

    public static void commonSubstring(List<String> a, List<String> b) {
        for(int i=0; i < a.size(); i++){
            String s1 = a.get(i)== null? "" : a.get(i);
            String s2 = b.get(i)== null? "" : b.get(i);

            List<Character> charList1 = s1.chars().mapToObj(e -> (char) e).collect(Collectors.toList());
            List<Character> charList2 = s2.chars().mapToObj(e -> (char) e).collect(Collectors.toList());

            charList1.retainAll(charList2);
            System.out.println(charList1.size()> 0? "YES" : "NO");
        }

    }
}
