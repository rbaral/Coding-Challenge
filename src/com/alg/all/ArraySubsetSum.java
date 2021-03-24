/**
Array subset sum

Subset Sum:

Given a set of non-negative integers, and a value sum, determine if there is a subset of the given set with sum equal to given sum.
Example:

Input:  set[] = {3, 34, 4, 12, 5, 2}, sum = 9
Output:  True  //There is a subset (4, 5) with sum 9.
*/

public class ArraySubsetSum{
	
	/**
	Method1:
	-sort the array
	*/
	public static boolean isSubsetSumRecursive(int[] nums, int len, int sum){
		if(len==0 && sum==0){
			return true;
		}else if(len!=0 && sum==0){
			return true;
		}
		else if(len==0 && sum!=0){
			return false;
		}
		//if last element is gretaer than sum, don't include it and check with other elements
		if(nums[len-1]>sum){
			return isSubsetSumRecursive(nums, len-1, sum);
		}
		//check if we can find teh sum by including this item or by excluding this item
		return isSubsetSumRecursive(nums, len-1, sum) || isSubsetSumRecursive(nums, len-1, sum-nums[len-1]);
		
	}
	
	public static boolean isSubsetSumDP(int[] nums, int len, int sum){
		//create a 2-D table and fill out in bottom up manner
		//dp[i][j] indicates if we found a sum of j using 0,..,i elements
		boolean dp[][] = new boolean[len+1][sum+1];
		for(int i=0;i<=len; i++){
			dp[i][0] = true;
		}
		for(int i=1;i<=sum; i++){
			dp[0][i] = false;
		}
		//fill the table in bottom up manner
		for(int i=1; i<=len; i++){
			for(int j=1; j<=sum;j++){
				if(nums[i-1]<=j){//if this number can be used to find the number
					dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i-1]];
				}else{
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		return dp[len][sum];
	}

	public static void main (String args[]) 
    { 
        int set[] = {3, 34, 4, 12, 5, 2}; 
        int sum = 9; 
        int n = set.length; 
		boolean found = isSubsetSumRecursive(set, n, sum); 
        System.out.println("Found a subset with given sum with recursion? "+found); 
        found =  isSubsetSumDP(set, n, sum); 
        System.out.println("Found a subset with given sum with DP? "+found);
    } 
}