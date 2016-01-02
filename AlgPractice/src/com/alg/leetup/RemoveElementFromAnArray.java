/**
 * Given an array and a value, remove all instances of that value in place and return the new length.

The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 */
package com.alg.leetup;

/**
 * @author rbaral
 *
 */
public class RemoveElementFromAnArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int nums[] = new int[]{2,2,3};
		int val = 2;
		System.out.println(removeElement(nums, val));

	}
	/**
	 * the basic idea is to keep two pointers, one iterates through all the elements
	 * of the given array and the other just keeps track of elements different than val.
	 * the final value for the other element pointer is the result because this is the position
	 * that we find for the elements other than the val
	 * @param nums
	 * @param val
	 * @return
	 */
	public static int removeElement(int[] nums, int val) {
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

}
