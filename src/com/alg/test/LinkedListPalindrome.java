/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.test;

import java.util.Stack;

public class LinkedListPalindrome {

    public static boolean isPalindrome(Node n1) {
        Node p1 = n1;
        Node p2 = n1;
        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next;
            p2 = p2.next;
            System.out.println("p1 now points to:"+p1.val);
        }
        //now p1 points to the middle, save the remaining half to a stack
        Stack<Integer> mystack = new Stack<Integer>();
        while (p1 != null) {
            System.out.println("pushing to stack:"+p1.val);
            mystack.push(p1.val);
            p1 = p1.next;
        }
        //now compare the stack entries with the first half
        p1 = n1;
        while (!mystack.isEmpty()) {
            if (mystack.pop() != p1.val) {
                return false;
            } else {
                p1 = p1.next;
            }
        }
        return true;
    }

    public static void main(String args[]) {
        Node n1 = new Node(1);
        n1.next = new Node(2);
        n1.next.next = new Node(5);
        System.out.println("is palindrome:" + isPalindrome(n1));

    }

}
