package com.onejava.threads.helper;

public class Data{
    private Object key = new Object();
    private boolean isOdd = true;

    public void printOddNumber(int i){
        synchronized (key){
            if(! isOdd){
                try {
                    key.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + ":" + i);
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
            System.out.println(Thread.currentThread().getName() + ":" + i);
            isOdd = true;
            key.notify();
        }
    }

}