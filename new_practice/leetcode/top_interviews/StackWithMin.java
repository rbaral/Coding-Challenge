/**
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.
Example:
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --> Returns -3.
minStack.pop();
minStack.top();      --> Returns 0.
minStack.getMin();   --> Returns -2.
*/

/**
Method1:
-we maintain an additional stack to keep track of the min element so far
-while pushing, if the minstack is empty the we push in both stacks
-while popping, if the top of org stack is same as the top of minstack then we pop from both stack,
else we only pop from the org stack
*/
import java.util.Stack;

class MinStack{
	/** initialize your data structure here. */
	Stack<Integer> orgstack;
	Stack<Integer> minstack;
    public MinStack() {
		orgstack = new Stack<Integer>();
        minstack = new Stack<Integer>();
    }
    
    public void push(int x) {
        if(minstack.isEmpty() || x<=minstack.peek()){
			minstack.push(x);
			orgstack.push(x);
		}else{
			orgstack.push(x);
		}
    }
    
    public void pop() {
        if(orgstack.peek()>minstack.peek()){
			orgstack.pop();
		}else{
			orgstack.pop();
			minstack.pop();
		}
    }
    
    public int top() {
        return orgstack.peek();
    }
    
    public int getMin() {
        return minstack.peek();
    }
}
public class StackWithMin{
	public static void main(String args[]){
		MinStack minstack = new MinStack();
		minstack.push(2);
		minstack.push(1);
		minstack.push(20);
		System.out.println("top is:"+minstack.top());
		System.out.println("min is:"+minstack.getMin());
		minstack.pop();
		System.out.println("top is:"+minstack.top());
		System.out.println("min is:"+minstack.getMin());
		minstack.push(-1);
		System.out.println("top is:"+minstack.top());
		System.out.println("min is:"+minstack.getMin());
		minstack.pop();
		System.out.println("top is:"+minstack.top());
		System.out.println("min is:"+minstack.getMin());
	}
	
}