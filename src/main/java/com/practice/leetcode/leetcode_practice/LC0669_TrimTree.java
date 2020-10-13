package com.practice.leetcode.leetcode_practice;

public class LC0669_TrimTree {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; }
    }
    
    public static TreeNode trimBST(TreeNode root, int low, int high) {
        root = trimBSTUtil(root, low, high);
        return root;
    }

    public static TreeNode trimBSTUtil(TreeNode root  , int low , int high){
        if(root == null)return root;
        TreeNode temp ;
        if(root.val >= low && root.val <= high ){
            temp = new TreeNode(root.val);
            temp.left = trimBSTUtil(root.left  , low , high);
            temp.right = trimBSTUtil(root.right  , low , high);
        }
        
        else if(root.val < low){
            temp = trimBSTUtil(root.right  , low , high);
        }
        else{
            temp = trimBSTUtil(root.left  , low , high);
        }
        
        return temp;
    }
}
