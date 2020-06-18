package com.onejava.ds;

public interface Queue<X> {
    void enQueue(X newElement);

    X deQueue();

    int size();

    X readHead();
}
