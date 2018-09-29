/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.leetup.todo.sol;

/**
 *
 * Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.

You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.

Example:
Given 1->2->3->4->5->NULL,
return 1->3->5->2->4->NULL.

Note:
The relative order inside both the even and odd groups should remain as it was in the input. 
The first node is considered odd, the second node even and so on ...
* 
* Solution 1:
* 1)First find the number of elements (n) in the linked list using a single pass - O(n), and get a pointer to the tail node,
* if n is odd, then there are n/2+1 odd nodes and n/2 -1 even nodes.
* 2)Start with index=1 because the first element is at odd index (1)
* 2 a) If index%2 !=0, this is an odd position, so increase odd counter
* 3)Advance the nodes (node = node.next) and increase the index at the same time
* 4)If index%2==0 (i.e. even node)
* 4 a) append the current node to the tail node
* 4 b)delete this current node (curr.val = curr.next.val; curr.next = curr.next.next)
* 4 c) advance the index because we deleted the current element and brought the next element to this position
* 4 d)Repeat from (4) until all the odd nodes are addressed (odd counter== # odd nodes)
 * 
 * 
 * @author rbaral
 */
public class OddEvenLinkedList {
    
}
