/**
Linked List addition backward:
- numbers represented by linked list ->each node has a digit
-numbers represented in reverse order (i.e. the ones digit is in head of the linked lists)
-write a method to add two numbers and return the sum
*/
class Node{
	int val; //we assume that the node contains int value
	Node(int v){
		val = v;
	}
	Node next;
}
public class LinkedListAddReverse{

	public static void printLinkedList(Node n){
		while(n!=null){
			System.out.print("->"+n.val);
			n=n.next;
		}
		System.out.println();
	}
	
	/**
	-start scanning the numbers from the head
	-add the values of the nodes and keep track of carry
	-create a new linked list and keep on adding the sum%10, while setting carry to sum/10
	O(n)
	*/
	public static Node addNumbers(Node n1, Node n2){
		//handle base cases
		if(n1==null)
			return n2;
		if(n2==null)
			return n1;
		int carry = 0;
		int sum = 0;
		Node sumListHead = null;
		Node sumListCur = null;
		while(n1!=null && n2!=null){
			sum = n1.val + n2.val + carry;
			carry = 0;
			if(sum>9){
				carry = 1; //is always 1 because only 10 can be carried to next level
			}
			sum = sum%10;
			//now add the sum to the sumList
			if(sumListCur == null){
				sumListHead = new Node(sum);
				sumListCur = sumListHead;
			}else{
				sumListCur.next = new Node(sum);
				sumListCur = sumListCur.next;
			}
			n1 = n1.next;
			n2 = n2.next;
		}
		//only one of the list may be exhausted or both can be exhausted
		//if n1 is exhausted
		while(n2!=null){
			sum = carry + n2.val;
			carry = 0;
			if(sum>9){
				carry = 1;
			}
			sum = sum%10;
			sumListCur.next = new Node(sum);
			sumListCur = sumListCur.next;
			n2 = n2.next;
		}
		//if n2 is exhausted
		while(n1!=null){
			sum = carry + n1.val;
			carry = 0;
			if(sum>9){
				carry = 1;
			}
			sum = sum%10;
			sumListCur.next = new Node(sum);
			sumListCur = sumListCur.next;
			n1 = n1.next;
		}
		//if there is a carry value left add into another node
		if(carry>0){
			sumListCur.next = new Node(carry);
		}
		return sumListHead;
	}
	
	/**
	adds the nodes of two linked lists recursively
	*/
	public static Node addNumbersRecursive(Node n1, Node n2, int carry){
		//handle the exit case
		if(n1==null && n2==null && carry==0){
			return null;
		}
		int sum = carry;
		if(n1!=null){
			sum+=n1.val;
		}
		if(n2!=null){
			sum+=n2.val;
		}
		//now a node should be created from the sum and the carry should be forwarded to the next level
		Node curNode = new Node(sum%10);
		carry = sum/10;
		if(n1!=null || n2!=null){
			curNode.next = addNumbersRecursive(n1==null? null:n1.next, n2==null?null:n2.next, carry);
		}
		return curNode;
	}
	
		
	public static void main(String args[]){
		//create a linked list for the number 325
		Node linkedList1 = new Node(9);
		Node secondNode = new Node(2);
		Node thirdNode = new Node(3);
		linkedList1.next = secondNode;
		secondNode.next = thirdNode;
		printLinkedList(linkedList1);
		//create a linked list for the number 56
		Node linkedList2 = new Node(6);
		linkedList2.next = new Node(5);
		printLinkedList(linkedList2);
		//Node sumNode = addNumbers(linkedList1, linkedList2);
		Node sumNode2 = addNumbersRecursive(linkedList1, linkedList2, 0);
		System.out.println("after finding the sum:");
		printLinkedList(sumNode2);
		
	}
}
