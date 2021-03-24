/*
Design an algorithm and write code to find the first common ancestor of two nodes
in a binary tree. Avoid storing additional nodes in a data structure. NOTE: This is not
necessarily a binary search tree.


Solution 1, if the link to parent nodes is available:
- trace the link to parent nodes from each of the given nodes
- store the trace of each nodes
- if the trace has some common nodes, then that will be the common ancestor of these nodes
--there are some constraints like usage of additional storage, availability parent nodes, if the nodes are at different depth then this migh
need some post processing to locate the first common ancestor because they might have traces with multiple ancestors (all the way to the root node)


Solution 2:
-locate the side of the subtree the two nodes are located, if the two nodes are on different side (one on left subtree and another on right subtree) then the
current root node/parent node will be the first common ancestor
-if they are on the same side, we recurse to locate the node where they split into different subtree

 */
package com.alg.practice;

/**
 *
 * @author rbaral
 */
public class BinaryTreeCommonAncestorFinder_bk {

    public static class Result {

        public TreeNode node;
        public boolean isAncestor;

        public Result(TreeNode n, boolean isAnc) {
            node = n;
            isAncestor = isAnc;
        }
        
        public String toString(){
            return node==null?"null":node.getValue()+"..."+String.valueOf(isAncestor);
        }
    }

    public static Result commonAncestorHelper(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return new Result(null, false);
        }
        if (root == p && root == q) {
            return new Result(root, true);
        }
        System.out.println("with input "+String.valueOf(root==null||root.left==null?"null":root.left.getValue()));
        Result rx = commonAncestorHelper(root.left, p, q);
        System.out.println(" rx result was:"+rx.toString());
        if (rx.isAncestor) { // Found common ancestor
            return rx;
        }
        System.out.println("with input "+String.valueOf(root==null||root.right==null?"null":root.right.getValue()));
        Result ry = commonAncestorHelper(root.right, p, q);
        System.out.println(" ry result was:"+ry.toString());
        if (ry.isAncestor) { // Found common ancestor
            return ry;
        }

        if (rx.node != null && ry.node != null) {
            return new Result(root, true); // This is the common ancestor
        } else if (root == p || root == q) {
            /* If we’re currently at p or q, and we also found one of those
			 * nodes in a subtree, then this is truly an ancestor and the
			 * flag should be true. */
            boolean isAncestor = rx.node != null || ry.node != null;
            System.out.println("isancestor is:"+String.valueOf(isAncestor)+" for root node:"+String.valueOf(root==null?"null":root.getValue()));
            return new Result(root, isAncestor);
        } else {
            System.out.println("getting result from else");
            return new Result(rx.node != null ? rx.node : ry.node, false);
        }
    }

    public static TreeNode commonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Result r = commonAncestorHelper(root, p, q);
        if (r.isAncestor) {
            return r.node;
        }
        return null;
    }

    public static void main(String[] args) {
        TreeNode root2 = new TreeNode(10);
        TreeNode l1_l = new TreeNode(5);
        TreeNode l1_r = new TreeNode(11);
        
        TreeNode l2_l = new TreeNode(4);
        TreeNode l2_r = new TreeNode(9);
        //l1_l.left = l2_l;
        //l1_l.right = l2_r;
        root2.left = l1_l;
        root2.right = l1_r;
        TreeNode ancestor = commonAncestor(root2, l1_l, l1_r);
        if (ancestor != null) {
            System.out.println(ancestor.getValue());
        } else {
            System.out.println("null");
        }
    }
}
