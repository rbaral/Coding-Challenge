/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.test;

public class StackWithMin {

    Node mystack;
    Node minstack;

    public void push(int a) {
        if (mystack == null) {
            mystack = new Node(a);
            minstack = new Node(a);
        } else {
            Node temp = new Node(a);
            temp.next = mystack;
            mystack = temp;
            //if the new item is less than the min value so far
            if (a < minstack.val) {
                temp.next = minstack;
                minstack = temp;
            }
        }
    }

    public int pop() throws Exception{
        if (mystack == null) {
            throw new Exception("Stack underflow");
        }
        //pop the min value if it is the top of the mystack
        int val = mystack.val;
        if (mystack.val == minstack.val) {
            minstack = minstack.next;
            mystack = mystack.next;
            return val;
        } else {
            mystack = mystack.next;
            return val;
        }
    }

    public int peek() {
        return mystack.val;
    }

    public int min() throws Exception{
        //handle if the stack is empty
        if (minstack == null) {
            throw new Exception("Stack underflow");
        }
        return minstack.val;
    }

    public static void main(String[] args) throws Exception {
        StackWithMin stackMin = new StackWithMin();
        stackMin.push(7);
        System.out.println("min is:" + stackMin.min());
        stackMin.push(1);
        System.out.println("min is:" + stackMin.min());
        stackMin.push(0);
        System.out.println("min is:" + stackMin.min());
        stackMin.push(20);
        System.out.println("min is:" + stackMin.min());
        stackMin.pop();
        System.out.println("min is:" + stackMin.min());
    }

}
