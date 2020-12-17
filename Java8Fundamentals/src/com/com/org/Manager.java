package com.com.org;

import java.util.Arrays;
import java.util.List;
import java.lang.Object;

public class Manager {
    public static void main(String[] args) {
        List<Car> cars = Arrays.asList(new Car(1, "Audi"), new Car(2, "BMW"));
        List<Employee> employees = Arrays.asList(new Employee("1", "aa", 22),
                new Employee("2", "bb", 33));
        List<Integer> integers = Arrays.asList(1, 2, 3);


        Car car = (Car) getNthElement(cars, 1);
        System.out.println(car);

        Employee employee = (Employee) getNthElement(employees, 1);
        System.out.println(employee);

        Employee employee1 = getElement(employees, 0);
        System.out.println(employee1);

        List<Integer> element = getAnotherElement(integers);
        System.out.println(element);

    }

    private static Object getNthElement(List list, int index){
        return list.get(index);
    }

    private static <T> T getElement(List<T> list, int index){
        return list.get(index);
    }

    private static <T> List<T> getAnotherElement(List<T> list){
        return list;
    }

}


class Car{
    private int id;
    private String name;

    public Car(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}


class Employee{
    private String id;
    private String name;
    private int age;

    public Employee(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}