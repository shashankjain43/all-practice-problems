package com.practice.snippet;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class CheckIterator {

    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        map.put("India", "Delhi");
        map.put("zdd", "daD");
        map.put("ADAs", "adS");
        map.put("DAs", "asdaS");

        Iterator<String> iterator = map.keySet().iterator();
        while(iterator.hasNext()){
            String str = iterator.next();
            System.out.println(str);
            map.put("Nepal","Kathmandu");
        }
    }
}
