/**
Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
*/

import java.util.Arrays;
import java.util.HashMap;


public class TwoSum{
	
	/**
	Method1:
	-we iteratively scan the array using two nested loops and check if the numbers at two different indices add up
	to the given target
	O(n^2)
	*/
	public static int[] getTwoSum1(int[] nums, int tar){
		int[] res = new int[2];
		for(int i=0;i<nums.length; i++){
			for(int j=i+1; j<nums.length; j++){
				if(nums[i] + nums[j] == tar){
					res[0] = i;
					res[1] = j;
					return res;
				}
			}
		}
		return res;
	}
	
	/**
	Method2:
	-in the first iteration, we store the numbers in a storage (e.g., Hash)
	-in the second iteration, we check if the hash already contains tar-nums[i], if so we found one
	O(n), Space: O(n)
	
	Enhancement: We can use the same loop to store the elements in the map and check if the map has relevant keys
	this saves an extra loop
	*/
	public static int[] getTwoSum2(int[] nums, int tar){
		int[] res = new int[2];
		HashMap<Integer, Integer> mapNums = new HashMap<Integer, Integer>();
		int index=0;
		for(int i:nums){
			mapNums.put(i, index);
			index++;
		}
		//reset the index
		index = 0;
		for(int i:nums){
			if(mapNums.containsKey(tar-i) && mapNums.get(tar-i)!=index){
				//we can maintain the order of the keys as well
				if(index<mapNums.get(tar-i)){
					res[0] = index;
					res[1] = mapNums.get(tar-i);
				}else{
					res[1] = index;
					res[0] = mapNums.get(tar-i);
				}
				return res;
			}
			index++;
		}
		return res;
	}
	
	/**
	Method3:
	-we use single loop to store items in hashmap and check if the current item has a matching pair in the hashmap
	O(n)
	*/
	public static int[] getTwoSum3(int[] nums, int tar){
		HashMap<Integer, Integer> mapNums = new HashMap<Integer, Integer>();
		int[] res = new int[2];
		//res[0] =-1;
		//res[1] = -1;
		int index = 0;
		for(int i:nums){
			if(mapNums.containsKey(tar - i) && mapNums.get(tar-i)!=index){
				if(index<mapNums.get(tar-i)){
					res[0] = index;
					res[1] = mapNums.get(tar-i);
				}else{
					res[1] = index;
					res[0] = mapNums.get(tar-i);
				}
				return res;
			}
			mapNums.put(i, index);
			index++;
		}
		return res;
	}
	
	
	public static void main(String args[]){
		int [] nums = new int[] {2, 7, 11, 15};
		int tar = 9;
		//nums = new int[]{3,3};
		//tar = 6;
		//nums = new int[]{3,2,4};
		//tar = 6;
		System.out.println("Two sum1 for target "+tar+" is:"+Arrays.toString(getTwoSum1(nums, tar)));
		System.out.println("Two sum2 for target "+tar+" is:"+Arrays.toString(getTwoSum2(nums, tar)));
		System.out.println("Two sum3 for target "+tar+" is:"+Arrays.toString(getTwoSum3(nums, tar)));
	}
}