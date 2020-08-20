package com.onejava.reflection.Model;

public interface TaskWorker<X> {
    void setTarget(X target);
    void doTask();
}
