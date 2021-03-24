/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.leetcode;

/**
 *
 * Find the sum of all left leaves in a given binary tree.

Example:

    3
   / \
  9  20
    /  \
   15   7

There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
* 
* 
* Solution 1:
* 1)Start from root and scan all the nodes
* 2) if a node is a leaf node (node.left==null) then add its value to the sum
* 3)return sum
* 
 * @author rbaral
 */
public class SumOfLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        if(root==null)  return 0;
        
        if(root.left!=null && root.right!=null){ //when root has two child nodes
            if(root.left.left==null && root.left.right==null){
                return root.left.val + sumOfLeftLeaves(root.right);
            }
            return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
        }else if(root.left!=null){ //when root has just left child node
            if(root.left.left==null && root.left.right==null){
                return root.left.val;
            }
            return sumOfLeftLeaves(root.left);
        }else if(root.right!=null){ //when root has jut the right child
            if(root.right.left!=null || root.right.right!=null){
                return sumOfLeftLeaves(root.right);
            }
            return 0;
        }
        else{
            return 0;
        }
        //return 0;
    }
    
    public static void main(String args[]){
        //[3,9,20,null,null,15,7]  ->24
        //[1,2] ->2
        //[0,2,4,1,null,3,-1,5,1,null,6,null,8] ->5
    }
}
