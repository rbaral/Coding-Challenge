/**
Given a singly linked list, determine if it is a palindrome.

Example 1:

Input: 1->2
Output: false
Example 2:

Input: 1->2->2->1
Output: true
Follow up:
Could you do it in O(n) time and O(1) space?
*/

public class LinkedListPalindrome{
	
	/**
	Method1:
	-put node values into stack in one pass
	-in second pass compare if the stack top is equal to the linkelist node value, if not return false
	O(n), Space O(n) for stack
	
	Method2:
	-use two pointers p1 and p2, where p1 is a slow pointer and advances one node at a time, p2 advances two nodes at a time
	-push node values to stack, when p2 reaches the end, p1 is at the middle of the list, 
	-compare the first half of items in stack with the values pointed by p1
	O(n), Space O(n/2)
	
	Method3:Ref: 
	-use recursive solution
	-recurse till we reach the end of the linked list and check the values
	
	*/
	static ListNode left;
	public static boolean isPalindrome3(ListNode head) {
		left = head;
		return isExtremeEqual(head);
		
    }
	
	public static boolean isExtremeEqual(ListNode right){
		if(right==null){
			return true;
		}
		boolean issubListPal = isExtremeEqual(right.next);
		if(!issubListPal){
			return false;
		}
		//check for the extreme values
		boolean extremeEqual = left.val==right.val;
		left = left.next;
		return extremeEqual;
	}
	
	public static void main(String args[]){
		ListNode root = new ListNode(0);
		ListNode one = new ListNode(1);
		ListNode two = new ListNode(2);
		ListNode three = new ListNode(3);
		ListNode four = new ListNode(2);
		ListNode five = new ListNode(1);
		ListNode six = new ListNode(0);
		root.next = one;
		one.next = two;
		two.next = three;
		three.next = four;
		four.next = five;
		five.next = six;
		System.out.println("list is palindrome:"+isPalindrome3(root));
	}
}