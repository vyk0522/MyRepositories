package com.onejava;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;


public class Sample011 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        numbers.parallelStream()
               .map(Sample011::transform)
               .forEach(e -> {});

        numbers.parallelStream()
               .map(Sample011::transform)
        .reduce(0, Sample011::add);

        // To know number of cores
        System.out.println(Runtime.getRuntime().availableProcessors());
        // To know number of threads
        System.out.println(ForkJoinPool.commonPool());
    }

    private static Integer add(Integer a, Integer b) {
        int result = a + b;
        System.out.println("a = " + a + " b = " + b + " result = " + result );
        return result;
    }

    private static Integer transform(Integer number) {
        System.out.println("t: " + number + "--" + Thread.currentThread() );
        sleep(1000);
        return number;
    }

    private static void sleep(int ms){
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
