/**
Given an array nums of integers, you can perform operations on the array.

In each operation, you pick any nums[i] and delete it to earn nums[i] points. After, you must delete every element equal to nums[i] - 1 or nums[i] + 1.

You start with 0 points. Return the maximum number of points you can earn by applying such operations.

Example 1:
Input: nums = [3, 4, 2]
Output: 6
Explanation: 
Delete 4 to earn 4 points, consequently 3 is also deleted.
Then, delete 2 to earn 2 points. 6 total points are earned.
Example 2:
Input: nums = [2, 2, 3, 3, 3, 4]
Output: 9
Explanation: 
Delete 3 to earn 3 points, deleting both 2's and the 4.
Then, delete 3 again to earn 3 points, and 3 again to earn 3 points.
9 total points are earned.
Note:

The length of nums is at most 20000.
Each element nums[i] is an integer in the range [1, 10000].
*/

public class DeleteAndEarn{

	public int deleteAndEarn(int[] nums) {
        int[] dp = new int[10002]; 
        for(int i = 0; i < nums.length; i++){
            dp[nums[i]] += nums[i]; 
        }
        for(int i = 2; i < dp.length; i++){
            dp[i] = Math.max(dp[i-1], dp[i-2] + dp[i]);
        }
        return dp[10001];
    }
	
	public static void main(String[] args){
		int[] nums = {3, 4, 2};
		System.out.println(deleteAndEarn(nums));
	}
}