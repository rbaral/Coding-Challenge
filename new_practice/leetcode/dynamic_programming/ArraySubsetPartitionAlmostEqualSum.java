/**
ArraySubsetPartition

Given a set of integers, the task is to divide it into two sets S1 and S2 such that the absolute difference between their sums is minimum.
If there is a set S with n elements, then if we assume Subset1 has m elements, Subset2 must have n-m elements and the value of abs(sum(Subset1) – sum(Subset2)) should be minimum.

Example:

Input:  arr[] = {1, 6, 11, 5} 
Output: 1
Explanation:
Subset1 = {1, 5, 6}, sum of Subset1 = 12 
Subset2 = {11}, sum of Subset2 = 11 
*/
import java.util.*;

public class ArraySubsetPartitionAlmostEqualSum{
	
	/**
	Method1:
	-use recursion
	-check if a  particualr element should be included in one set or another
	*/
	public static int findMinRecursive(int[] nums, int n){
		if(nums==null || nums.length<1){
			return 0;
		}
		if(nums.length==1){
			return nums[0];
		}
		int cursum = 0;
		int totsum = 0;
		for(int i:nums){
			totsum+=i;
		}
		return findMinRecursiveHelper(nums, n, cursum, totsum);
	}
	
	public static int findMinRecursiveHelper(int[] nums, int n, int cursum, int totsum){
		if(n==0){
			//no elements left to process, check if the cursum and totsum has minimum difference
			//one set has cur sum and the other set has totsum-cursum
			int diff = (totsum - cursum) - cursum;
			return Math.abs(diff);
		}
		int incsum = findMinRecursiveHelper(nums, n-1, cursum+nums[n-1], totsum);
		int excsum = findMinRecursiveHelper(nums, n-1, cursum, totsum);
		return Math.min(incsum, excsum);
	}
	
	/**
	-use dp
	-use 2-d array to store the sum formed by elements
	-dp[i][j] = 1, if subset from 0,...,i form the sum j
	-else it is 0
	-to find the minimum sum difference, find j such that
	--Min(sum - j*2
	*/
	public static int findMinDP(int[] nums, int n){
		//base cases
		if(nums==null || nums.length<1){
			return 0;
		}
		if(nums.length==1){
			return nums[0];
		}
		//find total sum
		int sum = 0;
		for(int i:nums){
			sum+=i;
		}
		boolean [][] dp = new boolean[n+1][sum+1];
		//sum of 0 is possible with any numbers (use the number or not)
		for(int i=0;i<=n; i++){
			dp[i][0] = true;
		}
		//sum of i is not possible with empty set
		for(int i=1; i<=sum; i++){
			dp[0][i] = false;
		}
		//fill the table in bottom up manner
		for(int i=1; i<=n; i++){
			for(int j=1; j<=sum; j++){
				//if the amount is greater or equal, use it to find the sum
				dp[i][j] = dp[i-1][j];
				if(nums[i-1]<=j){
					dp[i][j] = dp[i][j] || dp[i-1][j- nums[i-1]]; 
				}
			}
		}
		//now check which entry has minimum value
		int diff = Integer.MAX_VALUE;
		//the best division is to have sum/2 in each subset
		for(int i=sum/2; i>=0;i--){
			//if the sum is found
			if(dp[n][i]){
				diff = sum - 2*i;
				break;
			}
		}
		return diff;
	}
	
	public static void main(String[] args)  
    { 
        int[] arr = new int[]{1, 6, 11, 5};
		int n = arr.length;
		System.out.println("The minimum difference is "+findMinRecursive(arr, n)); 
		System.out.println("The minimum difference DP is "+findMinDP(arr, n)); 
		arr = new int[]{3, 1, 4, 2, 2, 1}; 
        n = arr.length; 
        System.out.println("The minimum difference is "+findMinRecursive(arr, n)); 
		System.out.println("The minimum difference DP is "+findMinDP(arr, n)); 
    } 
}