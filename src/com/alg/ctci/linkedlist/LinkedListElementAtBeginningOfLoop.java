/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.ctci.linkedlist;

/**
 *	Given a circular linked list, implement an algorithm which returns the node at the
	*beginning of the loop.

	The idea to the solution is to use two pointers - fast and slow. The fast pointer moves 2 steps
	at a time and the slow pointer moves one step at a point. These two pointers will meet at a point.
	If they met after the slow pointer moved k steps, then the fast pointer has moved 2k steps.
	Now, leaving the fast pointer at this position and starting the slow pointer from the head again,
	they will be k steps from the loop.
	
	Now if they move at the same speed (one step at a time), they will meet at the loop start
 * @author rbaral
 */
public class LinkedListElementAtBeginningOfLoop {
    
	/**
	finds the starting point of a loop in a circular linked list
	*/
	public static LinkedListNode findLoopStart(LinkedListNode a){
		//now we check for the base case
		if(a==null){
			return null;
		}
		//at first both point to the head of the linkedlist
		LinkedListNode fast = a;
		LinkedListNode slow = a;
		//now we advance the pointers accordingly
		while(fast!=null && fast.nextNode!=null){
			fast = fast.nextNode.nextNode;
			slow = slow.nextNode;
			if(fast==slow){ //meeting point
				break;
			}
		}
		//at this point either the pointers have met or they point to null if there is no loop
		if(fast==null){//there was no loop in the linkedlist
			return null;
		}
		
		//now move the slow to the head keeping fast to the meeting point
		//advance both pointers one step at a time, when they meet again, it will be the start of the loop
		slow = a; //again points to the head
		while(fast!=slow){
			slow = slow.nextNode;
			fast = fast.nextNode;
		}
		return fast;
	}
	public static void main(String args[]){
		//lets create some nodes and add them to a linked list
		LinkedListNode head = new LinkedListNode(1);
		LinkedListNode second;
		LinkedListNode current = head;
		//lets create linked list with 10 nodes and a loop somewhere in the middle
		LinkedListNode loopStartNode = null;
		for(int i=2; i<5;i++){
			second = new LinkedListNode(i);
			current.nextNode = second;
			current = second;
			if(i==3){
				loopStartNode = current;
			}else if(i>3){
				loopStartNode.nextNode = current;
				loopStartNode  = current;
			}
			if(i==4){
				//current.nextNode = loopStartNode;
			}
		}
		
		//System.out.println(loopStartNode.printForward());
		System.out.println(head.printForward());
	}
}
