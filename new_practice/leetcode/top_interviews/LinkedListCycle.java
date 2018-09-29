/**
Given a linked list, determine if it has a cycle in it.

Follow up:
Can you solve it without using extra space?
*/
import java.util.HashMap;

class ListNode{
	int val;
	ListNode next;
	ListNode(int v){
		val = v;
	}
}
public class LinkedListCycle{
	
	/**
	Method1:
	-we use a hashmap to store the nodes
	-we traverse the linkedlist and check if the node is already found one, if so, we found a circle
	O(n), Space O(n)
	*/
	public static boolean hasCycle1(ListNode head) {
        HashMap<ListNode, Integer> mapNode = new HashMap<ListNode, Integer>();
		ListNode cur = head;
		while(cur!=null){
			if(mapNode.containsKey(cur)){
				return true;
			}else{
				mapNode.put(cur, cur.val);
			}
			cur = cur.next;
		}
		return false;
    }
	
	/**
	Method2:
	-we use slow pointer and fast pointer
	-the fast pointer is advanced two nodes and slow pointer by one node
	-if the two pointers meet before reaching the end of the list then there is a cycle
	O(n), Space O(1)
	*/
	public static boolean hasCycle2(ListNode head){
		//base cases
		if(head==null || head.next==null)
			return false;
		ListNode p1 = head;
		ListNode p2 = head.next;
		while(p1!=null && p2!=null && p2.next!=null){
			if(p1==p2)
				return true;
			p1 = p1.next;
			p2 = p2.next.next;
		}
		return false;
	}
	
	public static void main(String args[]){
		ListNode root = new ListNode(0);
		ListNode one = new ListNode(1);
		ListNode two = new ListNode(2);
		ListNode three = new ListNode(3);
		ListNode four = new ListNode(4);
		root.next = one;
		one.next = two;
		two.next = three;
		three.next = four;
		four.next = two;
		four.next = new ListNode(2);;
		
		System.out.println("is cycle1 is:"+hasCycle1(root));
		System.out.println("is cycle1 is:"+hasCycle2(root));
	}
}