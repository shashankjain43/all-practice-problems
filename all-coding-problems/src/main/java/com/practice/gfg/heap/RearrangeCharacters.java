package com.practice.gfg.heap;

import com.practice.gfg.FastReader;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Collectors;

public class RearrangeCharacters {

    static class Key {
        char ch;
        int freq;

        public Key(char ch, int freq) {
            this.ch = ch;
            this.freq = freq;
        }
    }

    public static void main(String[] args) {

        FastReader fr = new FastReader();
        int test = fr.nextInt();
        for (int i = 0; i < test; i++) {
            String str = fr.nextLine();
            System.out.println(!checkIfRearrangeCharacters(str) ? 0 : 1);
        }
    }

    private static boolean checkIfRearrangeCharacters(String str) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            if (map.containsKey(str.charAt(i))) {
                map.put(str.charAt(i), map.get(str.charAt(i)) +1 );
            } else {
                map.put(str.charAt(i), 1);
            }
        }
        Queue<Key> maxHeap = new PriorityQueue<Key>((o1, o2) -> o2.freq - o1.freq);
        map.entrySet()
                .stream()
                .map(characterIntegerEntry -> new Key(characterIntegerEntry.getKey(), characterIntegerEntry.getValue()))
                .collect(Collectors.toList()).forEach(maxHeap::offer);

        Key prev = new Key('!', -1);
        String result = "";
        while (!maxHeap.isEmpty()) {
            Key curr = maxHeap.poll();
            curr.freq = curr.freq - 1;
            result = result + curr.ch;

            if(prev.freq>0){
                maxHeap.add(prev);
            }
            prev = curr;
        }
        return result.length() == str.length();
    }

}
