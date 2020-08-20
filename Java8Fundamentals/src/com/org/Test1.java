package com.org;

import java.security.cert.CollectionCertStoreParameters;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Test1 {

    public static void main(String[] args) {
        System.out.println(oddNumbers(3, 10));
        System.out.println(concatenate("abc", "def"));
        System.out.println(concatenate("ab", "zsd"));

        System.out.println(getTotalCandlesBurnt(10,2,5));
        System.out.println(getTotalCandlesBurnt(6,2,2));

    }

    public static List<Integer> oddNumbers(int l, int r) {
        ArrayList<Integer> nums = new ArrayList<>();
        IntStream.rangeClosed(l, r).filter(e -> e % 2 != 0).sum();
        System.out.println();
        return nums;

    }



    public static int getTotalCandlesBurnt(int amount, int costOfCandle, int noOfResidueCandles){
        int total = amount / costOfCandle;
        double extra = (double) total / noOfResidueCandles;




        /*int numberOfCandles = amount / costOfCandle; // 6 2 2
        double d = (double) numberOfCandles / noOfResidueCandles;
        int exraCandles = (int) Math.ceil(d);
        return numberOfCandles + exraCandles;*/
        int numberOfCandles = amount / costOfCandle; // 6 2 2
        double exraCandles = (double) numberOfCandles/ noOfResidueCandles;


        return 0;

    }

    public static String concatenate(String a, String b) {
        StringBuffer sb = new StringBuffer();
        char[] s1a = a.toCharArray();
        char[] s2a = b.toCharArray();
        int size = s2a.length;
        for(int i = 0; i < s1a.length ; i++){
            sb.append(s1a[i]);
            if (size > 0){
                sb.append(s2a[i]);
                size--;
            }

        }
        if (size > 0){
            sb.append(b.substring(b.length()-size));
        }

     return sb.toString();
    }

    private static int calculateResidue(int currentTotalResidue, int ration){

        int consume = currentTotalResidue/ration;

        int remain = currentTotalResidue%ration;

        if(remain!= 0){

            int result = calculateResidue(consume+remain,  ration);
            return consume+result;
        }else{
            return consume;
        }


    }

}
