/*
Imagine a (literal) stack of plates. If the stack gets too high, it migh t topple. Therefore,
in real life, we would likely start a new stack when the previous stack exceeds some
threshold. Implement a data structure SetOfStacks that mimics this. SetOf-
Stacks should be composed of several stacks and should create a new stack once
the previous one exceeds capacity. SetOfStacks.push() and SetOfStacks.
pop () should behave identically to a single stack (that is, pop () should return the
same values as it would if there were just a single stack).

FOLLOW UP
Implement a function popAt(int index) which performs a pop operation on a
specific sub-stack.
 */
package com.alg.practice;

import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author rbaral
 */
class SetOfStacks {

    List<MyStack> listStack;
    int stackSize = 5; //a threshold value for size of stack
    int lastStackSize = 0;

    public SetOfStacks() {
        listStack = new ArrayList<MyStack>();
    }

    //pushses to the last stack on the list
    void push(Object item) {
        if (listStack == null || listStack.size() < 1 || lastStackSize == stackSize) {
            listStack.add(new MyStack());
            lastStackSize = 0;
        }
        //check if the last stack is full
        listStack.get(listStack.size() - 1).push(item);
        lastStackSize++;
        //System.out.println("pushing item " + item + " to stack " + listStack.size());
    }

    //pops from the last stack of the list
    Object pop() {
        if (listStack == null || listStack.size() < 1) {
            return null;
        } else {
            Object item = listStack.get(listStack.size() - 1).pop();
            lastStackSize--;
            System.out.println("poping item " + item + " from stack " + listStack.size());
            if (lastStackSize == 0) {
                //remove from list
                listStack.remove(listStack.size() - 1);
				if(listStack.size()>0){
				//point to the size of new last stack
				lastStackSize = stackSize;
				}
			}
			
            return item;
        }
    }

    Object peek() {
        if (listStack == null || listStack.size() < 1) {
            return null;
        } else {
            Object item = listStack.get(listStack.size() - 1).peek();
            return item;
        }
    }
    
	//pops element from the given stack
    Object popAt(int stackIndex){
        //check if the given stack is present and is not empty
		//we assume that the stackIndex is 0-based, i.e. first stack in the list is pointed by 0, second by 1, and so on.
		if(listStack.size()>stackIndex){
			//pop from the given stack
			Object item = listStack.get(stackIndex).pop();
			//also need to bring items from the following stacks to the previous stacks by one item
			for(int i=stackIndex+1; i<listStack.size(); i++){
				//pop from this stack and push to the previous one
				Object nextStackItem = listStack.get(i).pop();
				//push to the previous stack
				listStack.get(i-1).push(nextStackItem);
			}
			//for every shift, the element should be managed from last stack
			lastStackSize--;
			System.out.println("item "+item+" popped from stack "+stackIndex);
			return item;
		}else{
			System.err.println("invalid index, it should be at most "+(listStack.size()-1));
			return null;
		}
    }
}

public class SetOfStacksDemo {

    public static void main(String args[]) {
        SetOfStacks setStacks = new SetOfStacks();
        for (int i = 0; i < 15; i++) {
            setStacks.push(i);
        }
        
        //for (int i = 0; i < 15; i++) {
        //    setStacks.pop();
        //}
		//pop from the 1st stack 2 times
		setStacks.popAt(0);
		setStacks.popAt(0);
		for (int i = 0; i < 15; i++) {
            setStacks.pop();
        }
		
    }
}
