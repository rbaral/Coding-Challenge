/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.ctci.stack;

/**
 *this class represents a node with above and below pointers to other nodes
 * this can be used to create a stack/queue/linkedlist
 * 
 * @author rbaral
 */
public class Node {
    
	Node above; //the node above this node
	Node below; //the node below this node
	int data; // the data of this node
	
	public Node(int d){
		data = d;
	}
}
