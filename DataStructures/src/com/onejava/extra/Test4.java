package com.onejava.extra;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Test4 {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        HashMap<Object, Object> output = new HashMap<>();
        map.put(1, "aa");
        map.put(1, "bb");
        map.put(2, "cc");
        map.put(2, "dd");
        map.put(3, "aa");
        map.put(3, "cc");

        List list = null;

        for (Integer str: map.keySet()){
            if (output.get(str) == null){
                list = new ArrayList();
                list.add(map.get(str));
            }
            else{
                list.add(map.get(str));
            }
            output.put(str, list);
        }

        System.out.println(output);




    }
}
