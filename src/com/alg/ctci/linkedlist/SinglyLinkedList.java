package com.alg.ctci.linkedlist;

/**
This class represents the single linked list
*
*
*/

public class SinglyLinkedList{
	
	/**
	class representing a node 
	of the linked list
	*/
	class Node{
		//lets say we have just int values for this node
		int data;
		//lets create a next node
		Node nextNode = null;
		
		public Node(int d){
			this.data = d;
		}
		
		/*
		appends a node at the end
		of a linked list
		*/
		void append(int d){
			Node next = null;
			Node current = this;
			while(current.nextNode!=null){
				current = current.nextNode; //just scan to the tail node
			}
			next = new Node(d);
			current.nextNode = next;
		}
		
		/*
		delete the node with data d by scanning
		through the headNode and return the pointer to new headNode
		*/
		Node deleteNode(Node headNode, int d){
			Node currentNode = headNode;
			if (currentNode.data==d){// head node is to be deleted
				//return the next node as the new head node
				return currentNode.nextNode;
			}
			//now we scan through the other nodes to check if the data is d
			while(currentNode.nextNode!=null){
				if(currentNode.nextNode.data==d){
					currentNode.nextNode = currentNode.nextNode.nextNode;
					return headNode;
				}
				currentNode = currentNode.nextNode; //advance the pointer
			}
			//the data d was not found, so return the default headNode
			return headNode;
		}
	}
}