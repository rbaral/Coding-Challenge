/**
In the classic problem of the Towers of Hanoi, you have 3 towers and N disks of
different sizes which can slide onto any tower. The puzzle starts with disks sorted
in ascending order of size from top to bottom (i.e., each disk sits on top of an even
larger one). You have the following constraints:
(T) Only one disk can be moved at a time.
(2) A disk is slid off the top of one tower onto the next rod.
(3) A disk can only be placed on top of a larger disk.
Write a program to move the disks from the first tower to the last using Stacks.
*/
import java.util.*;
class Tower{
	Stack<Integer> stack;
	Tower(){
		stack = new Stack<Integer>();
	}
	
	boolean isEmpty(){
		return stack.isEmpty();
	}
	
	int pop(){
		return stack.pop();
	}
	
	int peek(){
		return stack.peek();
	}
	
	
	boolean addTop(int val){
		//System.out.println("trying to add:"+val+" on tower with top:"+(this.isEmpty()?"NULL":this.peek()));
		if(this.isEmpty() || this.peek()>val){
			stack.push(val);
			return true;
		}else{
			System.out.println("Item "+val+" cannot be pushed on tower with top:"+this.peek());
			return false;
		}
	}
	
	boolean moveTopTo(Tower t1){
		if(t1.isEmpty() || t1.peek()>this.peek()){
			t1.addTop(this.pop());
			return true;
		}else{
			System.out.println("cannot move topto another stack:");
			return false;
		}
	}
	
	//move items from t1 to t2 using current tower as a buffer
	void moveItems(int n, Tower buffer, Tower dest){
		if(n<=0){
			return;
		}
		//first move the top n-1 disks from src to buffer using dest as buffer
		this.moveItems(n-1, dest, buffer);
		
		//move the last disk from source to the dest
		this.moveTopTo(dest);
		
		//now add all the n-1 disks from buffer to dest, using src as buffer
		
		buffer.moveItems(n-1, this, dest);
		
	}
	
	void printItems(){
		List<Integer> items = new ArrayList<Integer>();
		while(!this.isEmpty()){
			int val = this.pop();
			System.out.print(val+" ");
			items.add(0, val);
		}
		System.out.println();
		//after printing, add back the items to stack
		for(int i:items){
			this.addTop(i);
		}
	}
}
public class TowerOfHanoi{

	public static void main(String args[]){
		Tower t1 = new Tower();
		Tower t2 = new Tower();
		Tower t3 = new Tower();
		int n = 3;
		for(int i=n; i>0; i--){
			t1.addTop(i);
		}
		System.out.println("tower 1 has:");
		t1.printItems();
		t1.moveItems(n, t2, t3);
		System.out.println("tower 3 has:");
		t3.printItems();
	}
}