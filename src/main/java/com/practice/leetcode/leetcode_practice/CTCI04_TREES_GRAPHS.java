package com.practice.leetcode.leetcode_practice;

public class CTCI04_TREES_GRAPHS {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; }
    }  


    public static void printLevelOrder(TreeNode root , int level){
        if(root == null)return;
        if(level == 1)System.out.print("\t" + root.val);
        else{
            printLevelOrder(root.left, level - 1);
            printLevelOrder(root.right, level - 1);
        }
    }

    public static void bfs(TreeNode root){
        int h = height(root); 
        int i; 
        for (i=1; i<=h; i++) 
            printLevelOrder(root, i);
    }

    public static int height(TreeNode root) 
    { 
        if (root == null) 
           return 0; 
        else
        { 
            /* compute  height of each subtree */
            int lheight = height(root.left); 
            int rheight = height(root.right); 
              
            /* use the larger one */
            if (lheight > rheight) 
                return(lheight+1); 
            else return(rheight+1);  
        } 
    }

    public static void main (String [] args){
       TreeNode tree = new TreeNode(1); 
       tree.left= new TreeNode(2); 
       tree.right= new TreeNode(3); 
       tree.left.left= new TreeNode(4); 
       tree.left.right= new TreeNode(5); 


        bfs(tree);
    }

}

