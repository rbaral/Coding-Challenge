/**
ArrayWithDuplicateSubsets
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
import java.util.*;

public class ArraySubsetsDuplicateElements{

	public static List<List<Integer>> subsetsWithDup(int[] nums) {
       //handle base case
		List<List<Integer>> lists = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
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

	/**
	public static List<List<Integer>> subsetsWithDup(int[] nums) {
       //handle base case
		List<List<Integer>> sets = new ArrayList<List<Integer>>();
		sets.add(new ArrayList<Integer>());
		if(nums.length==0){
			return sets;//empty set
		}
		Arrays.sort(nums);
		for(int i=0;i<nums.length; i++){
			int size = sets.size();
			for(int j=0;j<size; j++){
			//TODO: handle duplicates
			List<Integer> newlist = new ArrayList<>(sets.get(j));
			newlist.add(nums[i]);
			sets.add(newlist);
				
			}
		}
		return sets;
    }
	
	*/
	
	public static void main(String[] args){
		int[] nums = new int[]{1,2,2};
		nums = new int[]{1,1,2,2};
		List<List<Integer>> sets = subsetsWithDup(nums);
		for(List<Integer> list:sets){
			System.out.println(Arrays.toString(list.toArray(new Integer[list.size()])));
		}
	}

}