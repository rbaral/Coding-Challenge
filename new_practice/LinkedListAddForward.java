/**
LinkedList add forward: two numbers are represented
*/
import java.util.Stack;


/**
a class that represents a linkedlist node
and the carry from the next node
*/
class PartialSum{
	Node sum = null;
	int carry = 0;
}


public class LinkedListAddForward{
	
	public static void printLinkedList(Node n){
		while(n!=null){
			System.out.print("->"+n.val);
			n=n.next;
		}
		System.out.println();
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
	Method1:
	-first we check the length of the two numbers, and pad the shorter one with zeros
	-iteratively add the digits of both numbers in two different stacks so that we can access the LSD first
	-keep on popping elements from the two stacks and adding them, create a new linked list and add the nodes on head for
	each new digit obtained by adding
	O(n), Space: O(n)=> we use stacks and additional space for the new linkedlist
	*/
	public static Node addNumbers1(Node n1, Node n2){
		//base case
		if(n1==null)
			return n2;
		if(n2==null)
			return n1;
		//check the length
		int len1 = countNodes(n1);
		int len2 = countNodes(n2);
		//check the length equality and pad zeros at the begining of the shorter one
		int diff = len2 - len1;
		while(diff>0){
			//pad zero nodes at the begining of n1
			Node zeroNode = new Node(0);
			zeroNode.next = n1;
			n1 = zeroNode;
			diff--;
		}
		diff = len1 - len2;
		while(diff>0){
			//pad zero nodes at the begining of n2
			Node zeroNode = new Node(0);
			zeroNode.next = n2;
			n2 = zeroNode;
			diff--;
		}
		//now check the length of two lists
		System.out.println("After padding n1 is:");
		printLinkedList(n1);
		System.out.println("After padding n2 is:");
		printLinkedList(n2);
		//now we add the node values of each linked list to stack
		Node head1 = n1;
		Stack<Integer> st1 = new Stack<Integer>();
		while(head1!=null){
			st1.push(head1.val);
			head1 = head1.next;
		}
		Node head2 = n2;
		Stack<Integer> st2 = new Stack<Integer>();
		while(head2!=null){
			st2.push(head2.val);
			head2 = head2.next;
		}
		Node sumNodeCur =null;
		int sum = 0;
		int carry = 0;
		//System.out.println("size of st1 stack is:"+st1.size()+" and size of st2 stack is:"+st2.size());
		while(!st1.empty()){
			//System.out.println("st1 peek:"+st1.peek()+" st2 peek is:"+st2.peek());
			sum=st2.pop() + carry + st1.pop();
			carry = 0;
			if(sum>9){
				carry = 1;
			}
			sum = sum%10;
			System.out.println("sum is:"+sum);
			if(sumNodeCur==null){
				sumNodeCur = new Node(sum);
			}else{
				Node tmp = new Node(sum);
				tmp.next = sumNodeCur;
				sumNodeCur = tmp;
			}
			System.out.println("sumnod is:"+sumNodeCur.val);
		}
		//if there is a non-zero carry, it will be a node too
		if(carry>0){
			Node tmp = new Node(carry);
			tmp.next = sumNodeCur;
			sumNodeCur = tmp;
		}
		
		return sumNodeCur;
	}
	
	/**
	method to pad zeros at the begining of a node
	*/
	public static Node padZeros(Node n, int padCount){
		while(padCount>0){
			Node temp = new Node(0);
			temp.next = n;
			n = temp;
			padCount--;
		}
		return n;
	}
	
	/**
	inserts a node with value val before the node n
	*/
	public static Node insertBefore(Node n, int val){
		Node node = new Node(val);
		if(n!=null){
			node.next = n;
		}
		return node;
	}
	
	/**
	a utility method that recursively adds two linked list's nodes
	*/
	public static PartialSum addNodesHelper(Node n1, Node n2){
		//the exit condition of recursion
		if(n1 == null && n2 ==null){
			PartialSum sum = new PartialSum();
			return sum;
		}
		//handle the result from prior recursions
		PartialSum sum = addNodesHelper(n1.next, n2.next);
		int val = sum.carry + n1.val + n2.val;
		//the current level nodes' sum should be inserted before the prior level nodes' level
		sum.sum = insertBefore(sum.sum, val%10);
		sum.carry = val/10;
		return sum;
	}
	
	public static Node addNodesRecursive(Node n1, Node n2){
		//base case
		if(n1==null)
			return n2;
		if(n2==null)
			return n1;
		//now check the length of the linked list and pad zeros if required
		int len1 = countNodes(n1);
		int len2 = countNodes(n2);
		
		if(len1<len2)
			n1 = padZeros(n1, len2-len1);
		if(len2<len1)
			n2 = padZeros(n2, len1-len2);
		System.out.println("after padding:");
		printLinkedList(n1);
		printLinkedList(n2);
		//now start adding the nodes
		PartialSum resultNode = addNodesHelper(n1, n2);
		//if the result has a non-zero carry then we need to create a separate node for this
		if(resultNode.carry>0){
			resultNode.sum = insertBefore(resultNode.sum, resultNode.carry);
		}
		return resultNode.sum;
	}
	
	
	public static void main(String args[]){
		//create a linked list for the number 923
		Node linkedList1 = new Node(9);
		Node secondNode = new Node(6);
		Node thirdNode = new Node(3);
		linkedList1.next = secondNode;
		secondNode.next = thirdNode;
		printLinkedList(linkedList1);
		//create a linked list for the number 65
		Node linkedList2 = new Node(6);
		linkedList2.next = new Node(9);
		printLinkedList(linkedList2);
		//Node sumNode = addNumbers1(linkedList1, linkedList2);
		Node sumNode = addNodesRecursive(linkedList1, linkedList2);
		System.out.println("after finding the sum:");
		printLinkedList(sumNode);
	}
}