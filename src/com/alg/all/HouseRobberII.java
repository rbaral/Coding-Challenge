/**
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.

Example 1:

Input: [2,3,2]
Output: 3
Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2),
             because they are adjacent houses.
Example 2:

Input: [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
             Total amount you can rob = 1 + 3 = 4.
*/

public class HouseRobberII{

	/**
	use the dp concept used in houserobberI
	*/
	public static int rob(int[] nums){
		if(nums== null || nums.length<1){
			return 0;
		}
		if(nums.length==1) return nums[0];
		//find the max profit with first and till the second last house
		int prof1 = robHelper(nums, 0, nums.length-2);
		//find the max profit with the second and till the last house
		int prof2 = robHelper(nums, 1, nums.length-1);
		return Math.max(prof1, prof2);
	}
	
	public static int robHelper(int[] nums, int start, int end){
		if(start== end){
			return nums[start];
		}
		int[] dp = new int[nums.length];
		dp[start] = nums[start];
		dp[start+1] = Math.max(dp[start], nums[start+1]);
		for(int i=start+2; i<=end; i++){
			//use the same relation as in houserobberI
			dp[i] = Math.max(dp[i-2] + nums[i], dp[i-1]);
		}
		return dp[end];
	}

	public static int rob2(int[] nums) {
		//base case
        if(nums.length==1) return nums[0];
		int rob=0,notrob=0;
		//first case, assume we start from the first house (index 0) and skip the last house
		for(int i=0;i<nums.length-1;i++){
			int currob=notrob+nums[i];
			notrob=Math.max(rob,notrob);
			rob=currob;
		}
		int firstcase=Math.max(rob,notrob);
		rob=0;notrob=0;
		//second case, assume we start from the second house (index 1) and take the last house
		for(int i=1;i<nums.length;i++){
			int currob=notrob+nums[i];
			notrob=Math.max(rob,notrob);
			rob=currob;
		}
		int secondcase=Math.max(rob,notrob);
		return Math.max(firstcase,secondcase);
    }
	
	public static void main(String[] args){
		int[] cost = new int[]{1,2,3,1};
		System.out.println(rob(cost));
		cost = new int[]{2,3,2};
		System.out.println(rob(cost));
	}

}