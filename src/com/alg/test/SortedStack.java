/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.test;

import java.util.Stack;

public class SortedStack {

    Stack<Integer> s1;
    Stack<Integer> s2;

    public SortedStack() {
        s1 = new Stack<Integer>();
        s2 = new Stack<Integer>();
    }

    public boolean isEmpty() {
        return s1.isEmpty();
    }

    public void push(int a) {
        if (s1.isEmpty() || s1.peek() <= a) {
            s1.push(a);
        } else {
            //pop all the elements larger than a from s1, push to s2, push a to s1, and push all items from s2 into s1 back
            while (!s1.isEmpty() && s1.peek() > a) {
                s2.push(s1.pop());
            }
            //push a to the correct position in s1
            s1.push(a);
            //take everything back from s2 into s1
            while (!s2.isEmpty()) {
                s1.push(s2.pop());
            }
        }
    }

    public int pop() throws Exception {
        if (s1.isEmpty()) {
            throw new Exception("Stack underflow");
        } else {
            return s1.pop();
        }
    }

    public static void main(String args[]) throws Exception {
        SortedStack mystack = new SortedStack();
        mystack.push(1);
        mystack.push(0);
        mystack.push(7);
        mystack.push(-1);
        mystack.push(3);
        mystack.push(2);
        System.out.println("sorted order is:");
        while (!mystack.isEmpty()) {
            System.out.println(mystack.pop());
        }
    }

}
