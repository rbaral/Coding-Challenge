/**
Given a linked list return the node at the begining of a loop
Alternatively, find if the linkedlist has a loop or not
*/

class Node{
	int val;
	Node(int v){
		val = v;
	}
	Node next = null;
}
public class LinkedListLoop{
	
	public static void printLinkedList(Node n){
		while(n!=null){
			System.out.print("->"+n.val);
			n=n.next;
		}
		System.out.println();
	}
	
	/**
	find the begining of a loop in a given linked list, if no loop is found
	return null node.
	-we use two pointers, ptr1 and ptr2, both point to the head node at first
	-the ptr1 is advanced by one node and ptr2 is advanced by two node at a time
	-if the ptr2 points to null, then there is no looop
	-if ptr2 and ptr1 meet, then:
	--set ptr1 to the head node
	--advance both ptr1 and ptr2 by one node at a time
	--when they meet the next time, that will be the begining of the loop
	O(n)
	*/
	public static Node findLoopNode1(Node n){
		Node p1 = n;
		Node p2 = n;
		//lets do the first scanning where p2 is advanced by two nodes and p1 is advanced by one node at a time
		while(p2!=null && p2.next!=null){
			p1 = p1.next;
			p2 = p2.next;
			p2 = p2.next;
			if(p1 == p2){
				//two pointers collided
				System.out.println("Two pointers collided at:"+p1.val+" or:"+p2.val);
				break;
			}
		}
		//if p2 points to null, then there is no loop so return null
		if(p2==null || p2.next==null){
			return null;
		}else{
			//the pointers collided somewhere, so we point p1 to the head and continue p2 from its current position
			p1 = n;
			while(p1!=p2){
				p1 = p1.next;
				p2 = p2.next;
			}
			return p1;
		}
	}
	
	public static void main(String args[]){
		//lets create a test data with loop
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		Node node6 = new Node(6);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		node6.next=node2; //we created a loop from node6 to the node3
		//printLinkedList(node1);
		Node loopNode1 = findLoopNode1(node1);
		System.out.println("loop node in node1 using method1 is:");
		System.out.println(loopNode1==null?"":loopNode1.val);
		//lets create a test data without a loop
		Node linkedList2 = new Node(9);
		Node secondNode = new Node(6);
		Node thirdNode = new Node(3);
		linkedList2.next = secondNode;
		secondNode.next = thirdNode;
		//printLinkedList(linkedList2);
		
		Node loopNode11 = findLoopNode1(linkedList2);
		System.out.println("loop node in node2 using method1 is:");
		System.out.println(loopNode11==null?"":loopNode11.val);
		
	}
}