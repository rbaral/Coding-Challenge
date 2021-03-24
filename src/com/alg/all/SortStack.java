/*
Write a program to sort a stack in ascending order (with biggest items on top).
You may use at most one additional stack to hold items, but you may not copy the
elements into any other data structure (such as an array). The stack supports the
following operations: push, pop, peek, and isEmpty.


Solution:
-we use two stacks s1 and s2
-s1 is the given stack
-s2 is the auxiliary stack


Complexity:

 */
package com.alg.practice;

import java.util.Random;

/**
 *
 * @author rbaral
 */
public class SortStack {

    static MyStack st1 = new MyStack();
    static MyStack st2 = new MyStack();

    public static MyStack sortStack(MyStack st1, MyStack st2) {
        if (st1 == null || st1.peek() == null) {
            return st1;
        }
        st2.push(st1.pop());
        while (st2.peek() != null) {//when st2 is empty, everything is in st1 and is sorted
            while (st1.peek() != null && (int) st2.peek() >= (int) st1.peek()) {
                st2.push(st1.pop());
            }
            //the item in st1 is greater than in st2
            //push back everything to st2
            if (st1.peek() != null) {
                int temp = (int) st1.pop();
                while (st2.peek() != null && (int) st2.peek() <= temp) {
                    st1.push(st2.pop());
                }
                st2.push(temp);
            } else {//push everything back to st1
                while (st2.peek() != null) {
                    st1.push(st2.pop());
                }
            }

        }
        return st1;

    }

    public static void main(String args[]) {
        //initialize st1
        Random random = new Random();
        int max = 100, min = 1;
        for (int i = 0; i < 10; i++) {
            int randomNumber = random.nextInt(max + 1 - min) + min;
            System.out.println("pushing " + randomNumber);
            st1.push(randomNumber);
        }

        sortStack(st1, st2);
        System.out.println("Items in st1 are:");
        while (st1.peek() != null) {
            System.out.println(st1.pop());
        }

    }

}
