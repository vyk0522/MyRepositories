package com.onejava.problems;

import java.util.Arrays;
import java.util.List;

public class Sample013_RiverRecords {
    public static void main(String[] args) {
        System.out.println(maxTrailing(Arrays.asList(5,3,6,7,4)));
        System.out.println(maxTrailing(Arrays.asList(4,3,2,1)));
        System.out.println(countGraphs(4));

    }

    static long power(long x,
                      long y)
    {
        int MOD = (int)1e9 + 7;
        long res = 1;
        while (y > 0)
        {
            if ((y & 1) != 0)
                res = (res * x) % MOD;
            x = (x * x) % MOD;
            y /= 2;
        }
        return res;
    }

    public static int maxTrailing(List<Integer> levels) {
        int result = -1;
        if (levels.size() < 2){
            return result;
        }
        for(int i = 1; i < levels.size(); i ++){
            int j = i-1;
            int upper = levels.get(i);
            while(j >= 0){
                int lower = levels.get(j);
                if(upper > lower){
                    int diff = upper - lower;
                    if(diff > result){
                        result = diff;
                    }
                }
                j--;
            }
        }

        return result;
    }

    static int countGraphs(int n)
    {
        long x = n * (n - 1) / 2;
        double pow = power(2, x);
        return (int) pow;
    }
}
