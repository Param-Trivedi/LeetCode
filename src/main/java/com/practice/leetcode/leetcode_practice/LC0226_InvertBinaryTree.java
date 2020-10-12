package com.practice.leetcode.leetcode_practice;

public class LC0226_InvertBinaryTree {
    private static class TreeNode {
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
    
    public static TreeNode invertTree(TreeNode root) {
        root = invertTreeUtil(root);
        return root;
    }

    public static TreeNode invertTreeUtil(TreeNode root){
        if(root == null || (root.left == null) && (root.right == null)) return root;
        TreeNode temp1 = root.left;
        TreeNode temp2 = root.right;
        root.left =  invertTreeUtil(temp2);
        root.right = invertTreeUtil(temp1);
        return root;
    }
}
