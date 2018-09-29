package com.alg.ctci.stack;

import com.alg.ctci.linkedlist.LinkedListNode;

/**
 * this is a Queue (FIFO) representation using the Node class. Queue has two
 * pointers one for the top and one for the bottom. We basically define the
 * enqueue and dequeue method.
 */
public class Queue {

    LinkedListNode top, bottom;

    /**
     * a method to add item at the bottom
     */
    void enqueue(int item) {
        LinkedListNode newNode = new LinkedListNode(item);
        //check if the Queue is empty
        if (top == null) {
            top = newNode;
            bottom = top;
        } else {
            bottom.nextNode = newNode;
            bottom = newNode;
        }
    }

    /**
     * a method to remove item from the top
     */
    Object dequeue() {
        if (top == null) {
            return null;
        } else {
            Object item = top.data;
            top = top.nextNode;
            return item;
        }
    }

}
