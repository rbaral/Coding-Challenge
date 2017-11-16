/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.leetup;

/**
 * 
 * Implement the following operations of a queue using stacks.

push(x) -- Push element x to the back of queue.
pop() -- Removes the element from in front of queue.
peek() -- Get the front element.
empty() -- Return whether the queue is empty.
Notes:
You must use only standard operations of a stack -- which means only push to top, peek/pop from top, size, and is empty operations are valid.
Depending on your language, stack may not be supported natively. You may simulate a stack by using a list or deque (double-ended queue), as long as you use only standard operations of a stack.
You may assume that all operations are valid (for example, no pop or peek operations will be called on an empty queue)
* 
* 
 *
 * Solution 1:
 * 1)Create two stacks, assume s1 be the one which maintains queue order and s2 as a buffer
 * 2)when adding element, 
 * a) empty s1 into s2
 * b) add the  new element to s1
 * c) empty s2 to s1
 * 3)when dequeuing element, simply do pop on s1
 * 4) when doing peek, simply do peek on s1
 * 
 * Complexity: O(4n) as we have every element in stack pushed and popped twice
 * 
 * Solution 2:
 * 1)Just push every element into s1
 * 2)when we have to dequeue, empty s1 into s2 and pop from top of s2
 * 2 a) the push will be always on s1
 * 2 b) dequeue from s2, when s2 is empty transfer all items from s1 and again repeat the same process
 * 
 * 3) We can have a pointer point to the last inserted element and directly use it for peek instead of looking into s2
 * 
 * Complexity: O(n) - when s2 is empty we have to copy n elements from s1 before we can dequeue (pop from s2)
 * O(1) - when there is an item in s2, a dequeue simply needs a pop operation on s2
 * 
 * @author rbaral
 */
import com.alg.ctci.stack.Stack;

public class QueueUsingStack {
    Stack s1 = new Stack();
    Stack s2 = new Stack();
    
    //Solution 1
    public void push1(int x){
        if(s1.isEmpty()){
            s1.push(x);
        }else{
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
            s2.push(x);
            while(!s2.isEmpty()){
                s1.push(s2.pop());
            }
        }
    }
    
    public int pop1(){
        return s1.pop();
    }
    
    public int peek1(){
        return s1.peek();
    }
    
    public boolean isEmpty1(){
        return s1.isEmpty();
    }
    
    //Solution 2
    //s1 = new Stack();
    //s2 = new Stack();
    int lastInserted;
    public void push(int x){
        s1.push(x);
        lastInserted = x;
    }
    
    public int pop(){
        if(s2.isEmpty()){
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
        }
        return s2.pop();
    }
    
    public int peek(){
        return lastInserted;
    }
    
    public boolean isEmpty(){
        return s1.isEmpty() && s2.isEmpty();
    }
}
