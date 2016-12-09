/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.leetup;

/**
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].

Note:
You must do this in-place without making a copy of the array.
Minimize the total number of operations.
* 
* Solution:
* 
* *****
* Solution_1
* *******
* 1)We take out the element if it is zero and shift all of its successors to one slot left
* 2)Repeat this process till we reach the end
* 
* ***
* Solution_2
* *****
* 1)Scan through the array and count the number of zeros
* 2)Next iterate through the array and move the non-zero elements by keeping track of the non-zero index
 *
 * @author rbaral
 */
public class MoveZeros {
 
    static void moveZeros(int[] nums) {
        //base case
        if (nums == null || nums.length < 1) {
            return;
        }
        /*
        //first pass- count the zeros
        int zeroCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroCount += 1;
            }
        }
        //what if there are all zeros in the array
        if (zeroCount == nums.length) {
            return;
        }
        */
        //now shift the array
        int zeroIndex = -1;
        int nonzeroIndex = -1;
        int arrIndex = 0;
        while (arrIndex < nums.length) {
            if(nums[arrIndex]!=0){
                nonzeroIndex = arrIndex;
            }
            else if (zeroIndex < 0) {//if found zero andif already pointed to previously occured zero which has not been swapped
                    zeroIndex = arrIndex;
                }
            
            //if zero was found, nonzero was found and zero is left of nonzero
            if (zeroIndex >= 0 && nonzeroIndex >= 0 && zeroIndex < nonzeroIndex) {
                //swap
                nums[zeroIndex] = nums[nonzeroIndex];
                nums[nonzeroIndex] = 0;
                zeroIndex = zeroIndex + 1;
                arrIndex = zeroIndex;
                nonzeroIndex = -1;
            }else{
                arrIndex++;
            }
        }

    }
	
    public static void main(String args[]) {
        int[] nums = {0, 0, 1, 0, 0, 3, 12, 0};
        moveZeros(nums);
        for (int c : nums) {
            System.out.print(" " + c);
        }
    }
    
}
