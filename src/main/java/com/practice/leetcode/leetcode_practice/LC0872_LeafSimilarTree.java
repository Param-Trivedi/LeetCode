package com.practice.leetcode.leetcode_practice;
import java.util.*;
import java.lang.*;

public class LC0872_LeafSimilarTree {

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
    public static boolean leafSimilar(TreeNode root1, TreeNode root2) 
    {
        List<Integer> array1 = new ArrayList<>();
        List<Integer> array2 = new ArrayList<>();
        
        array1 = leafSimilarUtil(root1, array1);
        array2 = leafSimilarUtil(root2, array2);

        return array1.equals(array2);
    }

    public static List<Integer> leafSimilarUtil(TreeNode root , List<Integer> array){
        if(root ==null)return array;
        Stack<TreeNode> currStack = new Stack<>();
        currStack.push(root);

        while(!currStack.isEmpty()){
            TreeNode curr = currStack.pop();
            if(curr.left == null && curr.right == null){
                array.add(curr.val);
            }

            if(curr.right != null)currStack.push(curr.right);
            if(curr.left != null)currStack.push(curr.left);
        }
        return array;
    }

    public static void main (String [] args){
        System.out.print(leafSimilar(null, null));
    }
}