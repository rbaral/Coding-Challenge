/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
    [
      [3],
      [9,20],
      [15,7]
    ]
 *
 * Solution 1:
 * 1)Start from the root node
 * 2)add the root node to a list/queue
 * 3)repeat till there is an element in the list/queue
 * 3 a) fetch the first element from the list/queue
 * 3 b) if it has child nodes, first add its left child to the end of the list/queue, and then add its right child to the end of the list/queue
 * 3 c) print the value of the node
 * 
 * NOTE: the stopping criteria is when the queue is empty, so we need to maintain a temporary list/queue
 * which accumulates the nodes at next level
 * 
 * Complexity: O(mn); where m is the maximum elements at a level of the tree; Space: O(n)
 * 
 * Solution 2:
 * Use recursive approach
 * 
 * @author rbaral
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class BinaryOrderLevelTraversal {
    public static List<List<Integer>> levelOrder1(TreeNode root) {
        if (root == null) {
            return new ArrayList<List<Integer>>();
        }
        List<List<Integer>> items = new ArrayList<List<Integer>>();
        List<TreeNode> queue = new ArrayList<TreeNode>();
        List<TreeNode> tempQueue = new ArrayList<TreeNode>();
        queue.add(root);
        TreeNode currentItem;

        List<Integer> itemsAtLevel = new ArrayList<Integer>();
        while (queue.size() > 0) {

            currentItem = queue.get(0); //take the first item
            if (currentItem.left != null) {

                tempQueue.add(currentItem.left);
            }
            if (currentItem.right != null) {

                tempQueue.add(currentItem.right);
            }

            itemsAtLevel.add(currentItem.val);
            queue.remove(0); //after adding its left and right child to the processing queue, we remove it from the list

            if (queue.size() == 0) {
                //now add the items found at this level to the final list
                items.add(itemsAtLevel);
                //copy tempQueue to queue
                queue.addAll(tempQueue);
                tempQueue = new ArrayList<TreeNode>();
                itemsAtLevel = new ArrayList<Integer>();
            }
        }
        return items;
    }
    
    public static List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<List<Integer>>();
        }
        else{
            List<List<Integer>> itemsList = new ArrayList<List<Integer>>();
            List<TreeNode> items = new ArrayList<TreeNode>();
            items.add(root);
            performBFS(items);
            return itemsList;
        }
    }
    
    /**
     * a single call to the performBFS should use all the elements in
     * the queue and the new elements added to the queue should be
     * tracked so that they will be used in another call
     * 
     * @param queue 
     */
    public static void performBFS(List<TreeNode> queue) {

        if (queue.isEmpty())
            return;

        TreeNode node = queue.get(0);

        System.out.println(node.val + " ");

        if (node.left != null)
            queue.add(node.left);
        
        if (node.right != null)
            queue.add(node.right);
        queue.remove(0);
        
        performBFS(queue);
    }
    
    
    
    public static void main(String args[]){
        
    }
}
