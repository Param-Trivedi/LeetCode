package com.practice.leetcode.leetcode_practice;
import java.util.*;
public class LC1379_FindClonedNode {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; }
    }

    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        Queue<TreeNode> nodeList = new LinkedList<>();
        if(cloned == null || (cloned.left == null && cloned.right == null)){
            return cloned;
        }
        
        nodeList.add(cloned);
        while(!nodeList.isEmpty()){
            TreeNode temp = nodeList.poll();
            if(temp.val == target.val){
                return temp;
            }
            
            if(temp.right != null)nodeList.add(temp.right);
            if(temp.left != null)nodeList.add(temp.left);
        }
        
        return null;
        
    }

}
