package com.onejava.ds;

import java.util.HashMap;

public class LRUCache<T> {
    private int capacity;
    private int size;
    private HashMap<String, Node> map = new HashMap<>();
    private DoublyLinkedList doublyLinkedList = new DoublyLinkedList();

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    /*
      1. If Node does not exist return null or else
      2. move the Node to the front and then return the value
     */
    public T get(String key){
        Node node = map.get(key);
        if(node == null){
            return null;
        }
        doublyLinkedList.moveNodeToFront(node);
        return node.value;
    }

    /*
    1. If current node already exists, replace its value and move the Node to the front
    2. If size = capacity, remove node from rear and last node from map and decrease the size
    3. Else Node to front and Hashmap. Increase the size
     */
    public void put(String key, T value){
        Node currentNode = map.get(key);
        if (currentNode != null){
            currentNode.value = value;
            doublyLinkedList.moveNodeToFront(currentNode);
        }

        else if(size == capacity){
            doublyLinkedList.removeNodeFromRear();
            map.remove(doublyLinkedList.getRearKey());
            size--;
        }
        Node newNode = new Node(key, value);
        doublyLinkedList.addNodeToFront(newNode);
        map.put(key, newNode);
        size++;
    }

    private class Node{
        String key;
        T value;
        Node next, previous;

        public Node(String key, T value) {
            this.key = key;
            this.value = value;
        }
    }

    private class DoublyLinkedList{
        Node front, rear;

        private String getRearKey(){
            return rear.key;
        }

        private void removeNodeFromRear(){
            if (rear == null){
                return;
            }
            System.out.println("Deleting key: " + rear.key);
            if (front == rear){
                front = rear = null;
            }
            else {
                rear = rear.previous;
                rear.next = null;
            }

        }

        private void addNodeToFront(Node node){
            if (rear == null){
                rear = front = node;
                return;
            }
            node.next = front;
            front.previous = node;
            front = node;
        }

        /*
        1. Detach the node -- node at front(just return), at rear, in the middle
        2. Add it to front
         */
        private void moveNodeToFront(Node node){
            if (front == node){
                return;
            }
            if(node == rear){
                rear = rear.previous;
                rear.next = null;
            }
            else{
                node.previous.next = node.next;
                node.next.previous = node.previous;
            }
            node.previous = null;
            front.previous = node;
            node.next = front;
            front = node;
        }
    }
}
