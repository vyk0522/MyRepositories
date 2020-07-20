package com.org;

public class Test2 {

    public static void main(String[] args) {
        System.out.println(getTotalCandlesBurnt(6, 2,2));
    }

    static int getTotalCandlesBurnt(int amount, int costOfCandle, int noOfResidueCandles) {

        int num = calculateResidue(amount/costOfCandle, noOfResidueCandles);

        int totalResult = amount/costOfCandle+num;

        return totalResult;
    }

    private static int calculateResidue(int currentTotalResidue, int ration){

        int consume = currentTotalResidue/ration;

        int remain = currentTotalResidue%ration;

        while(remain > 0){

            int result = calculateResidue(consume+remain,  ration);
            return consume+result;
        }

        return consume;


    }
}
