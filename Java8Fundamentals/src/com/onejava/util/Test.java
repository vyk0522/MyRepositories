package com.onejava.util;

import java.util.HashSet;
import java.util.Set;

public class Test {

    private int find(String input, int low, int high) {
        Set<String> result = new HashSet<>();
        while (low >= 0 && high < input.length() && input.charAt(low) == input.charAt(high)) {
            result.add(input.substring(low, high + 1));
            low--;
            high++;
        }
        return result.size();
    }


}
