/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.leetup;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
* 
* 
* Solution 1:
* 1)perform DFS traversal of the tree by visiting all the nodes and storing them till we reach the leaf node or the sum is found in that path
* 
 * 
 * 
 * @author rbaral
 */
public class PathSum {
 
    public boolean hasPathSum(TreeNode root, int sum) {
      if(root==null){
            return false;
        }
        
        int sumSoFar = 0;
        return performDFS(root, sumSoFar, sum);
    }
    
    boolean performDFS(TreeNode root, int sumSoFar,int sum) {
       
        if (root.left == null && root.right == null) {
            if ((sumSoFar+root.val) == sum){
                return true;
            }
        }
        boolean leftValid = false;
        if (root.left != null) {
            leftValid = performDFS(root.left, sumSoFar + root.val, sum);
        }
        if(leftValid)
            return leftValid;
        boolean rightValid = false;
        if (root.right != null) {
            rightValid = performDFS(root.right, sumSoFar + root.val, sum);
        }
        
        return rightValid;
    }
}
