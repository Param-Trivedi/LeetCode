package com.practice.leetcode.leetcode_practice;
import java.util.*;

public class LC0022_GenerateParenthesis {
    
    public static List<String> generateParenthesis(int n) {
        List<String> finalList = new ArrayList<>();
        utilFunc(new StringBuilder(), finalList , 0 , 0 , n);             
        return finalList;   
    }

    public static void utilFunc(StringBuilder str , List<String> currList , int open , int close , int max){

        if(str.length() == 2*max){
            System.out.println(str.toString());
            currList.add(str.toString());
            return;
        }

        if(open < max){
            utilFunc(str.append("("), currList, open+1, close, max);
            str.deleteCharAt(str.length() - 1);
        }
        if(close < open ) {
            utilFunc(str.append(")"), currList, open, close+1, max);
            str.deleteCharAt(str.length() - 1);
        }

    }

    public static void main (String [] args){
        List<String> fin = generateParenthesis(3);
    }
    
}
