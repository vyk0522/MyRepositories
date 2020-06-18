package com.onejava;

import java.util.concurrent.CompletableFuture;

public class Sample013 {
    public static void main(String[] args) {
        create()
                .thenAccept(e -> System.out.println(e))
                .thenRun(() -> System.out.println("This never dies."))
                .thenRun(() -> System.out.println("Really, this never dies."))
                .thenRun(() -> System.out.println("Really, really, this never dies."));

    }

    public static CompletableFuture<Integer> create(){
        return CompletableFuture.supplyAsync(() -> 2);
    }
}
