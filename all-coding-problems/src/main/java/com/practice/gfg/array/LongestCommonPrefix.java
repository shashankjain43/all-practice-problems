package com.practice.gfg.array;

import com.practice.gfg.FastReader;

public class LongestCommonPrefix {

    public static void main(String[] args) {

        FastReader fastReader = new FastReader();
        int testCases = fastReader.nextInt();
        for (int test = 0; test < testCases; test++) {
            int noOfWords = fastReader.nextInt();
            Trie trie = new Trie();
            for (int j = 0; j < noOfWords; j++) {
                String word = fastReader.next();
                trie.insert(word);
            }
            String result = trie.getLongestCommonPrefix();
            System.out.println(result.isEmpty() ? -1 : result);
        }
    }
}