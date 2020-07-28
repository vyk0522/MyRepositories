package com.onejava.problems;

import java.util.Arrays;
import java.util.List;

public class Sample004_Compression {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("a", "a", "b", "a", "c", "c", "d", "z");
        findCompression(names);
        names = Arrays.asList("a", "a", "b", "a", "c", "c", "d", "d");
        System.out.println();
        findCompression(names);
    }

    private static void findCompression(List<String> names) {
        int count= 1;
        for (int i = 0; i < names.size() -1; i++) {
            if(names.get(i).equals(names.get(i+1))){
                count++;
            }
            else{
                System.out.print(names.get(i) + count + ", ");
                count = 1;
            }
        }
        System.out.print(names.get(names.size() -1) + count);

    }
}
