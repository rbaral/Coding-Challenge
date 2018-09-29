/**
Stack with min method that returns the minimum element in the stack. Push, pop, and min all should have O(1) running time
*/

import java.util.Stack;

class MinStack{
	Stack<Integer> myStack;
	Stack<Integer> minStack;
	
	public MinStack(){
		myStack = new Stack<Integer>();
		minStack = new Stack<Integer>();
	}
	
	
	/**
	while pushing, we check if the element to be pushed is smaller than the one on minstack, if so push on both stacks
	-if greater than the top of minstack, only push to org stack
	*/
	public void push(int val){
		if((minStack.size()==0) || (val<minStack.peek())){
			myStack.push(val);
			minStack.push(val);
		}else {//no need to push to minstack
			myStack.push(val);
		}
	}
	
	public int peek(){
		return myStack.peek();
		
	}
	
	/**
	if the item at top of org stack is same as the one on minstack then pop from both
	*/
	public int pop(){
		if(minStack.size()>0 &&(minStack.peek()==myStack.peek())){
			minStack.pop();
			return myStack.pop();
		}else{
			return myStack.pop();
		}
	}
	
	/**
	the min element is always retained on the top of the minstack
	*/
	public int min(){
		return minStack.peek();
	}
}
public class StackWithMin{
	
	public static void main(String args[]){
		//push some elements
		MinStack stackMin = new MinStack();
		stackMin.push(12);
		stackMin.push(11);
		stackMin.push(7);
		stackMin.push(9);
		System.out.println("Min so far is:"+stackMin.min());
		stackMin.pop();
		stackMin.pop();
		System.out.println("Min so far is:"+stackMin.min());
		stackMin.push(-20);
		System.out.println("Min so far is:"+stackMin.min());
		
	}
}