/**
Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:

Input: [1,2,2]
Output:
[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
*/
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class SubsetsII{

	public static List<List<Integer>> subsetsWithDup1(int[] nums) {
        //handle base case
		List<List<Integer>> lists = new ArrayList<List<Integer>>();
		Arrays.sort(nums);//required to pass leetcode test cases to order the subsets
		subsetRecursive(lists, new ArrayList<Integer> (), nums, 0);
		return lists;
    }
	
	public static void subsetRecursive(List<List<Integer>> lists, List<Integer> tempList, int[] nums, int start){
		lists.add(new ArrayList<>(tempList));
		for(int i=start; i<nums.length; i++){
			//skip duplicates
			if(i>start && nums[i]==nums[i-1]) continue;
			tempList.add(nums[i]);
			subsetRecursive(lists, tempList, nums, i+1);
			tempList.remove(tempList.size()-1);
		}
		
	}
	
	public static void main(String args[]){
		int nums[] = new int[]{1,2,2};
		List<List<Integer>> lists = subsetsWithDup1(nums);
		for(List<Integer> list:lists){
			System.out.println(Arrays.toString(list.toArray(new Integer[list.size()])));
		}
	}
}