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
        ListNode root1 = root;
        // while(root1 != null){
        //     System.out.print("\t" + root1.val);
        //     root1 = root1.next;
        // }
    }

}
