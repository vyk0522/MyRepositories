package com.onejava.threads.helper;

public class Resource {
    private Object key1 = new Object();
    private Object key2 = new Object();

    public void method1() {
        synchronized (key1){
            System.out.println(Thread.currentThread().getName() + " : in method1");
            method2();
        }
    }

    public void method2() {
        synchronized (key2){
            System.out.println(Thread.currentThread().getName() + " : in method2");
            method3();
        }
    }

    private void method3() {
        synchronized (key1){
            System.out.println(Thread.currentThread().getName() + " : in method3");
        }
    }
}
