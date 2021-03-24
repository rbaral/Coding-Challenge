/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.ccup;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author rbaral
 * 
 * Given a stack S, write a C program to sort the stack (in ascending order). 
You are not allowed to make any assumptions about how the stack is implemented; the only 
functions allowed to be used are: Push, Pop, Top, IsEmpty, IsFull.
* 
* Solution 1:
* 1)create a new stack 
* 2) repeat while the input stack is not empty
* 2 a) pop the top of input stack and hold in a temp variable
* 2 b) while the top of new stack is greater than temp variable, pushs the top of new stack to the input stack
* 2 c) push the temp variable to the new stack
* 
* Complexity: O(n^2)
 * 
 */
public class SortStackQueue {
    
    public static Stack<Integer> sortStack(Stack<Integer> a){
        Stack<Integer> b = new Stack<Integer>();
        //pop from the input stack and push into the new stack
        //if the popped one from input stack is greater than the top of new stack, push the greater first and then only smallest
        while(!a.isEmpty()){
            int topA = a.pop();
            while(!b.isEmpty() && b.peek()>topA){
                a.push(b.pop());
            }
            b.push(topA);
        }
        return b;
    }
    
    public static Stack<Integer> sortStackUsingBubble(Stack<Integer> a){
        int n = a.size();
        for(int i=0;i<n;i++){
            int x = a.pop();
            for(int j=0;j<n;j++){
                int y = a.pop();
                if(x<y){
                    a.push(y);
                }else{
                    a.push(x);
                    x = y;
                }
            }
            a.push(x);
        }
        return a;
    }
    
    
    /**
     * Use bubble sort for the sorting of queue elements
     * @param a
     * @return 
     */
    public static Deque<Integer> sortQueueUsingBubble(Deque<Integer> a){
        int n = a.size();
        for(int i=0;i<n;i++){
            int x = a.pollFirst();
            for(int j=1;j<n;j++){
                int y = a.pollFirst();
                if(x<y){
                    a.offer(y);
                }else{
                    a.offer(x);
                    x = y;
                }
            }
            a.offer(x);
        }
        return a;
    }
    
    public static void main(String args[]){
        Stack<Integer> st = new Stack<Integer>();
        /*
        st.push(5);
        st.push(1);
        st.push(0);
        st.push(3);
        */
        
        st.push(5);
        st.push(3);
        st.push(12);
        st.push(7);
        
        Stack<Integer> sortedStack = sortStack(st);
        //print the elements
        while(!sortedStack.isEmpty()){
            System.out.println(" "+sortedStack.pop());
        }
        
        /*
        Deque<Integer> a = new LinkedList<Integer>();
        a.offer(11);
        a.offer(1);
        a.offer(2);
        a.offer(0);
        a.offer(7);
        a.offer(-1);
        a = sortQueueUsingBubble(a);
        while(!a.isEmpty()){
            System.out.println(" "+a.pollFirst());
        }
        */
        
    }
}
