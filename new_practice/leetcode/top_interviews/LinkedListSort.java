/**
Sort a linked list in O(n log n) time using constant space complexity.

Example 1:

Input: 4->2->1->3
Output: 1->2->3->4
Example 2:

Input: -1->5->3->4->0
Output: -1->0->3->4->5
*/

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class LinkedListSort{

	public static void printList(ListNode head){
		ListNode cur = head;
		while(cur!=null){
			System.out.print(cur.val+"->");
			cur = cur.next;
		}
		System.out.println();
	}
	
	/**
	Method1:
	-dump the node value in an array
	-sort the array
	-build a new linked list from the sorted array
	O(n) + O(nlogn) + O(n) time
	O(n) for space
	*/
	public static ListNode sortList1(ListNode head) {
        return null;
    }
	
	/**
	Method2:
	-use the concept of merge sort
	-use two pointers (slow and fast) to find the mid of the list
	-split the list into two halves by pointing the next value of one pointer to null and taking another as the head of second half
	-recursively sort the two halves to get two sorted lists
	-use the concept of merge list to merge the two sorted lists
	O(nlogn) to split and sort the two halves, O(1) space
	*/
	public static ListNode sortList2(ListNode head){
		//base case
		if(head==null || head.next==null){
			return head;
		}
		ListNode slow = head, prev = null, fast = head;
		while(fast!=null && fast.next!=null){
			prev = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		//make the end of first half
		prev.next = null;
		//the second half starts from where the slow pointer points
		//recursively sort the two halves
		ListNode list1 = sortList2(head);
		ListNode list2 = sortList2(slow);
		//now merge the two lists
		return mergeSortedLists(list1, list2);
		
	}
	
	public static ListNode mergeSortedLists(ListNode n1, ListNode n2){
		ListNode l = new ListNode(0); //a fake node to start build the merged list
		ListNode p =l;
		if(n1==null){
			return n2;
		}else if(n2==null){
			return n1;
		}else{
			while(n1!=null && n2!=null){
				if(n1.val<n2.val){
					p.next = n1;
					n1 = n1.next;
				}else{
					p.next = n2;
					n2=n2.next;
				}
				p = p.next;
			}
			if(n1!=null){
				p.next = n1;
			}else if(n2!=null){
				p.next = n2;
			}
			return l.next;
		}
	}
	
	public static void main(String args[]){
		ListNode node1 = new ListNode(4);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(1);
		ListNode node4 = new ListNode(3);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		System.out.println("before sorting:");
		printList(node1);
		ListNode sortedhead = sortList2(node1);
		System.out.println("after sorting:");
		printList(sortedhead);
		
	}
	
}