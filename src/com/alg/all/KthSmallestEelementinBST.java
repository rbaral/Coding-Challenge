/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.leetup.todo.sol;

/**
 *
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

Note: 
You may assume k is always valid, 1 ≤ k ≤ BST's total elements.

Follow up:
What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?

Hint:

Try to utilize the property of a BST.
What if you could modify the BST node's structure?
The optimal runtime complexity is O(height of BST).
* 
* 
* Solution 1:
* As we are having BST, we can have the in-order traversal of the tree and get the list of node values 
* The kth item in the list/array of the in-order traversal path will be the required value.
* 
* Complexity: O(n) as we need to traverse all the nodes of the tree
* 
* Solution 2:
* 1)We modify the tree data structure and add the attribute (count) to keep track of the nodes on the left subtree of each node
* 2) So if a node has a count value k, that means there are k nodes in its left subtree
* 3)When we need to find k+1 th smallest element, it will be this node (the k nodes in its left child have small value than this)
* 4)When we need to find kth smallest element, we traverse on the left subtree of this node and find the node
* whose count is (k-1)
* 4 a) if k is greater than count of a node, traverse its right subtree
* 4 b) if k is less than the count of a node, traverse its left subtree
* 4 c) if k is equal to count then return the value of current node
* 
 * @author rbaral
 */
public class KthSmallestEelementinBST {
    
}
