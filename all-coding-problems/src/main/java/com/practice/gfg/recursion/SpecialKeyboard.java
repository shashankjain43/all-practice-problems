package com.practice.gfg.recursion;

import com.practice.gfg.FastReader;

public class SpecialKeyboard {

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        int test = fr.nextInt();
        for (int i = 0; i < test; i++) {
            int size = fr.nextInt();
            System.out.println(getMaxPrints(size));
        }
    }

    private static int getMaxPrints(int size) {

        if (size <= 4) {
            return size;
        }
        return 3 * getMaxPrints(size - 4);
    }

}
