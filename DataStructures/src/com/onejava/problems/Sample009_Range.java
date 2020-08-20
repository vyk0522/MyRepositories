package com.onejava.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Sample009_Range {
    public static void main(String[] args) {
        System.out.println(oddNumbersBetweenTwo(0, 14));
    }

    public static List<Integer> oddNumbersBetweenTwo(int i, int j) {
        ArrayList<Integer> nums = new ArrayList<>();
        IntStream.rangeClosed(i, j).filter(e -> e % 2 != 0).forEach(nums::add);
        System.out.println(IntStream.rangeClosed(i, j)
                .filter(e -> e % 2 != 0).boxed().collect(Collectors.toList()));
        return nums;
    }
}
