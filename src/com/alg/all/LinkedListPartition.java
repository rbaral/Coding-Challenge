/**
Partition a linked list around a value x, such that all nodes with value less than x come before all nodes that have
value greater than or equal to x.
*/
class Node{
	int val; //we assume that the node contains int value
	Node(int v){
		val = v;
	}
	Node next;
}

public class LinkedListPartition{
	public static void printLinkedList(Node n){
		while(n!=null){
			System.out.print("->"+n.val);
			n=n.next;
		}
	}
	
	/**
	partition the linkedlist around value x
	-we create two linked list, one for the values smaller than x and another for all other values
	O(n), space O(n)
	*/
	public static Node partitionList1(Node n, int x){
		//base case
		if(n==null || n.next==null){
			return n;
		}
		Node smallHead = null;
		Node smallCur = null;
		Node largeHead = null;
		Node largeCur = null;
		Node cur = n;
		while(cur!=null){
			if(cur.val <x){//add to the small linked list
				if(smallHead==null){
					smallHead = new Node(cur.val);
					smallCur = smallHead;
				}else{
					smallCur.next = new Node(cur.val);
					smallCur = smallCur.next;
				}
			}else{//add to the large linked list
				if(largeHead ==null){
					largeHead = new Node(cur.val);
					largeCur = largeHead;
				}else{
					largeCur.next = new Node(cur.val);
					largeCur = largeCur.next;
				}
			}
			cur = cur.next;
		}
		//base case check if one of the linked list is null
		//now we concatente the two linked lists
		smallCur.next = largeHead;
		return smallHead;
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
		System.out.println("\nBefore partition");
		printLinkedList(linkedList);
		int x = 2;
		//Node partition1 = partitionList1(linkedList, x);
		//System.out.println("\nafter partition1 with node "+x);
		//printLinkedList(partition1);
		Node partition2 = partitionList2(linkedList, x);
		System.out.println("\nafter partition2 with node "+x);
		printLinkedList(partition2);
	}
}