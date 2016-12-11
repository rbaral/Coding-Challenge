/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.leetup;

/**
 *
 * Given an array and a value, remove all instances of that value in place and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

The order of elements can be changed. It doesn't matter what you leave beyond the new length.

Example:
Given input array nums = [3,2,2,3], val = 3

Your function should return length = 2, with the first two elements of nums being 2.
* 
* 
* 
* Solution 1:
* 1) use two loops and for every element that matches, find the first non-matching element and swap them
* 2) the second loop should be starting at index 1 more than the index of first loop
* 2) break the loops when the second loop can't find non-matching value
* 3) the index1-1 will be the required value (or 0 if index1-1 is negative)
* 
* Complexity: O(n^2)
* 
* 
* * 
* Solution 2:
* 1)use two pointers one pointing to start of the array and another to the end of the array
* 2)if a[p2] == val,
*  a) //its fine, we can keep this intact on the right portion of the array
*    p2--;
* 3) if a[p1] == val,
*  a) swap a[p1] and a [p2] //send the element to the rightmost portion of the array
*  b) p2 --;
* 4) if a [p1] <> val then p1++; //we need to compare the next element
 * 5) return p1
 * 
 * 
 * Complexity: O(logn)
 * 
 * 
 * 
 * Solution 3:

* the basic idea is to keep two pointers, one iterates through all the elements
* of the given array and the other just keeps track of elements different than val.
* the final value for the other element pointer is the result because this is the position
* that we find for the elements other than the val
* 
* Complexity: O(n)
* 
* 
 * @author rbaral
 */
public class RemoveElementFromAnArray {
    
    public static int removeElement(int[] nums, int val) {
        //handle base cases
        if(nums == null){
            return 0;
        }else if(nums.length==1)
            return nums[0]==val?0:1;
        int p1 = 0, p2 = nums.length-1;
        while(p1<=p2){
            if(nums[p2]==val){
                p2--;
            }
            if(p2<0 || p1>p2)
                break; //in the middle if p2 is negative, we get AIOB exception; if p1>p2 we compare the number at a[p1] once again
            if(nums[p1]==val){
                int temp = nums[p2];
                nums[p2] = nums[p1];
                nums[p1] = temp;
                p2--;
            }else{
                p1++;
            }
        }
        return p2+1;
    }
    
    public static int removeElementSolution3(int[] nums, int val) {
		//otherElemCount pointer to keep track of elements other than val
        int otherElemCount=0; //to keep track of the iteration for elements in nums
        for(int allElemCount =0; allElemCount<nums.length;allElemCount++){
        	if(nums[allElemCount] != val){
                nums[otherElemCount] = nums[allElemCount];
                otherElemCount++; 
            }
        }
        return otherElemCount;
    }
    
    public static void main (String args[]){
        int nums[] = {3,2,2,3};
        int val = 3;
        System.out.println(removeElement(nums, val));
        nums = new int[] {3,3};
        System.out.println(removeElement(nums, val));
        nums = new int[] {3,3,3};
        System.out.println(removeElement(nums, val));
        nums = new int[] {2};
        System.out.println(removeElement(nums, val));
        nums = new int[] {4,5};
        System.out.println(removeElement(nums, 4));
        nums = new int[] {2,3,3};
        System.out.println(removeElement(nums, 3));
    }
}
