/**
Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Example:

Input: [0,1,0,3,12]
Output: [1,3,12,0,0]
Note:

You must do this in-place without making a copy of the array.
Minimize the total number of operations.
*/
import java.util.Arrays;

public class MoveZeros{

	public static void moveZeroes(int nums[]){
		//move every non-zero items to front part
		int index = 0;
		for(int i=0;i<nums.length; i++){
			if(nums[i]!=0){
				nums[index++] = nums[i];
			}
		}
		while(index<nums.length){
			nums[index++] = 0;
		}
	}
	
	
	
	public static void main(String args[]){
		int[] nums = new int[]{0,1,0,3,12};
		moveZeroes(nums);
		System.out.println("new array is:"+Arrays.toString(nums));
		nums = new int[]{1,0,1};
		moveZeroes(nums);
		System.out.println("new array is:"+Arrays.toString(nums));
		nums = new int[]{2,1};
		moveZeroes(nums);
		System.out.println("new array is:"+Arrays.toString(nums));
	}

}