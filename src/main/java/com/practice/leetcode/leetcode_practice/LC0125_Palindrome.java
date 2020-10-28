package com.practice.leetcode.leetcode_practice;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LC0125_Palindrome {
    
    public static boolean isPalindrome(String s) {
        
        int i = 0,j = s.length() -1;
        Boolean lastEqual = true;
        
        while(i <= j){
            char iVal = Character.toLowerCase(s.charAt(i));
            char jVal = Character.toLowerCase(s.charAt(j)); 

            if(!Character.isLetterOrDigit(iVal)){
                i++; continue;
            }else if (!Character.isLetterOrDigit(jVal)){
                j-- ; continue;
            }else if(iVal == jVal){
                    i++; j--; continue;
                
            }else{
                return false;
            }
        }
        return (lastEqual == true)?true:false;
        //"ecabba"
    }

}
