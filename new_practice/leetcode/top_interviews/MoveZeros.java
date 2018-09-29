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
	
	/**
	-scan the array elements iteratively
	-if a 0 is found, bring all the elements succeeding it one step before
	O(n^2)
	*/
	public static int[] moveZeros1(int[] nums){
		for(int i=0;i<nums.length;i++){
			if(nums[i]==0){
				//find the first element after this that is non-zero
				int cur = i;
				while(nums[cur]==0 && cur<nums.length-1){
					cur++;
				}
				
				int zeros = cur - i;//these many consecutive zeros were found
				//now shift all the elements from the cur to nums.length-1 to position i
				int start = i;
				while(cur<nums.length){
					nums[start] = nums[cur];
					cur++;
					start++;
				}
				//now from the end, we fill zeros number of 0s
				
				while(zeros>0){
					nums[nums.length-zeros] = 0;
					zeros--;
				}
			}
		}
		return nums;
	}
	
	public static int[] moveZeros2(int[] nums){
		int non_zeroIndex = 0;
		for(int i=0;i<nums.length; i++){
			if(nums[i]!=0){
				nums[non_zeroIndex++] = nums[i];
			}
		}
		//after using the non_zerIndex for all the non-zero elements, the rest of the iteration till nums.length can be used to fill the zeros
		while(non_zeroIndex<nums.length){
			nums[non_zeroIndex]=0;
			non_zeroIndex++;
		}
		return nums;
	}
	
	public static void main(String args[]){
		int nums[] = new int[]{0,1,0,3,12};
		//nums = new int[]{0,0,1};
		//nums = new int[] {4,2,4,0,0,3,0,5,1,0};
		int[] shifted = moveZeros1(nums);
		System.out.println("shifted array1 is:"+Arrays.toString(shifted));
		System.out.println("shifted array2 is:"+Arrays.toString(moveZeros2(nums)));
	}
}