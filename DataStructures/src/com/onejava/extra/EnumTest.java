package com.onejava.extra;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.List;

public class EnumTest {
    public static void main(String[] args) {

        List<User> users = Arrays.asList(new User("aa", "vv"), new User("aa", "dd"));
        List<String> hh = Arrays.asList("aa");

        users.stream().filter(e -> hh.contains(e.getName())).forEach(System.out::println);

    }
}

@Getter
@Setter
class User{
    private String name;
    private String email;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
