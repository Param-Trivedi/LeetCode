package com.practice.leetcode.leetcode_practice;

import java.util.*;

public class LC0590_NaryPostOrder {
	 /**
     *  TODO:
     *    1. LEETCODE# : 617
     *    2. TIMER:
     */
	
	private static class Node {
	    public int val;
	    public List<Node> children;

	    public Node() {}

	    public Node(int _val) {
	        val = _val;
	    }

	    public Node(int _val, List<Node> _children) {
	        val = _val;
	        children = _children;
	    }
	}
	
	
	public static List<Integer> postorder(Node root) {
		LinkedList<Integer> finalList = new LinkedList<>();
		Stack<Node> nodeStack = new Stack<>();
		if(root == null)return finalList;
		
		nodeStack.push(root);
		
		while(!nodeStack.isEmpty()) {
			Node curr = nodeStack.pop();
			
			if(curr == null)continue;
			
			finalList.addFirst(curr.val);
			
			if(curr.children != null) {
				for(Node temp : curr.children) {
					nodeStack.push(temp);
				}
			}
		}
		
        return finalList;
    }
	
	public static void main (String [] args) {
		
		
	}
}
