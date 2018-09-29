/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.test;

class TreeNode {

    TreeNode left;
    TreeNode right;
    int val;

    public TreeNode(int v) {
        val = v;
    }
}

public class BinaryTreeBalanceChecker {

    public int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int lheight = getHeight(root.left);
            //if left is not balanced
            if(lheight==-1)
                return -1;
            int rheight = getHeight(root.right);
            if(rheight==-1)
                return -1;
            //if right is not balanced
            if (Math.abs(lheight - rheight) > 1) {
                return -1;
            }
            return Math.max(lheight, rheight)+1;
        }
    }

    public boolean isBalanced(TreeNode root) {
        int height = getHeight(root);
        if(height==-1)
            return false;
        else
            return true;
    }

    public static void main(String args[]) {
        TreeNode five = new TreeNode(5);
        TreeNode four = new TreeNode(4);
        TreeNode three = new TreeNode(3);
        TreeNode two = new TreeNode(2);
        TreeNode one = new TreeNode(1);
        one.left = two;
        one.right = three;
        two.left = four;
        //four.left = five;
        BinaryTreeBalanceChecker checker = new BinaryTreeBalanceChecker();
        System.out.println("balanced is:" + checker.isBalanced(one));
    }

}
