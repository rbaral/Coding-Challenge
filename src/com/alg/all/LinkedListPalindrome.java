/**
Check if a given linked list is a palindrome
*/

import java.util.Stack;

class Node{
	char val;
	Node(char c){
		val = c;
	}
	Node next = null;
}
public class LinkedListPalindrome{
	
	public static void printLinkedList(Node n){
		while(n!=null){
			System.out.print("->"+n.val);
			n=n.next;
		}
		System.out.println();
	}

	/**
	creates a reversed linked list of a given linked list
	*/
	public static Node getReversedLinkedList(Node n){
		//base case
		if(n==null || n.next==null){
			return n;
		}
		Node rev = new Node(n.val);
		Node pt = n.next;
		while(pt!=null){
			Node temp = new Node(pt.val);
			temp.next = rev;
			rev = temp;
			pt = pt.next;
		}
		return rev;
	}
	
	/**
	method1:
	-reverse the linked list and store into another linked list
	-in the second iteration, compare with the original one
	-if the reversed and the original linked list have same elements then it is a palindrome
	O(n), space O(n)
	*/
	public static boolean isPal1(Node n){
		Node rev = getReversedLinkedList(n);
		System.out.println("reversed linked list is:");
		printLinkedList(rev);
		while(rev!=null){
			if(rev.val != n.val){
				return false;
			}
			rev = rev.next;
			n = n.next;
		}
		return true;
	}
	
	
	/**
	method2:
	-we scan the linkedlist iteratively and store the node values into a stack
	-when we reach the middle of the linkedlist, we pop the values stored in the stack and check if they match
	-if every item in stack is matached to the second half of the linkedlist then it is a palindrome, else not
	-we can use one iteration (O(n)) to find the length of the linked list or use fast/slow pointers
	-O(n), Space O(n/2)
	*/
	public static boolean isPal2(Node n){
		//handle base cases
		if(n==null || n.next==null)
			return false;
		//we push first half in stack
		Node p1 = n;
		Node p2 = n;
		Stack<Character> nodeStack = new Stack<Character>();
		//when the fast pointer reaches the end, we have pushed half of the linked list into the stack
		while(p2!=null && p2.next!=null){
			nodeStack.push(p1.val);
			p1 = p1.next;
			p2 = p2.next.next;
		}
		/**
		NOTE: if the linkedlist is of odd length, then the middle node should be skipped before comparing
		*/
		if(p2!=null){
			p1 = p1.next;
		}
		//continue scanning from slow pointer p1 and checking the values stored in stack
		while(p1!=null){
			if(p1.val!=nodeStack.pop()){
				return false;
			}
			p1 = p1.next;
		}
		return true;
		
	}

	public static void main(String args[]){
		Node n1 = new Node('r');
		Node n2 = new Node('a');
		Node n3 = new Node('c');
		Node n4 = new Node('e');
		Node n5 = new Node('c');
		Node n6 = new Node('a');
		Node n7 = new Node('r');
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		printLinkedList(n1);
		System.out.println("is palindrome from method 1:"+isPal1(n1));
		System.out.println("is palindrome from method 2:"+isPal2(n1));
	}
}