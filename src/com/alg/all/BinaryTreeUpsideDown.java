/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.leetup.locked;

/**
 *
 * @author rbaral
 * 
 * Given a binary tree where all the right nodes are either leaf nodes with a sibling 
 * (a left node that shares the same parent node) or empty, flip it upside down 
 * and turn it into a tree where the original right nodes turned into left leaf nodes. 
 * Return the new root.
 * 
 * 
 * Solution:
 * 
 * Solution
At each node you want to assign: 
* p.left = parent.right; p.right = parent;
* 
* Ref:https://discuss.leetcode.com/topic/40924/java-recursive-o-logn-space-and-iterative-solutions-o-1-space-with-explanation-and-figure
 * 
 */
public class BinaryTreeUpsideDown {
    
    public static TreeNode upsideDownBinaryTree(TreeNode root){
        TreeNode cur = root;
        TreeNode next = null;
        TreeNode prev = null;
        TreeNode temp = null;
        while(cur!=null){
            next = cur.left;
            
            //swap the ndoes and keep track of the previous right child
            cur.left = temp;
            temp = cur.right;
            cur.right = prev;
            
            prev = cur;
            cur = next;
        }
        return prev;
    }
}
