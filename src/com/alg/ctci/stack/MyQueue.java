package com.alg.ctci.stack;

/**
Implement a MyQueue class which implements a queue using two stacks.

Basically, we need to provide the queue operations:
enqueue - adding item to end of the queue
dequeue - removing item from front of the queue
isFull, 
isEmpty, 
peek
*/

public class MyQueue{
	
	static Stack s1, s2;
	
	MyQueue(){
		s1 = new Stack();
		s2 = new Stack();
	}
	
	//add element to s1
	static enqueue(int data){
		
	}
	
	//remove element from top of s2
	static dequeue(){
		shiftElementsToS2();
	}
	
	static peek(){
		return s2.peek();
	}
	
	//if s2 is empty, pop from s1 and push to s2
	static shiftElementsToS2(){
		
	}
	public static void main(String args[]){
		
	}
}