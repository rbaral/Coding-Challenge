/**
Write a program to find the node at which the intersection of two singly linked lists begins.


For example, the following two linked lists:

A:          a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗            
B:     b1 → b2 → b3
begin to intersect at node c1.


Notes:

If the two linked lists have no intersection at all, return null.
The linked lists must retain their original structure after the function returns.
You may assume there are no cycles anywhere in the entire linked structure.
Your code should preferably run in O(n) time and use only O(1) memory.
*/

public class LinkedListsIntersection{

	/**
	Method1:
	-the intersection can be at any node, so we use a nested loop and check if the two lists intersect at any point
	by checking the value of the nodes
	-when an intersection is found, we return
	O(n^2), Space O(1)
	*/
	public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        return null;
    }
	
	/**
	Method2: Ref Leetcode
	-
	*/
	public static ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        //boundary check
		if(headA == null || headB == null) return null;
		
		ListNode a = headA;
		ListNode b = headB;
		
		//if a & b have different len, then we will stop the loop after second iteration
		while( a != b){
			//for the end of first iteration, we just reset the pointer to the head of another linkedlist
			System.out.println("a points to:"+(a==null?"NULL":a.val)+" and b points to:"+(b==null?"NULL":b.val));
			a = a == null? headB : a.next;
			b = b == null? headA : b.next;    
			
		}
		
		return a;
    }
	
	/**
	Method3: REf Leetcode
	-find the length of the two lists
	-advance the longer list so that only equal length of the two lists is left
	-start comparing the nodes of two lists from this point
	*/
	public static ListNode getIntersectionNode3(ListNode headA, ListNode headB) {
        //base case
		if(headA==null || headB==null)
			return null;
		//find the lengths of the two lists
		int lena = 0;
		ListNode a = headA;
		while(a!=null){
			lena++;
			a=a.next;
		}
		int lenb = 0;
		ListNode b = headB;
		while(b!=null){
			lenb++;
			b=b.next;
		}
		a = headA;
		b = headB;
		//advance the longer list to make them of same length
		if(lena>lenb){
			for(int i=0;i<lena-lenb;i++){
				a = a.next;
			}
		}else if(lenb>lena){
			for(int i =0;i<lenb-lena; i++){
				b = b.next;
			}
		}
		//now check if the two nodes are equal
		while(a!=b){
			a = a.next;
			b = b.next;
		}
		return a;
    }
	
	public static void main(String args[]){
		ListNode a1 = new ListNode(1);
		ListNode a2 = new ListNode(2);
		
		ListNode c1 = new ListNode(3);
		ListNode c2 = new ListNode(4);
		ListNode c3 = new ListNode(5);
		
		ListNode b1 = new ListNode(11);
		ListNode b2 = new ListNode(12);
		ListNode b3 = new ListNode(13);
		
		a1.next = a2;
		a2.next = c1;
		c1.next = c2;
		c2.next = c3;
		
		b1.next = b2;
		b2.next = b3;
		b3.next = c1;
		System.out.println("Intersection2 node is:"+getIntersectionNode2(a1,  b1).val);
		System.out.println("Intersection3  node is:"+getIntersectionNode3(a1,  b1).val);
	}
}