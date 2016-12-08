/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.ctci.linkedlist;

/**
 *
 * Implement an algorithm to find the kth to last element of a singly linked list
 *
 *We assume that we dont know the lenght of the linked list and we use two pointers
 p1 and p2 which are k nodes apart at the beginning and then advance both pointers such that
 when the p2 hits the last node p1 will be at (n-k)th node.
 * @author rbaral
 */
public class KElementInLinkedList {
    
	/**
	finds the node that is kth node from the last
	of a linked list
	*/
	static LinkedListNode findKtoLastNodes(LinkedListNode n, int k){
		//lets declare two pointers
		LinkedListNode p1 = n;
		LinkedListNode p2 = n;
		int index = 0;
		//advance the second pointer by k so that p1 and p2 differ by k
		while(p2!=null && index<k){
			//now advance the p2 pointer
			p2 = p2.nextNode;
			index++;
		}
		//now p2 is k ahead of p1
		//now we advance p1 and p2 same time till p2 reaches the end
		while(p2!=null){
			p2 = p2.nextNode;
			p1 = p1.nextNode;
		}
		//now the p1 should be at kth position from end
		//System.out.println(p1.printForward());
		return p1;
	}
	public static void main(String args[]){
		//lets create some nodes and add them to a linked list
		LinkedListNode head = new LinkedListNode(0);
		LinkedListNode second;
		LinkedListNode current = head;
		//lets create linked list with 10 nodes
		for(int i=1; i<10;i++){
			second = new LinkedListNode(i);
			current.nextNode = second;
			current = second;
		}
		
		System.out.println(head.printForward());
		LinkedListNode k = findKtoLastNodes(head, 3);
		System.out.println(k.printForward());
	}
}
