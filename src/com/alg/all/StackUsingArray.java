/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.practice;

/**
 *
 * @author rbaral
 */
public class StackUsingArray {

    //create an array and send to helper methods
    static int[] stackIndices = {-1, -1, -1};//the default index of each stack that matches to the index of the array
    static int[] arr = new int[60]; //20 elements per stack, we have three stacks
    static int stackSize = arr.length / 3; //20 elements per stack

    public static void main(String args[]) {
        for(int i=0;i<25; i++){
            push(0, i);
        }
        for(int i=0;i<2; i++){
            peek(0);
        }
        for(int i=0;i<25; i++){
            pop(0);
        }
    }

//push the given item to the top of given stack
    public static void push(int stackNum, Object item) {
        if (stackIndices[stackNum] >= stackSize) {
            //Stack out of space
            System.err.println("Stack" + stackNum + " has already "+stackIndices[stackNum]+" elements and is out of space and cannot add item "+item);
        } else {
            //get the equivalent array index
            int index = stackNum*stackSize + stackIndices[stackNum] +1;
            arr[index] = (int) item;
            stackIndices[stackNum]+= 1;
            System.out.println("added item "+item+" to stack "+stackNum);
        }
    }

    public static Object pop(int stackNum) {
        if (stackIndices[stackNum] < 0) {
            //stack empty
            System.err.println("Stack " + stackNum + " is empty");
            return null;
        } else {
            //find the array index for this stack
            int index = stackNum * stackSize + stackIndices[stackNum];
            //decrease the index for this stack
            stackIndices[stackNum]-= 1;
            //can also invalidate the index that is popped
            arr[index] = 0;
            System.out.println("removed item "+arr[index] +" from stack "+stackNum);
            return arr[index];
        }
    }

    public static Object peek(int stackNum) {
        if (stackIndices[stackNum] < 0) {
            //stack empty
            System.err.println("Stack " + stackNum + " is empty");
            return null;
        } else {
            //find the array index for this stack
            int index = stackNum * stackSize + stackIndices[stackNum];
            System.out.println("Peeked item "+arr[index] +" from stack "+stackNum);
            return arr[index];
        }
    }

}
