package com.practice.leetcode.leetcode_practice;
import java.util.*;

public class CTCI03_STACK_QUEUES {
    
    public static void sort(Stack<Integer> stack){
        Stack<Integer> tempStack = new Stack<Integer>();

        while(!stack.isEmpty()){
           int temp = stack.pop();
           while (!tempStack.isEmpty() && tempStack.peek() < temp){
                stack.push(tempStack.pop());           
           }
           tempStack.push(temp);
        }

        while(!tempStack.isEmpty()){
            stack.push(tempStack.pop());
        }
        for(int i = 0 ; i < stack.size() ; i++){
            System.out.print("\t"+ stack.get(i));
        }
    }


    public static void main (String [] args){
        System.out.println("Sort Stack : " );
        Stack<Integer> stack = new Stack<>();
        stack.push(1);stack.push(2); stack.push(4); stack.push(3); stack.push(5);
        sort(stack);
        
    }
}
