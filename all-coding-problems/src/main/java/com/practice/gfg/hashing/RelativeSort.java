package com.practice.gfg.hashing;

import com.practice.gfg.FastReader;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RelativeSort {

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        int test = fr.nextInt();
        for (int i = 0; i < test; i++) {
            int size1 = fr.nextInt();
            int arr1[] = new int[size1];
            int size2 = fr.nextInt();
            int arr2[] = new int[size2];
            for (int j = 0; j < size1; j++) {
                arr1[j] = fr.nextInt();
            }
            for (int j = 0; j < size2; j++) {
                arr2[j] = fr.nextInt();
            }
            relativeSort(arr1, arr2);
            System.out.println();
        }
    }

    private static void relativeSort(int[] arr1, int[] arr2) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr2.length; i++) {
            map.put(arr2[i], i);
        }
        Arrays.stream(arr1).boxed().sorted((o1, o2)-> {
            if(map.containsKey(o1) && map.containsKey(o2)){
                return map.get(o1) - map.get(o2);
            } else if (map.containsKey(o1)){
                return -1;
            } else if(map.containsKey(o2)){
                return 1;
            } else {
                return o1 - o2;
            }
        }).forEach(value -> System.out.print(value+" "));
    }
}
