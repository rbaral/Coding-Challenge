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
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Permutations{

	/**
	Method1:
	-we start from the first element whose only permutation is itself
	-for the second element, we add it to the every possible positions on the permutations of the first element
	-we repeat this till we have the permutation of the last element of the array
	O(nk), where k is the maximum permutation of (n-1) items of the input array
	*/
	public static List<List<Integer>> permute1(int[] nums) {
        List<List<Integer>> lastPermsList = new ArrayList<List<Integer>>();
		//initialize the perms from only the first element of the input array
		List<Integer> firstPerm = new ArrayList<Integer>();
		firstPerm.add(nums[0]);
		lastPermsList.add(firstPerm);
		//now populate the permutations of other elements based on the lastpermslist
		for(int i=1;i<nums.length; i++){
			List<List<Integer>> newPermList = new ArrayList<List<Integer>>();
			for(List<Integer> lastPerm:lastPermsList){
				//add this element to all the possible combinations of the last permutation
				for(int j = 0;j<=lastPerm.size(); j++){
					List<Integer> newPerm = new ArrayList<Integer>(lastPerm);
					Collections.copy(newPerm, lastPerm);
					newPerm.add(j, nums[i]);
					//System.out.println(Arrays.toString(newPerm.toArray(new Integer[newPerm.size()])));
					newPermList.add(newPerm);
				}
			}
			lastPermsList = newPermList;
		}
		return lastPermsList;
		
    }
	/**
	Method2: recursive solution
	-Ref: https://leetcode.com/problems/subsets/discuss/27281/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partitioning)
	*/
	public static List<List<Integer>> permute2(int[] nums){
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		permuteRecursive(list, new ArrayList<Integer>(), nums);
		return list;
		
	}
	
	public static void permuteRecursive(List<List<Integer>> list, List<Integer> tempList, int[] nums){
		if(tempList.size()==nums.length){//only add if the intermediate list contains a combination of all the items
			list.add(new ArrayList<Integer>(tempList));//we already reached the max size for the permutation
		}else{
			for(int i=0;i<nums.length; i++){
				if(tempList.contains(nums[i])){
					continue; //skip if already contained in the list
				}else{
					tempList.add(nums[i]);
					permuteRecursive(list, tempList, nums);
					//remove the last element
					tempList.remove(tempList.size()-1);
				}
			}
		}
		
	}

	public static void main(String args[]){
		int nums[] = new int[]{1,2,3};
		
		/*
		List<List<Integer>> permsList = permute1(nums);
		for(List<Integer> intlist: permsList){
			Integer [] intarr = new Integer[intlist.size()];
			System.out.println(Arrays.toString(intlist.toArray(intarr)));
		}
		*/
		List<List<Integer>> permsList = permute2(nums);
		for(List<Integer> intlist: permsList){
			Integer [] intarr = new Integer[intlist.size()];
			System.out.println(Arrays.toString(intlist.toArray(intarr)));
		}
	}
}