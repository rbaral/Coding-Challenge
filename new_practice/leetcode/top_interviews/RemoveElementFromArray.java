/**
Given an array nums and a value val, remove all instances of that value in-place and return the new length.

Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

The order of elements can be changed. It doesn't matter what you leave beyond the new length.

Example 1:

Given nums = [3,2,2,3], val = 3,

Your function should return length = 2, with the first two elements of nums being 2.

It doesn't matter what you leave beyond the returned length.
Example 2:

Given nums = [0,1,2,2,3,0,4,2], val = 2,

Your function should return length = 5, with the first five elements of nums containing 0, 1, 3, 0, and 4.

Note that the order of those five elements can be arbitrary.

It doesn't matter what values are set beyond the returned length.
Clarification:

Confused why the returned value is an integer but your answer is an array?

Note that the input array is passed in by reference, which means modification to the input array will be known to the caller as well.

Internally you can think of this:

// nums is passed in by reference. (i.e., without making a copy)
int len = removeElement(nums, val);

// any modification to nums in your function would be known by the caller.
// using the length returned by your function, it prints the first len elements.
for (int i = 0; i < len; i++) {
    print(nums[i]);
}
*/
import java.util.Arrays;

public class RemoveElementFromArray{

	public static int removeElement1(int[] nums, int val) {
        //base case
		if(nums==null)
			return 0;
		if(nums.length<2){
			return nums.length;
		}
		int start = 0;
		int end = 1;
		int dupcount=0;
		while(end<nums.length){
			if(nums[start]==nums[end] && nums[start]==val){
				end++;
				dupcount++;
			}else{
				//do the shifting of the duplicates detected so far
				nums[++start] = nums[end++];
			}
		}
		return nums.length - dupcount;
    }
	
	public static void main(String args[]){
		int[] nums = new int[]{3,2,2,3};
		int val = 3;
		System.out.println("org array is:"+Arrays.toString(nums));
		int newlen = removeElement1(nums, val);
		System.out.println("after removing "+val+" from array new length is:"+newlen+" and the array is:"+Arrays.toString(nums));
	}
}