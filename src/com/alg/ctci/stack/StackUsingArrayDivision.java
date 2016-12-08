/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.ctci.stack;

/**
 *Describe how you could use a single array to implement three stacks
 
 Solution: 
 The easy approach is to divide the array in three consecutive portions for the three stacks
 and define the index of the array as the top of the stacks.
 * @author rbaral
 */
 import java.lang.Exception;
 
public class StackUsingArrayDivision {
    
	//lets initialize the top of all three stacks
	static int[] stackIndices = {-1, -1, -1}; //at beginning all the stacks are empty
	//WLOG lets suppose all three stacks can have maximum size of 20 (the size is needed because we are using array and arrays have fixed size, we can have the stacks of different size too)
	//lets declare the array of size equal the sum of the sizes of all the stacks
	static int [] arr = new int[60];
	
	static void push(int stackID, int data) throws Exception{
		//check if we have reached out of space
		int stackIndex = getStackIndex(stackID); //get the top pointer for this stack
		//update for the new data
		stackIndex++;
		if(stackIndex>(20*stackID + 19)){
			throw new Exception("Stack is out of space");
		}
		
		//we still have some space
		arr[stackIndex] = data;
		//System.out.println("pusing data at index "+stackIndex);
		//we also advance the index of the stack for future operations
		stackIndices[stackID]++;
		
	}
	
	static int pop(int stackID) throws Exception{
		//check if there is some element in the stack
		int stackIndex = getStackIndex(stackID);
		if(stackIndex>-1){
			//System.out.println("getting data at index "+stackIndex);
			int data = arr[stackIndex];
			//we just clear out the slot and assume that the space is not used
			arr[stackIndex] = Integer.MAX_VALUE;
			//we also update the index of the stack for future operations
			stackIndices[stackID] = stackIndex-1;
			return data;
		}else{
			throw new Exception("Stack is empty");
		}
	}
	
	static int peek(int stackID)throws Exception{
		//check if there is some element in the stack
		int stackIndex = getStackIndex(stackID);
		if(stackIndex>-1){
			int data = arr[stackIndex];
			return data;
		}else{
			throw new Exception("Stack is empty");
		}
	}
	
	//returns the index of array which represents the top of a stack
	static int getStackIndex(int stackID){
		return stackIndices[stackID];
	}
	
	public static void main(String args[])throws Exception{
		//lets try inserting some elements in the stack
		for(int i=0;i<20;i++){
			push(0, i);
		}
		
		for(int i=0;i<20;i++){
			System.out.println(pop(0));
		}
	}
}
