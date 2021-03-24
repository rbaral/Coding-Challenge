/*
Implement a function to check if a binary tree is balanced. For the purposes of this
question, a balanced tree is defined to be a tree such that the heights of the two
subtrees of any node never differ by more than one.


In general,
a) a binary tree is balanced if for every node, the number of nodes on left subtree and the number of nodes on the right subtree differ by at most 1
b) a binary tree is balanced if for any two leaf nodes, the difference in height of the two leaf nodes is at most 1



Solution 1- using DFS traversal:
- traverse the tree from the root and keep track of the depth for each leaft node
- check the difference between the depths of each pair of leaf nodes and if the difference is greater than 1 then return false, else return true

Complexity: DFS scanning + Difference checking = O(V^2) if the data is stored in adjacency matrix

Solution 2 - using recursive approach:
-recursively find the depth of each node and check if the depth of its left and right child differ by at most 1
-break the recursion when imbalanced node is found

Complexity: O(V)

 */
package com.alg.practice;

/**
 *
 * @author rbaral
 */
public class BinaryTreeBalanceChecker {

    //recursively check height of a node and its left and right child
    public static int checkHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = checkHeight(node.left);
        if (leftHeight == -1) {
            return -1;
        }
        int rightHeight = checkHeight(node.right);
        if (rightHeight == -1) {
            return -1;
        }

        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }
        int height = Math.max(leftHeight, rightHeight) + 1;
        System.out.println("height of node:" + node.getValue() + " is:" + height);
        return height;

    }

    public static boolean isBalanced(TreeNode root) {
        if (checkHeight(root) == -1) {
            return false;
        } else {
            return true;
        }
    }

    public static void main(String args[]) {
        //lets construct a balanced tree and unbalanced tree and check
        //balanced tree
        TreeNode n1 = new TreeNode(1);
        TreeNode n1l = new TreeNode(2);
        TreeNode n1r = new TreeNode(3);
        n1.left = n1l;
        n1.right = n1r;

        TreeNode n2 = new TreeNode(4);
        TreeNode n2l = new TreeNode(5);
        TreeNode n2r = new TreeNode(6);
        //lets add other nodes to make it imbalanced
        TreeNode n22 = new TreeNode(11);
        TreeNode n23 = new TreeNode(12);
        n2l.left = n22;
        n2l.right = n23;
        n2.left = n2l;
        n2.right = n2r;

        TreeNode root = new TreeNode(7);
        root.left = n1;
        root.right = n2;
        System.out.println("is balanced:" + isBalanced(root));

        //System.out.println("is balanced:" + isBalanced(root));
    }

}
