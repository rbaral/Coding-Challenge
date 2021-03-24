/**
Given an array of integers nums, write a method that returns the "pivot" index of this array.

We define the pivot index as the index where the sum of the numbers to the left of the index is equal to the sum of the numbers to the right of the index.

If no such index exists, we should return -1. If there are multiple pivot indexes, you should return the left-most pivot index.

Example 1:
Input: 
nums = [1, 7, 3, 6, 5, 6]
Output: 3
Explanation: 
The sum of the numbers to the left of index 3 (nums[3] = 6) is equal to the sum of numbers to the right of index 3.
Also, 3 is the first index where this occurs.
Example 2:
Input: 
nums = [1, 2, 3]
Output: -1
Explanation: 
There is no index that satisfies the conditions in the problem statement.
Note:

The length of nums will be in the range [0, 10000].
Each element nums[i] will be an integer in the range [-1000, 1000].
*/
import java.util.*;

public class ArrayEquillibriumPivotIndex{

	/**
	-accumulate the whole sum into a var
	-start taking sum from beginning, and reducing the previous accumulated sum
	-if the two sums are equal, we found a pivot
	O(n)
	*/
	public static int pivotIndex1(int[] nums) {
        //base case
		if(nums==null || nums.length<1){
			return -1;
		}
		if(nums.length==1){
			return 0;
		}
		int leftsum = 0, rightsum = 0;
		//accumulate the sum
		for(int i:nums){
			rightsum+=i;
		}
		//reduce the previously collected sum
		for(int i = 0;i<nums.length; i++){
			rightsum-=nums[i];
			if(leftsum== rightsum){
				return i;
			}
			leftsum+=nums[i];
		}
		return -1;
    }
	
	public static void main(String[] args){
		int[] nums = new int[]{1, 7, 3, 6, 5, 6};
		System.out.println("array:"+Arrays.toString(nums)+" has pivot index at:"+pivotIndex1(nums));
		nums = new int[]{1, 2, 3};
		System.out.println("array:"+Arrays.toString(nums)+" has pivot index at:"+pivotIndex1(nums));
		nums = new int[]{-1,-1,-1,-1,-1,0};
		System.out.println("array:"+Arrays.toString(nums)+" has pivot index at:"+pivotIndex1(nums));
		nums = new int[]{-1,-1,0,1,1,1};
		System.out.println("array:"+Arrays.toString(nums)+" has pivot index at:"+pivotIndex1(nums));
		nums = new int[]{-1,-1,-1,-1,0,-1};
		System.out.println("array:"+Arrays.toString(nums)+" has pivot index at:"+pivotIndex1(nums));
		nums = new int[] {-1,-1,-1,-1,0,1};
		System.out.println("array:"+Arrays.toString(nums)+" has pivot index at:"+pivotIndex1(nums));
	}

}