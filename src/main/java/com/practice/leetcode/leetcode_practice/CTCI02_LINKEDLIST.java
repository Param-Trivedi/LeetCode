package com.practice.leetcode.leetcode_practice;
import java.util.*;
public class CTCI02_LINKEDLIST {
    
    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
        
    }

    public static void removeDups(ListNode root){
        // ListNode temp = root;
        // HashSet<Integer> mapper=  new HashSet<Integer>();
        
        // mapper.add(temp.val);
        
        // while(temp != null){
        //     if(temp.next != null && mapper.contains(temp.next.val)){
        //         temp.next = temp.next.next;
        //     }else{
        //         if(temp.next != null)mapper.add(temp.next.val);
        //         temp = temp.next;
        //     }
        // }

        ListNode  prev = null;
        HashSet<Integer> mapper=  new HashSet<Integer>();

        while(root != null){
            if(mapper.contains(root.val)){
                prev.next = root.next;
            }else{
                mapper.add(root.val);
                prev = root;
            }
            root = root.next;
        }
    }

    public static ListNode addition(ListNode l1 , ListNode l2){

        ListNode finalSum = new ListNode(0);
        ListNode tempfinalSum = finalSum;
        int carry = 0;
        while(l1 != null || l2 != null){
            int num1 = 0, num2 =0, tempSum = 0, finalVal = 0;
            if(l1 != null)num1 = l1.val;
            if(l2 != null)num2 = l2.val;
            tempSum = num1 + num2 + carry;
            if(tempSum > 10){
                carry = tempSum/10;
                finalVal = tempSum%10;
            }else{
                finalVal = tempSum;
            }

            tempfinalSum.next = new ListNode(finalVal);
            tempfinalSum = tempfinalSum.next;

            if(l1 != null)l1 = l1.next ;
            if(l2 != null) l2 = l2.next;
        }

        return finalSum.next;
    }

    public static ListNode reverseList(ListNode currList){
        ListNode prev = null;
        ListNode curr = currList;
        ListNode next = currList.next;

        while(curr != null){
            curr.next = prev;
            prev = curr;
            if(next != null){
                curr = next;
                next = curr.next;
            }else{
                break;
            }
        }

        return prev;
    }


    public static Boolean  findIntersection(ListNode l1 , ListNode l2){

        if(l1 == null || l2 == null)return false;

        int len1 = findLength(l1);
        int len2 = findLength(l2);
        ListNode tail1 = l1, tail2 = l2;

        while(tail1.next != null){
            tail1 = tail1.next;
        }

        while(tail2.next != null){
            tail2 = tail2.next;
        }

        if(tail1 != tail2)return false;

        if(len1 > len2){
            int diff = len1 - len2;
            while(diff != 0){
                l1 = l1.next;
                diff--;
            }
        }else{
            int diff = len2 - len1;
            while(diff != 0){
                l2 = l2.next;
                diff--;
            }
        }

        while(l1 != null && l2 != null){
            if(l1 == l2)return true;
            l1 = l1.next;
            l2 = l2.next;
        }

        return false;
    }

    public static int findLength(ListNode head){
            int len = 0;
            if(head == null)return 0;
            while(head != null){
                len++;
                head = head.next;
            }
            return len;
    }

    public static void printList(ListNode root){
        System.out.println("");
        while(root != null){
            System.out.print("\t" + root.val);
            root = root.next;
        }
    }

    public static void main (String [] args){
        ListNode root = new ListNode(5);
        root.next = new ListNode(2);
        root.next.next = new ListNode(2);
        root.next.next.next = new ListNode(3);
        root.next.next.next.next = new ListNode(5);
        printList(root);
        removeDups(root);
        printList(root);    

        System.out.println("\nAdding two list");

        ListNode l1 = new ListNode(7);l1.next = new ListNode(1); l1.next.next = new ListNode(6);l1.next.next.next = new ListNode(10);
        ListNode l2 = new ListNode(5);l2.next = new ListNode(9); l2.next.next = new ListNode(2);

        ListNode finalSum = addition(l1, l2);
        System.out.println("\n Addition : ");
        printList(finalSum);
        //System.out.println("Module " + 12/10);


        System.out.print("\nReverse List: ");
        ListNode reversedList = reverseList(l1);
        printList(reversedList);


        ListNode inter1 = new ListNode(1); inter1.next = new ListNode(2); inter1.next.next = new ListNode(3); inter1.next.next.next = new ListNode(4);
        ListNode inter2 = new ListNode(5); inter2.next = new ListNode(6); inter2.next.next = new ListNode(2); 
        System.out.print("\n\n Find Intersection: " + findIntersection(inter1, inter2));
    }

}
