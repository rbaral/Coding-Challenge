/*
Implemen t a function to check if a binary tree is a binary search tree.


Solution:
-start with the root node and check if it satisfies the property of BST (left < node, right>= node)
-if it satisfies, then check recursively if the left and right subchild satisfy the same property

A tricky mistake the above solution does is it does not propagate the limit of the values (e.g, even if in a subtree left< node, right>=node property is satisfied, these constraint should also check that the max value in this subtree does take care of the value of its parent node). So, the maximum value a node in a subtree can take should be passed and this is the value of the current node.

 */
package com.alg.practice;


/**
 *
 * @author rbaral
 */
public class BinaryBSTChecker {

    public static boolean isBST(TreeNode node, int lowLimit, int upLimit) {
        if (node == null) {
            return true;
        }
        if ((int) node.getValue()>upLimit || (int) node.getValue()<=lowLimit) {
            return false;
        }
        boolean leftBST = false;
        leftBST = isBST(node.left, lowLimit, (int) node.getValue());
        
        boolean rightBST = false;
        rightBST = isBST(node.right, (int) node.getValue(), upLimit);
        if(!leftBST || !rightBST){
            return false;
        }
        return leftBST && rightBST;
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

        TreeNode n22 = new TreeNode(11);
        TreeNode n23 = new TreeNode(12);
        n2l.left = n22;
        n2l.right = n23;
        n2.left = n2l;
        n2.right = n2r;

        TreeNode root1 = new TreeNode(7);
        root1.left = n1;
        root1.right = n2;

        TreeNode root2 = new TreeNode(10);
        TreeNode l1_l = new TreeNode(8);
        TreeNode l1_r = new TreeNode(15);
        TreeNode l2_l = new TreeNode(4);
        TreeNode l2_r = new TreeNode(9);
        l1_l.left = l2_l;
        l1_l.right = l2_r;
        root2.left = l1_l;
        root2.right = l1_r;
        BFSTraversal bfs = new BFSTraversal();
        System.out.println("bfs string is:" + bfs.performBFSTraversal(root2));
        System.out.println(isBST(root2, Integer.MIN_VALUE, Integer.MAX_VALUE));
    }

}
