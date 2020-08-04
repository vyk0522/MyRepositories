package com.onejava.generics;

import com.onejava.generics.domain.Car;
import com.onejava.generics.domain.User;

import java.util.Arrays;
import java.util.List;

public class Sample001 {
    public static void main(String[] args) {
        List<Car> cars = Arrays.asList(new Car(1, "Audi", 22), new Car(2, "BMW", 33));
        List<User> users = Arrays.asList(new User(1, "User1"), new User(2, "User2"));
        List<Integer> numbers = Arrays.asList(1, 2);
        List<?> genericList = Arrays.asList(new Car(1, "BENZ", 22), new User(1, "User3"), 3);

        Car car = (Car) getNthElement(cars, 0);
        System.out.println(car.getName());

        User user = getNthElementGeneric(users, 0);
        System.out.println(user.getName());

        Integer element = (Integer) getNthElementGeneric(genericList, 2);
        System.out.println(element);

        List<Integer> list = getGenericList(numbers);
        System.out.println(list);

    }

    /*
      It takes any list. But we need to use cast.
     */
    private static Object getNthElement(List list, int index) {
        return list.get(index);
    }

    /*
      It takes any list. But we don't need to use cast.
      A. We need to add <T> before return type.
      B. We can return T or Object as well
     */
    private static <T> T getNthElementGeneric(List<T> list, int index){
        return list.get(index);
    }

    private static <T> List<T> getGenericList(List<T> list){
        return list;
    }
}

