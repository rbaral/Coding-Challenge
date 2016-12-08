/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.ctci.linkedlist;

/**
 * You have two numbers represented by a linked list, where each node contains a
single digit. Suppose the digits are stored in forward order. 
* Write a function that adds the two numbers and returns the sum as a
linked list
 * @author rbaral
 */
public class LinkedListAdderForward {
    
	/**
	Given two linked lists (that represent numbers in forward order i.e. the 1s in the tail node),
	this method adds the numbers represented by the nodes and return a linked list that represents
	the sum
	*/
	static LinkedListNode addLinkedLists(LinkedListNode a, LinkedListNode b){
		//base cases
		//check if the lists are null
		if(a==null){
			return b;
		}else if(b==null){
			return a;
		}else{//both of the lists have at least one element
			/**
			to make it easier, we iterate and revert the linked list
			and repeat the process as we did in the LinkedListAdderBackward
			*/
			
			LinkedListNode aCurrent = a;
			LinkedListNode bCurrent = b;
			LinkedListNode c = null; //the sum holder
			LinkedListNode cCurrent = c;
			LinkedListNode n = null;
			
			while(aCurrent!=null){
				LinkedListNode tempA = new LinkedListNode(aCurrent.data, n, null);
				n = tempA;
				//System.out.println("aCurrent is:"+aCurrent.data);
				aCurrent = aCurrent.nextNode;
			}
			aCurrent = n;
			System.out.println(aCurrent.printForward());
			n = null;
			while(bCurrent!=null){
				LinkedListNode tempB = new LinkedListNode(bCurrent.data, n, null);
				n = tempB;
				//System.out.println("aCurrent is:"+bCurrent.data);
				bCurrent = bCurrent.nextNode;
			}
			bCurrent = n;
			System.out.println(bCurrent.printForward());
			int sum, carry=0;
			while(aCurrent!=null || bCurrent!=null){
					sum = 0; //reset the sum
					if(aCurrent!=null){
						sum+= aCurrent.data;
						//advance the current node of the param linked lists
						aCurrent = aCurrent.nextNode;
					}
					if(bCurrent!=null){
							sum+= bCurrent.data;
							//advance the current node of the param linked lists
							bCurrent = bCurrent.nextNode;
					}
					sum+= carry;
					if(sum>=10){
							carry = 1; //the carryon will be retained for next addition
							sum = sum - 10;
					}
					else{
							carry = 0; //reset the carry flag
					}
					//now create a node and add it to the resulting linkedlist
					if(cCurrent!=null){ //the resulting list already has some nodes
							cCurrent.nextNode = new LinkedListNode(sum, null, cCurrent);
							cCurrent = cCurrent.nextNode;
					}else{ //the resulting list has no elements
							cCurrent = new LinkedListNode(sum, null, null);
							c = cCurrent;
					}
					//if(aCurrent!=null)
					//		System.out.println("acurrent is "+aCurrent.data);
					//if(bCurrent!=null)
					//		System.out.println(" bcurrent is: "+bCurrent.data);
			}
			//there might be still some value in the carry left over and the two linked lists were exhausted
			if(carry>0){
					cCurrent.nextNode = new LinkedListNode(carry, null, null);
			}
			//revert the c and return it
			n = null;
			while(c!=null){
				LinkedListNode temp = new LinkedListNode(c.data, n, null);
				n = temp;
				c = c.nextNode;
			}
			return n;
		}
	}
	public static void main(String args[]){
		//lets create some nodes and add them to a linked list
		LinkedListNode head = new LinkedListNode(1);
		LinkedListNode second;
		LinkedListNode current = head;
		//lets create linked list with 10 nodes
		for(int i=2; i<5;i++){
			second = new LinkedListNode(i);
			current.nextNode = second;
			current = second;
		}
		
		LinkedListNode head2 = new LinkedListNode(7);
		head2.nextNode = new LinkedListNode(9);
		System.out.println(head.printForward());
		System.out.println(head2.printForward());
		LinkedListNode sum = addLinkedLists(head, head2);
		System.out.println(sum.printForward());
		
	}
}
