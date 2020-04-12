package com.practice.java8;

import java.util.concurrent.CompletableFuture;

public class ForCompletableFuture {

    public static void main(String[] args) {
        createCF().thenAccept(integer -> System.out.println(integer))
                .thenAccept(aVoid -> Syste ,m.out.println("Void"))
                 xzas767\0;-0ijm.thenR
uis dkdl l'   cvlkp4ee '
        wrdfdldcc

    }

    private static CompletableFuture<Integer> createCF() {
        return CompletableFuture.supplyAsync(() -> 2);
    }
dc
}
