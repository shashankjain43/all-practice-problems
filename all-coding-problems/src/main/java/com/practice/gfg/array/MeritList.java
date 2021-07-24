package com.practice.gfg.array;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MeritList {
    public static void main(String[] args) {
        int[] arr  = {49,40,49,98,76,49,67,99};
        List<Pair> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            list.add(new Pair(arr[i], i+1));
        }
        list.sort(Comparator.comparingInt(Pair::getMarks).reversed());
        int rank=1;
        int skip=0;
        System.out.println("Roll: ["+list.get(0).getRollNum()+"] Rank: ["+rank+"] Marks: ["+list.get(0).getMarks()+"]");
        for (int i = 1; i < list.size(); i++) {
            if(list.get(i).getMarks() != list.get(i-1).getMarks()){
                rank=rank+skip+1;
                skip=0;
                System.out.println("Roll: ["+list.get(i).getRollNum()+"] Rank: ["+rank+"] Marks: ["+list.get(i).getMarks()+"]");
            } else {
                skip++;
                System.out.println("Roll: ["+list.get(i).getRollNum()+"] Rank: ["+rank+"] Marks: ["+list.get(i).getMarks()+"]");
            }
        }
    }

    static class Pair{
        int marks;
        int rollNum;

        public Pair(int marks, int rollNum) {
            this.marks = marks;
            this.rollNum = rollNum;
        }

        public int getMarks() {
            return marks;
        }

        public int getRollNum() {
            return rollNum;
        }
    }
}
