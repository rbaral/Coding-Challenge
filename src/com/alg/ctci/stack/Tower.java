package com.alg.ctci.stack;
//represents a single tower
public class Tower{
	int index; //indicates the position of this tower in the Tower of Hanoi
	Stack st; // the stack of elements in this tower
	
	//public Tower(){}
	public Tower(int i){
		index = i;
		st = new Stack(10); //an empty stack with capacity of 10 elements at the beginning
	}
	
	//operation to add element to this tower
	public void add(int item){
		System.out.println(st.isEmpty()+"...."+st.size);
		if(!st.isEmpty() && st.peek()<item){
			System.out.println("Item "+item+" doesn't fit in "+index+" which already has top item"+st.peek());
		}else{
			st.push(item);
		}
	}
	
	public void moveTopItemTo(Tower d){
		int topItem = st.pop();
		d.add(topItem);
		System.out.println("Moving item:"+topItem+" from "+index+" to "+d.getIndex());
	}
	
	/**
	Use one tower as a buffer while transferring the elements to the destination tower
	*/
	public void moveItems(int n, Tower buffer, Tower destination){
		moveItems(n-1, destination, buffer); //make the destination as a buffer this time and move all n-1 items to the buffer tower
		//next move the last item to the destination
		moveTopItemTo(destination);
		//next move the n-1 items from the buffer to the destination using the start as the buffer
		buffer.moveItems(n-1, this, destination);
	}
	
	//getter and setters
	public int getIndex(){
		return index;
	}
	
}