package com.practice.leetcode.leetcode_practice;
import java.util.*;
public class LC0965_UnivaluedBinaryTree {
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

    public static boolean isUnivalTree(TreeNode root) {    
        if(root == null)return true;

        Queue<TreeNode> treeQueue = new LinkedList<>();
        boolean isUniTree = true; int val = root.val;
        treeQueue.add(root);
        while(!treeQueue.isEmpty()){
            TreeNode dum = treeQueue.poll();
            if(dum.val != val){
                isUniTree = false;
                break;
            }

            if(dum.right != null)treeQueue.add(dum.right);
            if(dum.left != null)treeQueue.add(dum.left);
        }
        return isUniTree;
    }

}
