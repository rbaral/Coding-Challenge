/**
Array Partition I

Given an array of 2n integers, your task is to group these integers into n pairs of integer, say (a1, b1), (a2, b2), ..., (an, bn) which makes sum of min(ai, bi) for all i from 1 to n as large as possible.

Example 1:
Input: [1,4,3,2]

Output: 4
Explanation: n is 2, and the maximum sum of pairs is 4 = min(1, 2) + min(3, 4).
Note:
n is a positive integer, which is in the range of [1, 10000].
All the integers in the array will be in the range of [-10000, 10000].
*/
import java.util.*;

public class ArrayPartitionI{
	
	/**
	-sort the array
	-take the min of every two numbers and accumulate the sum
	O(nlogn)
	*/
	public static int arrayPairSum(int[] nums) {
        //base case
		if(nums==null || nums.length==0){
			return 0;
		}
		if(nums.length%2!=0){
			return 0;
		}
		Arrays.sort(nums);
		//now find the sum of the pairs
		int sum = 0;
		for(int i=0;i<nums.length; i+=2){
			sum+=Math.min(nums[i], nums[i+1]);
		}
		return sum;
    }
	
	public static void main(String args[]){
		int[] nums = new int[]{1,4,3,2};
		System.out.println("sum for array "+Arrays.toString(nums)+" is: "+arrayPairSum(nums));
		nums = new int[]{1,1};
		System.out.println("sum for array "+Arrays.toString(nums)+" is: "+arrayPairSum(nums));
	}

}