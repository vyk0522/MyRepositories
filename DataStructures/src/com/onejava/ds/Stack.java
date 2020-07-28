package com.onejava.ds;

public interface Stack<X> {
    int size();
    void push(X newElement);
    X pop();
    boolean contains(X element);
    X access(X element);
}
