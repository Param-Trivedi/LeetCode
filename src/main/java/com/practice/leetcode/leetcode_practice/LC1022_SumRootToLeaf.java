package com.practice.leetcode.leetcode_practice;

public class LC1022_SumRootToLeaf {
    
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

    public static int sumRootToLeaf(TreeNode root) {
        if(root == null) return 0;

        int finalSum = 0;

        finalSum = sumRootToLeafUtil(root , finalSum );
        return finalSum;
    }

    public static int sumRootToLeafUtil(TreeNode root, int finalSum){
        if(root == null)return finalSum;
        
        finalSum = 2*finalSum + root.val;
        
        return (root.left == null && root.right == null) ?  finalSum : (sumRootToLeafUtil(root.left, finalSum) + sumRootToLeafUtil(root.right, finalSum));

    }
}
