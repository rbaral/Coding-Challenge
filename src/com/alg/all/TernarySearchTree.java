/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.basics;

/**
 *
 * @author rbaral
 * 
 * We have a modified binary search tree where the left child node
 * has value less than its parent node, the right child node has value greater
 * than its parent node and the mid child node has value equal to the parent node
 * Write a method to insert and delete nodes in such a tree
 * 
 */
public class TernarySearchTree {
    
    private class Node{
        private int val;
        private Node left = null;
        private Node right = null;
        private Node mid = null;
        
        public Node(int val){
            this.val = val;
        }
    }
    
    private Node root;
    
    /**
     * inserts val into the tree
     * 
     * we have an iterative version, we can also write a recursive version
     * as we have in the deleteNode method
     * @param val 
     */
    public void insert(int val){
        if(root ==null){
            root = new Node(val);
        }else{
            Node currentNode = root;
            Node parentNode = null;
            while(currentNode!=null){ //iterate to find the right position of the new node
                parentNode = currentNode;
                if(val < currentNode.val){
                    currentNode = currentNode.left;
                }else if(val> currentNode.val){
                    currentNode = currentNode.right;
                }else{
                    currentNode = currentNode.mid;
                    break;
                }
            }
            //now we have the pointer to the parent node of the new node
            if(val < parentNode.val){
                parentNode.left = new Node(val);
            }else if(val> parentNode.val){
                parentNode.right = new Node(val);
            }else{
                parentNode.mid = new Node(val);
            }
        }
    }
    
    /**
     * deletes only one instance of the val from the tree
     * and if the val doesn't exist in the tree, it does nothing.
     * @param val 
     */
    public void delete(int val){
        //find the position of the node to be deleted
        root = deleteNode(root, val);
    }
    
    public Node deleteNode(Node n, int val){
        if(n==null){
            return n;
        }
        else if(val < n.val){
            n.left = deleteNode(n.left, val);
        }else if(val > n.val){
            n.right = deleteNode(n.right, val);
        }else if(val == n.val){
            //there can be or can't be the middle node
            if(n.mid!=null){
                n.mid = deleteNode(n.mid, val);
            }else if(n.right!=null){
                //we don't have the mid node, so we need to delete this node itself
                //to delete this node, we need to find it's successor (the left most node in its right subtree)
                Node succ = findSuccessor(n.right);
                
                //the successor will be the new root
                n.val = succ.val;
                //now delete the successor from the right subtree
                n.right = deleteNode(n.right, succ.val);
                
            }else{
                n = n.left;
            }
        }
        return n; //return the new root of the tree
    }
    
    public Node findSuccessor(Node n){
        Node suc = n;
        while(suc.left!=null){
            suc = suc.left;
        }
        return suc;
    }
}
