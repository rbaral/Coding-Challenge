/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.leetcode;

/**
 * Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
* 
* Solution 1:
* 1)handle base case, if the root node is null then return true
* 2) compute the height of the left node and the right node 
* 2 a) if the height diff is more than 1 return false
* 2 b) repeat 2 until the node is null
* 3) to compute the height
* 3 a) if the node is null, return 0
* 3 b) else return 1 + max(height of left, height of right)
* 
 Complexity: O(n^2) when the tree is skewed, if the tree is balanced then it is more likely O(height of tree)
 * 
 * Solution 2: compute the height while we are checking if the tree is balanced
 * 
 * 
 * 
 * 
 * @author rbaral
 */
public class BalancedBinaryTree {
    
    
    public static boolean isBalanced(TreeNode root){
        if(heightDiff(root)==-1){
            return false;
        }else{
            return true;
        }
    }
    
    //we return -1 to wait for the right subtree to be computed
    static int heightDiff(TreeNode root){
        if(root ==null){
            return 0;
        }
        int leftTreeHeight = heightDiff(root.left);
        if(leftTreeHeight==-1){
            return -1;
        }
        
        int rightTreeHeight = heightDiff(root.right);
        if(rightTreeHeight==-1){
            return -1;
        }
        
        int heightDiff = Math.abs(leftTreeHeight - rightTreeHeight);
        if(heightDiff>1){
            return -1;
        }else{
            return 1 +Math.max(leftTreeHeight, rightTreeHeight);
        }
    }
    
    public static boolean isBalanced1(TreeNode root) {
        if(root==null){
            return true;
        }else{
            int heightDiff = getHeight(root.left) - getHeight(root.right);
            if (Math.abs(heightDiff)>1){
                return false;
            }else{
                return isBalanced1(root.left) && isBalanced1(root.right);
            }
        }
    }
    
    static int getHeight(TreeNode root){
        if(root==null){
            return 0;
        }else{
            return 1 + Math.max(getHeight(root.left), getHeight(root.right));
        }
    }
    
    public static void main(String args[]){
        
    }
}
