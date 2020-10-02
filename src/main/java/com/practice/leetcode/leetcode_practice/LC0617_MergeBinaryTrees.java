package com.practice.leetcode.leetcode_practice;

import java.util.*;

public class LC0617_MergeBinaryTrees {
	 /**
     *  TODO:
     *    1. LEETCODE# : 617
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
	
	public static void inOrder (TreeNode root) {
		if(root == null)return;
		inOrder(root.left);
		System.out.print("\t" + root.val);
		inOrder(root.right);
	}
	
	public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
		Queue<TreeNode> t1Q = new LinkedList();
		Queue<TreeNode> t2Q = new LinkedList();
	
		if(t1 == null)return t2;
		if(t2 == null)return t1;
		
		TreeNode finalTree = null;
		t1Q.add(t1);
		t2Q.add(t2);
		
		while(!(t1Q.isEmpty()) || !(t2Q.isEmpty())) {
			TreeNode dummy1 = t1Q.poll();
			TreeNode dummy2 = t2Q.poll();
			//System.out.println(dummy1.val +" " + dummy2.val);
		
			
			if(dummy1 != null && dummy2 != null) dummy1.val += dummy2.val;
			if(dummy1 == null && dummy2 != null) dummy1 = dummy2;
			if(dummy1 != null && dummy2 == null) continue;
			
			if(dummy1.left == null) {
				dummy1.left = dummy2.left;
			}else {
				t1Q.add(dummy1.left);
				t2Q.add(dummy2.left);
			}
			
			
			
			if(dummy1.right == null) {
				dummy1.right = dummy2.right;
			}else {
				t1Q.add(dummy1.right);
				t2Q.add(dummy2.right);
			}
		
		}
        return t1;
    }
	
	public static void main (String [] args) {
		TreeNode root1 = new TreeNode(1);
		root1.left = new TreeNode(3);
		root1.right = new TreeNode(2);
		root1.left.left = new TreeNode(5);
		
		
		TreeNode root2 = new TreeNode(2);
		root2.left = new TreeNode(1);
		root2.right = new TreeNode(3);
		root2.left.right = new TreeNode(4);
		root2.right.right = new TreeNode(7);
		
		
		TreeNode root = mergeTrees(root1,root2);
		System.out.print("InOrder Print :");
		inOrder(root);
		
	}
}
