/*
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
 */
package com.alg.practice;

/**
 *
 * @author rbaral
 */
public class BinaryTreeCommonAncestor {
	
	/**
	first we keep on traversing and when the node p or q is found,
	we mark that the node is found.
	If the p and q nodes were found on different subtrees, then we mark the current root node as the ancestor.
	If they are on the same subtree, the recursion catches it.
	*/
	public static TreeNode commonAncestorHelper(TreeNode root, TreeNode p, TreeNode q){
		//check if the root node is null
		if(root==null){
			return null;
		}
	}
	
	public static TreeNode commonAncestor(TreeNode root, TreeNode p, TreeNode q){
		TreeNode anc = commonAncestorHelper(root, p, q);
		return anc;
	}
	
	public static void main(String args[]){
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
