/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.leetcode;

/**
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
But the following [1,2,2,null,3,null,3] is not:
    1
   / \
  2   2
   \   \
   3    3
   * 
   * Solution:
   * 1)get the string with the in-order traversal
   * 2)check if the in-order traversal string is a palindrome
   * 3)If palindrome then the tree is a symmetric tree, else not
   * 
   * Complexit= complexity to find the in-order traversal + complexity to check palindrome
   * = O(logn) + O(logn)
   * 
   * Note:
   * 1) In-order string computation- depends on the height of the tree
   * 2) palindrome - just have two pointers one from start and another from end and check if both chars match
 *
 * @author rbaral
 */
public class SymmtricTree {
    
}
