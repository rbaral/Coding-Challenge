/**
Given a collection of numbers that might contain duplicates, return all possible unique permutations.

Example:

Input: [1,1,2]
Output:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]
*/

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;


public class PermutationsII{

	public static List<List<Integer>> permute1(int[] nums){
		List<List<Integer>> lists = new ArrayList<List<Integer>>();
		Arrays.sort(nums);
		permuteRecursive(lists, new ArrayList<Integer>(), nums, new boolean[nums.length]);
		return lists;
	}
	
	public static void permuteRecursive(List<List<Integer>> lists, List<Integer> tempList, int[] nums, boolean[] used){
		if(tempList.size()==nums.length){
			lists.add(new ArrayList<>(tempList));
		}
		for(int i=0;i<nums.length; i++){
			if(used[i] || i>0 && nums[i-1] == nums[i] && !used[i-1])
				continue;
			tempList.add(nums[i]);
			used[i] = true;
			permuteRecursive(lists, tempList, nums, used);
			used[i] = false;
			tempList.remove(tempList.size()-1);
		}
	}
	
	
	public static void main(String args[]){
		int nums[] = new int[]{1,1,2};
		
		List<List<Integer>> permsList = permute1(nums);
		for(List<Integer> intlist: permsList){
			Integer [] intarr = new Integer[intlist.size()];
			System.out.println(Arrays.toString(intlist.toArray(intarr)));
		}
	}
}