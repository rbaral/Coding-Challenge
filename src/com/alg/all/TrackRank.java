/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.test;

/**
 * Track the rank (the number of elements less than) of a numer when there is a
 * stream of incoming numbers.
 */
/**
 * Solution: We store the incoming numbers in a binary search tree, so that the
 * number of nodes in the left subtree gives the rank for a node. When the rank
 * of a node is to be computed, we traverse the tree: - if the node lies on the
 * left, then keep on traversing the left subtree to get the node and return the
 * left value stored in the matching node, else return -1 (not found) - if the
 * node lies on the right, keep on traversing the right subtree, if it is found
 * return left value + 1 + right rank
 */
class RankNode {

    RankNode left, right;
    int val;
    int leftVal = 0;//the number of nodes in the left subtree

    public RankNode(int v) {
        val = v;
    }

    public void insert(int v) {
        if (v <= val) {//goes on the left subtree
            if (left == null) {
                left = new RankNode(v);
                leftVal++;
            } else {
                //insert to the left RankNode
                left.insert(v);
            }
        } else if (right == null) {
            right = new RankNode(v);
        } else {
            right.insert(v);
        }
    }
    //find the rank of a given node by finding it in the tree, or return -1

    public int getRank(int v) {
        if (v == val) {
            //we found the node
            return leftVal;
        } else if (v < val) {
            //check on the left subtree
            if (left != null) {
                return left.getRank(v);
            } else {
                return -1;
            }
        } else {
            //check on the right subtree
            int rightRank = (right == null) ? -1 : right.getRank(v);
            if (rightRank == -1) {
                return -1;
            } else {
                return rightRank + 1 + leftVal;
            }
        }

    }
}

public class TrackRank {

    RankNode root = null;
    //insert the incoming stream of number

    public void track(int v) {
        if (root == null) {
            root = new RankNode(v);
        } else {
            root.insert(v);
        }
    }

    public int getRank(int v) {
        if (root == null) {
            return -1;
        } else {
            return root.getRank(v);
        }
    }
    
    public static void main(String[] args){
        TrackRank trackRank = new TrackRank();
        trackRank.track(5);
        trackRank.track(10);
        trackRank.track(13);
        trackRank.track(15);
        trackRank.track(20);
        trackRank.track(23);
        trackRank.track(25);
        trackRank.track(24);
        int num = 10;
        System.out.println("rank of "+num+" is:"+trackRank.getRank(num));
        num = 20;
        System.out.println("rank of "+num+" is:"+trackRank.getRank(num));
        num = 25;
        System.out.println("rank of "+num+" is:"+trackRank.getRank(num));
        num = 100;
        System.out.println("rank of "+num+" is:"+trackRank.getRank(num));
    }

}
