/**
Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the array.

Formally the function should:

Return true if there exists i, j, k 
such that arr[i] < arr[j] < arr[k] given 0 ≤ i < j < k ≤ n-1 else return false.
Note: Your algorithm should run in O(n) time complexity and O(1) space complexity.

Example 1:

Input: [1,2,3,4,5]
Output: true
Example 2:

Input: [5,4,3,2,1]
Output: false
*/
import java.util.Arrays;

public class ArrayIncreasingTripletSequence{

	/**
	Method1:
	-use brute force solution by counting the elements that satisfy the increasing triplet
	-iterate through the arraya elements and keep track of max element found so far and min element found so far
	-whenever a new min so far is found, the potential triplet sequence starting point is reset
	*/
	public static boolean increasingTriplet1(int[] nums) {
        //base case
		if(nums==null || nums.length<3){
			return false;
		}
		int minsoFar = Integer.MAX_VALUE;
		int maxsoFar = Integer.MAX_VALUE;
		int start = 0;
		int end = 0;
		boolean found = false;
		for(int i=0;i<nums.length; i++){
			if(nums[i]<=minsoFar){
				minsoFar = nums[i];
				start= i;
			}
			else if(nums[i]<=maxsoFar){
				maxsoFar = nums[i];
			}else{
				end = i;
				found = true;
				break;
			}
		}
		System.out.println("increasing sequence found from index:"+start+" to :"+end);
		return found;
    }
	
	public static void main(String[] args){
		int[] nums = new int[]{1,2,3,4,5};
		nums = new int[]{5,4,3,2,1};
		//nums = new int[] {};
		//nums = new int[]{1,1,3,4,5};
		//nums = new int[]{5,1,5,5,2,5,4};
		System.out.println("triplet found in array "+Arrays.toString(nums)+" is "+increasingTriplet1(nums));
	}
}