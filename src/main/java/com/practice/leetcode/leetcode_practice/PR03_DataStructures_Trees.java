package com.practice.leetcode.leetcode_practice;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class PR03_DataStructures_Trees {

    /**
     *  TODO:
     *   1. Explore Trees and its applications
     *      1a. Insertion through binary search tree and level order insertion
     *      1b. Print inOrder, preOrder , postOrder (Recurive and Iterative) , DFS , BFS
     *      1c.
     */

    public node root;
    public node binarytRoot;

    public static class node {
        int data;
        node left;
        node right;

        node (int val){
            data = val;
            left = null;
            right = null;
        }
    }

    void addTreeNodeLevelOrderInsertion(int val){
        if(root == null){
            root = new node(val); return;
        }
        //node dummy = root;
        Queue<node> nodeList = new LinkedList<node>();
        if(nodeList.isEmpty() == true){
            nodeList.add(root);
        }

        while (!nodeList.isEmpty()){
            node dummy = nodeList.poll();
            if(dummy.left == null){
                dummy.left = new node(val);
                break;
            }
            if(dummy.right == null){
                dummy.right = new node(val);
                break;
            }
            if(dummy.right != null && dummy.right != null) {
                nodeList.add(dummy.left);
                nodeList.add(dummy.right);
            }
        }

    }

    void binaryTreeInsertion(  int val){
        binarytRoot = insert(binarytRoot, val);
        return ;
    }

    node insert(node root , int val){
        if(root == null){
            root = new node(val);
        }
        if(root.data > val){
            root.left = insert(root.left , val);
        }

        if(root.data < val){
            root.right = insert(root.right , val);
        }
        return root;
    }

    void printInOrder(node head){
        if(head == null) return;
        printInOrder(head.left);
        System.out.print("\t" + head.data);
        printInOrder(head.right);
    }

    void printPreOrder(node head){
        if(head == null)return;
        System.out.print("\t" + head.data);
        printPreOrder(head.left);
        printPreOrder(head.right);
    }

    void printPostOrder(node head){
        if(head == null)return;
        printPostOrder(head.left);
        printPostOrder(head.right);
        System.out.print("\t"+head.data);

    }

    void DFS(node head){
        Stack<node> nodeList = new Stack<node>();
        if(head == null) return;
        nodeList.push(head);
        while (!nodeList.isEmpty()){
            node dummy = nodeList.pop();
            System.out.print("\t" + dummy.data);
            if(dummy.right != null){
                nodeList.push(dummy.right);
            }
            if(dummy.left != null) {
                nodeList.push(dummy.left);
            }
        }
    }

    void BFS (node head){
        Queue<node> nodeList = new LinkedList<node>();
        if(head == null)return;
        nodeList.add(head);
        while (!nodeList.isEmpty()){
            node dummy = nodeList.poll();
            System.out.print("\t" + dummy.data);
            if(dummy.left != null){
                nodeList.add(dummy.left);
            }

            if(dummy.right != null){
                nodeList.add(dummy.right);
            }
        }

    }

    public static void main (String [] args){
        //////////////////////////////TREES//////////////////////////////
        System.out.print("\n\n//////////////////////////////TREES//////////////////////////////\n");

        PR03_DataStructures_Trees trees = new PR03_DataStructures_Trees();
        ////// LEVEL ORDER INSERTION
        trees.addTreeNodeLevelOrderInsertion(5);
        trees.addTreeNodeLevelOrderInsertion(4);
        trees.addTreeNodeLevelOrderInsertion(3);
        trees.addTreeNodeLevelOrderInsertion(2);
        trees.addTreeNodeLevelOrderInsertion(1);
        trees.addTreeNodeLevelOrderInsertion(7);
        trees.addTreeNodeLevelOrderInsertion(8);


        System.out.print("\n InorderPrint of root : ");
        trees.printInOrder(trees.root);

        ////// BINARY TREE INSERTION
        trees.binaryTreeInsertion(6);
        trees.binaryTreeInsertion(4);
        trees.binaryTreeInsertion(3);
        trees.binaryTreeInsertion(5);
        trees.binaryTreeInsertion(8);
        trees.binaryTreeInsertion(7);
        trees.binaryTreeInsertion(9);


        System.out.print("\n InorderPrint of binary root : ");
        trees.printInOrder(trees.binarytRoot);

        System.out.print("\n PreorderPrint of binary root : ");
        trees.printPreOrder(trees.binarytRoot);

        System.out.print("\n PostorderPrint of binary root : ");
        trees.printPostOrder(trees.binarytRoot);

        System.out.print("\n DFS of root : ");
        trees.DFS(trees.root);

        System.out.print("\n BFS of root : ");
        trees.BFS(trees.root);


    }
}
