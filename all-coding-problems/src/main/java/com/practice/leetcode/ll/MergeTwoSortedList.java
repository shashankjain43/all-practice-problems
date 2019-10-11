package com.practice.leetcode.ll;

public class MergeTwoSortedList {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode curr = new ListNode(-1);
        ListNode head = curr;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
                curr = curr.next;
            } else if (l1.val > l2.val) {
                curr.next = l2;
                l2 = l2.next;
                curr = curr.next;
            } else {
                curr.next = l1;
                l1 = l1.next;
                curr = curr.next;
                curr.next = l2;
                l2 = l2.next;
                curr = curr.next;
            }
        }

        if (l1 != null) {
            curr.next = l1;
        } else {
            curr.next = l2;
        }
        return head.next;
    }


}
