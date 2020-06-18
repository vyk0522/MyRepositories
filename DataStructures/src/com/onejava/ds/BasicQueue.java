package com.onejava.ds;

public class BasicQueue<X> implements Queue<X> {
    private X[] data;
    private int i=0, j=0;

    public BasicQueue() {
        data = (X[]) new Object[1000];
    }

    @Override
    public void enQueue(X newElement){
        data[j++] = newElement;
    }

    @Override
    public X deQueue(){
        if(i == j){
            throw new IllegalStateException("No more elements on the queue");
        }
        return data[i++];
    }

    @Override
    public int size(){
        return j - i;
    }

    @Override
    public X readHead(){
        return data[i];
    }

}
