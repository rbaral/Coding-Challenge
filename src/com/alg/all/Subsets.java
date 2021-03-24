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


public class Subsets{

    public List<List<Integer>> subsets(int[] nums) {
        //handle base case
		List<List<Integer>> lists = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
		subsetsRecursive(lists, new ArrayList<Integer>(), nums, 0);
		return lists;
	}
	
	public void subsetsRecursive(List<List<Integer>> lists, List<Integer> tempList, int[] nums, int start){
		lists.add(new ArrayList<>(tempList));
		for(int i=start; i<nums.length; i++){
			tempList.add(nums[i]);
			subsetsRecursive(lists, tempList, nums, i+1);
			tempList.remove(tempList.size()-1);
		}
	}
}

