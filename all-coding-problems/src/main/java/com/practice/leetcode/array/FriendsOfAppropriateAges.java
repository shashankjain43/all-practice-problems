package com.practice.leetcode.array;

import java.util.Arrays;

public class FriendsOfAppropriateAges {

    public int numFriendRequests(int[] ages) {

        Arrays.sort(ages);
        int left = 0;
        int right = ages.length - 1;
        int friendRequests = 0;

        while (left < right) {

            if(ages[left] <= ages[right]/2 + 7){

            }


        }

        return friendRequests;

    }
}
