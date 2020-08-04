package com.onejava.threads;

import com.onejava.threads.helper.LongWrapper;

/*
We can avoid race condition using synchronized block
 */
public class Sample002_RaceCondition {
    public static void main(String[] args) throws InterruptedException {
        LongWrapper wrapper = new LongWrapper(0l);
        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) {
                wrapper.increment();
            }
        };
        /*
        Thread thread1 = new Thread(task);
        thread1.start();
        thread1.join(); // Main thread will wait until thread1 finishes its execution
        System.out.println("Value = " + wrapper.getNumber());
        */

        Thread[] threads = new Thread[1000];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(task);
            threads[i].start();
        }

        for (int i = 0; i < threads.length; i++) {
            threads[i].join();
        }
        System.out.println("Value = " + wrapper.getNumber());
    }
}


