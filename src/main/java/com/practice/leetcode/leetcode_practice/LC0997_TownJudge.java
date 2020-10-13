package com.practice.leetcode.leetcode_practice;

public class LC0997_TownJudge {
    
    public static int findJudge(int N, int[][] trust) {
        // int[][] adjMat = new int[N+1][N+1];

        // for(int i = 0 ; i < trust.length ; i++){
        //     int [] currArry = trust[i];
        //     adjMat[currArry[1]][currArry[0]] = 1;
        // }

        // int n = 0;
        // for(int i = 1 ; i < adjMat.length ; i++){
        //     int sum = 0;
        //     for(int j = 1 ; j < adjMat[i].length ; j++){
        //         sum += adjMat[i][j];
        //     }

        //     if(sum == N-1){
        //         n = i; break;
        //     }
        // }
        // if(n == 0)return -1;
        
        // int sum = 0;
        // for(int i = 1 ; i < adjMat[n].length ; i++){
        //     sum += adjMat[i][n];
        // }
        // if(sum > 0)return -1;
        // return n; 

        int [] trustArray = new int[N+1];
        for(int i = 0 ; i < trust.length ; i++){
            int [] currArry = trust[i];
            trustArray[currArry[0]] -=  1;
            trustArray[currArry[1]] +=  1;
        }

        int currPerson = 0; boolean containsZero = false;

        for(int i = 0 ; i < trustArray.length ; i++){
            if(trustArray[i] > 0){
                currPerson = trustArray[i] ;
            }

            if(trustArray[i] == 0)containsZero = true;
        }

        if(containsZero == false && currPerson > 0)return currPerson;

        return - 1;

    }

}
