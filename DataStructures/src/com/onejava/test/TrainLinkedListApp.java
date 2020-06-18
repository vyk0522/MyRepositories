package com.onejava.test;

import com.onejava.ds.BasicLinkedList;

import java.util.Objects;

public class TrainLinkedListApp {
    BasicLinkedList<TrainCar> train = new BasicLinkedList<TrainCar>();

    public static void main(String[] args) {
        TrainLinkedListApp app = new TrainLinkedListApp();
        app.buildInitialTrain();
		app.insertNode(5, "Vivek");
		app.removeNode(3);
		app.getNode(4);
		app.findNode("Vivek");
    }

    private void findNode(String item) {
        TrainCar newBoxcar = new TrainCar(CarType.B, item);
        System.out.println("Given item found at position: " + train.find(newBoxcar));
        System.out.println("-------------------------------------");
    }

    private void getNode(int position) {
        System.out.println("Element at " + position + " is: " + train.get(position));
        System.out.println("-------------------------------------");
    }

    private void insertNode(int position, String item) {
        TrainCar newBoxcar = new TrainCar(CarType.B, item);
        train.insert(newBoxcar, position);
        System.out.println(train.toString());
        System.out.println("Head: " + train.getFirstNodeItem());
        System.out.println("tail: " + train.getLastNodeItem());
        System.out.println("After Insert Size: " + trainSize());
        System.out.println("-------------------------------------");
    }

    private void removeNode(int position) {
		TrainCar trainCar = train.removeAt(position);
        System.out.println(train.toString());
		System.out.println("Head: " + train.getFirstNodeItem());
		System.out.println("tail: " + train.getLastNodeItem());
        System.out.println("After Remove Size: " +trainSize());
        System.out.println("removed item: " + trainCar.contents);
        System.out.println("-------------------------------------");
    }

    private int trainSize() {
        return train.size();
    }

    private void buildInitialTrain() {
        //build the train for it's initial trip
        TrainCar car1 = new TrainCar(CarType.B, "0");
        TrainCar car2 = new TrainCar(CarType.B, "1");
        TrainCar car3 = new TrainCar(CarType.B, "2");
        TrainCar car4 = new TrainCar(CarType.B, "3");
        TrainCar car5 = new TrainCar(CarType.B, "4");

        //connect the cars
        train.add(car1);
        train.add(car2);
        train.add(car3);
        train.add(car4);
        train.add(car5);

        System.out.println(train);
        System.out.println("Initial Size: " + trainSize());
        System.out.println("-------------------------------------");
    }

    class TrainCar {
        private CarType type;
        private String contents;

        public TrainCar(CarType carType, String carContents) {
            this.type = carType;
            this.contents = carContents;
        }

        public String toString() {
            return type.toString() + "-" + contents;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            TrainCar trainCar = (TrainCar) o;
            return type == trainCar.type &&
                    Objects.equals(contents, trainCar.contents);
        }

        @Override
        public int hashCode() {
            return Objects.hash(type, contents);
        }
    }

    enum CarType {
        BOXCAR, TANKER, FLATBED, HOPPER, A, B, C
    }
}