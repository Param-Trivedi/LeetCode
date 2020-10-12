package com.practice.leetcode.leetcode_practice;

public class LC0104_BinaryTreeHeight {
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
    
    public static int maxDepth(TreeNode root) {
        int height = 0;
        height = maxDepthUtil(root, height + 1);
        return height;
    }

    public static int maxDepthUtil(TreeNode root , int h){
        if(root == null)return h - 1;
        return Integer.max(maxDepthUtil(root.left , h+1), maxDepthUtil(root.right , h+1));
    }


}
