/**
Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

Example:

Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4

*/
class ListNode{
	ListNode next;
	int val;
	ListNode(int v){
		val = v;
	}
}

public class MergeTwoSortedLists{

	/**
	Method1:
	-we can iterate through the lists and check the item at head of both lists
	-whichever is smaller goes to a new list and so on
	-when one of the list is exhausted and another is not, we can just append that list to the end of new list
	O(n), Space O(n)
	*/
	public static ListNode mergeSortedLists1(ListNode node1, ListNode node2){
		//TODO:base cases
		if(node1==null){
			return node2;
		}else if(node2==null){
			return node1;
		}
		//lets create a  new list
		ListNode newList;
		ListNode newListHead;
		if(node1.val<=node2.val){
			newList = new ListNode(node1.val);
			newListHead = newList;
			node1=node1.next;
		}else{
			newList = new ListNode(node2.val);
			newListHead = newList;
			node2 = node2.next;
		}
		while(node1!=null && node2!=null){
			if(node1.val<=node2.val){
				newList.next = node1;
				node1=node1.next;
			}else{
				newList.next = node2;
				node2 = node2.next;
			}
			newList = newList.next;
		}
		//one of hte list is exhausted, repeat with the other one
		if(node1==null){
			newList.next =node2;
		}else{
			newList.next = node1;
		}
		return newListHead;
	}
	
	/**
	Method2
	-can we perform better without using additional space?
	-we iterate both lists, and find the smaller head, advance the pointer whose head is smaller
	-if the next lists head is smaller, append it as a new node to the current list and keep on iterating
	O(n), Space O(1)
	*/
	public static ListNode mergeSortedLists2(ListNode node1, ListNode node2){
		//TODO:base cases
		if(node1==null){
			return node2;
		}else if(node2==null){
			return node1;
		}
		ListNode resultNode = null;
		if(node1.val<=node2.val){
			resultNode = new ListNode(node1.val);
			resultNode.next = mergeSortedLists2(node1.next, node2);
		}else{
			resultNode = new ListNode(node2.val);
			resultNode.next = mergeSortedLists2(node1, node2.next);
		}
		return resultNode;
	}
	
	public static void printLinkedList(ListNode root){
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
	
	public static void main(String args[]){
		ListNode root1 = new ListNode(1);
		ListNode two = new ListNode(5);
		ListNode three = new ListNode(7);
		ListNode four = new ListNode(9);
		ListNode five = new ListNode(20);
		root1.next = two;
		two.next = three;
		three.next = four;
		four.next = five;
		
		ListNode root2 = new ListNode(-1);
		root2.next = new ListNode(6);
		root2.next.next = new ListNode(7);
		printLinkedList(root1);
		printLinkedList(root2);
		
		//ListNode merged = mergeSortedLists1(root1, root2);
		ListNode merged = mergeSortedLists1(root1, root2);
		printLinkedList(merged);
		
	}
}