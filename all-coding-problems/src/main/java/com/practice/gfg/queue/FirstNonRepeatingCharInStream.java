package com.practice.gfg.queue;

import com.practice.gfg.FastReader;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class FirstNonRepeatingCharInStream {

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        int test = fr.nextInt();
        for (int i = 0; i < test; i++) {
            int size = fr.nextInt();
            String str = fr.nextLine();
            printFirstNonRepeatingCharInStream(str);
            System.out.println();
        }
    }

    private static void printFirstNonRepeatingCharInStream(String arr) {

        arr = arr.replaceAll(" ", "");
        Deque<Character> queue = new LinkedList<>();
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length(); i++) {
            if(map.containsKey(arr.charAt(i))){
                queue.remove(arr.charAt(i));
            } else {
                map.put(arr.charAt(i), i);
                queue.add(arr.charAt(i));
            }

            if(queue.isEmpty()){
                System.out.print("-1 ");
            } else {
                System.out.print(queue.peek()+" ");
            }
        }
    }
}