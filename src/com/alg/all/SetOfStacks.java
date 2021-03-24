/**
Set of Stack: when one stack is full, add another stack and operate on it. It is just like simulating the pile of plates
on restaurants. When the last stack is empty, the operation starts on the second last stack and so on.

Followup: implement popat(int index) which performs pop operation at specific stack
*/

/**
we use arraylist to hold the stacks and when the last stack is full, we add a new stack into the array list and start operating on it

Complexity: O(n), Space: O(n)
*/
import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

class StackSet{
	int stackSize = 5;//lets assume the stack holds 10 elements only
	List<Stack<Integer>> stackList;
	public StackSet(){
		stackList= new ArrayList<Stack<Integer>>();
	}
	
	//push into the last stack
	public void push(int val){
		if(stackList.size()<1){
			Stack<Integer> newStack = new Stack<Integer>();
			newStack.push(val);
			stackList.add(newStack);
		}else{
			//check if the last stack is full or not if full create new stack else push into the existing one
			if(stackList.get(stackList.size()-1).size()<stackSize){
				stackList.get(stackList.size()-1).push(val);
			}else{
				Stack<Integer> newStack = new Stack<Integer>();
				newStack.push(val);
				stackList.add(newStack);
			}
		}
		System.out.println("pop item from stack:"+stackList.size()+" is:"+val);
	}
	
	//peek the top element from last stack
	public int peek() throws Exception{
		if(stackList.size()>0){
			return stackList.get(stackList.size()-1).peek();
		}else{
			throw new Exception("Stack list is empty");
		}
	}
	
	//pop the element from the last stack, if the stack is empty, remove it from the list
	public int pop() throws Exception{
		if(stackList.size()>0){
			int val = stackList.get(stackList.size()-1).pop();
			System.out.println("pop item from stack:"+stackList.size()+" is:"+val);
			//if the last stack became empty, remove it from the array list
			if(stackList.get(stackList.size()-1).size()==0){
				stackList.remove(stackList.size()-1);
			}
			return val;
			
		}else{
			throw new Exception("Stack list is empty");
		}
	}
	
	/**
	FOLLOWUP: Implement popat(int index) which performs pop operation on a specific stack
	
	-this method is tricky because we need to maintain rolling stack. When pop is performed at the middle stack,
	then we need to push the elements from following stack to this stack.
	*/
	public int popAt(int index) throws Exception{
		//first we check if the index is a valid one, we assume 0-indexed stacks are used
		if(index<0 || index>stackList.size()-1){
			throw new Exception("Invalid stack index, the stack index shoul be in range:0 to:"+(stackList.size()-1));
		}
		//if the index is the last stack, then just pop and we are done
		if(index==stackList.size()-1){
			return stackList.get(index).pop();
		}else{//its in the middle
			int popItem = stackList.get(index).pop();
			//pop all the following stacks and push into a new Stack
			Stack<Integer> bigStack = new Stack<Integer>();
			while(stackList.size()>index){//it is a zero based index
				while(stackList.get(stackList.size()-1).size()>0){
					System.out.println("pushed into big stack is:"+stackList.get(stackList.size()-1).peek());
					bigStack.push(stackList.get(stackList.size()-1).pop());
				}
				//now remove the empty stacks from the stackList
				stackList.remove(stackList.size()-1);
			}
			
			//now push the elements from big stack to the small stacks by creating new stacks whenever needed
			while(bigStack.size()>0){
				//push the item to the last stack in the stacklist
				int val = bigStack.pop();
				System.out.println("popped from big stack is:"+val);
				if(stackList.size()<1 || (stackList.get(stackList.size()-1).size()==stackSize)){
					//craeate a new stack and add it to the list
					Stack<Integer> newStack = new Stack<Integer>();
					newStack.push(val);
					stackList.add(newStack);
				}else {//if(stackList.get(stackList.size()-1).size()<stackSize){
					stackList.get(stackList.size()-1).push(val);
				}
			}
			return popItem;
		}
	}
	
	//return the value at the top of the given stack
	public int peekAt(int index)throws Exception{
		//first we check if the index is a valid one, we assume 0-indexed stacks are used
		if(index<0 || index>stackList.size()-1){
			throw new Exception("Invalid stack index, the stack index shoul be in range:0 to:"+(stackList.size()-1));
		}
		return stackList.get(index).peek();
	}
	
}
public class SetofStacks{
	
	public static void main(String args[]) throws Exception{
		StackSet setStack = new StackSet();
		for(int i=0;i<20; i++){
			setStack.push(i);
		}
		int popatIndex = 0;
		setStack.popAt(popatIndex);
		//now check the value the top of popatIndex stack
		System.out.println("the "+popatIndex+" stack has peek value as:"+setStack.peekAt(popatIndex));
	}
	
}