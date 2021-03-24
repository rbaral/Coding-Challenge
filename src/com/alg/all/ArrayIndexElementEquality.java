/**
#Array Index & Element Equality

Given an array of sorted distinct integers named arr, write a function that returns an index i in arr for which arr[i] = i or -1 if no such index exists.

Implement the most efficient solution possible, prove the correctness of your solution and analyze its runtime complexity (in terms of n - the length of arr).

Examples:

Given arr = [-8,0,2,5] the function returns 2, since arr[2] = 2
Given arr = [-1,0,3,6] the function returns -1, since no index in arr satisfies arr[i] = i
*/
import java.util.Arrays;

public class ArrayIndexElementEquality{
	
	/**
	Method1
	-scan through whole array and return the index where the matching is found
	O(n)
	*/
	public static int getIndexelementEquality1(int[] nums){
		int index = -1;
		for(int i = 0;i<nums.length; i++){
			if(i==nums[i]){
				return i;
			}
		}
		return index;
	}

	/**
	-we need to use the concept of binary search because the given array is sorted
	O(logn)
	*/
	public static int getIndexElementEquality2(int[] nums){
		//base case
		if(nums==null || nums.length<1){
			return -1;
		}
		int start = 0, end = nums.length-1;
		while(start<=end){
			int mid = (start+end)/2;
			if(nums[mid]==mid){//found one
				return mid;
			}else if(nums[mid]<mid){//if the value is lower than index, moving right will increase both index and value
				//search right
				start = mid+1;
			}else if(nums[mid]>mid){//if the value is higher than index, going right will increase value and index both, so search left
				end = mid-1;
			}
		}
		return -1;
	}
	
	public static void main(String[] args){
		int[] nums = new int[]{-8,0,2,5};
		nums = new int[]{-1,0,3,6};
		System.out.println("Array "+Arrays.toString(nums)+" has index value equality at:"+getIndexElementEquality2(nums));
	}

}