package com.onejava.threads;

public class Sample005_OddEven {
    private static Object key = new Object();
    private static boolean isOdd = true;

    public static void main(String[] args) throws InterruptedException {
        Resource resource = new Resource();
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

    static class Resource{
        public void printOddNumber(int i){
            synchronized (key){
                if(! isOdd){
                    try {
                        key.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() + ": " + i);
                isOdd = false;
                key.notify();
            }
        }

        public void printEvenNumber(int i){
            synchronized (key){
                if(isOdd){
                    try {
                        key.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() + ": " + i);
                isOdd = true;
                key.notify();
            }
        }
    }
}
