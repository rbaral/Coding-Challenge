/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.test;

public class LowestCommonAncestorFinder {

    //check if the node p lies under the node root
    public boolean covers(TreeNode root, TreeNode p) {
        if (root == null) {
            return false;
        }
        if (root == p) {
            return true;
        }
        return covers(root.left, p) || covers(root.right, p);
    }

    public TreeNode commonAncFinder(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root == p || root == q) {
            return root;
        }
        boolean pOnLeft = covers(root.left, p);
        boolean qOnLeft = covers(root.left, q);
        if (pOnLeft != qOnLeft) {
            //are on opposite side
            return root;
        }
        //are on the same side, both can be on left or both on right
        TreeNode sideNode = (pOnLeft && qOnLeft == true) ? root.left : root.right;
        return commonAncFinder(sideNode, p, q);
    }
    
    public static void main(String args[]) {
        TreeNode six = new TreeNode(6);
        TreeNode five = new TreeNode(5);
        TreeNode four = new TreeNode(4);
        TreeNode three = new TreeNode(3);
        TreeNode two = new TreeNode(2);
        TreeNode one = new TreeNode(1);
        four.left = two;
        four.right = five;
        two.left = one;
        two.right = three;
        LowestCommonAncestorFinder ancFinder = new LowestCommonAncestorFinder();
        if(!ancFinder.covers(four, one) ||!ancFinder.covers(four, six)){
            System.out.println("Does not cover one of the nodes");
        }else{
            TreeNode anc = ancFinder.commonAncFinder(four, one, six);
            System.out.println("common acn is:"+anc.val);
        }
        
    }
}
