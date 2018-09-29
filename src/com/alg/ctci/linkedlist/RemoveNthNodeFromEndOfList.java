/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.ctci.linkedlist;

/**
 *
 * Given a linked list, remove the nth node from the end of list and return its head.

For example,

   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:
Given n will always be valid.
Try to do this in one pass.
* 
* 
* Solution:
* 1)create two pointers p1 and p2 both pointing to the head initially
* 2) have a separate pointer point to the head node
* 3) advance p2 n times while p1 being untouched (difference between p1 and p2 is to be made of n nodes)
* 4)advance p1 and p2 till p2 points to null
* 5)Now p1 points to the nth node from the end
* 6)delete the node pointed by p1 (p1.val = p1.next.val; p1.next = p1.next.next)
* 7)return the head node
* 
 * @author rbaral
 */
public class RemoveNthNodeFromEndOfList {
    
}
