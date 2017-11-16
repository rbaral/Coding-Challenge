/*
You have two very large binary trees: Tl, with millions of nodes, and T2, with
hundreds of nodes. Create an algorithm to decide ifT2 is a subtree ofTl.
A tree T2 is a subtree of Tl if there exists a node n in Tl such that the subtree ofn
is identical to T2. That is, if you cut off the tree at node n, the two trees would be
identical.


solution 1)
-find the root node of T2 in T1 (can be in zero, one, or multiple places)
-for every node in T1 that matched the root node of T2
--compare the root node of T2 with the node and traverse down, break if there is not a match


Complexity: O(n+ mk), where n is the number of nodes in T1 and m is the number of nodes in T2

 */
package com.alg.practice;

import static com.alg.practice.ListForEachDepth.createListForLevels;
import java.util.List;

/**
 *
 * @author rbaral
 */
public class BinaryTreeSubtree {

    /**
     * check if t1 and t2 match recursively
     */
    public static boolean treeMatchesHelper(TreeNode t1, TreeNode t2) {
        System.out.println("checking for nodes:"+String.valueOf(t1==null?"null":t1.getValue())+"..."+String.valueOf(t2==null?"null":t2.getValue()));
        if (t1 == null && t2 == null) {
            return true;
        }else if (t2 == null) {
            return true;
        }else if(t1==null){
            return false; //only t1 is null
        }

        if (t1.getValue() == t2.getValue()) {//these node match, now repeat with the successors
            return treeMatchesHelper(t1.left, t2.left) && treeMatchesHelper(t1.right, t2.right);
        } else {
            return false;
        }

    }

    public static boolean treeMatches(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {//both trees empty
            return true;
        } else if (t2 == null) {//second tree empty
            return true;
        }else if(t1==null){
            return false;
        }
        else if (t1.getValue() == t2.getValue()) {
            //the root of t2 and any node of t1 match, traverse for the subtree
            if (treeMatchesHelper(t1, t2)) {
                //we don't fully rely on this node as this node might not give us a subtree, so we look for next node that matches the root node of t2
                return true;
            }
        }
        //look for other nodes that match root node of t2. The nodes can be either on the left or right.
        return treeMatches(t1.left, t2) || treeMatches(t1.right, t2);

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
        n1l.left = n22;
        n1l.right = n23;
        n2.left = n2l;
        n2.right = n2r;

        TreeNode root1 = new TreeNode(7);
        root1.left = n1;
        root1.right = n2;
        
        BFSTraversal bfs = new BFSTraversal();
        //System.out.println(bfs.performBFSTraversal(root1));
        
        TreeNode root2 = new TreeNode(1);
        TreeNode l1_l = new TreeNode(2);
        TreeNode l1_r = new TreeNode(3);
        TreeNode l2_l = new TreeNode(11);
        TreeNode l2_r = new TreeNode(12);
        l1_l.left = l2_l;
        l1_l.right = l2_r;
        root2.left = l1_l;
        root2.right = l1_r;
        //System.out.println(bfs.performBFSTraversal(root2));
        
        List<List<Integer>> levelLists = createListForLevels(root1);
        for (List levelList : levelLists) {
            System.out.println("new list:\n");
            for(Object item : levelList) {
                System.out.println((int)item + " ");
            }
            System.out.println("");
        }
        /*
        levelLists = createListForLevels(root2);
        for (List levelList : levelLists) {
            System.out.println("new list:\n");
            for(Object item : levelList) {
                System.out.println((int)item + " ");
            }
            System.out.println("");
        }
        */
        System.out.println("is subtree:"+treeMatches(root1, root2));
    }

}
