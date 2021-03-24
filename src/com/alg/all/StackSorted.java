/**
sort stack in ascending order(biggest on top) using at most one additional stack as temporary space.

Method1:
-push: if the stack is empty, simply push. If the stack is not empty, pop all the elements bigger than the val into the temporary/auxiliary stack, push the val into the original stack, and push all the items back from auxiilary stack to the org. stack
-pop: simply pop the item at the top of the org. stack

O(n) for the push because we might need to pop all the elements from the org. stack to the auxiliary stack
O(1) for pop because we just return the top element form org. stack
*/
import java.util.Stack;
public class StackSorted{
	static Stack<Integer> s1 = new Stack<Integer>();
	static Stack<Integer> s2 = new Stack<Integer>(); //auxiliary stack
	
	public static void push(int val){
		if(s1.isEmpty()){
			s1.push(val);
		}else{
			//push all the values in s1 that are larger than val into s2
			while(!s1.isEmpty() && val<peek()){
				s2.push(s1.pop());
			}
			//now push the val into s1 becuase this is its right position
			s1.push(val);
			//now push back all the values from s2 into s1
			while(!s2.isEmpty()){
				s1.push(s2.pop());
			}
		}
	}
	
	public static int peek(){
		return s1.peek();
	}
	
	public static int pop(){
		return s1.pop();
	}
	
	public static void main(String args[]){
		//lets push some values arbitrarily and check if the pop operation returns the items in proper order or not
		push(10);
		push(1);
		push(12);
		push(0);
		push(15);
		push(5);
		push(7);
		//we pushed 7 values, lets pop the top 7 values and check the order of the items
		int counter = 1;
		while(counter<8){
			System.out.println("popping from s1:"+pop());
			counter++;
		}
	}
}

