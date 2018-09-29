/**
Given an array nums of n integers and an integer target, 
are there elements a, b, c, and d in nums such that a + b + c + d = target? 
Find all unique quadruplets in the array which gives the sum of target.

Note:

The solution set must not contain duplicate quadruplets.

Example:

Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.

A solution set is:
[
  [-1,  0, 0, 1],
  [-2, -1, 1, 2],
  [-2,  0, 0, 2]
]
*/
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Arrays;

public class FourSum{

	/**
	Method 1:
	Use four loops and check if there are four entries that give the sum of the target
	O(n^4)
	*/
	public List<List<Integer>> fourSum1(int[] nums, int target) {
        return null;
    }
	
	/**
	Method2:
	-for each item in the array, compute target-item = newtarget
	-use the concept of 3-sum to check if there are triplets that form the sum newtarget
	-exclude the item for which we are finding the triplets
	O(n^3)=> O(n^2) for 3-sum and O(n) for the items in the array
	*/
	public static List<List<Integer>> fourSum2(int[] nums, int target) {
        //handle base cases
		List<List<Integer>> trips = new ArrayList<List<Integer>>();
		if(nums==null || nums.length<1){
			return trips;
		}
		int newtarget = 0;
		Arrays.sort(nums);
		for(int i=0;i<nums.length; i++){
			//for each item find the new target
			newtarget = target-nums[i];
			List<List<Integer>> trips1 = threeSum(nums, newtarget, i);
			//add all these lists into the big lists
			for(List<Integer> list:trips1){
				Integer[] arr = new Integer[list.size()];
				System.out.println("the target "+target+" can be found by "+Arrays.toString(list.toArray(arr))+" and "+nums[i]);
			}
		}
		return trips;
    }
	
	/**
	Method3:
	-use two nested loops and two pointers on a sorted array to check if there is a sum of three numbers that yield zero
	O(n^2), Space O(1)
	*/
	public static List<List<Integer>> threeSum(int[] nums, int target, int skipindex) {
		List<List<Integer>> trips = new ArrayList<List<Integer>>();
		if(nums==null || nums.length==0)
			return trips;
		//Arrays.sort(nums);//enable this if to find threesum only
		int start = 0;
		int end = nums.length-1;
		
		for(int i=0;i<nums.length-3; i++){
			start = i+1;
			end = nums.length -1;
			if(nums[i]>=0 && nums[start]>nums[i])
				continue;
			if(i==0 || nums[i]>nums[i-1]){
				//only repeat when the consecutive elements are not equal, this helps to avoid duplicate set of triplets
				while(start<end && start!=skipindex && end!=skipindex && i!=skipindex){
					if(nums[i]+nums[start]+nums[end]==target){
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
					}else if(nums[i]+nums[start]+nums[end] > target){
						end--;
					}else{
						start++;
					}
				}
			}
		}
		return trips;
		
	}
	
	/**
	Method3:
	-finds one quadruplets that give the desired sum
	-sort the given array
	-use two nested loops and find the target-(outerloop item + innerloop item) in the array
	*/
	public static int[] fourSum3(int[] nums, int target){
		//base cases
		if(nums==null || nums.length<4){
			return null;
		}
		//sort the array
		Arrays.sort(nums);
		int[] quads = new int[4];
		for(int i=0;i<nums.length; i++){
			for(int j=i+1;j<nums.length; j++){
				int com = target - (nums[i] + nums[j]);
				//check if we can find the com by using other elements in the input array
				int start = j+1;
				int end = nums.length-1;
				while(start<end){
					if(nums[start] + nums[end] < com){
						start++;
					}else if(nums[start] + nums[end]>com){
						end--;
					}else{
						//we found one quadruplet
						quads[0] = nums[i];
						quads[1] = nums[j];
						quads[2] =  nums[start];
						quads[3] = nums[end];
						return quads;
					}
				}
			}
		}
		return quads;
	}
	
	/**
	Method4:
	-use the concept of 2-sum and store each quads that give the target
	*/
	public static List<List<Integer>> fourSum4(int[] nums, int target) {
        List<List<Integer>> quads = new ArrayList<List<Integer>>();
		for(int i=0;i<nums.length; i++){
			for(int j=i+1; j<nums.length; j++){
				
			}
		}
    }
	
	public static void main(String args[]){
		int[] nums = new int[] {1, 0, -1, 0, -2, 2};
		int target = 0;
		//List<List<Integer>> listofLists = fourSum2(nums, target);
		//nums = new int[]{2, 7, 4, 0, 9, 5, 1, 3};
		//target = 20;
		int[] quads = fourSum3(nums, target);
		System.out.println("Quads is:"+(quads==null?"NULL":Arrays.toString(quads)));
	}
}