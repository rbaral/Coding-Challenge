/**
ArraySubsets:

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
import java.util.*;

public class ArraySubsets{

	public static List<List<Integer>> subsets(int[] nums){
		List<List<Integer>> sets = new ArrayList<List<Integer>>();
		sets.add(new ArrayList<Integer>());
		if(nums.length==0){
			return sets;//empty set
		}
		//iterate and add the respective element to the subsets of previous iteration
		for(int i = 0; i<nums.length; i++){
			int size = sets.size();
			for(int j=0;j<size; j++){
				List<Integer> newlist = new ArrayList<>(sets.get(j));
				newlist.add(nums[i]);
				sets.add(newlist);
			}
		}
		return sets;
	}
	
		
	public static void main(String[] args){
		int[] nums = new int[]{1,2,3};
		List<List<Integer>> sets = subsets(nums);
		for(List<Integer> list:sets){
			System.out.println(Arrays.toString(list.toArray(new Integer[list.size()])));
		}
	}

}