package com.practice.leetcode.leetcode_practice;

public class LC0206_ReverseLinkedList {
    /**
     *  TODO:
     *    1. LEETCODE# : 206
     *    2. TIMER:
     */

    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static  ListNode reverList(ListNode head){
        ListNode prev= null;
        ListNode curr = head;
        ListNode next = null;
        while (curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static void main (String [] args) {
        ListNode list = new ListNode(1);
        list.next =new ListNode(2);
        list.next.next = new ListNode(3);
        list.next.next.next = new ListNode(4);
        list.next.next.next.next = new ListNode(5);
        ListNode reversedList = reverList(list);

        while (reversedList != null){
            System.out.print(reversedList.val + "\t");
            reversedList = reversedList.next;
        }
    }

}
