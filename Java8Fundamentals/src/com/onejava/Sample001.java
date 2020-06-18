package com.onejava;

public class Sample001 {
    public static void main(String[] args) {
        Thread th1 = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("Inside Traditional Thread");
                    }
                }
                );
        th1.start();

        Thread th2 = new Thread(() -> System.out.println("Inside Lambda Thread"));
        th2.start();

        System.out.println("Main Thread");

    }
}
