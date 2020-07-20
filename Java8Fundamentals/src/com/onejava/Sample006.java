package com.onejava;

import java.util.*;
import java.util.function.Function;

import static java.util.stream.Collectors.*;

public class Sample006 {
    public static void main(String[] args) {
        List<Person> people = createPeople();

        // Accumulate names into a List, sorted list
        List<String> names = people.stream().map(p -> p.getName()).collect(toList());
        System.out.println("List of Names: ");
        System.out.println(names);
        System.out.println("------------------------");

        names = people.stream().map(p -> p.getName()).sorted().collect(toList());
        System.out.println("List of Sorted Names: ");
        System.out.println(names);
        names = people.stream().map(p -> p.getName()).sorted(Comparator.reverseOrder()).collect(toList());
        System.out.println(names);
        System.out.println("------------------------");

        // Accumulate names into a Set, TreeSet
        HashSet<String> nameSet = people.stream().map(p -> p.getName()).collect(toCollection(HashSet::new));
        System.out.println("Set of Names: ");
        System.out.println(nameSet);
        System.out.println("------------------------");

        TreeSet<String> treeSet = people.stream().map(p -> p.getName()).collect(toCollection(TreeSet::new));
        System.out.println("Sorted set of Names: ");
        System.out.println(treeSet);
        Set<String> descendingSet = people.stream().map(p -> p.getName()).collect(toCollection(TreeSet::new)).descendingSet();
        System.out.println(descendingSet);
        System.out.println("------------------------");

        // concatenate Names, separated by commas
        String conName = people.stream().map(p -> p.getName()).collect(joining(", "));
        System.out.println("Concatenated Names: ");
        System.out.println(conName);
        System.out.println("------------------------");

        // Compute sum of ages of people
        int sum = people.stream().mapToInt(p -> p.getAge()).sum();
        Integer sum1 = people.stream().collect(summingInt(person -> person.getAge()));
        Integer sum2 = people.stream().map(p -> p.getAge()).collect(summingInt(e -> e));
        System.out.println("Sum: "+sum + " , Another sum: " + sum1 + " , Another sum: " + sum2);
        System.out.println("------------------------");


        // create a map with name and age as key, and person as value
        Map<String, Person> nameAgeMap = people.stream().collect(toMap(p -> p.getName() + "-" + p.getAge(), Function.identity()));
        System.out.println("Map with name and age as key, and person as value:");
        System.out.println(nameAgeMap);
        System.out.println(people.stream().collect(toMap(p -> p.getName()+ "-" + p.getAge(), p -> p)));
        System.out.println("------------------------");

        // create a map where their name is key and Value is all the people with that name
        Map<String, List<Person>> groupByNames = people.stream().collect(groupingBy(Person::getName));
        System.out.println("Map of name and all the people with that name:");
        System.out.println(groupByNames);
        System.out.println("------------------------");

        // create a map where their name is key and value is list of age of all the people with that name
        Map<String, List<Integer>> collect = people.stream().collect(groupingBy(Person::getName, mapping(Person::getAge, toList())));
        System.out.println("Map of name and list of age of all the people with that name:");
        System.out.println(collect);

        Map<String, String> collect1 = people.stream().collect(groupingBy(Person::getName, mapping(p -> Integer.toString(p.getAge()), joining(","))));
        System.out.println("map of name and Concatenated String of ages of all people with that name:");
        System.out.println(collect1);

        Map<String, Integer> collect2 = people.stream().collect(groupingBy(Person::getName, summingInt(Person::getAge)));
        System.out.println("Map of name and sum of ages of all people with that name:");
        System.out.println(collect2);

        Map<Boolean, List<Person>> collect3 = people.stream().collect(partitioningBy(person -> person.getAge() >= 21));
        System.out.println("Partition of people satisfying the condition and not satisfying the condition:");
        System.out.println(collect3);

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
        return name + age;
    }
}
