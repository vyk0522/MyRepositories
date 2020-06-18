package com.onejava.ds;

public class BasicStack<X> implements Stack<X> {
    private X[] data;
    private int stackPointer;

    public BasicStack() {
        data = (X[]) new Object[1000];
        stackPointer = 0;
    }

    @Override
    public void push(X newElement){
        data[stackPointer++] = newElement; // new element gets assigned to the previous value and then the stack pointer gets incremented.
    }

    @Override
    public X pop(){
        if(stackPointer == 0){
            throw new IllegalStateException("No more elements on the stack");
        }
        return data[--stackPointer];
    }

    @Override
    public boolean contains(X element){
        for(int i=0; i< stackPointer; i++){
            if(data[i].equals(element)){
                return true;
            }
        }
        return false;
    }

    @Override
    public X access(X element){
        while (stackPointer > 0){
            X tmpElement = pop();
            if(element.equals(tmpElement)) {
                return tmpElement;
            }
        }
        throw new IllegalArgumentException("Could not find the element on the stack: " + element);
    }

    @Override
    public int size(){
        return stackPointer;
    }
}
