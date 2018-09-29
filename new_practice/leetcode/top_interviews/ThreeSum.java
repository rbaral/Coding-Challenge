/**
Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? 
Find all unique triplets in the array which gives the sum of zero.

Note:

The solution set must not contain duplicate triplets.

Example:

Given array nums = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
*/
import java.util.HashMap;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class ThreeSum{

	/**
	Method1:
	-we use three nested loops and check if there are three indices that have element that sum to zero, if so, we record them
	O(n^3)
	*/
	public static List<List<Integer>> threeSum1(int[] nums) {
        return null;
    }
	
	/**
	Method2:
	-use hashmap to store each element
	-then use two nested loops to check if there are pairs that form (-(a+b)) which sum with a third number c to get the zero sum
	O(n^2), Space O(n)
	*/
	public static List<List<Integer>> threeSum2(int[] nums) {
		List<List<Integer>> trips = new ArrayList<List<Integer>>();
		Arrays.sort(nums);
		//store the numbers in map along with their index
		HashMap<Integer, Integer> mapNums = new HashMap<Integer, Integer>();
		int index = 0;
		for(int i:nums){
			mapNums.putIfAbsent(i, index); //handle the case when duplicate numbers are present in input array
			index++;
		}
		//now use nested loop to check if we find other two numbers
		for(int i=0;i<nums.length; i++){
			for(int j=i+1;j<nums.length; j++){
				if(mapNums.containsKey(-(nums[i] + nums[j]))){//a triplet was found, record them
					List<Integer> trip = new ArrayList<Integer>();
					trip.add(nums[i]);
					trip.add(nums[j]);
					trip.add(-(nums[i] + nums[j]));
					trips.add(trip);
				}
			}
		}
        return trips;
    }
	
	
	/**
	Method3:
	-use two nested loops and two pointers on a sorted array to check if there is a sum of three numbers that yield zero
	O(n^2), Space O(1)
	*/
	public static List<List<Integer>> threeSum3(int[] nums) {
		List<List<Integer>> trips = new ArrayList<List<Integer>>();
		if(nums==null || nums.length==0)
			return trips;
		Arrays.sort(nums);
		int start = 0;
		int end = nums.length-1;
		
		for(int i=0;i<nums.length-3; i++){
			start = i+1;
			end = nums.length -1;
			if(nums[i]>=0 && nums[start]>nums[i])
				continue;
			if(i==0 || nums[i]>nums[i-1]){
				//only repeat when the consecutive elements are not equal, this helps to avoid duplicate set of triplets
				while(start<end){
					if(nums[i]+nums[start]+nums[end]==0){
						//found one
						List<Integer> trip = new ArrayList<Integer>();
						trip.add(nums[i]);
						trip.add(nums[start]);
						trip.add(nums[end]);
						trips.add(trip);
						start++;
						end--;
						//skip duplicate items
						while(nums[start-1]==nums[start] && start<end){
							start++;
						}
						while(nums[end]==nums[end+1] && start<end){
							end--;
						}
					}else if(nums[i]+nums[start]+nums[end] > 0){
						end--;
					}else{
						start++;
					}
				}
			}
		}
		return trips;
		
	}
	
	
	public static List<List<Integer>> threeSum(int[] nums) {
     List<List<Integer>> triplets = new ArrayList<List<Integer>>();
		Integer triplet[];
		if(nums==null||nums.length<3)
			return triplets;
		else if(nums.length==3){
			if(nums[0]+nums[1]+nums[2]==0){
				triplet = new Integer[]{nums[0], nums[1], nums[2]};
				Arrays.sort(triplet);
				triplets.add(Arrays.asList(triplet));
			}
			return triplets;
		}
		else{
			Arrays.sort(nums);
			int low=0, high=nums.length-1;
			for(int i=0;i<nums.length-3;i++){
				low =i+1; high = nums.length-1;
				if(nums[i]>=0 && nums[low]>nums[i])
					continue;
				else{
                    if(i==0 || nums[i]>nums[i-1]){
						while(low<high){
							if(nums[low]+nums[high]+nums[i]==0){
								triplet = new Integer[]{nums[i],nums[low], nums[high]};
								//Arrays.sort(triplet);
								//if(!triplets.contains(Arrays.asList(triplet)))
								triplets.add(Arrays.asList(triplet));
								low++;
								high--;
								//avoid duplicate solutions
								while (low < high && nums[high] == nums[high + 1])
									high--;
			 
								while (low < high && nums[low] == nums[low - 1])
									low++;
							}
							else if(nums[low]+nums[high]+nums[i]<0){
								low++;
							}else{
								high--;
							}
						}	
					}	
				}
			}
		}
		return triplets;
    }
	
	public static void main(String args[]){
		int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
		//nums = new int[]{0,0,0,0};
		//nums = new int[] {0,0,0};
		//nums = new int[] {-2,0,0,2,2};
		nums = new int[] {-2, 0, 1, 1, 2};
		List<List<Integer>> trips = threeSum3(nums);
		for(List<Integer> trip:trips){
			System.out.println(Arrays.toString(trip.toArray()));
		}
	}
}