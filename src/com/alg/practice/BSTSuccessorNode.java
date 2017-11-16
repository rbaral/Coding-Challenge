/*
Write an algorithm to find the 'next'node (i.e., in-order successor) of a given node in
a binary search tree. You may assume that each node has a link to its parent.

Solution:
1)Traverse the tree and find the location of the given node
2)If the node has no child
a) if the node is left child of its parent, its parent is the succesor node
b) if the node is right child of its parent, and its parent is left child of its grand parent, then traverse the parent nodes till a node with no parent is found, thi
is the root node and will be the successor node
c) if the node is right child of its parent, and its parent is right child of its grand parent, there is no successor node, return null
3) if the node has child,
a) traverse the leftmost branch of its right child, when no more nodes are left, the current node will be the successor node
 */
package com.alg.practice;

/**
 *
 * @author rbaral
 */
public class BSTSuccessorNode {

    public static TreeNode BSTSuccessor(TreeNode root, TreeNode n) {
        //traverse the tree to find its position
        if (root == null) {
            return null;
        }
        boolean found = false;
        boolean finished = false;
        TreeNode curNode = root;
        //find the position of the given node
        while (!found && !finished) {
            if (curNode == null) {
                break;
            }
            if ((int) curNode.getValue() == (int) n.getValue()) {
                //found
                break;
            } else if ((int) n.getValue() < (int) curNode.getValue()) {
                //check left
                curNode = curNode.left;
            } else {
                //check right
                curNode = curNode.right;
            }
        }
        if (curNode == null) {
            //node not found in tree
            return null;
        }
        //now look for the successor node
        //case- if given node has no child 
        if (curNode.right == null) {
            //and it is left child of its parent, its parent is the successor node
            if ((int) curNode.parent.left.getValue() == (int) curNode.getValue()) {
                return curNode.parent;
            }// if its the right child of its parent
            else if ((int) curNode.parent.right.getValue() == (int) curNode.getValue()) {
                // and its parent is left child of its grandparent
                if (curNode.parent.parent!= null && (int) curNode.parent.getValue() == (int) curNode.parent.parent.left.getValue()) {
                    //traverse till the node without parent is encountered
                    curNode = curNode.parent;
                    while (curNode.parent != null) {
                        //continue
                        curNode = curNode.parent;
                    }
                    return curNode;
                } else {// and its parent is right child of its grandparent, there is no successor
                    return null;
                }
            }
        } else {
            //given node has child so the successor will the leftmost node of the right subtree
			curNode = curNode.right;
            while (curNode.left != null) {
                curNode = curNode.left;
            }
            return curNode;
        }

        return null;
    }

    public static void main(String args[]) {
        TreeNode root2 = new TreeNode(10);
        TreeNode l1_l = new TreeNode(8);
        TreeNode l1_r = new TreeNode(15);
        TreeNode l2_l = new TreeNode(4);
        TreeNode l2_r = new TreeNode(9);
        l1_l.left = l2_l;
        l1_l.right = l2_r;
        l2_l.parent = l1_l;
        l2_r.parent = l1_l;
        root2.left = l1_l;
        root2.right = l1_r;
        l1_l.parent = root2;
        l1_r.parent = root2;

        TreeNode succ = BSTSuccessor(root2, l1_r);
        System.out.println(succ==null?"No successor found in the tree":succ.getValue());
    }

}
