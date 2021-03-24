/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.leetcode;

/**
 *
 * Invert a binary tree.

     4
   /   \
  2     7
 / \   / \
1   3 6   9
to
     4
   /   \
  7     2
 / \   / \
9   6 3   1
* 
* 
* Solution:
* The basic idea here is to switch the right and left child of a node. This process should recursively applied
* to all the nodes which have the child nodes.
 * 
 * 
 * @author rbaral
 */
public class InvertBinaryTree {
    TreeNode root = null;
	
	public InvertBinaryTree(){
		
	}
	
	public TreeNode invertTree(TreeNode node){
		if(node==null){
			return node;
		}else{
			TreeNode n = node.left;
			node.left = node.right;
			node.right = n;
			invertTree(node.left);
			invertTree(node.right);
		}
		return node;
	}
	
	
	public static void main(String args[]){
		InvertBinaryTree inv = new InvertBinaryTree();
		//lets create a binary tree
		TreeNode btree = new TreeNode(4);
		TreeNode lvl1_left = new TreeNode(2);
		TreeNode lvl1_right = new TreeNode(7);
		btree.left = lvl1_left;
		btree.right = lvl1_right;
		
		TreeNode lvl2_left_l = new TreeNode(1);
		TreeNode lvl2_left_r = new TreeNode(3);
		lvl1_left.left = lvl2_left_l;
		lvl1_left.right = lvl2_left_r;
		
		TreeNode lvl2_right_l = new TreeNode(6);
		TreeNode lvl2_right_r = new TreeNode(9);
		lvl1_right.left = lvl2_right_l;
		lvl1_right.right = lvl2_right_r;
		
		btree.printInOrderTree();
		
		TreeNode invTree = inv.invertTree(btree);
		invTree.printInOrderTree();
	}
	
	
	
}
