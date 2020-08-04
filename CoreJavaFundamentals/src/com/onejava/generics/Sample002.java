package com.onejava.generics;

import com.onejava.generics.domain.Node;

public class Sample002 {
    public static void main(String[] args) {
        Node util1 = new Node(22);
        System.out.println(getVoteEligibility(util1));

        Node util2 = new Node("abc");
        System.out.println(getBeforeOrAfter(util2));

    }

    private static String getVoteEligibility(Node<Integer> node) {
        return node.getItem().compareTo(18) >= 0 ? "Eligible" : "Not eligible";
    }

    private static String getBeforeOrAfter(Node<String> node) {
        return node.getItem().compareTo("random") >= 0 ? "After" : "Before";
    }
}


