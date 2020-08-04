package com.onejava.threads;

public class Sample004_ProducerConsumer {
    private static Object lock = new Object();
    private static int[] buffer = new int[10];
    private static int count;

    private static boolean isEmpty(){
        return count == 0;
    }

    private static boolean isFull(){
        return count == buffer.length;
    }

    public static void main(String[] args) throws InterruptedException {
        Producer producer = new Producer();
        Consumer consumer = new Consumer();

        Runnable produceTask = () -> {
            for (int i = 0; i < 50; i++) {
                producer.produce();
            }
            System.out.println("Done Producing");
        };

        Runnable consumeTask = () -> {
            for (int i = 0; i < 45; i++) {
                consumer.consume();
            }
            System.out.println("Done Consuming");
        };

        Thread producerThread = new Thread(produceTask);
        Thread consumerThread = new Thread(consumeTask);

        producerThread.start();
        consumerThread.start();

        producerThread.join();
        consumerThread.join();

        System.out.println("Data in the buffer: " + count);
    }

    static class Producer{
        public void produce() {
            synchronized (lock){
                if (isFull()){
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                buffer[count++] = 1;
                lock.notify();
            }
        }
    }

    static class Consumer{
        public void consume() {
            synchronized (lock){
                if (isEmpty()){
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                buffer[--count] = 0;
                lock.notify();
            }
        }
    }
}


