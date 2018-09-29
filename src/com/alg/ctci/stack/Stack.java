/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.ctci.stack;

/**
 * the stack is composed of Node objects
 *
 * @author rbaral
 */
public class Stack {

    int capacity;// if the stack is of fixed size
    int size = 0; //the size of this stack - the no. of elements it is holding
    Node top; //the node at the top of the stack
    Node bottom; //the node at the bottom of the stack

    public Stack() {

    }

    // pushes the data to stack, assuming it supports only int data type
    public boolean push(int data) {
        size++;
        if (capacity > 0 && size > capacity) {
            return false;
        }
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
    public int pop() {
        Node n = top;
        top = top.below;
        //top.above = null;
        size--;
        return n.data;
    }

    //returns the top element without removing from the stack
    public int peek() {
        Node n = top;
        return n.data;
    }

    /**
     * auxiliary methods required for the problem
     */
    public Stack(int cap) {
        this.capacity = cap;
    }

    public void printStack() {//prints the content of the stack
        if (isEmpty()) {
            System.out.println("");
        } else {
            Node t = top;
            while (t != null) {
                System.out.print("->" + t.data);
                t = t.below;
            }
            System.out.println("");
        }
    }

    //check if the stack is full
    public boolean isFull() {
        return size == capacity;
    }

    //check if the stack is empty
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * this method is used when rolling over the set of stacks. this will remove
     * the element at the bottom of the stack and other elements will shift to
     * the left of the stack
     */
    public int removeFromBottom() {
        Node b = bottom;
        if (bottom != null) {
            bottom = bottom.above;
            bottom.below = null;
            size--;

        }
        return b.data;
    }

}
