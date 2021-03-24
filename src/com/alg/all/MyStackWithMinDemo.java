/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.practice;

/**
 * implement stack with min() function
 *
 * @author rbaral
 */
public class MyStackWithMinDemo {

    public static void main(String args[]) {
        MyStack st = new MyStack();
        MyStack minStack = new MyStack();
        for (int i = 1; i <= 10; i++) {
            //while pushing, check if this value is <= top item of minstack
			int item = i%5;
            if (minStack.peek() == null || item <= (int)minStack.peek()) {
                minStack.push(item);
            }
            st.push(item);
            System.out.println("after pushing " + item + " min so far is:" + minStack.peek());
        }
        //lets see what is the minvalue so far
        System.out.println("min item so far is:" + minStack.peek());
        //lets pop and see if the values are inserted properly
        for (int i = 0; i < 10; i++) {
            Object item = st.pop();
            //check if the popped item is the same as the top item of minstack, if so pop from minstack also
            if ((int)item == (int)minStack.peek()) {
                minStack.pop();
            }
            System.out.println("after popping " + item + " min so far is:" + minStack.peek());
        }
    }
}
