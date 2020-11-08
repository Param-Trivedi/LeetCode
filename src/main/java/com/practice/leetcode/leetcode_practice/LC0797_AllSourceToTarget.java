package com.practice.leetcode.leetcode_practice;
import java.util.*;
import java.util.Arrays;
public class LC0797_AllSourceToTarget {
    public static HashMap<Integer ,Edge> currlist;
    
    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {   
        currlist = new HashMap<>();
        Edge curr;
        for(int i = 0 ; i < graph.length ; i++){
             if(currlist.containsKey(i)){
                 curr = currlist.get(i);
             }else{
                 curr = new Edge(i);
                 
             }
            //  System.out.println("");
            //  System.out.print(curr.val + " | " + Arrays.toString(graph[i]));   
             curr.populateGraph(graph[i]);

            //  System.out.println("");
            //  System.out.print(curr.val + " | " + Arrays.toString( curr.edgeList.toArray() ));    

        }
        
        return currlist.get(0).pathToNode(graph.length - 1);
        
    }
    
    public static class Edge {
        int val;
        List<Edge> edgeList;
       
        
        Edge(int val){
            this.val = val;
            this.edgeList = new ArrayList<>();
            currlist.put(val , this);
        }
        
        void populateGraph(int[] edges){
            
            for(int i = 0 ; i < edges.length ; i++){
                Edge curr;
                if(currlist.containsKey(edges[i])){
                    curr = currlist.get(edges[i]);
                }else{
                    curr = new Edge(edges[i]);
                }
                
                this.edgeList.add(curr);
            }
        }
        
        List<List<Integer>> pathToNode(int node){
            List<List<Integer>> finalList = new ArrayList<>();
            Edge curr = this;
            pathToNodeUtil(node ,curr, new ArrayList<Integer>() , finalList);
            return finalList;
        }
        
        void pathToNodeUtil(int node , Edge curr , ArrayList<Integer> nodeList , List<List<Integer>> finalList){
            if(curr == null)return;
            
            if(curr.val == node){
                nodeList.add(curr.val);
                finalList.add(nodeList); return;
            }
            
            if(curr.edgeList.size() == 0){
                return;
            }
            //System.out.print("\n");
            //System.out.print(curr.val + "  | ");
            nodeList.add(curr.val);
            for(int i = 0 ; i < curr.edgeList.size() ; i++){
               // System.out.print(" \t " + edgeList.get(i).val);
                pathToNodeUtil(node , curr.edgeList.get(i) , new ArrayList<>(nodeList) , finalList);
            }
        }
        
    }


    public static void main (String [] args){
        //List<List<Integer>> finallist = allPathsSourceTarget(new int[][]{ {1,2} , {3} , {3} , {} });
        List<List<Integer>> finallist = allPathsSourceTarget(new int[][]{ {4,3,1} , {3,2,4} , {3} , {4} , {} });

        for(int i = 0 ; i < finallist.size() ; i++){
            System.out.println(Arrays.toString(finallist.get(i).toArray()));
        }
    }
}
