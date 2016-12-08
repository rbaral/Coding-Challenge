/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.ctci.stack;

/**
 *Implements Tower of Hanoi problem using Stack
 * @author rbaral
 */
public class TowerOfHanoi {
    
	public static void main(String args[]){
		int n = 3;
		Tower[] towers = new Tower[n];
		for(int i=0;i<3;i++){
			towers[i] = new Tower(i);
		}
		//add elements to the first tower, make sure the order of item maintains the order for TOH problem
		for(int i= n-1; i>=0;i--){
			towers[0].add(i);
		}
		//now start moving
		towers[0].moveItems(n, towers[1], towers[2]);
	}
}
