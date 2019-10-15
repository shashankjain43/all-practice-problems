package com.practice.leetcode.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class InsertDeleteGetRandom_O_1 {

    ArrayList<Integer> valuesArray;
    Map<Integer, Integer> valToIndex;
    Random random;

    /**
     * Initialize your data structure here.
     */
    public InsertDeleteGetRandom_O_1() {
        valuesArray = new ArrayList<>();
        valToIndex = new HashMap<>();
        random = new Random();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (valToIndex.containsKey(val)) {
            return false;
        }
        valuesArray.add(val);
        valToIndex.put(val, valuesArray.size() - 1);
        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {

        int index = valToIndex.getOrDefault(val, -1);
        if (index == -1) {
            return false;
        }
        int lastValue = valuesArray.get(valuesArray.size() - 1);
        valuesArray.set(index, lastValue);
        valuesArray.remove(valuesArray.size() - 1);
        valToIndex.put(lastValue, index);
        valToIndex.remove(val);
        return true;
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {

        return valuesArray.get(random.nextInt(valuesArray.size()));
    }
}
