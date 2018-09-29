/**
Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

The same repeated number may be chosen from candidates unlimited number of times.

Note:

All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
Example 1:

Input: candidates = [2,3,6,7], target = 7,
A solution set is:
[
  [7],
  [2,2,3]
]
Example 2:

Input: candidates = [2,3,5], target = 8,
A solution set is:
[
  [2,2,2,2],
  [2,3,3],
  [3,5]
]
*/

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class CombinationSum{

	public static List<List<Integer>> combSum(int[] nums, int target){
		//base case
		List<List<Integer>> lists = new ArrayList<List<Integer>>();
		Arrays.sort(nums);
		combSumRecursive(lists, new ArrayList<Integer>(), nums, 0, target);
		return lists;
	}
	
	public static void combSumRecursive(List<List<Integer>> lists, List<Integer> tempList, int[] nums, int start, int rem){
		if(rem<0){
			return;
		}else if(rem==0){//we found a sum
			lists.add(new ArrayList<>(tempList));
		}else{
			for(int i=start;i<nums.length; i++){
				tempList.add(nums[i]);
				combSumRecursive(lists, tempList, nums, i, rem-nums[i]);
				tempList.remove(tempList.size()-1);
			}
		}
	}
	
	public static void main(String args[]){
		int nums[] = new int[]{2,3,6,7};
		int target = 7;
		nums = new int[]{2,3,5};
		target = 8;
		
		List<List<Integer>> permsList = combSum(nums, target);
		for(List<Integer> intlist: permsList){
			Integer [] intarr = new Integer[intlist.size()];
			System.out.println(Arrays.toString(intlist.toArray(intarr)));
		}
	}
}