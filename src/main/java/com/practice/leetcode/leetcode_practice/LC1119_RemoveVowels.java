package com.practice.leetcode.leetcode_practice;

import java.util.HashSet;

public class LC1119_RemoveVowels {
    
    public static HashSet<Character> initializeVowels(){

        HashSet<Character> vowelSet = new HashSet<>();
        vowelSet.add('a');vowelSet.add('e');vowelSet.add('i');vowelSet.add('o');vowelSet.add('u');
        return vowelSet;
    }
    public String removeVowels(String S) {
        HashSet<Character> charSet = initializeVowels();
        StringBuilder str = new StringBuilder();
        for(int i = 0 ; i < S.length() ; i++){
            if(charSet.contains(S.charAt(i)))continue;
            else{
                str.append(""+S.charAt(i));
            }
        }

        return str.toString();
    }

}
