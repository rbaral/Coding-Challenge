/**
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.

Example 1:

Input: [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
             Total amount you can rob = 1 + 3 = 4.
Example 2:

Input: [2,7,9,3,1]
Output: 12
Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
             Total amount you can rob = 2 + 9 + 1 = 12.
*/
import java.lang.Math;
import java.util.Arrays;

public class HouseRobber{
	
	public static int findMaxProf(int[] nums, int start, int[] prof){
		//exit case
		if(start>=nums.length){
			return 0;
		}
		if(prof[start]!=-1)
			return prof[start];
		prof[start] = Math.max(nums[start] + findMaxProf(nums, start+2, prof) , findMaxProf(nums, start+1, prof));
		return prof[start];
	}
	/**
	Method1:
	- use DP
	*/
	public static int rob1(int[] nums) {
		int[] prof = new int[nums.length];
		Arrays.fill(prof, -1);
		return findMaxProf(nums, 0, prof);
    }
	
	/**
	Method2:
	-bottom up DP
	*/
	public static int rob2(int[] nums){
		//base case
		if(nums==null || nums.length==0)
			return 0;
		int[] prof = new int[nums.length+1];
		prof[0] = 0;
		prof[1] = nums[0];
		for(int i =2;i<prof.length; i++){
			prof[i] = Math.max(prof[i-2] + nums[i-1], prof[i-1]);
		}
		System.out.println(Arrays.toString(prof));
		return prof[nums.length];
	}
	
	public static void main(String args[]){
		int [] nums = new int[]{1,2,3,1};
		nums = new int[]{2,7,9,3,1};
		System.out.println("max rob1 is:"+rob1(nums));
		System.out.println("max rob2 is:"+rob2(nums));
	}

}