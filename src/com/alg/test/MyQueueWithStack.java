/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.test;

import java.util.Stack;

public class MyQueueWithStack {

    Stack<Integer> s1;
    Stack<Integer> s2;

    public MyQueueWithStack() {
        s1 = new Stack<Integer>();
        s2 = new Stack<Integer>();

    }

    public void enqueu(int a) {
        //push to s1
        s1.push(a);
    }

    public int dequeu() throws Exception{
        //if s2 is not empty, pop from it
        if (!s2.isEmpty()) {
            return s2.pop();
        } else {//first pop everything from s1 to s2
            if (s1.isEmpty()) {
                throw new Exception("Queue underflow");
            } else {
                while (!s1.isEmpty()) {
                    s2.push(s1.pop());
                }
            }
            return s2.pop();
        }
    }

    public boolean isEmpty() {
        return s2.isEmpty() && s1.isEmpty();
    }

    public static void main(String args[]) throws Exception{
        MyQueueWithStack queue = new MyQueueWithStack();
        queue.enqueu(1);
        queue.enqueu(2);
        queue.enqueu(3);
        queue.enqueu(4);
        //now dequeue and check if the order is maintained or not
        while (!queue.isEmpty()) {
            System.out.println("Dequeued item is:" + queue.dequeu());
        }

    }

}
