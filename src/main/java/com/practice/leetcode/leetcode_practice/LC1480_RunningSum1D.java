package com.practice.leetcode.leetcode_practice;

import java.util.Arrays;

public class LC1480_RunningSum1D {

    /**
     *  TODO:
     *    1. LEETCODE# : 1480
     *    2. TIMER: 5:00
     */

    public static int[] runningSum (int [] nums){
        if(nums.length == 0)return nums;
        int currSum = 0;
        for(int i = 0 ; i< nums.length ; i++){
            nums[i] =  nums[i] + currSum;
            currSum = nums[i];
        }
        return nums;
    }

    public static void main (String [] args){
        int [] finalNums = runningSum(new int [] {1,2,3,4});
        System.out.print(Arrays.toString(finalNums));
    }

}
