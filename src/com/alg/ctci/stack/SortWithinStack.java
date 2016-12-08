/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.ctci.stack;

/**
 *Write a program to sort a stack in ascending order (with biggest items on top).
You may use at most one additional stack to hold items, but you may not copy the
elements into any other data structure (such as an array). The stack supports the
following operations: push, pop, peek, and isEmpty
* 
 * @author rbaral
 */
public class SortWithinStack {
    
	/**
	the main idea is to take the top element from s1 and compare it with the top of s2.
	1) store top of s1 in a temp
	2) if top of s1 > top of s2, push temp into s2
	3) if top of s1 < top of s2, push s2 to s1 till the top of s2 is smaller than temp, finally push temp into s2
	4) repeat the process 1-3 till there are elements in s1
	*/
    
    
}
