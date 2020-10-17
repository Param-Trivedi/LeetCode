package com.practice.leetcode.leetcode_practice;

public class LC0067_AddBinary {
    
    public static String addBinary(String a, String b) {
        StringBuilder str = new StringBuilder();
        int carry = 0;         
        for(int i = a.length() -1, j = b.length() - 1 ; i >= 0 || j>=0  ; i-- , j-- ){
            int bigChar = (i < 0)?0:Integer.parseInt(""+a.charAt(i));
            int smallChar = (j < 0)?0:Integer.parseInt(""+b.charAt(j));
            int sum = bigChar + smallChar + carry;
            if(sum > 1)carry = 1;
            sum = sum%2;
            str.insert(0,sum);
            System.out.println(sum  + " " + bigChar + " " + smallChar + "\t");

        }
        str = (carry == 1)? str.insert(0,carry): str;
        return   str.toString();
    }   


    public static void main (String [] args){
        System.out.print(addBinary("11","1"));
    }

}
