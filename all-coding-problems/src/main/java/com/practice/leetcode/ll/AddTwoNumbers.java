package com.practice.leetcode.ll;

public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode head = null;
        ListNode curr = head;
        ListNode head1 = l1;
        ListNode head2 = l2;
        int carry = 0;
        while (head1 != null || head2 != null) {
            int digSum = carry;
            if (head1 != null) {
                digSum += head1.val;
            }
            if (head2 != null) {
                digSum += head2.val;
            }
            ListNode newNode = null;
            if (digSum > 9) {
                newNode = new ListNode(digSum % 10);
                carry = digSum / 10;
            } else {
                newNode = new ListNode(digSum);
                carry = 0;
            }
            if (curr != null) {
                curr.next = newNode;
            } else {
                head = newNode;
            }
            head1 = head1 != null ? head1.next : head1;
            head2 = head2 != null ? head2.next : head2;
            curr = newNode;
        }

        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return head;
    }


}
