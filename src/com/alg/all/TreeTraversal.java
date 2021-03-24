/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.test;

import java.util.List;
import java.util.ArrayList;

public class TreeTraversal {

    /**
     * performs inorder, preorder and postorder traversal of a tree
     */
    public static List<TreeNode> inOrderTraversal(TreeNode root, ArrayList<TreeNode> nodesList) {
        if (root == null) {
            return nodesList;
        }
        if (root.left == null) {
            nodesList.add(new TreeNode(Integer.MIN_VALUE));
        } else {
            nodesList.addAll(inOrderTraversal(root.left, new ArrayList<TreeNode>()));
        }
        nodesList.add(root);
        if (root.right == null) {
            nodesList.add(new TreeNode(Integer.MIN_VALUE));
        } else {
            nodesList.addAll(inOrderTraversal(root.right, new ArrayList<TreeNode>()));
        }
        return nodesList;

    }

    public static void main(String args[]) {
        TreeNode five = new TreeNode(5);
        TreeNode four = new TreeNode(4);
        TreeNode three = new TreeNode(3);
        TreeNode two = new TreeNode(2);
        TreeNode one = new TreeNode(1);
        four.left = two;
        four.right = five;
        two.left = one;
        two.right = three;
        List<TreeNode> inorder = inOrderTraversal(four, new ArrayList());
        for (TreeNode node : inorder) {
            if (node.val == Integer.MIN_VALUE) {
                System.out.print("null");
            } else {
                System.out.print(node.val);
            }
        }
    }

}
