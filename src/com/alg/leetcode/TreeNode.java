/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.leetcode;

/**
 *
 * @author rbaral
 */

public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode(int x) {
        val = x;
    }
    
    //auxiliary methods
    //prints the tree
    public void printInOrderTree(){
        printInOrderTree(this);
        System.out.println();
    }
     
    //prints the tree using in-order traversal
    void printInOrderTree(TreeNode node){
        if(node==null){
            return;
        }
        printInOrderTree(node.left);
        System.out.println(node.val);
        printInOrderTree(node.right);
    }
}
 
