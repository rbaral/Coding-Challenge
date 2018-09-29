/**
Given an unsorted array of integers, find the length of longest increasing subsequence.

Example:

Input: [10,9,2,5,3,7,101,18]
Output: 4 
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4. 
Note:

There may be more than one LIS combination, it is only necessary for you to return the length.
Your algorithm should run in O(n^2) complexity.
Follow up: Could you improve it to O(n log n) time complexity?
*/
import java.util.*;

public class LongestIncreasingSubSequence{

	/**
	Method1: use DP
	REf: https://www.geeksforgeeks.org/longest-increasing-subsequence-dp-3/
	-we initialize an array of length(nums.length) to all 1s, to hold the length of subsequence ending in each items
	because a single element subsequence is of length 1
	-we use two nested loops, the outer loop starts with 1 and inner loop starts with 0
	-for every outer loop item, we check if the inner item is less than the one on outer loop, if so, we update
	the length of outer loop item as Max(length of outer item, length of inner item +1)
	O(n^2) time and O(n) space
	*/
	public static int lengthOfLIS1(int[] nums) {
		//handle base cases
		if(nums== null || nums.length<1){
			return 0;
		}else if(nums.length==1 && nums[0]>=0){
			return 1;
		}else if(nums.length==1 && nums[0]<0){
			return 0;
		}
		int[] len = new int[nums.length];
        for(int i=0;i<len.length; i++){
			len[i] = 1;
		}
		for(int i=1; i<nums.length; i++){
			for(int j=0;j<i; j++){
				if(nums[i] > nums[j]){
					len[i] = Math.max(len[i], len[j] +1);
				}
			}
		}
		System.out.println(Arrays.toString(len));
		int max = 0;
		for(int i:len){
			if(max<i){
				max = i;
			}
		}
		return max;
    }
	
	/**
	Method2: use concept of binary seach
	-iteratively build a subsequence of length i=1,2,...
	- for each next element in the array, check if it is greater than the tail element of the previous iteration's subsequence
	--if greater, append it to the previous iteration subsequence
	--if smaller, find the subsequences (first iteration,...to, previous iteration) whose tail is smaller than this
	---and remove the subsequence that is of same length as the new subsequence
	-O(nlogn) for the binary search to find the matching subsequence for the current element
	Ref: https://www.geeksforgeeks.org/longest-monotonically-increasing-subsequence-size-n-log-n/
	*/
	public static int lengthOfLIS2(int[] nums) {
		//handle base cases
		if(nums== null || nums.length<1){
			return 0;
		}else if(nums.length==1 && nums[0]>=0){
			return 1;
		}else if(nums.length==1 && nums[0]<0){
			return 0;
		}
		int[] tails = new int[nums.length];
		int len = 1; //a pointer to the empty slot
		tails[0] = nums[0];
		for(int i=1; i<nums.length; i++){
			if(nums[i] <tails[0]){
				//make a new subsequence of size one with this element
				tails[0] = nums[i];
			}else if(nums[i] > tails[len-1]){
				//append to the previous subsequences
				tails[len++] = nums[i];
			}else{
				//this item fits at the end of some other subsequences, so we find the subsequence
				tails[findCeilIndex(tails, 0, len-1, nums[i])] = nums[i];
			}
		}
		return len;
	}
	
	/**
	use binary search to find the position of val in the given array
	*/
	public static int findCeilIndex(int[] nums, int start, int end, int val){
		while(start<end){
			int mid = start +(end-start)/2;
			if(nums[mid]>=val){
				end = mid;
			}else{
				start = mid+1;
			}
		}
		return end;
	}
	
	public static void main(String args[]){
		int[] nums = new int[]{10,9,2,5,3,7,101,18};
		//nums = new int[]{0};
		//nums = new int[]{4,10,4,3,8,9};
		System.out.println("longest increasing subseq is:"+lengthOfLIS1(nums));
		System.out.println("longest increasing subseq is:"+lengthOfLIS2(nums));
	}


}