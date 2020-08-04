package com.onejava.threads;

public class Sample001 {
    public static void main(String[] args) {
        Runnable task = () -> System.out.println("I am running in: " + Thread.currentThread().getName());

        Thread t1 = new Thread(task);
        t1.setName("child1");
        t1.start();
        // thread1.run();   // Main thread executes this.
    }
}
