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
 
public class MyStackDemo{
	public static void main(String args[]){
		MyStack st = new MyStack();
		for(int i=0;i<10; i++){
			st.push(i);
		}
		//lets pop and see if the values are inserted properly
		for(int i=0;i<10; i++){
			System.out.print(st.pop()+" ");
		}
	}
	
}
