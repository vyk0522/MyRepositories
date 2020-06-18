package com.onejava;

import java.util.concurrent.CompletableFuture;

public class Sample012 {
    public static void main(String[] args) {
        CompletableFuture<Integer> future = create();
        // thenAccept takes consumer
        // consumer takes T
        // It returns nothing
        // CompletableFuture returns CompletableFuture
        // Here VoidCompletableFuture
        CompletableFuture<Void> voidFuture = future.thenAccept(e -> System.out.println(e));

    }

    // supplyAsync takes supplier
    // supplier takes nothing
    // and it returns T ie., Integer ie., 2
    public static CompletableFuture<Integer> create(){
        return CompletableFuture.supplyAsync(() -> 2);
    }
}
