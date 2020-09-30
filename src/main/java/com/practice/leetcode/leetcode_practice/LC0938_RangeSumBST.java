package com.practice.leetcode.leetcode_practice;

import java.util.LinkedList;
import java.util.Queue;

public class LC0938_RangeSumBST {
	 /**
     *  TODO:
     *    1. LEETCODE# : 938
     *    2. TIMER:
     */
	
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
	
	public static int rangeSumBST(TreeNode root, int L, int R) {
		Queue<TreeNode> node = new LinkedList<>();
		node.add(root);
		int sum = 0;
		while(!node.isEmpty()) {
			TreeNode dummy =  node.poll();
			
			if(dummy.val >= L && dummy.val <= R)sum += dummy.val;
			
			if(dummy.left != null)node.add(dummy.left);
			if(dummy.right != null)node.add(dummy.right);
		}
        return sum;
    }
	
	public static void main (String [] args) {
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(5);
		root.right = new TreeNode(15);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(7);
		root.right.right = new TreeNode(18);
		
		System.out.print("Range Sum is : " + rangeSumBST(root , 7,15));
	}
}
