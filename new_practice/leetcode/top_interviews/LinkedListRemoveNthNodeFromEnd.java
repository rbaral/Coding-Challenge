/**
Given a linked list, remove the n-th node from the end of list and return its head.

Example:

Given linked list: 1->2->3->4->5, and n = 2.

After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:

Given n will always be valid.

Follow up:

Could you do this in one pass?
*/

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class LinkedListRemoveNthNodeFromEnd{
	
	/**
	Method1: brute force solution
	-store all the elements of the list in a stack/queue
	-while counter<n, remove a node from end
	-build a linkedlist from the leftover
	O(n), Space O(n)
	*/
	public static ListNode removeNthFromEnd1(ListNode head, int n){
		return head;
	}

	/**
	Method2:
	-we need to remove the nth node from the end and we assume that we don't have pointer to that node
	-we also assume that we dont have access to the count of no. of nodes in the list
	-we use the concept of two pointers, slow and fast
	-the fast node is first advanced n times
	-then we repeat the following till fast.next!=null the slow node and fast node are advanced one time
	-when the fast node points to end, the slow node points to a node whose next node is the one to be removed
	*/
	public static ListNode removeNthFromEnd2(ListNode head, int n) {
		//base cases
		//if(head==null || n<=0){
		//	return head;
		//}
		//create a dummy node and assume it as the first node of the given list so that when
		//the fast node is at the end, the slow pointer is at n-1 th node of the list
        ListNode start = new ListNode(0);
		ListNode slow = start;
		ListNode fast = start;
		start.next = head;
		int count = 0;
		//we advance fast to n+1 because we want it to point to the node after the target node
		while(count<=n && fast!=null){
			fast = fast.next;
			count++;
		}
		//TODO: handle the case when the value of n is more than the size of list
		//advance both nodes
		while(fast!=null){
			slow = slow.next;
			fast = fast.next;
		}
		//the slow pointer points to the node before the target node so we just get rid of the target node by advancing the next value one step ahead
		slow.next = slow.next.next;
		//having updated the slow pointer, the start pointer points to the head of the corrected list, just get rid of the dummy node at the front and the rest of the list gives the desired result
		return start.next;
    }
	
	public static void printList(ListNode root){
		ListNode cur = root;
		while(cur!=null){
			System.out.print(cur.val+"->");
			cur = cur.next;
		}
		System.out.println();
	}
	
	public static void main(String args[]){
		//1->2->3->4->5, and n = 2
		ListNode one = new ListNode(1);
		ListNode two = new ListNode(2);
		ListNode three = new ListNode(3);
		ListNode four = new ListNode(4);
		ListNode five = new ListNode(5);
		one.next = two;
		two.next = three;
		three.next = four;
		four.next = five;
		int n = 3;
		//printList(one);
		//ListNode res = removeNthFromEnd2(one, n);
		//printList(res);
		
		//[1,2]
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		node1.next = node2;
		//printList(node1);
		n =1;
		//ListNode res2 = removeNthFromEnd2(node1, n);
		//printList(res2);
		
		ListNode node11 = new ListNode(1);
		//printList(node11);
		//ListNode res3 = removeNthFromEnd2(node11, n);
		//printList(res3);
		ListNode node12 = null;
		ListNode res4 = removeNthFromEnd2(node12, n);
		printList(res4);
	}
}