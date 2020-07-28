package com.onejava.ds;

public interface Queue<X> {
    int size();
    void enQueue(X newElement);
    X deQueue();
    X readHead();
}
