package com.practice.leetcode.leetcode_practice;

import java.util.Arrays;

public class LC1470_ShuffleArray {

    /**
     *  TODO:
     *    1. LEETCODE# : 1470
     *    2. TIMER:
     */

    public static int[] shuffleArray (int [] nums , int n){
        int[] finalArray = new int [nums.length];
        int numCurr = 0;
        for(int i = 0 ;  i < nums.length ; i = i+2, n++, numCurr++){
            finalArray[i] = nums[numCurr];
            finalArray[i+1] = nums[n];
        }

        return finalArray;
    }

    public static void main (String [] args) {
        int [] arrayFinal = shuffleArray(new int [] {1,2,3,4,5,6},3);
        System.out.print(Arrays.toString(arrayFinal));
    }
}
