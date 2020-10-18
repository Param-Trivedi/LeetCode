package com.practice.leetcode.leetcode_practice;

import java.util.*;

public class LC0459_RepeatedSubstringPattern {
     public boolean repeatedSubstringPattern(String s) {
        StringBuilder finalPattern = new StringBuilder(); 
        boolean repeatedPattern = false;
        for(int i = 0 ; i < s.length()/2 ; i++){
            finalPattern.append(s.charAt(i));

            if((s.length()%i == 0) && s.split(finalPattern.toString()).length == 0){
                repeatedPattern = true;
                break;
            }
        }

        return repeatedPattern;
    } 
}
