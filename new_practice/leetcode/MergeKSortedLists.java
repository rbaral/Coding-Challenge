/**
Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

Example:

Input:
[
  1->4->5,
  1->3->4,
  2->6
]
Output: 1->1->2->3->4->4->5->6
*/

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}

public class MergeKSortedLists{

	/**
	-use priority queue or min heap to store the head node of each linked list
	-repeat until queue has some elements
	--pop from the queue and add the item to the end of the result list
	--
	*/
	public ListNode mergeKLists(ListNode[] lists) {
        if (lists==null||lists.length==0) {
            return null;
        }
        
        PriorityQueue<ListNode> queue= new PriorityQueue<ListNode>(lists.length,new Comparator<ListNode>(){
            @Override
            public int compare(ListNode o1,ListNode o2){
                if (o1.val<o2.val) {
                    return -1;
                } else if (o1.val==o2.val) {
                    return 0;
                } else {
                    return 1;
                }
            }
        });
        
        ListNode dummy = new ListNode(0);
        ListNode tail=dummy;
        
		//add the head node of each input linked list into the queue
        for (ListNode node:lists) {
            if (node!=null) {
                queue.add(node);
            }
        }

		/**
		-pop the smallest element from the heap and insert it into the end of result list
		-if the recently added element has next node, add that to the queue
		-repeat the above process until the queue/heap has some elements
		*/
        while (!queue.isEmpty()){
            tail.next=queue.poll();
            tail=tail.next;

            if (tail.next!=null) {
                queue.add(tail.next);
            }
        }

        return dummy.next;
   }

}