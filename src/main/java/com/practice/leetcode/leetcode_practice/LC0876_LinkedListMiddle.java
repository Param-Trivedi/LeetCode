package com.practice.leetcode.leetcode_practice;

public class LC0876_LinkedListMiddle {
    /**
     *  TODO:
     *    1. LEETCODE# : 876
     *    2. TIMER:
     */

    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static int countLen(ListNode head){
        int i = 0;
        while (head != null){
            head = head.next; i++;
        }
        return i;
    }
    public static ListNode middleNode(ListNode head){
        ListNode dummyCount  = head;
        int len = countLen(dummyCount);
        if(len == 0) return head;
        int middle = len /2;
        while (middle > 0){
            head  = head.next;
            middle--;
        }

        return head;
    }

    public static void main (String [] args) {
        ListNode list = new ListNode(1);
        list.next =new ListNode(2);
        list.next.next = new ListNode(3);
        list.next.next.next = new ListNode(4);
        list.next.next.next.next = new ListNode(5);
        System.out.print(middleNode(list).val);
    }

}
