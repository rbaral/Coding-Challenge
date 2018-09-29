/**
A peak element is an element that is greater than its neighbors.

Given an input array nums, where nums[i] ≠ nums[i+1], find a peak element and return its index.

The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

You may imagine that nums[-1] = nums[n] = -∞.

Example 1:

Input: nums = [1,2,3,1]
Output: 2
Explanation: 3 is a peak element and your function should return the index number 2.
Example 2:

Input: nums = [1,2,1,3,5,6,4]
Output: 1 or 5 
Explanation: Your function can return either index number 1 where the peak element is 2, 
             or index number 5 where the peak element is 6.
Note:

Your solution should be in logarithmic complexity.
*/
import java.util.Arrays;

public class ArrayPeakElement{

	/**
	Method1:
	-brute force approach
	-start from index=0 and end with index=nums.length-1
	-iteratively check if for a triplet, one of the number forms a peak
	*/
	public static int findPeakElement1(int[] nums) {
        int peak = -1;
		if(nums==null || nums.length<1){
			return -1;
		}else if(nums.length==1){
			return 0;
		}
		for(int i=0;i<nums.length; i++){
			if(i==0 && nums[i]>nums[i+1]){ //first element is a peak
				return i;
			}else if(i==nums.length-1 && nums[i-1]<nums[i]){ //last element is a peak
				return i;
			}else if(i>0 && i<nums.length-1){
				if(nums[i-1]<nums[i] && nums[i]>nums[i+1]){
					return i;
				}
			}
		}
		return peak;
    }
	
	/**
	Method2:
	-use the concept of binary search and check if two elements at the middle satisfy the peak property
	-if so, we repeat with the right half, else we repeat with the left half
	*/
	public static int findPeakElement2(int[] nums){
		if(nums==null || nums.length<1){
			return -1;
		}else if(nums.length==1){
			return 0;
		}
		int low = 0, high = nums.length-1;
		while(low<high){
			int mid = low +(high-low)/2;
			int mid2 = mid+1;
			if(nums[mid] < nums[mid+1]){
				low = mid+1;
			}else{
				high = mid;
			}
		}
		return low;
	}
	
	public static void main(String[] args){
		int nums[] = new int[]{1,2,3,1};
		//nums = new int[]{1,2,1,3,5,6,4};
		nums = new int[] {1,1,2,2};
		System.out.println("for array "+Arrays.toString(nums)+" one of the peak is:"+nums[findPeakElement1(nums)]);
		System.out.println("for array "+Arrays.toString(nums)+" one of the peak is:"+nums[findPeakElement2(nums)]);
	}
}