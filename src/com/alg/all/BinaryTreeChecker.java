/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.ctci;

/**
 *
 * Implemen t a function to check if a binary tree is a binary search tree.
 * 
 * @author rbaral
 */
public class BinaryTreeChecker {
    	public static boolean checkBST(TreeNode n, Integer min, Integer max) {
		if (n == null) {
			return true;
		}
		if ((min != null && n.data <= min) || (max != null && n.data > max)) {
			return false;
		}
		if (!checkBST(n.left, min, n.data) ||
			!checkBST(n.right, n.data, max)) {
			return false;
		}
		return true;
	}
		
	public static boolean checkBST(TreeNode n) {
		return checkBST(n, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	public static void main(String[] args) {
		int[] array = {Integer.MIN_VALUE, Integer.MAX_VALUE - 2, Integer.MAX_VALUE - 1, Integer.MAX_VALUE};
		TreeNode node = TreeNode.createMinimalBST(array);
		//node.left.data = 5;
		//node.left.right.data = 3;
		System.out.println(checkBST(node));
	}
}
