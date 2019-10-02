package com.practice.gfg.hashing;

import com.practice.gfg.FastReader;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SortByFrequency {

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        int test = fr.nextInt();
        for (int i = 0; i < test; i++) {
            int size1 = fr.nextInt();
            int arr1[] = new int[size1];
            for (int j = 0; j < size1; j++) {
                arr1[j] = fr.nextInt();
            }
            sortByFrequency(arr1);
            System.out.println();
        }
    }

    private static void sortByFrequency(int[] arr) {

        Map<Integer, Integer> map = Arrays.stream(arr)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.collectingAndThen(Collectors.counting(), Long::intValue)));
        Arrays.stream(arr).boxed().sorted((o1, o2) -> {
            if (map.get(o2) == map.get(o1)) {
                return o1 - o2;
            } else {
                return map.get(o2) - map.get(o1);
            }
        }).forEach(value -> System.out.print(value + " "));
    }
}
