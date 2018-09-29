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
import java.util.Arrays;

public class SortColors{

	/**
	Method2:
	-define three indices for three type of values (0, 1, and 2)
	-for each type of value encountered in the input, insert the value in the index greater than the relevant index
	-e.g., for 0, insert the item in index for 2, in index for 1, and then in the index for 0
	-for 1, insert the item in index for 2 and in the index for 1
	for 2, insert the item in index for 2
	O(n), O(1) space
	*/
	public static void sortColors(int[] nums) {
        int i0 = -1, i1=-1, i2=-1;
		for(int i=0;i<nums.length; i++){
			if(nums[i]==0){
				nums[++i2] = 2;
				nums[++i1] = 1;
				nums[++i0] = 0;
			}
			else if(nums[i]==1){
				nums[++i2] = 2;
				nums[++i1] = 1;
			}
			else if(nums[i]==2){
				nums[++i2] = 2;
			}
		}
    }
	
	public static void main(String args[]){
		int[] nums = new int[]{2,0,2,1,1,0};
		sortColors(nums);
		System.out.println("sorted array is:"+Arrays.toString(nums));
	}
}