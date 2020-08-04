package com.onejava.threads;

import com.onejava.threads.helper.Resource;

/*
If method1() and method2() is called at the same time -- it gives dead lock
 */
public class Sample003_DeadLock {
    public static void main(String[] args) throws InterruptedException {
        Resource resource = new Resource();
        Runnable task1 = () -> resource.method1();
        Runnable task2 = () -> resource.method2();

        Thread thread1 = new Thread(task1);
        thread1.start();

        Thread thread2 = new Thread(task2);
        thread2.start();

        thread1.join();
        thread2.join();
    }
}