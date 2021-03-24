/**
Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note: You are not suppose to use the library's sort function for this problem.

Example:

Input: [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
Follow up:

A rather straight forward solution is a two-pass algorithm using counting sort.
First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.
Could you come up with a one-pass algorithm using only constant space?
*/
import java.util.*;

public class ColorSort{
	/**
	Method1:
	-count the different colors and maintain their counts in separate vars
	-populate the array with the desired counts found earlier
	-uses two pass
	O(n), O(k) space
	
	Can we do better?
	Method2:
	-create zeroindex, oneindex, and twoindex vars and set all of them to -1
	-iterate through the input array and do the following
	-if 0 is found, add 0 to zeroindex, oneindex, and twoindex
	-if 1 is found, add 1 to oneindex and twoindex
	-if 2 is found, add 2 to twoindex
	O(n), Space O(1)
	*/
	public static void sortColors(int[] nums) {
		int zeroid = -1, oneid = -1, twoid = -1;
		for(int i:nums){
			if(i==0){
				nums[++twoid] = 2;
				nums[++oneid] = 1;
				nums[++zeroid] = 0;
			}else if(i==1){
				nums[++twoid] = 2;
				nums[++oneid] = 1;
			}else if(i==2){
				nums[++twoid] = 2;
			}
		}
	}
	
	public static void main(String[] args){
		int[] nums = new int[]{2,0,2,1,1,0};
		sortColors(nums);
		System.out.println("sorted array is:"+Arrays.toString(nums));
	}
}