package com.onejava.problems;

import java.util.Arrays;
import java.util.List;

public class Sample001_Volume {
    public static void main(String[] args) {
        List<Integer> items = Arrays.asList(200, 300, 1000);
        int volume = 1000;
        printVolume(items, volume);
    }

    private static void printVolume(List<Integer> items, int volume) {
        for(Integer i : items){
            if(volume == 0){
                break;
            }
            if (volume >= i){
                System.out.println(i);
                volume = volume - i;
            }
            else if(volume > 0){
                System.out.println(volume);
                volume = 0;
                break;
            }
        }

    }
}
