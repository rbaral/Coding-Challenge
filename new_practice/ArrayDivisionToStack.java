/**
Array division into three stacks:

Method1:
- we use fixed size of an array and allow size/3 lenght of an arry to each stack, so the first stack
will be using the space 0-size/3, second stack size/3-2*size/3, and third stack 2*size/3-size.
-the main problem with this approach is that some stack will be exhausted and some can have empty spaces

*/
import java.util.Arrays;
import java.lang.Exception;

public class ArrayDivisionToStack{
	//lets create an array assuming each stack will have 10 elements
	static int stackSize = 10;
	static int[] arr = new int[stackSize*3];
	static int[] stackIndices = {-1, -1, -1}; //these are the indices that point to the top element of each stack
	
	//method to push element into stack
	public static void push(int stack, int val) throws Exception{
		System.out.println("pushing item :"+val+" to stack:"+stack);
		if(stackIndices[stack]<stackSize-1){
			arr[++stackIndices[stack]+stack*stackSize] = val;
		}else{
			throw new Exception("Stack "+stack+" is full:");
		}
	}
	
	//pop value from the top of the given stack
	public static int pop(int stack) throws Exception{
		System.out.println("popping element from stack:"+stack);
		if(stackIndices[stack]>=0){
			int item = arr[stackIndices[stack] + stack*stackSize];
			//clear the position
			arr[stackIndices[stack] + stack*stackSize] = 0;
			stackIndices[stack]--;
			return item;
		}
		else{
			throw new Exception("Stack "+stack+" is empty");
		}
	}
	
	//peek value from the top of the given stack
	public static int peek(int stack) throws Exception{
		System.out.println("peeking element from stack:"+stack);
		if(stackIndices[stack]>=0){
			int item = arr[stackIndices[stack] + stack*stackSize];
			return item;
		}
		else{
			throw new Exception("Stack "+stack+" is empty");
		}
	}

	public static void main(String args[]) throws Exception{
		System.out.println(Arrays.toString(arr));
		//push item to some stacks
		
		for(int i=0;i<11;i++)
			push(0,i);
		System.out.println(Arrays.toString(stackIndices));
		System.out.println(Arrays.toString(arr));
		pop(2);
		System.out.println(Arrays.toString(arr));
		
	}
}