/*
Implement a MyQueue class which implements a queue using two stacks
 */
package com.alg.practice;

/**
 *
 * @author rbaral
 */
class MyQueue {

    /**
     * we use two stack st1 and st2, items are pushed to st1 when there is
     * enqueue operation, if we need to dequeue, then we check if st2 has items,
     * if there are items then pop, if st2 is empty, pop from st1 and push to
     * st2, then pop from st2 for dequeue
     */
    MyStack st1, st2;

    public MyQueue() {
        st1 = new MyStack();
        st2 = new MyStack();
    }

    public void enqueue(Object item) {
        if (st1 == null) {
            st1 = new MyStack();
        }
        st1.push(item);
    }

    public Object dequeue() {
        //check if items in st2
        if (st2 != null && st2.peek() != null) {
            return st2.pop();
        } else {
            while (st1.peek() != null) {
                st2.push(st1.pop());
            }
            return st2.pop();
        }
    }

    public Object peek() {
        if (st2.peek() != null) {
            return st2.peek();
        } else {
            return st1.peek();
        }
    }

}

public class MyQueueDemo {

    public static void main(String args[]) {
        //do some enqueue
        MyQueue myQueue = new MyQueue();
        for (int i = 0; i < 10; i++) {
            myQueue.enqueue(i);
        }
        //do some dequeue
        while (myQueue.peek() != null) {
            System.out.println(myQueue.dequeue());
        }
    }
}
