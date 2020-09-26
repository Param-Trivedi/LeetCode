package com.practice.leetcode.leetcode_practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class LC1512_NoOfGoodPairs {
    /**
     *  TODO:
     *    1. LEETCODE# : 1512
     *    2. TIMER:
     */

    public static int goodPairs(int [] nums){
        int goodPairs = 0;
        for(int i =0; i < nums.length ; i++){
            for(int j = i+1; j < nums.length ; j++){
                if(nums[i] == nums[j])goodPairs++;
            }
        }

        return goodPairs;
    }

    public static int goodPairMap(int [] nums){
        HashMap<Integer , Integer> numMap = new HashMap<>();
        int totalPair = 0;
        for(int i = 0 ; i < nums.length ; i++){
            numMap.put(nums[i], numMap.getOrDefault(nums[i],0) + 1);
            totalPair += numMap.get(nums[i]) - 1;
        }

        return totalPair;
    }


    public static void main (String [] args){
         System.out.print(goodPairMap(new int [] {1,2,3,1,1,3}));
    }
}
