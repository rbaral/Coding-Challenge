/**
Given a non-empty array of integers, return the k most frequent elements.

Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
Example 2:

Input: nums = [1], k = 1
Output: [1]
Note:

You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
*/

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class ArrayTopKFrequentElements{

	/**
	Method1:
	-put the count of elements in a hashmap
	-prepare the result list by putting the elements at index count-1
	O(n), Space O(n)
	*/
	public static List<Integer> topKFrequent1(int[] nums, int k) {
        if(nums==null)
			return null;
		HashMap<Integer, Integer> mapnum = new HashMap<Integer, Integer>();
		//now create a list to hold the numbers by their frequency, multiple elements can have same frequency, so we use nested lists
		List<List<Integer>> numsList = new ArrayList<List<Integer>>();
		for(int i = 0;i<nums.length; i++){
			mapnum.put(nums[i], mapnum.getOrDefault(nums[i], 0)+1);
			//the numsList should be initialized to be big enough to hold all the elements
			numsList.add(new ArrayList<Integer>());
		}
		
		for(Integer num:mapnum.keySet()){
			int count = mapnum.get(num);
			//get the key and assign to the list of this frequency because other elements can also have same frequency
			List<Integer> curList = numsList.get(count-1);
			curList.add(num);
			numsList.set(count-1, curList);
		}
		//now we can filterout the first k elements as these are the top-k elements we need
		List<Integer> topk = new ArrayList<Integer>();
		//add the elements from teh numsList to the topk list
		for(int i=numsList.size()-1; i>=0;i--){
			//get the list for the freq i
			List<Integer> curList = numsList.get(i);
			//sort the item in the list
			Integer[] items = new Integer[curList.size()];
			curList.toArray(items);
			Arrays.sort(items);
			int index = items.length-1;
			while(topk.size()<=k && index>=0){
				topk.add(items[index]);
				index--;
			}
			if(topk.size()==k){
				return topk;
			}
		}
		return topk;
    }

	public static void main(String args[]){
		int [] nums = new int[] {1,1,1,2,2,3};
		int k = 2;
		List<Integer> freqList = topKFrequent1(nums, k);
		Integer[] freqArr = new Integer[freqList.size()];
		System.out.println("top "+k+" frequent elements are:"+Arrays.toString(freqList.toArray(freqArr)));
	}
}