package com.onejava.problems;

import java.util.Arrays;

public class Sample010_Pangram {
    public static void main(String[] args) {
        String[] sentences = {"Pack my box with five dozen liquor jugs",
        "Jackdaws love my big sphinx of quartz", "The five boxing izards jump quickly"};

        Arrays.stream(sentences).forEach(e -> System.out.println(isPangram(e)));
        Arrays.stream(sentences).map(Sample010_Pangram::isPangram).forEach(System.out::println);

        String s = "xcZM561";  // D U L
        char[] chars = s.toCharArray();
        System.out.println(chars);
        Arrays.sort(chars);
        System.out.println(chars);


    }

    private static boolean isPangram(String str){
        return str.toUpperCase()
                .replaceAll("[^A-Z]", "")
                .chars()
                .distinct()
                .count() == 26;
    }

}
