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
public class TreeNode {
    TreeNode left;
    TreeNode right;
	TreeNode parent;
    Object val;
    public TreeNode(Object val){
        this.val = val;
    }
    
    public void setLeft(TreeNode node){
        this.left = node;
    }
    
    public void setRight(TreeNode node){
        this.right = node;
    }
    
    public TreeNode getLeft(){
        return this.left;
    }
    public TreeNode getRight(){
        return this.right;
    }
	
	public void setParent(TreeNode par){
		this.parent = par;
	}
	
	public TreeNode getParent(){
		return this.parent;
	}
	
	public Object getValue(){
		return this.val;
	}
}
