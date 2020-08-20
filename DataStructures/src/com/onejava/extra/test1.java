package com.onejava.extra;

public class test1 {
    public static void main(String[] args) {
        //String[] inputs = {"91011", "7891011", "9899100", "160099024160099025160089026"};
        String[] inputs = {"90071992547409929007199254740993"};
        for(String input : inputs){
            compute(input);
        }

    }

    private static void compute(String input) {
        int n = input.length();

        for (int i = 1; i <= n / 2; i++) {
            StringBuilder output = new StringBuilder(input.substring(0, i));
            Long number = Long.parseLong(output.toString());



            while (output.length() < n){
                output.append(++number);
            }

            if (output.toString().equals(input)){
                System.out.println("YES " + Long.parseLong(input.substring(0, i)));
                return;
            }

        }

        System.out.println("NO");;
    }


}
