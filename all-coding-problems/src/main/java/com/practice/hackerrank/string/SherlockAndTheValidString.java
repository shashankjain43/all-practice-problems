package com.practice.hackerrank.string;

import com.practice.gfg.FastReader;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SherlockAndTheValidString {
    public static void main(String[] args) {

        FastReader fr = new FastReader();
        int test = fr.nextInt();
        for (int i = 0; i < test; i++) {
            String str = fr.next();
            System.out.println(!isValid(str) ? "NO" : "YES");
        }
    }

    // Complete the isValid function below.
    static boolean isValid(String s) {

        Map<Character, Integer> map = new HashMap<>();
        Map<String, Long> frequencies =
                Stream.of(s)
                        .collect(Collectors.groupingBy(Function.identity(),
                                Collectors.counting()));
        Set<Long> st = new HashSet<>();
        for (long freq : frequencies.values()) {
            st.add(freq);
        }
        if (st.size() > 2) { //More than 2 frequencies
            return false;
        }
        if (st.size() == 2) {
            long max = st.stream().max(Comparator.naturalOrder()).get();
            long min = st.stream().min(Comparator.naturalOrder()).get();
            if (max - min > 1) {
                return false;
            }
        }
        return true;
    }
}