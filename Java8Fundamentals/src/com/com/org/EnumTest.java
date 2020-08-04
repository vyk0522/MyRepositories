package com.com.org;

import java.lang.reflect.Field;
import java.util.Arrays;

public class EnumTest {
    public static void main(String[] args) {
       System.out.println(isValidEnum("aaA"));
       valid(Enum1.class, "aa");
    }

    private static boolean isValidEnum(String element){
        return Arrays.stream(Enum2.values()).anyMatch(e -> e.label.equalsIgnoreCase(element));
    }

    private static <E extends java.lang.Enum<E>> void valid(final Class<E> enumClass, String element){
        Class<? extends Enum1> aClass = enumClass.asSubclass(Enum1.class);
        Field[] fields = aClass.getFields();
    }

}

enum Enum2 {
    AA("aaa");
    public final String label;
    Enum2(String label){
        this.label = label;
    }

}

enum Enum1{
    BB,CC;

}

