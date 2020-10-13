package com.practice.leetcode.leetcode_practice;

import java.util.*;

public class LC0637_AvgOfLevels {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; }  
    } 

    public List<Double> averageOfLevels(TreeNode root) {
        HashMap<Integer , Double> levelSum = new HashMap<>();
        HashMap<Integer , Integer> levelCount = new HashMap<>();
        int height = height(root);
        for(int i = 1 ; i <= height; i++){
            storeLevelOrderSum(root , i ,i , levelSum , levelCount);
        }

       List<Double> finalList = new ArrayList<>();
        
        for(Integer key : levelSum.keySet()){
           finalList.add(levelSum.get(key)/levelCount.get(key)); 
        }

        return new ArrayList<>(levelSum.values());
    }

    public static void storeLevelOrderSum(TreeNode root , int currLevel , int level  , HashMap<Integer , Double>  levelSum , HashMap<Integer , Integer> levelCount){
        if(root == null)return;
        if(currLevel == 1 ){
            levelSum.put(level, levelSum.getOrDefault(level, 0.0) + (root.val));
            levelCount.put(level, levelCount.getOrDefault(level, 0) + 1);
        }else {
            storeLevelOrderSum(root.left, currLevel - 1, level, levelSum , levelCount);
            storeLevelOrderSum(root.right, currLevel - 1, level, levelSum, levelCount);
        }
    }

    public List<Double> averageOfLevels2(TreeNode root) {
        List<Double> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int levelSize = q.size();
            Double levelSum = 0.0;
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = q.poll();
                levelSum += currentNode.val;
                if (currentNode.left != null) {
                    q.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    q.offer(currentNode.right);
                }
            }
            result.add(levelSum / levelSize);
        }
        return result;
    }

    public static int height (TreeNode root){
        if(root == null) return 0;
        return Integer.max(height(root.left), height(root.right)) + 1;
    }

    public static void main (String [] args){
        TreeNode root1 = new TreeNode(1);
		root1.left = new TreeNode(3);
		root1.right = new TreeNode(2);
        root1.left.left = new TreeNode(5);
        
        System.out.print(height(root1));
    }
}
