/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.ctci.stack;

/**
 *How would you design a stack which, in addition to push and pop, also has a
function min which returns the minimum element? Push, pop and min should all
operate in 0(1) time
* 
* Solution 1:
* 1)when an element is inserted, it should keep track of what is the minimum element caused by its insertion
* So whatever the top element thinks as min will be the min of the stack
* 2)This requires every node to have an extra field to remember the min
* 
* This might not be efficient with large stack
* 
* 
* Solution 2:
* 1)We use a separate stack s2 to maintain the minimums
* 2)If the newly inserted item is greater than the top of s2, we don't need to insert into s2
* 3)if the item popped is equal to the top of s2, we remove the top item from s2
* 
* 
* 
 * @author rbaral
 */
public class MinStack {
    
    class Node {
        Node above; //the node above this node
        Node below; //the node below this node
        int data; // the data of this node

        public Node(int d) {
            data = d;
        }
    }
    
    
    class Stack{
        int size = 0; //the size of this stack - the no. of elements it is holding
        Node top; //the node at the top of the stack
        Node bottom; //the node at the bottom of the stack
        public Stack() {

        }

        // pushes the data to stack, assuming it supports only int data type
        public boolean push(int data) {
            size++;

            Node n = new Node(data);
            if (size == 0) {//there are no elements in the stack
                bottom = n;
                bottom.below = null;
                bottom.above = null;
                top = n;
            } else{//there is already at least one node
                if (top != null) {
                    top.above = n;
                    n.below = top;
                    top = n;
                } else {
                    top = n;
                    top.below = bottom;
                    top.above = null;
                }
                }
            return true;
        }

        //pops the top element from the stack
        public void pop() {
            Node n = top;
            top = top.below;
            //top.above = null;
            size--;
            
        }
        
        public int top() {
            Node n = top;
            //top = top.below;
            //size--;
            return n.data;
        }
        public boolean isEmpty() {
            return size == 0;
        }
    }
    
    int size = 0; //the size of this stack - the no. of elements it is holding
    Node top; 
    Node bottom;
    Stack s2;
    
    /** initialize your data structure here. */
    public MinStack() {
        
    }
    
    public void push(int x) {
        if(x<=getMin()){
            s2.push(x);
        }
        size++;
        Node n = new Node(x);
        if (size == 0) {//there are no elements in the stack
            bottom = n;
            bottom.below = null;
            bottom.above = null;
            top = n;
        } else//there is already at least one node
        if (top != null) {
            top.above = n;
            n.below = top;
            top = n;
        } else {
            top = n;
            top.below = bottom;
            top.above = null;
        }
    }
    
    public void pop() {
        int value = top();
        if(value==getMin()){
            s2.pop();
        }
        Node n = top;
        top = top.below;
        size--;
        
    }
    
    public int top() {
        Node n = top;
        //top = top.below;
        return n.data;
    }
    
    public int getMin() {
        if(s2.isEmpty()){
            return Integer.MAX_VALUE;
        }else{
            return s2.top();
        }
    }
}
