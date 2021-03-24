/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.practice;

/**
 *
 * @author rbaral
 */
class Node {

    Object val = null;
    Node next = null;

    public Node(Object v) {
        this.val = v;
    }

    public Object getData() {
        return this.val;
    }
}

public class MyStack {

    Node head;

    public void push(Object item) {
        if (head == null) {
            Node n = new Node(item);
            head = n;
        } else {
            Node n = new Node(item);
            n.next = head;
            head = n;
        }
    }

    public Object pop() {
        if (head == null) {
            System.err.println("Stack empty");
            return null;
        } else {
            Node n = head;
            head = head.next;
            return n.getData();
        }
    }

    public Object peek() {
        if (head == null) {
            System.err.println("Stack empty");
            return null;
        } else {
            return head.getData();
        }
    }
}
