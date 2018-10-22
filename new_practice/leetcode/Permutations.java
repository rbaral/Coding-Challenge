/**
Given a collection of distinct integers, return all possible permutations.

Example:

Input: [1,2,3]
Output:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
*/

import java.util.*;

public class Permutations{

	public static List<List<Integer>> permute(int[] nums) {
		List<List<Integer>>  result = new ArrayList<List<Integer>>(); 
		if(nums==null || nums.length<1){
			return result;
		}
		List<List<Integer>> temp = new ArrayList<List<Integer>>();
		temp.add(new ArrayList<Integer>());
		temp.get(temp.size()-1).add(nums[0]);
		getPermutations(nums, temp, result, 1);
		return result;
	}
	
	public static void getPermutations(int[] nums, List<List<Integer>> temp, List<List<Integer>> result, int index){
		if(index>=nums.length){
			//add all the elements from temp into result
			for(List<Integer> list:temp){
				result.add(list);
			}
			return;
		}
		//for every previous permutation, add the following elements, in each possible position
		List<List<Integer>> newperm = new ArrayList<List<Integer>>();
		for(int i = 0;i<temp.size(); i++){
			int size = temp.get(i).size();
			for(int j=0; j<=size; j++){
				List<Integer> list = new ArrayList<>();
				list.addAll(temp.get(i));
				list.add(j, nums[index]);
				newperm.add(list);
			}
		}
		getPermutations(nums, newperm, result, index+1);
	}
	
	public static void main(String[] args){
		int[] nums = {1,2,3};
		List<List<Integer>> perms = permute(nums);
		for(List<Integer> list:perms){
			System.out.println(Arrays.toString(list.toArray(new Integer[list.size()])));
		}
	}
}