package com.practice.leetcode.leetcode_practice;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class PR02_DataStructures_LinkedList {
    /**
     *  TODO:
     *   1. Explore Trees and its applications
     *      1a. Create functions like print list , size , get root
     *      1b. Create functions like add node , remove node , contains
     *   2. Explore LinkedList and its applications
     */

    node head;
    int length = 0;
    HashSet<Integer> keySet = new HashSet<Integer>();

        public static class node {
            int data;
            node next;
            node(int val){
                data = val;
                next = null;
            }
        }

        void toStringFunc(){
            node dummy = head;
            System.out.print("\nLinked List : \t");
            while (dummy != null){
                System.out.print(dummy.data + "\t");
                dummy = dummy.next;
            }
        }
        void printRoot(){
            System.out.print("Root Node Val is: " + head.data);
        }

        int length(){
            return length;
        }

        void addNode(int val){
            if(head == null) {
                head = new node(val);
                length++;
                return;
            }
            node dummy = head;
            while (dummy.next != null){
                dummy = dummy.next;
            }
            dummy.next = new node(val);
            length++;
        }

        void removeNode (int val){
            node dummy = head;
            if(dummy.data == val){
                head = dummy.next;
                length--;

                return;
            }
            while(dummy.next != null && dummy.next.data != val){
                dummy = dummy.next;
            }

            if(dummy != null){
                length--;
                dummy.next = dummy.next.next;
            }
            else{
                System.out.print("Can not find Node");return;
            }

        }


    public static void main (String[] args){

        //////////////////////////////LINKEDLIST//////////////////////////////
        System.out.print("//////////////////////////////LINKEDLIST//////////////////////////////\n");
        List dummyList = new LinkedList();
        PR02_DataStructures_LinkedList linkedList = new PR02_DataStructures_LinkedList();
        linkedList.addNode(5); linkedList.addNode(4);linkedList.addNode(3);linkedList.addNode(2);linkedList.addNode(1);
        linkedList.toStringFunc();
        System.out.print("\n");
        linkedList.printRoot();
        System.out.print("\nLength of the linkedList is : " + linkedList.length());
        linkedList.removeNode(5);
       linkedList.toStringFunc();

       //////////////////////////////TREES//////////////////////////////
        System.out.print("\n\n//////////////////////////////TREES//////////////////////////////\n");


        //////////////////////////////STACK//////////////////////////////
        System.out.print("\n\n//////////////////////////////STACK//////////////////////////////\n");


        //////////////////////////////QUEUE//////////////////////////////
        System.out.print("\n\n//////////////////////////////QUEUE//////////////////////////////\n");

    }
}
