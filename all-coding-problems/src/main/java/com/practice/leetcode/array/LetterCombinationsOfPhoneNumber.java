package com.practice.leetcode.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfPhoneNumber {

    public List<String> letterCombinations(String digits) {
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        return letterCombinationsUtil(digits, map);
    }

    public List<String> letterCombinationsUtil(String digits, Map<Character, String> map) {
        List<String> result = new ArrayList<>();
        if(digits.length() == 0){
            //result.add("");
            return result;
        }

        List<String> prevResult = letterCombinationsUtil(digits.substring(1), map);

        String code = map.get(digits.charAt(0));
        for (String val: prevResult) {
            for (int i = 0; i < code.length(); i++) {
                result.add(code.charAt(i) + val);
            }
        }
        return result;
    }
}
