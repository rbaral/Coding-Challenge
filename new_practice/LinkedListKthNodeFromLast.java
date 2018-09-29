/**
Find kth node from last in a given linked list
*/
class Node{
		int val;
		Node next;
		Node(int v){
			val = v;
		}
	}
	
public class LinkedListKthNodeFromLast{
	
	public static void printLinkedList(Node n){
		while(n!=null){
			System.out.print("->"+n.val);
			n=n.next;
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
	Method1: 
	-in first iteration, we count the number of nodes in the linked list
	-in the second iteration, we find the count-k th node from the head, which will be the kth node from end
	-O(n)
	*/
	public static Node findKthNode1(Node n, int k){
		int count = countNodes(n);
		int nodeFromHead = count-k;
		Node cur = n;
		while(cur!=null){
			if(nodeFromHead==0){
				return cur;
			}
			cur=cur.next;
			nodeFromHead--;
		}
		return cur;
	}
	
	/**
	-we use two pointers, ptr1 and ptr2, both of which point to the head node at the begining.
	-keeping ptr2 intact, we advance ptr1 k times making ptr1 and ptr2 k nodes apart
	-now we advance both ptr1 and ptr2 one step at a time, until ptr1 reaches the end of the linked list
	-at this moment, ptr1 and ptr2 will still be k nodes apart and hence ptr2 will point to the kth node from the end
	O(n) in time
	*/
	public static Node findKthNode2(Node n, int k){
		
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
		int k =3;
		Node kNode1 = findKthNode1(linkedList, k);
		System.out.println("\n"+k+" th node from last is: "+kNode1.val);
	}
}