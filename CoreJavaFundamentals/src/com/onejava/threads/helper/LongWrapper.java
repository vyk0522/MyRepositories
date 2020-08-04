package com.onejava.threads.helper;

public class LongWrapper{
    private Object key = new Object();
    private long number;

    public LongWrapper(long number) {
        this.number = number;
    }

    public long getNumber() {
        return number;
    }

    public void increment(){
        synchronized (key){
            number = number + 1;
        }
    }
}
