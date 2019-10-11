package com.practice.leetcode.array;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ReorderDataInLogFiles {

    public String[] reorderLogFiles(String[] logs) {

        return Arrays.stream(logs).sorted((o1, o2) -> {
            int index1 = o1.indexOf(' ');
            int index2 = o2.indexOf(' ');
            String str1 = o1.substring(o1.indexOf(' ') + 1);
            String str2 = o2.substring(o2.indexOf(' ') + 1);
            if (str1.charAt(0) >= 'a' && str1.charAt(0) <= 'z' && str2.charAt(0) >= 'a' && str2.charAt(0) <= 'z') {
                int comp = str1.compareTo(str2);
                if (comp == 0) {
                    return o1.substring(0, index1).compareTo(o2.substring(0, index2));
                }
                return comp;
            }
            if (str1.charAt(0) >= 'a' && str1.charAt(0) <= 'z' && str2.charAt(0) >= '0' && str2.charAt(0) <= '9') {
                return -1;
            }
            if (str1.charAt(0) >= '0' && str1.charAt(0) <= '9' && str2.charAt(0) >= '0' && str2.charAt(0) <= '9') {
                return 0;
            }
            return 1;
        }).collect(Collectors.toList()).toArray(logs);

    }

    public static void main(String[] args) {
        ReorderDataInLogFiles obj = new ReorderDataInLogFiles();
        //String[] logs = {"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"};
        String[] logs = {"w 7 2", "l 1 0", "6 066", "o aay", "e yal"};
        Arrays.stream(obj.reorderLogFiles(logs)).forEach(s -> System.out.print(s + " , "));
    }
}
