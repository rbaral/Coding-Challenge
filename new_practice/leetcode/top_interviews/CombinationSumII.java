/**
Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

Each number in candidates may only be used once in the combination.

Note:

All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
Example 1:

Input: candidates = [10,1,2,7,6,1,5], target = 8,
A solution set is:
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]
Example 2:

Input: candidates = [2,5,2,1,2], target = 5,
A solution set is:
[
  [1,2,2],
  [5]
]
*/
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class CombinationSumII{

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
				//handle duplicates
				if(i>start && nums[i]==nums[i-1]) continue;
				tempList.add(nums[i]);
				combSumRecursive(lists, tempList, nums, i+1, rem-nums[i]);
				tempList.remove(tempList.size()-1);
			}
		}
	}
	
	public static void main(String args[]){
		int nums[] = new int[]{10,1,2,7,6,1,5};
		int target = 8;
		//nums = new int[]{2,5,2,1,2};
		//target = 5;
		
		List<List<Integer>> permsList = combSum(nums, target);
		for(List<Integer> intlist: permsList){
			Integer [] intarr = new Integer[intlist.size()];
			System.out.println(Arrays.toString(intlist.toArray(intarr)));
		}
	}

}