package com.practice.java8;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PracticeStreamsJava8 {

    public static void main(String[] args) {

        Random random = new Random();
        List<Integer> numbers = random.ints(15, 1, 10).distinct().boxed().collect(Collectors.toList());
        int sum = numbers.stream()
                .filter(integer -> integer % 2 == 0)
                .mapToInt(integer -> integer * 2)
                .sum();

        System.out.println("Sum is: "+ sum);

        List<Integer> sorted  = numbers.stream().sorted().collect(Collectors.toList());

        IntStream.
                range(1,21)
                .boxed()
                .parallel()
                .map(integer -> transform(integer))
                .forEachOrdered(System.out::println);

    }

    private static Object transform(Integer integer) {
        try {
            TimeUnit.SECONDS.sleep(2);
            System.out.println("For number: "+integer+ " Thread is: "+ Thread.currentThread().getName() +" CommonPool: "+ForkJoinPool.commonPool()) ;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return integer;
    }
}
