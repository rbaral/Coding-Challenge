/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.ccup;

import com.ds.binarytree.BinaryNode;
import com.ds.binarytree.BinaryTree;

/**
 *Given a specific type of DAT that forms a pyramid
 * (the links have up-down direction), in which the  node labels
 * are integer, find the path that has the maximum sum of node values.
 * What is the time and space complexity of the algorithm?
 * 
 * Ref:https://careercup.com/page?pid=google-interview-questions&job=software-engineer-intern-interview-questions&topic=algorithm-interview-questions
 * 
 * 
 * @author rbaral
 */
public class MaxSumPathBinaryTree {
    
    
    /**
     * we assume the tree is a binary tree
     * and solve the problem for now.
     * But the solution should be similar
     * for trees with n degree
     */
    
    static int findMaxSum(BinaryNode node){
        if(node==null){
            return 0;
        }else if(node.getLeft()==null && node.getRight()==null){ //has no child
            return node.getData();
        }
        else{
            return Math.max(findMaxSum(node.getLeft()), findMaxSum(node.getRight())) + node.getData();
        }
    }
    
    public static void main(String args[]){
        
        //now add the nodes to the tree
        BinaryNode root = new BinaryNode(3);
        //add the nodes
        BinaryNode level2Left = new BinaryNode(9);
        BinaryNode level2Right = new BinaryNode(4);
        root.setLeft(level2Left);
        root.setRight(level2Right);
        
        BinaryNode level3Left = new BinaryNode(1);
        BinaryNode level3Mid = new BinaryNode(8);
        BinaryNode level3Right = new BinaryNode(2);
        
        level2Left.setLeft(level3Left);
        level2Left.setRight(level3Mid);
        
        level2Right.setLeft(level3Mid);
        level2Right.setRight(level3Right);
        
        
        BinaryNode level4Left = new BinaryNode(4);
        BinaryNode level4Mid1 = new BinaryNode(5);
        BinaryNode level4Mid2 = new BinaryNode(8);
        BinaryNode level4Right = new BinaryNode(2);
        
        level3Left.setLeft(level4Left);
        level3Left.setRight(level4Mid1);
        
        level3Mid.setLeft(level4Mid1);
        level3Mid.setRight(level4Mid2);
        
        level3Right.setLeft(level4Mid2);
        level3Right.setRight(level4Right);
        
        
        BinaryTree bTree = new BinaryTree(root);
        bTree.printInOrderTree();
        //bTree.printPostOrder();
        
        /**
         * the maximum sum can be the maximum value of sum when traversed to a leaf node
         * so we can use some kind of recursion from the root node and repeat till we reach
         * the leaf node. Whichever leaf has the maximum value will be selected in the path
         * from the root node.
         * 
         * 
         * The Dynamic programming solution offered  has some limitations when the nodes are labeled with negative integers. If the nodes are negative then one solution might be to
            change the sign of the nodes and search for the path with minimum value. As we have reversed the sign of the nodes, the path with least sum is infact the path with the maximum value of the original data.
         */
        System.out.println(""+findMaxSum(root));
        
    }
}
