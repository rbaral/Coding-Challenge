/**
Reverse a singly linked list.

Example:

Input: 1->2->3->4->5->NULL
Output: 5->4->3->2->1->NULL
Follow up:

A linked list can be reversed either iteratively or recursively. Could you implement both?
*/

class Node{
	int val;
	Node next;
	Node(int v){
		val = v;
	}
}
public class LinkedListReverse{

	public static void printLinkedList(Node root){
		if(root==null){
			return;
		}else{
			while(root!=null){
				System.out.print(root.val+"->");
				root = root.next;
			}
			System.out.print("NULL");
			System.out.println();
		}
	}
	
	/**
	Method1:
	-use iterative solution
	-can store the nodes in Stack or other additional space and create a new linked list with reversed node
	O(n), Space O(n)
	-can we do without using additional space?
	--use two pointers and while advancing one pointer, add the elements at the begining of another pointer
	*/
	public static Node getReversedIterative(Node root){
		//base case
		if(root==null || root.next==null){
			return root;
		}
		Node head = new Node(root.val);
		Node cur = root.next;
		Node temp;
		while(cur!=null){
			System.out.println("cur node is:"+cur.val);
			temp = new Node(cur.val);
			temp.next = head;
			head = temp;
			cur = cur.next;
		}
		return head;
	}
	
	/**
	recursively add the root node as the next node of newroot
	*/
	public static Node getReversedRecursive(Node root, Node newroot){
		if(root==null){
			return newroot;
		}
		Node temp = new Node(root.val);
		temp.next = newroot;
		return getReversedRecursive(root.next, temp);
	}
	
	public static void main(String args[]){
		Node root = new Node(1);
		Node two = new Node(2);
		Node three = new Node(3);
		Node four = new Node(4);
		Node five = new Node(5);
		root.next = two;
		two.next = three;
		three.next = four;
		four.next = five;
		printLinkedList(root);
		Node rev1 = getReversedIterative(root);
		printLinkedList(rev1);
		Node rev2 = getReversedRecursive(root.next, new Node(root.val));
		printLinkedList(rev2);
	}

}