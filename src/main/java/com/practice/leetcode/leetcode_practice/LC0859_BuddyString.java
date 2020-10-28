package com.practice.leetcode.leetcode_practice;
import java.util.*;

public class LC0859_BuddyString {
    public static boolean buddyStrings(String A, String B) {
        
        if(A.length() != B.length()){
            return false;
        }

        if(A.equals(B)){
            return equalBuddyUtil(A);
        }
        List<Integer> diff = new ArrayList<>();
        for(int i  = 0 ; i < A.length() ; i++){
            if(A.charAt(i) != B.charAt(i)){
                diff.add(i);
            }    
        }

        if(diff.size() == 2 && ( A.charAt(diff.get(0)) == B.charAt(diff.get(1)) ) &&  (A.charAt(diff.get(1)) == B.charAt(diff.get(0))) ){
            return true;
        }

        return false;
    }    

    public static boolean equalBuddyUtil(String A){

        HashSet<Character> charSet = new HashSet<>();

        for( int i = 0 ; i < A.length() ; i++){
            charSet.add(A.charAt(i));
        }

       
        
        return (charSet.size() < A.length());
    }
    

    public static void main (String [] args){
        String S = "abccbd";
        System.out.print(S.substring(0, 2) + S.substring(3, S.length()));
        ArrayList<String> s = new ArrayList<>();
        HashMap<String, Integer> curr = new HashMap<>();
    }
    
}
