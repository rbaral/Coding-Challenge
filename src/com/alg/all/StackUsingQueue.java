/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.leetup.todo.sol;

/**
 *
 * Implement the following operations of a stack using queues.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
empty() -- Return whether the stack is empty.
Notes:
You must use only standard operations of a queue -- which means only push to back, peek/pop from front, size, and is empty operations are valid.
Depending on your language, queue may not be supported natively. You may simulate a queue by using a list or deque (double-ended queue), as long as you use only standard operations of a queue.
You may assume that all operations are valid (for example, no pop or top operations will be called on an empty stack).
Update (2015-06-11):
The class name of the Java function had been updated to MyStack instead of Stack.
* 
* 
* Solution 1:
* 1)Use two queues
* 2)Insert the elements to Q1
* 3)When there is a pop request, insert every element except the last one of Q1 to Q2, whatever is left in Q1 is the latest added element and can now be popped from front of Q1
* 4) just switch Q1 and Q2 so that we don't need to copy all the elements back to Q1
* 
* Complexity: O(n), Space O(n)
* 
* Solution 2:
* 1)use a single stack
* 2)when we have to push an element, push it. This will be at the end of the queue which is not the desired one for stack.
* 3)repeatedly pop from the front of the queue and add to the back until we have the latest element in front (we can control this using
* the size property of the queue i.e. repeat this process size times)
 * @author rbaral
 */
public class StackUsingQueue {
    
}
