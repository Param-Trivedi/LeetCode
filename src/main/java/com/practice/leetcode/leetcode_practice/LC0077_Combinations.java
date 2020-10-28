package com.practice.leetcode.leetcode_practice;
import java.util.*;

public class LC0077_Combinations {

    public static List<List<Integer>> finalList = new ArrayList<>();;

    public static List<List<Integer>> combine(int n, int k) { 
        combineUtil(n ,k , new ArrayList<Integer>() , 1);
        return finalList;
    }


    public static void combineUtil(int n , int k , ArrayList<Integer> list , int index){

        if(list.size() == k){
            //System.out.println(Arrays.toString(list.toArray()));
            finalList.add(new ArrayList<Integer>(list));
            return;
        }

        for(int i = index ; i <= n ;i++){
            list.add(i);
            combineUtil(n, k, list, i+1);
            list.remove(list.size()-1);
        }

    }


    public static void main (String [] args){

        finalList = combine(4, 2);

        for(List<Integer> list  : finalList){
            System.out.println(Arrays.toString(list.toArray()));
        }
    }
    
}
