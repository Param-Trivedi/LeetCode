package com.practice.leetcode.leetcode_practice;

import java.util.Arrays;

public class LC0014_LongestCommonPrefix {
    
    public static String longestCommonPrefix(String[] strs) {

        String word = findShortest(strs);
        if(word.equals(""))return word;
        StringBuilder prefix=  new StringBuilder();
        for(int i = 0 ; i < strs.length ; i++){
            String currWord = strs[i];
            StringBuilder tempPrefix=  new StringBuilder();
            for(int j = 0 ; j < word.length() ; j++){
               if(currWord.charAt(j) == word.charAt(j)){
                tempPrefix.append(word.charAt(j));
               }else{
                   break;
               }
            }

            if(tempPrefix.toString().equals(""))return "";
            else if(prefix.toString().equals("")) {
                prefix = new StringBuilder(tempPrefix);
                //System.out.println(tempPrefix.toString() + "  |  " + prefix.toString());
            }else {
                prefix =  (tempPrefix.length() <= prefix.length())? new StringBuilder(tempPrefix)   : new StringBuilder(prefix);
            }
            
        }

        return prefix.toString();
    }

    public static String findShortest(String[] strs){
        int len = Integer.MAX_VALUE;
        String word = "";

        for(int i = 0 ; i < strs.length ; i++){
            String currWord = strs[i];
            if(currWord.length() < len){
                len = currWord.length();
                word = currWord;
            }
        }

        return word;
    }

    public static void main (String [] args){
        System.out.println(longestCommonPrefix(new String [] {"flower","flow","flight"}));
    }
}
