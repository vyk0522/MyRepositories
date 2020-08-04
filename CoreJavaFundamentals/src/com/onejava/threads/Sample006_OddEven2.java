package com.onejava.threads;

import com.onejava.threads.helper.Data;

public class Sample006_OddEven2 {
    public static void main(String[] args) throws InterruptedException {
        Data resource = new Data();
        Runnable oddTask = () -> {
            for (int i = 1; i <= 20 ; i= i+2) {
                resource.printOddNumber(i);
            }
        };
        Runnable evenTask = () -> {
            for (int i = 2; i <= 20 ; i= i+2) {
                resource.printEvenNumber(i);
            }
        };
        Thread oddThread = new Thread(oddTask);
        oddThread.start();
        Thread evenThread = new Thread(evenTask);
        evenThread.start();

        oddThread.join();
        evenThread.join();
    }
}
