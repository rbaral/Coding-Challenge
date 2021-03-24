/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.practice;

/**
 *
 * @author rbaral
 */
public class BFSTraversal {

    /**
     * BFS traversal can be done in recursive or iterative way In iterative
     * approach, the child nodes can be stored in a queue and traverse the node
     * in front of the queue
     */
    public static String performBFSTraversal(TreeNode root) {
        StringBuffer bfs = new StringBuffer();
        MyQueue queue = new MyQueue();
        if (root == null) {
            return "";
        }

        queue.enqueue(root);
        while (queue.peek() != null) {
            TreeNode node = (TreeNode)queue.dequeue();
            if (node.left != null) {
                queue.enqueue(node.left);
            }
            if (node.right != null) {
                queue.enqueue(node.right);
            }
            //add the current node to string
            bfs.append(node.getValue()+" ");
        }
        return bfs.toString();
    }

    public static void main(String args[]) {
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
        String bfs = performBFSTraversal(root);
        System.out.println("BFS Traversal order:" + bfs);
    }

}
