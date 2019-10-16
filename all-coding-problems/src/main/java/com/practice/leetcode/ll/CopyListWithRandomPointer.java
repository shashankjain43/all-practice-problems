package com.practice.leetcode.ll;

public class CopyListWithRandomPointer {

    public ListNode copyRandomList(ListNode head) {

        if (head == null) {
            return head;
        }
        ListNode copyHead = new ListNode(-1, null, null);
        ListNode copyPtr = copyHead;
        ListNode currNode = head;
        printList(head);
        System.out.println();
        printRandomOfList(head);

        //create a copy of
        while (currNode != null) {
            ListNode copyNode = new ListNode(currNode.val, currNode.next, null);
            currNode.next = copyNode;
            currNode = copyNode.next;
        }

        printList(head);
        //printRandomOfList(head);


        currNode = head;
        while (currNode != null && currNode.next != null) {
            if(currNode.random != null){
                currNode.next.random = currNode.random.next;
            }
            currNode = currNode.next.next;
        }

        printList(head);
        printRandomOfList(head);

        //Remove links between original and copied nodes means saperate list
        currNode = head;
        while (currNode != null && currNode.next != null) {
            ListNode copy = currNode.next;
            copyPtr.next = copy;
            currNode.next = copy.next;
            currNode = currNode.next;
            copyPtr = copyPtr.next;
        }
        return copyHead.next;
    }

    private void printList(ListNode next) {
        while(next != null){
            System.out.print(next.val+ " ");
            next = next.next;
        }
    }
    private void printRandomOfList(ListNode next) {
        while(next != null){
            System.out.print(next.random.val+ " ");
            next = next.next;
        }
    }

}
