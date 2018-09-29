/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.test;

class Node {

    public Node next;
    int val;

    public Node(int v) {
        this.val = v;
    }

}

public class LinkedListAdderBackward {

    public static Node getSum(Node n1, Node n2) {
        Node sumNodeHead = null;
        Node cursumNode = null;
        Node n1head = n1;
        Node n2head = n2;
        int sum = 0;
        int carry = 0;
        while (n1head != null && n2head != null) {
            sum = n1head.val + n2head.val + carry;
            carry = sum / 10;
            sum = sum%10;
            if (sumNodeHead == null) {
                sumNodeHead = new Node(sum);
                cursumNode = sumNodeHead;
            } else {
                cursumNode.next = new Node(sum);
                cursumNode = cursumNode.next;
            }
            n1head = n1head.next;
            n2head = n2head.next;
        }
        while (n1head != null) {
            sum = carry + n1head.val;
            carry = sum / 10;
            sum = sum%10;
            cursumNode.next = new Node(sum);
            cursumNode = cursumNode.next;
            n1head = n1head.next;
        }
        while (n2head != null) {
            sum = carry + n2head.val;
            carry = sum / 10;
            sum = sum%10;
            cursumNode.next = new Node(sum);
            cursumNode = cursumNode.next;
            n2head = n2head.next;
        }
        //if there is carry left
        if (carry > 0) {
            cursumNode.next = new Node(carry);
        }
        //now revert the sum node 
        Node finalsumNode = null;
        while (sumNodeHead != null) {
            Node temp = new Node(sumNodeHead.val);
            temp.next = finalsumNode;
            finalsumNode = temp;
            sumNodeHead = sumNodeHead.next;
        }

        return finalsumNode;

    }

    public static void main(String args[]) {
        //123
        Node n1 = new Node(3);
        n1.next = new Node(1);
        n1.next.next = new Node(8);
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
