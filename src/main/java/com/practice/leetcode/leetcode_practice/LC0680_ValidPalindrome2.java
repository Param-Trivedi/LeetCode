package com.practice.leetcode.leetcode_practice;

public class LC0680_ValidPalindrome2 {
    
    public static boolean validPalindrome(String s) {
        return validPalindromeUtil(s, false);
    }

    public static boolean validPalindromeUtil(String s, Boolean removeChar){
        int i = 0,j = s.length() -1;    
        while(i < j){
            char iVal = Character.toLowerCase(s.charAt(i));
            char jVal = Character.toLowerCase(s.charAt(j)); 

            if(iVal == jVal){
                    i++; j--; continue;
                
            }else if(iVal != jVal && removeChar == false){
                return (validPalindromeUtil(s.substring(i+1,j+1) , true )  || validPalindromeUtil(s.substring(i,j) , true ));
            }else{
                return false;
            }
        }
        return true;
    }


    public static void main(String [] args){
        //ececabbacec
        String s = "abcdefg";
        System.out.println(validPalindrome("ebcbbcecabbacecebbcbe"));
        System.out.println(validPalindrome("aba"));
        System.out.println(validPalindrome("abca"));
        System.out.println(validPalindrome("abcde"));
    }

}
