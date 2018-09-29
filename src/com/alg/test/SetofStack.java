/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SetofStack {

    List<Stack<Integer>> setStack = new ArrayList<Stack<Integer>>();
    List<Integer> stackSizes = new ArrayList<Integer>();
    int capacity = 10; //lets assume each stack can hold only capacity items

    public void push(int a) {
        //first time we are pushing
        if (setStack == null || setStack.size() == 0) {
            stackSizes.add(1);
            Stack<Integer> myStack = new Stack<Integer>();
            myStack.push(a);
            setStack.add(myStack);
        } else {
            //we already have some stacks in the list, so operate on the last one
            int lastIndex = setStack.size() - 1;
            //check if the last stack is full or not
            if (stackSizes.get(lastIndex) < capacity) {//not full
                stackSizes.set(lastIndex, stackSizes.get(lastIndex) + 1);
                setStack.get(lastIndex).push(a);
            } else {//is full
                Stack<Integer> myStack = new Stack<Integer>();
                myStack.push(a);
                setStack.add(myStack);
                stackSizes.add(1);
            }
        }
    }

    public int pop() throws Exception {
        //if the stacks are empty
        int lastIndex = stackSizes.size();
        if (lastIndex < 0) {
            throw new Exception("Stack underflow");
        } else {
            //get item from the last stack and remove it if it gets empty
            int val = setStack.get(lastIndex).pop();
            stackSizes.set(lastIndex, stackSizes.get(lastIndex) - 1);
            if (stackSizes.get(lastIndex) == 0) {//remove this empty stack
                setStack.remove(lastIndex);
                stackSizes.remove(lastIndex);
            }
            return val;
        }

    }

    public int popAt(int index) throws Exception {
        //check if the index is valid
        int lastIndex = stackSizes == null ? -1 : stackSizes.size();
        if (index < 0 || lastIndex < index) {
            //invalid index
            throw new Exception("invalid stack index:");
        }
        //fetch item from the given index
        int val = setStack.get(index).pop();
        stackSizes.set(index, stackSizes.get(index) - 1);
        //now shift the items from the following stacks
        while ((index + 1) <= lastIndex) {
            //push the item from following stack to current stack
            setStack.get(index).push(setStack.get(index + 1).pop());
            stackSizes.set(index, stackSizes.get(index) + 1);
            stackSizes.set(index + 1, stackSizes.get(index + 1) - 1);
            //if the following stack is empty, remove it from the list
            if (stackSizes.get(index + 1) == 0) {
                stackSizes.remove(index + 1);
                setStack.remove(index + 1);
            }
            lastIndex = setStack.size();
            index++;
        }
        return val;
    }

    public static void main(String args[]) {

    }

}
