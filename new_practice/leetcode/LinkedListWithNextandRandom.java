/**
You are given a Double Link List with one pointer of each node pointing to the next node just like in a single link list. The second pointer however CAN point to any node in the list and not just the previous node. Now write a program in O(n) time to duplicate this list. That is, write a program which will create a copy of this list.

Let us call the second pointer as arbit pointer as it can point to any arbitrary node in the linked list.
*/

class RandomListNode {
    int label;
    RandomListNode next, random;
    RandomListNode(int x) { this.label = x; }
};

public class LinkedListWithNextandRandom{

	/**
	-create a new node as a copy of the original node's head
	-start creating the next node and random node of the copy list from the original list's node
	*/
	public RandomListNode copyRandomList(RandomListNode head) {
		RandomListNode newHead = new RandomListNode(head.label);
		RandomListNode next = newHead;
		addNextAndRandom(head, next);
		//iteratively add the next and random links on all the nodes of the copy list
		while(head!=null){
			addNextAndRandom(head, next);
			head = head.next;
			next = next.next;
		}
		return newHead;
	}
	
	public void addNextAndRandom(RandomListNode oldNode, RandomListNode newNode) {
		newNode.next = oldNode.next==null?null:new RandomListNode(oldNode.next.label);
		newNode.random = oldNode.random==null?null:new RandomListNode(oldNode.random.label);
	}
}