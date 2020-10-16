package com.practice.leetcode.leetcode_practice;
import java.util.*;
public class LC1614_MaxNestingOfParenthesis {
    
    public static int maxDepth(String s) {
        int maxDepth = 0;
        if(s.length() == 0) return maxDepth;
        int tempDepth = 0 ; boolean isFront = false ; boolean isBack = false;

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                tempDepth = (tempDepth == 0)?1:tempDepth + 1;                
            }
            else if (s.charAt(i) == ')'  ){
                tempDepth -= 1;
            }else{
                continue;
            }
            maxDepth = (maxDepth > tempDepth)? maxDepth: tempDepth;   
        }
        return maxDepth;
    }

    public static void main (String [] args){
        System.out.print(maxDepth("(1+(2*3)+((8)/4))+1"));
    }
}
