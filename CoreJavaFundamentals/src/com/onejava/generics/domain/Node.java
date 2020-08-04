package com.onejava.generics.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Node<E extends Comparable<E>> {
    private E item;
}