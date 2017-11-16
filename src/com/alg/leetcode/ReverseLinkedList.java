/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.leetcode;

/**
 *
 * Reverse a singly linked list.


Hint:
A linked list can be reversed either iteratively or recursively. Could you implement both?
* 
* 
* Solution:
* Base case: if there are just two nodes, then just swap them, else proceed the followings:
* 1)Make three pointers - head, cur1, cur2
* a) head always points to the current head
* b) cur1 always points to the node whose next element will be brought to the head
* c) cur2 always points to the element that will be the new head
* 2) do the following till cur2 is not null
* a)cur1.next = cur2.next
* b)cur2.next = head
* c)head = cur2
* d)cur2 = cur1.next
* 
 * @author rbaral
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class ReverseLinkedList {
    
}
