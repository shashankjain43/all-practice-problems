package com.practice.leetcode.ll;

public class ListNode {

    int val;
    ListNode next;
    ListNode random;

    public ListNode(int x) {
        val = x;
    }

    public ListNode(int _val, ListNode _next, ListNode _random) {
        val = _val;
        next = _next;
        random = _random;
    }

}
