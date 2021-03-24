/**
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 */
package com.alg.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author rbaral
 *
 */
public class MergeKSortedLists {
/**
 * TIME LIMIT EXCEEDED
 */
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ListNode l1 = new ListNode(5);
		l1.setNext(new ListNode(7));
		ListNode l2 = new ListNode(1);
		l2.setNext(new ListNode(6));
		ListNode[] lists= new ListNode[2];
		lists[0] = l1;
		lists[1] = l2;
		System.out.println(mergeKLists(lists));

	}
	
	/**
	 * we can handle the problem in multiple ways:
	 * approach 1) we can repeatedly select 2 ListNodes at a time, until we have
	 * just a single ListNode
	 * approach 2) use the concept of heap and at every recursion, find the smallest value from all the nodes
	 * We are using the approach 2 here
	 * @param lists
	 * @return
	 */
	public static ListNode mergeKLists(ListNode[] lists) {
		//base case
				if(lists == null){
					return null;
				}else if(lists.length==1){
					return lists[0];
				}
				int smallVal=-1000, smallNodeIndex=0;
				boolean repeat = lists.length>0;
				int emptyNodesCount=0, index =0, nodesCount =0;
				List<ListNode> nodesList = new ArrayList<ListNode>();
				while(repeat){
					index=0;
					emptyNodesCount=0;//keep track of exhausted nodes
					for(int i=0; i<lists.length;i++){
					    if(lists[i]==null){//this node is exhausted or is empty
							emptyNodesCount++;
							continue;
						}
						if(index==0){//the first time, lets assume the first node's head has the smallest value
							smallVal = lists[i].val;
							smallNodeIndex = i;
							index++;
						}else{
							if(lists[i]!=null && lists[i].val < smallVal){
								smallVal = lists[i].val;
								smallNodeIndex = i;
							}
						}
					}
					if(index==0){//we haven't found any non-null node
					    System.out.println("NodesList size:"+nodesCount+"..."+nodesList.size());
					    return nodesList.get(0);
					}
					
					nodesList.add(new ListNode(smallVal));
					if(nodesCount>0){//update the pointer
					    nodesList.get(nodesCount -1).next = nodesList.get(nodesCount);  
					}
					nodesCount++;
					if(lists[smallNodeIndex].next!=null)
						lists[smallNodeIndex] = lists[smallNodeIndex].next;//advance the pointer for this node
					else{
						lists[smallNodeIndex] = null;
					}
					if(emptyNodesCount == lists.length)
						repeat = false;
				}
				return nodesList.get(0);   
		    }
}
