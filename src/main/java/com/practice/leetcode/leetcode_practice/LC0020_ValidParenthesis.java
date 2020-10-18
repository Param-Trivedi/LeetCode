package com.practice.leetcode.leetcode_practice;
import java.util.*;
public class LC0020_ValidParenthesis {
    
    public static boolean isValid(String s) {
        Stack<Character> paraStack = new Stack<>();
        if(s.length()%2 != 0)return false;

        for(int i = 0 ; i < s.length() ; i++){
            if( (s.charAt(i) == ')' && ( paraStack.peek() == '(' ))  || (s.charAt(i) == ']' && ( paraStack.peek() == '[' )) || (s.charAt(i) == '}' && ( paraStack.peek() == '{' )) ){
               paraStack.pop();
            }else{
                paraStack.push(s.charAt(i));
            }
        }

        return (paraStack.isEmpty())? true: false;
    } 

}
