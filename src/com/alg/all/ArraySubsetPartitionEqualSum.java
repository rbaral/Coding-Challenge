/**
ArraySubsetEqualPartition

Partition problem is to determine whether a given set can be partitioned into two subsets such that the sum of elements in both subsets is same.
Examples

arr[] = {1, 5, 11, 5}
Output: true 
The array can be partitioned as {1, 5, 5} and {11}

arr[] = {1, 5, 3}
Output: false 
The array cannot be partitioned into equal sum sets.
*/
import java.util.*;

public class ArraySubsetPartitionEqualSum{
	
	/**
	Method1:
	-use recursion
	*/
	public static boolean isSubsetSumRecursive(int[] nums, int n){
		if(nums==null || nums.length<1){
			return true;
		}
		if(nums.length==1){
			return nums[0]==0;
		}
		int cursum = 0;
		int totsum = 0;
		for(int i:nums){
			totsum+=i;
		}
		if(totsum%2!=0){
			return false;
		}
		return isSubsetSumRecursiveHelper(nums, n, cursum, totsum);
		
	}
	
	/**
	recursively take one element from the end, and accumulate to a sum, check if sum/2 is reached
	*/
	public static boolean isSubsetSumRecursiveHelper(int[] nums, int n, int cursum, int totsum){
		if(n==0){
			return cursum==totsum/2;
		}
		//if the current element is greater than sum, don't use it
		if(nums[n-1]>totsum/2){
			return isSubsetSumRecursiveHelper(nums, n-1, cursum, totsum);
		}
		//use this element
		boolean incsum = isSubsetSumRecursiveHelper(nums, n-1, cursum+nums[n-1], totsum);
		//dont use this element
		boolean excsum = isSubsetSumRecursiveHelper(nums, n-1, cursum, totsum);
		return incsum || excsum;
	}
	
	/**
	use DP to check if the sum is obtained at some point using the given numbers
	*/
	public static boolean isSubsetSumDP(int[] nums, int n){
		//base cases
		if(nums==null || nums.length<1){
			return true;
		}
		if(nums.length==1){
			return nums[0]==0;
		}
		int sum = 0;
		for(int i:nums){
			sum+=i;
		}
		if(sum%2!=0){
			return false;
		}
		sum = sum/2;//because we are looking for equal division
		//create an array to store the chances of getting the sum using that many numbers
		boolean[] dp = new boolean[sum+1];
		dp[0] = true;//sum of 0 is always possible
		for(int i=0;i<nums.length; i++){
			for(int j=1; j<=sum; j++){
				if(nums[i]<=j){
					dp[j] = dp[j] || dp[j - nums[i]];
				}
			}
		}
		return dp[sum];
	}
	
	public static void main(String[] args)  
    { 
        int[] arr = new int[]{1, 5, 11, 5};
		int n = arr.length;
		System.out.println("subset exits recursion is "+isSubsetSumRecursive(arr, n)); 
		System.out.println("subset exits dp is "+isSubsetSumDP(arr, n)); 
		arr = new int[]{1, 5, 3}; 
        n = arr.length; 
        System.out.println("subset exits recursion is "+isSubsetSumRecursive(arr, n)); 
		System.out.println("subset exits dp is "+isSubsetSumDP(arr, n)); 
    } 
}