/**
Shortest unsorted continuous subarray
Given an integer array, you need to find one continuous subarray that if you only sort this subarray in ascending order, then the whole array will be sorted in ascending order, too.

You need to find the shortest such subarray and output its length.

Example 1:
Input: [2, 6, 4, 8, 10, 9, 15]
Output: 5
Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
Note:
Then length of the input array is in range [1, 10,000].
The input array may contain duplicates, so ascending order here means <=.

*/
import java.util.*;

public class ArrayShortestUnsortedSubarray{

	/**
	Method1:
	-make a copy of the array and sort the copy
	-iterate through beginning to end the array until the sorted copy and the org array have same items
	-iterate through end to beginning the array until the sorted copy and the org array have same items
	-return end - start + 1
	O(nlogn), Space: O(n)
	*/
	public static int findUnsortedSubarray1(int[] nums) {
        int [] temp = nums.clone();
		Arrays.sort(temp);
		int start = 0, end = nums.length-1;
		//check if the sorted portion in both arrays are same, if so keep on advancing the index
		while(start<=end && nums[start]==temp[start]){
			start++;
		}
		//check if the end portion is sorted
		while(end>start && nums[end]==temp[end]){
			end--;
		}
		return end - start +1;
    }
	
	/**
	the sorted array holds the following property:
	1) nums[k]<=nums[k+1] for all 0<=k<n-1
	2) nums[k] == max[k] for all 0<=k<=n-1, where max[k] is the max value in the sub array [0,...,k]
	3) nums[k] == min[k] for all 0<=k<=n-1, where min[k] is the min value in the sub array [k,...,n-1]
	
	So, we have:
	nums[k] = max[k] <=max[k+1] = nums[k+1]
	nums[k] = min[k] <= min[k+1] = nums[k+1]
	
	So, the nums[i,j] hold the unsorted array if the following conditions are met:
	- i is the smallest index such that nums[i]!=min[i]
	- j is the largest index such that nums[j]!=max[j]
	
	O(n), one pass solution
	*/
	public static int findUnsortedSubarray2(int[] nums) {
		int i = 0, j = -1;
		int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
		for(int left = 0, right = nums.length-1; right>=0; left++,right--){
			max = Math.max(max, nums[left]);
			if(nums[left]!=max){//violates the order
				j = left;
			}
			min = Math.min(min, nums[right]);
			if(nums[right]!=min){
				i = right;
			}
			System.out.println(" i is:"+ i+" j is:"+j);
		}
		return j - i +1;
	}
	
	public static void main(String[] args){
		int[] nums = new int[]{2, 6, 4, 8, 10, 9, 15}; //need to sort items from index 1 to index 5=> (5-1+1)=5 items
		nums = new int[]{1,2,3,4}; //need to sort 0 items
		nums = new int[]{1,2,3,3,3};// need to sort 0 items
		nums = new int[]{1,3,2,2,2};//need to sort from index = 1 to index = 4=> (4-1 +1)=4 items
		nums = new int[]{1,2,3,5,4,4,14,14};// need to sort from index = 3 to index = 5=(5-3 +1) = 3 items
		nums = new int[]{2,1};
		nums = new int[]{2,3,3,2,4};
		nums = new int[]{1,2,4,5,3};
		nums = new int[]{1,1};
		nums = new int[]{1,1,1,1,1,1,1,1,1};
		nums = new int[]{1,3,4,2,5};
		System.out.println("for array "+Arrays.toString(nums)+" shortest unsorted subarr is:"+findUnsortedSubarray2(nums));
	}

}