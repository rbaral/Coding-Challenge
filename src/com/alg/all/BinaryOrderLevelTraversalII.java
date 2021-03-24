/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7],
  [9,20],
  [3]
]
* 
* 
* Solution 1:
* 1)Start from root node and for every next level, keep track of the height of the node
* 2)Store the same height elements in a list which can be stored in another list, the height being identified by the index of the outer list
* 3)Retrieve from the max height
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
public class BinaryOrderLevelTraversalII {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        /*
        List result = new ArrayList();
        result.add(Arrays.asList(new int[]{5,1,15,7}));
        result.add(Arrays.asList(new int[]{9,20}));
        result.add(Arrays.asList(new int[]{3}));
        return result;
        */
        return null;
    }
}
