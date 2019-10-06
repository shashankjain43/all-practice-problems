package com.practice.gfg.hashing;

import com.practice.gfg.FastReader;

import java.util.Map;
import java.util.stream.Collectors;

public class CheckIfFrequenciesCanBeEqual {

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        int test = fr.nextInt();
        for (int i = 0; i < test; i++) {
            String str = fr.nextLine();
            checkIfFrequenciesCanBeEqual(str);
        }
    }

    private static void checkIfFrequenciesCanBeEqual(String str) {

        Map<Character, Integer> collect = str.chars()
                .boxed()
                .collect(Collectors.groupingBy(o -> Character.valueOf((char) o.intValue()), Collectors.collectingAndThen(Collectors.counting(), Long::intValue)));


    }

}
