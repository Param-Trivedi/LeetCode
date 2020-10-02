package com.practice.leetcode.leetcode_practice;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class LC1290_LinkListBinaryToNumber {
    /**
     *  TODO:
     *    1. LEETCODE# : 1290
     *    2. TIMER:
     */


     private static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static int binaryToDecimal(ListNode head){
         int currDec = 1, finalNum = 0, currIndex= 0 ;
         List<Integer> reversedList = new ArrayList<Integer>();
         ListNode dummy = head;

         while (dummy != null){
            reversedList.add(dummy.val);
            dummy = dummy.next;
         }

         for(int i = reversedList.size() - 1; i >= 0 ; i--){
             if(reversedList.get(i) == 1){
                 finalNum += currDec;
             }
             currDec *= 2;
         }

         return finalNum;
    }

    public static void main (String [] args) {
         ListNode list = new ListNode(1);
         list.next =new ListNode(0);
//         list.next.next = new ListNode(1);
//         list.next.next.next = new ListNode(1);

         System.out.print(binaryToDecimal(list));
    }
}
