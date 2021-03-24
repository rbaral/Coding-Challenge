/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.leetcode;

/**
 * Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.

Supposed the linked list is 1 -> 2 -> 3 -> 4 and you are given the third node with value 3, the linked list should 
* become 1 -> 2 -> 4 after calling your function.
 *
 * NOTE: This problem can be found in the  Cracking the Coding Interviews book as well.
 * 
 * Solution 1:
 * 1)We are removing the current node (as we don't have access to the head node), so copy the value of next node to this node
 * 2)remove the next node by doing the followings:
 * current.val = current.next.val;
 * current.next = current.next.next
 * 
 * @author rbaral
 */
public class DeleteNodeinLinkedList {
    
}
