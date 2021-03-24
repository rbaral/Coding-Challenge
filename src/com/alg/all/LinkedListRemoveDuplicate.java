/**
remove duplicate entries from a LinkedList
*/

/**
we create a class to represent a linked list node
A linked list has a node, its value, and a pointer to the next node
*/

import java.util.HashMap;
import java.util.Map;

class Node{
	int val; //we assume that the node contains int value
	Node(int v){
		val = v;
	}
	Node next;
}
public class LinkedListRemoveDuplicate{

	public static void printLinkedList(Node n){
		while(n!=null){
			System.out.print("->"+n.val);
			n=n.next;
		}
	}
	
	/**
	Method1: store the node values in HashMap and check if the duplicate was encountered
	O(n), space O(n)
	*/
	public static void removeDuplicate1(Node n){
		if(n==null || n.next==null){
			return;
		}
		Map nodeMap = new HashMap();
		Node prev = null;
		while(n!=null){
			if(nodeMap.containsKey(n.val)){
				prev.next = n.next;
			}else{
				prev = n;
				nodeMap.put(n.val,1);
			}
			n = n.next;
		}
	}
	
	/**
	counts the number of nodes in a linked list
	*/
	public static int countNodes(Node n){
		int count = 0;
		Node cur = n;
		while(cur!=null){
			count++;
			cur = cur.next;
		}
		return count;
	}
	
	/**
	we use nested loop and check for duplicates
	O(n^2)
	*/
	public static void removeDuplicate2(Node n){
		//handle base cases
		if(n==null || n.next==null){
			return;
		}
		Node ptr1 = n;
		while(ptr1!=null){
			Node ptr2 = ptr1;
			while(ptr2.next!=null){
				if(ptr1.val ==ptr2.next.val){
					ptr2.next = ptr2.next.next;
				}else{
					ptr2 = ptr2.next;
				}
			}
			ptr1 = ptr1.next;
		}
	}
	
	public static void main(String args[]){
		//create a linked list
		Node linkedList = new Node(1);
		Node secondNode = new Node(2);
		Node thirdNode = new Node(3);
		Node fourthNode = new Node(1);
		linkedList.next = secondNode;
		secondNode.next = thirdNode;
		thirdNode.next = fourthNode;
		printLinkedList(linkedList);
		System.out.println("\nNode count "+countNodes(linkedList));
		//System.out.println("\nafter duplicate removal1");
		//removeDuplicate1(linkedList);
		//printLinkedList(linkedList);
		removeDuplicate2(linkedList);
		System.out.println("\nafter duplicate removal2");
		printLinkedList(linkedList);
		System.out.println("\nNode count "+countNodes(linkedList));
	}

}