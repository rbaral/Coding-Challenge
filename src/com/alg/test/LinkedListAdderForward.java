/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.test;

/**
 *
 * @author rbaral
 */
public class LinkedListAdderForward {

    public static Node getSum(Node n1, Node n2) {
        Node sumNodeHead = null;
        Node cursumNode = null;
        Node n1head = n1;
        Node n2head = n2;
        int sum = 0;
        int carry = 0;
        //check for the length of the two lists and pad to make them equal length
        int l1 = 0, l2 = 0;
        while (n1head != null) {
            l1++;
            n1head = n1head.next;
        }
        while (n2head != null) {
            l2++;
            n2head = n2head.next;
        }
        n1head = n1;
        n2head = n2;
        if (l1 < l2) {//append node with zero value in front
            int diff = l2 - l1;
            while (diff > 0) {
                Node n = new Node(0);
                n.next = n1head;
                n1head = n;
                diff--;
            }
        }

        if (l2 < l1) {//append node with zero value in front
            int diff = l1 - l2;
            while (diff > 0) {
                Node n = new Node(0);
                n.next = n2head;
                n2head = n;
                diff--;
            }

        }
        //now both lists are of same length, do addition
        //remember to transfer the carry back
        while (n1head != null && n2head != null) {
            sum = n1head.val + n2head.val + carry;
            carry = sum/10;
            sum = sum % 10;
            //System.out.println("sum of "+n1head.val+" and "+n2head.val+" is:"+sum+" carry is:"+carry);
            if (sumNodeHead == null) {
                sumNodeHead = new Node(sum);
                cursumNode = sumNodeHead;
                cursumNode.next = cursumNode;
                if (carry > 0) {
                    Node carryNode = new Node(carry);
                    carryNode.next = sumNodeHead;
                    sumNodeHead = carryNode;
                    carry = 0;
                }
            } else {
                if (carry > 0) {
                    cursumNode.val+= carry;//add the carry to the previous node
                }
                cursumNode.next = new Node(sum);
                cursumNode = cursumNode.next;
            }
            n1head = n1head.next;
            n2head = n2head.next;
        }
        return sumNodeHead;

    }

    public static void main(String args[]) {
        //123
        Node n1 = new Node(7);
        n1.next = new Node(2);
        n1.next.next = new Node(1);
        //457
        Node n2 = new Node(7);
        n2.next = new Node(5);
        n2.next.next = new Node(4);
        Node sumNode = getSum(n1, n2);
        while (sumNode != null) {
            System.out.println("sum node is:" + sumNode.val);
            sumNode = sumNode.next;
        }
    }

}
