/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.leetup.todo.sol;

/**
 *
 * Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array 
 * such that nums[i] = nums[j] and the difference between i and j is at most k.
 * 
 * 
 * Solution 1:
 * 
 * 1)Scan the array and store the element as key and its index as a value in a HashTable (O(1))
 * 2)When an element is found in the HashTable, simply retrieve its index and compare with the current one, if the difference is at most k then we found one
 * 
 * 
 * @author rbaral
 */
public class ContainsDuplicateII {
    
}
