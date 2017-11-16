/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.leetcode;

/**
 *
 * Given a linked list, determine if it has a cycle in it.

Follow up:
Can you solve it without using extra space?
* 
* 
* Solution 1:
* 1)add each visited node to a Hash table and when there is already one, its a cycle
* 
* Complexity; O(n)
* 
* Solution 2:
* 1)Use two pointers, one advances one node and another advances two nodes
* 2)repeat until
* a) one of them points to null, then there is no cycle
* b) both of them point to the same node, then there is a cycle
* 
* complexity: O(n)
* 
* 
 * @author rbaral
 */
public class LinkedListCycle {
    
}
