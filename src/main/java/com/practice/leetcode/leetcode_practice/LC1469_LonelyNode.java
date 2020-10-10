package com.practice.leetcode.leetcode_practice;

import java.util.*;


public class LC1469_LonelyNode {
    
    public static class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;
            TreeNode() {}
            TreeNode(int val) { this.val = val; }
            TreeNode(int val, TreeNode left, TreeNode right) {
                 this.val = val;
                 this.left = left;
                 this.right = right;
            }
    }

    public static List<Integer> getLonelyNodes(TreeNode root) {
        ArrayList<Integer> finalList = new ArrayList<>();

        getLonelyNodesUtil(root,root.left,root.right,finalList);

        return finalList;
    }

    public static void getLonelyNodesUtil(TreeNode root , TreeNode left , TreeNode right , ArrayList<Integer> finalList){
        if(root == null)return;

        if(left == null && right != null)finalList.add(right.val);
        if(right == null && left != null)finalList.add(left.val);

        if(left != null) getLonelyNodesUtil(left, left.left, left.right, finalList);
        if(right != null)getLonelyNodesUtil(right, right.left, right.right, finalList);
        
    }

    public static void main (String [] args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.left.right.right = new TreeNode(5);

        List<Integer> finalList = getLonelyNodes(root);

        for(int i = 0 ; i < finalList.size() ; i++){
            System.out.print("\t" + finalList.get(i));
        }
    }
}
