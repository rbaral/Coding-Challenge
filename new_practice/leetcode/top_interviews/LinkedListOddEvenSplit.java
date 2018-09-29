/**
Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.

You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.

Example 1:

Input: 1->2->3->4->5->NULL
Output: 1->3->5->2->4->NULL
Example 2:

Input: 2->1->3->5->6->4->7->NULL
Output: 2->3->6->7->1->5->4->NULL
Note:

The relative order inside both the even and odd groups should remain as it was in the input.
The first node is considered odd, the second node even and so on ...
*/

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
public class LinkedListOddEvenSplit{

	/**
	Method1:
	-use two pointers odd and even that point to the nodes at odd and even positions
	-both pointers advance two nodes at a time
	*/
	public static ListNode oddEvenList1(ListNode head) {
		//base case
		if(head==null){
			return head;
		}else{
			ListNode odd = head;
			ListNode even = head.next;
			ListNode evenHead = even; //the even head will be used at the end to concatenate the odd and even partitions
			while(even!=null && even.next!=null){
				odd.next = odd.next.next;
				even.next = even.next.next;
				//after advancing the points the odd position contains even position element and even position contains originally odd position item
				odd = odd.next;
				even = even.next;
			}
			odd.next = evenHead;
		}
        return head;
    }
	
	public static void printLinkedList(ListNode root){
		ListNode cur = root;
		while(cur!=null){
			System.out.print(cur.val+" ");
			cur = cur.next;
		}
		System.out.println();
	}
	
	public static void main(String args[]){
		ListNode one = new ListNode(1);
		ListNode two = new ListNode(2);
		ListNode three = new ListNode(3);
		ListNode four = new ListNode(4);
		ListNode five = new ListNode(5);
		one.next = two;
		two.next = three;
		three.next = four;
		four.next = five;
		printLinkedList(one);
		System.out.println("rearranged list is:");
		ListNode oddevenList = oddEvenList1(one);
		printLinkedList(oddevenList);
	}

}