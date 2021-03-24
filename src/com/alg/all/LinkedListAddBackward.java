/**
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example:

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.
*/

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
public class LinkedListAddBackward{

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null){
            return l2;
        }
        if(l2==null){
            return l1;
        }
        int sum = 0, carry = 0;
        ListNode sumNode = new ListNode(0);
        ListNode sumHead = sumNode;
        while(l1!=null || l2!=null){
            sum = 0;
            if(l1!=null){
                sum+=l1.val;
                l1 = l1.next;
            }
            if(l2!=null){
                sum+=l2.val;
                l2 = l2.next;
            }
			sum+=carry;
            carry = sum/10;
            sum = sum%10;
			System.out.println("sum is:"+sum+" carry is:"+carry);
            sumNode.next = new ListNode(sum);
            sumNode = sumNode.next;
        }
		System.out.println("outside while carry is:"+carry);
        if(carry>0){
            sumNode.next = new ListNode(carry);
        }
        return sumHead.next;
        
    }

	public static void printList(ListNode n){
		while(n!=null){
			System.out.print(n.val+"->");
			n = n.next;
		}
		System.out.println();
	}
	
	public static void main(String args[]){
		ListNode n1 = new ListNode(2);
		n1.next = new ListNode(4);
		n1.next.next = new ListNode(3);
		ListNode n2 = new ListNode(5);
		n2.next = new ListNode(6);
		n2.next.next = new ListNode(4);
		ListNode sumNode = addTwoNumbers(n1, n2);
		printList(sumNode);
	}
}