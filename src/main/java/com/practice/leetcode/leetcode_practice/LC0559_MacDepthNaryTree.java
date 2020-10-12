package com.practice.leetcode.leetcode_practice;

import java.util.*;

public class LC0559_MacDepthNaryTree {

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

    public static int maxDepth(Node root) {
        int maxDepth = 0;
        maxDepth = maxDepthUtil(root, maxDepth + 1);   
        return maxDepth;
    }

    public static int maxDepthUtil(Node child, int h){
        if(child.children.isEmpty()) {
            return (h);
        }
        int maxDepth = 0;
        for(Node ch : child.children){
            maxDepth = Integer.max(maxDepth, maxDepthUtil(ch,h+1)) ;
        }
        return maxDepth;
    }

    public static void main (String [] args){

    }
    
}
