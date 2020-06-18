package com.onejava;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Sample006 {
    public static void main(String[] args) {
        List<Person> people = createPeople();

        // create a map with name and age as key, and person as value
        System.out.println(people.stream()
                                 .collect(Collectors.toMap( p -> p.getName()+"-"+p.getAge(), p -> p)));

        // create a map where their name is key and Value is all the people with that name
        System.out.println(people.stream()
                                 .collect(Collectors.groupingBy(Person::getName)));

        // create a map where their name is key and value is list of age of all the people with that name
        System.out.println(people.stream()
                                 .collect(Collectors.groupingBy(Person::getName, Collectors.mapping(Person::getAge, Collectors.toList()))));

    }
    public static List<Person> createPeople(){
        return Arrays.asList(
                new Person("Sara",Gender.FEMALE, 20),
                new Person("Sara",Gender.FEMALE, 22),
                new Person("Bob",Gender.MALE, 20),
                new Person("Paula",Gender.FEMALE, 32),
                new Person("Paul",Gender.MALE, 32),
                new Person("Jack",Gender.MALE, 2),
                new Person("Jack",Gender.MALE, 72),
                new Person("Jill",Gender.MALE, 12)
        );
    }
}

enum Gender {
    MALE, FEMALE
}

class Person {
    private String name;
    private Gender gender;
    private int age;

    public Person(String name, Gender gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", gender=" + gender +
                ", age=" + age +
                '}';
    }
}
