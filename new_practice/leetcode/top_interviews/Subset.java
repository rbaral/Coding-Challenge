/**
Given a set of distinct integers, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:

Input: nums = [1,2,3]
Output:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
*/

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Subset{

	
	public static List<List<Integer>> subsets1(int[] nums) {
		//handle base case
		List<List<Integer>> lists = new ArrayList<List<Integer>>();
		subsetsRecursive(lists, new ArrayList<Integer>(), nums, 0);
		return lists;
	}
	
	public static void subsetsRecursive(List<List<Integer>> lists, List<Integer> tempList, int[] nums, int start){
		lists.add(new ArrayList<>(tempList));
		for(int i=start; i<nums.length; i++){
			tempList.add(nums[i]);
			subsetsRecursive(lists, tempList, nums, i+1);
			tempList.remove(tempList.size()-1);
		}
	}
	
	
	public static void main(String args[]){
		int[] nums = new int[]{1,2,3};
		System.out.println("List of lists are:");
		List<List<Integer>> lists = subsets1(nums);
		for(List<Integer> list:lists){
			System.out.println(Arrays.toString(list.toArray(new Integer[list.size()])));
		}
	}
}
