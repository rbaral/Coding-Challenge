/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.test;

public class ArrayDivisionToStack {

    int stackSize = 10;
    int[] stackIndices = {-1, -1, -1};
    int[] buff = new int[3 * stackSize];

    public int getBuffIndex(int stackIndex) {
        int index = stackSize * stackIndex + stackIndices[stackIndex];
        return index;
    }

    public void push(int stackIndex, int val) throws Exception {
        //get the index where to insert
        int index = getBuffIndex(stackIndex) + 1;
        if (index >= (stackIndex + 1) * stackSize) {
            throw new Exception("Stack overflow");

        } else {
            buff[index] = val;
            stackIndices[stackIndex] = index;
        }
    }

    public int pop(int stackIndex) throws Exception {
        if (isEmpty(stackIndex)) {
            throw new Exception("Stack underflow");
        }
        int index = getBuffIndex(stackIndex);
        stackIndices[stackIndex]--;
        return buff[index];
    }

    public boolean isEmpty(int stackIndex) {
        return stackIndices[stackIndex] == -1;
    }

    public static void main(String args[]) throws Exception {
        ArrayDivisionToStack arrayStack = new ArrayDivisionToStack();
        arrayStack.push(0, 2);
        arrayStack.push(1, 5);
        arrayStack.pop(0);
    }

}
