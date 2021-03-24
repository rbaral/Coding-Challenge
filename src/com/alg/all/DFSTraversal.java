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
public class DFSTraversal {

    /**
     * DFS traversal can be done in iterative or recursive approach. In
     * recursive approach, the node can be traversed and its child can be stored
     * in stack. The items in top of stack are traversed next.
     */
    public static String performDFSTraversal(TreeNode root) {
        StringBuffer dfs = new StringBuffer();
        MyStack st = new MyStack();
        if (root == null) {
            return "";
        }

        st.push(root);
        while (st.peek()!= null) {
            TreeNode node = (TreeNode) st.pop();

            if (node.right!= null) {
                st.push(node.right);
            }
            if (node.left!= null) {
                st.push(node.left);
            }
            //add the current node to string
            dfs.append(node.getValue() + " ");
        }
        return dfs.toString();
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
        String dfs = performDFSTraversal(root);
        System.out.println("DFS Traversal order:" + dfs);
    }
}
