package com.practice.leetcode.leetcode_practice;

import java.util.Arrays;

public class LC1528_ShufflingString {

    /**
     *  TODO:
     *    1. LEETCODE# : 1528
     *    2. TIMER:
     */

    public static String shuffleString(String s, int[] indices){
        String[] stringArray = new String[s.length()] ;

        for(int i = 0 ;  i < stringArray.length ; i++){
            stringArray[indices[i]] = ""+s.charAt(i);
        }

        StringBuilder finalStr = new StringBuilder();
        for(int i = 0 ; i < stringArray.length ; i++){
            finalStr.append(stringArray[i]);
        }
        return finalStr.toString();
    }

    public static void main (String [] args){
        System.out.print(shuffleString("codeleet" , new int [] {4,5,6,7,0,2,1,3}));
    }

}
