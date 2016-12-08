/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.ctci.stack;

/**
*Imagine a (literal) stack of plates. If the stack gets too high, it migh t topple. Therefore,
in real life, we would likely start a new stack when the previous stack exceeds some
threshold. Implement a data structure SetOfStacks that mimics this. SetOf-
Stacks should be composed of several stacks and should create a new stack once
the previous one exceeds capacity. SetOfStacks.push() and SetOfStacks.
pop () should behave identically to a single stack (that is, pop () should return the
same values as it would if there were just a single stack).


 *
 * @author rbaral
 */
 
import java.util.ArrayList;

public class SetOfStacks {
    static ArrayList<Stack> stacks = new ArrayList<Stack>();
	static int stackCapacity; //the size of a stack
	
	public SetOfStacks(int size){
		this.stackCapacity = size;
	}
	/*
	push should always push to the last stack.
	If the last stack is full, it should create a new stack
	and then add the data to the new stack.
	*/
	public static void push(int data){
		Stack last = getLastStack(); //get the stack at the last index
		if(last!=null && !last.isFull()){ //if we have a stack that can be used for addition
			last.push(data);
		}else{ //we need to create a new stack
			Stack newStack = new Stack(stackCapacity);
			newStack.push(data);
			stacks.add(newStack);
		}
	}
	
	/**
	pop should pop item from the last stack. 
	If the last stack is empty, it should be removed from the list of stacks.
	*/
	public static int pop(){
		Stack lastStack = getLastStack();
		int data = lastStack.pop();
		if(lastStack.size <= 0){
			stacks.remove(stacks.size()-1);// remove the last one
		}
		return data;
	}
	
	/**
	pops the element from the specified stack
	* the stacks next to it need to shift the elements
	* one step left to implement the rollover
	*/
	public static int popAt(int index){
		//we pop the element from top of the stack at index "index", the rest of the stack at the top of this stack will pop the elements from the bottom
		return leftShift(index, true);
	}
	
	/**
	* pops the element from top of the given stack and the other stacks after this will
	* pop elements from the bottom to reflect the rollover
	*/
	public static int leftShift(int index, boolean popFromTop){
		Stack st = stacks.get(index);
		int data;
		if(popFromTop){
			data = st.pop();
		}else{ //bottom pop
			data = st.removeFromBottom();
			//such popped element will be pushed to the top of the stack before it to indicate the rollover
		}
		//if the stack became empty, we remove it from the list and no shift is required
		if(st.isEmpty()){
			stacks.remove(index);
		}else if(stacks.size()>index+1){//there are still some stacks after this stack, in the list
			//get the bottom of the succeeding stack and insert into this stack
			st.push(leftShift(index+1, false));
		}
		return data;
	}
	public static Stack getLastStack(){
		//check if there is some stack in the list
		if(stacks.size()>0){
			int lastStackIndex = stacks.size()-1;
			System.out.println("processing stack at index:"+lastStackIndex);
			return stacks.get(lastStackIndex);
		}else{
			return null;
		}
		
	}
	
	public static void main(String[] args) {
		int capacity_per_substack = 5;
		SetOfStacks set = new SetOfStacks(capacity_per_substack);
		for (int i = 0; i < 34; i++) {
			set.push(i);
		}
		/**
		for (int i = 0; i < 34; i++) {
			System.out.println("Popped " + set.pop());
		}
		*/
		//lets see the effect of popAt
		int totalStacks = 7; //we know the no. of stacks created by simple arithmetic
		Stack st;
		for(int i=0;i<totalStacks; i++){
			st = stacks.get(i);
			st.printStack();
		}
		//lets pop from bottom of the 1st stack 
		System.out.println(popAt(0));
		for(int i=0;i<totalStacks; i++){
			st = stacks.get(i);
			st.printStack();
		}
		
		
	}
}
