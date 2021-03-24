/**
You are given a list of non-negative integers, a1, a2, ..., an, and a target, S. Now you have 2 symbols + and -. For each integer, you should choose one from + and - as its new symbol.

Find out how many ways to assign symbols to make sum of integers equal to target S.

Example 1:
Input: nums is [1, 1, 1, 1, 1], S is 3. 
Output: 5
Explanation: 

-1+1+1+1+1 = 3
+1-1+1+1+1 = 3
+1+1-1+1+1 = 3
+1+1+1-1+1 = 3
+1+1+1+1-1 = 3

There are 5 ways to assign symbols to make the sum of nums be target 3.
Note:
The length of the given array is positive and will not exceed 20.
The sum of elements in the given array will not exceed 1000.
Your output answer is guaranteed to be fitted in a 32-bit integer.
*/

public class TargetSum{

	 public static int findTargetSumWaysDP(int[] nums, int S) {
        int sum = 0; 
        for(int num : nums){
            sum += num;
        }
		//if the total sum does not reach the target then we cannot find target with addition and subtraction combinations
		//if the total sum and the target addup to an odd number then not possible
        return (sum < S || (sum + S) %2 != 0) ? 0 : helper(nums,(sum+S)/2);
    }
    
    private static int helper(int[] nums, int target){
        int[] dp = new int[target+1];
        dp[0] = 1;
        for(int n : nums){
            for(int i = target; i >= n; i--){
                dp[i] += dp[i-n];
            }
        }
        return dp[target];
    }
	
	
	public static void main(String args[]){
		int[] nums = {1, 1, 1, 1, 1, 1};
		int s = 3;
		System.out.println(findTargetSumWaysDP(nums, s));
		//System.out.println(findTargetSumWaysRecursive(nums, s));
	}

}