package com.practice.java8;

import java.util.concurrent.*;

public class ForCompletableFuture {

    public static void main(String[] args) {

        /*createCF().thenAccept(integer -> System.out.println(integer))
                .thenAccept(aVoid -> System.out.println("Void"));*/

        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(() -> {
                                System.out.println("Thread: " + Thread.currentThread());
                                return 11;
                            }, forkJoinPool);
        completableFuture.thenApplyAsync(integer -> {
                                System.out.println("Thread: " + Thread.currentThread());
                                return integer * 10;
                            })
                        .thenApplyAsync(integer -> {
                                System.out.println("Thread: " + Thread.currentThread());
                                return integer + 2;
                            })
                        .thenAcceptAsync(integer -> {
                            System.out.println("Thread: " + Thread.currentThread());
                            System.out.println(integer);
                        });


        System.out.println("Built the pipeline");

        completableFuture.complete(16);

        completableFuture.thenAccept(integer -> {
            System.out.println("Thread: "+ Thread.currentThread());
            System.out.println(integer);
        });

    }

    private static CompletableFuture<Integer> createCF() {
        return CompletableFuture.supplyAsync(() -> 2);
    }

}
