/*
Given two binary trees and imagine that when you put one of them to cover the other, some nodes of the two trees are overlapped while the others are not.

You need to merge them into a new binary tree. The merge rule is that if two nodes overlap, then sum node values up as the new value of the merged node. Otherwise, the NOT null node will be used as the node of new tree.

Example 1:
Input: 
	Tree 1                     Tree 2                  
          1                         2                             
         / \                       / \                            
        3   2                     1   3                        
       /                           \   \                      
      5                             4   7                  
Output: 
Merged tree:
	     3
	    / \
	   4   5
	  / \   \ 
	 5   4   7
Note: The merging process must start from the root nodes of both trees.
 */
package com.alg.leetcode.incomplete;

import com.alg.leetcode.TreeNode;

/**
 *
 * @author rbaral
 * 
 * Solution 1:
 * 
 * 1) Lets say T1 and T2 are the given trees and T3 is the final tree we need to get after merging T1 and T2
 * 2) We use three stacks to store the nodes of the three trees, we name these stacks as S1, S2, and S3 respectively
 * 3) Perform BFS on T1 and T2 to store the preorder of the trees in S1 and S2. Store a marker as indicator of right/left child missing (it can be NULL)
 * 4) Pop the elements from S1 and S2, add them and push to S3
 * 5) Build T3 from S3
 * 
 * Complexity: O(h) + O(n), where h is the height of the tree (T1 or T2 whichever is deeper) and n is the total  nodes in both trees
 * 
 */

public class MergeTwoBinaryTrees {
    
     public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        
    }
}
