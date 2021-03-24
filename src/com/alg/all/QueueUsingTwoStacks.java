/**
Implement Queue using two stacks:

Method1:
Use two stacks s1 and s2
enqueue: push items to stack s1
dequeue: check if s2 is empty, if so, pop all elements form s1 into s2, return the top item of s2., if s2 is not empty, simply return the top of s2.
*/
import java.util.Stack;

class MyQueue{
	Stack<Integer> s1;
	Stack<Integer> s2;
	MyQueue(){
		s1 = new Stack<Integer>();
		s2 = new Stack<Integer>();
	}
	
	//add item to the end of the queue
	public void enqueue(int val){
		System.out.println("adding item "+val);
		s1.push(val);
	}
	
	//pop the first item from the queue
	public int dequeue() throws Exception{
		if(s2.isEmpty() && s1.isEmpty()){
			throw new Exception("Queue is empty");
		}else{
			//we can only pop if s2 is empty, else just pop from s2
			if(s2.isEmpty()){
				//pop all the elements from s1 into s2
				while(!s1.isEmpty()){
					s2.push(s1.pop());
				}
			}
			System.out.println("removing item:"+s2.peek());
			return s2.pop();
		}
	}
	
	public int peek() throws Exception{
		if(s1.isEmpty() && s2.isEmpty()){
			throw new Exception("Attempting to peek from empty Queue");
		}else{
			if(s2.isEmpty()){
				while(!s1.isEmpty()){
					s2.push(s1.pop());
				}
			}
			return s2.peek();
		}
	}
	
	public boolean isEmpty(){
		return s1.isEmpty() && s2.isEmpty();
	}
}
public class QueueUsingTwoStacks{

	public static void main(String args[]) throws Exception{
		MyQueue myQueue = new MyQueue();
		for(int i=0;i<10;i++){
			myQueue.enqueue(i);
		}
		while(!myQueue.isEmpty()){
			myQueue.dequeue();
		}
	}

}