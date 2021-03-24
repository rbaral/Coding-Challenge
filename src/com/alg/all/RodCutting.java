/**
RodCutting

Given a rod of length n inches and an array of prices that contains prices of all pieces of size smaller than n. Determine the maximum value obtainable by cutting up the rod and selling the pieces. For example, if length of the rod is 8 and the values of different pieces are given as following, then the maximum obtainable value is 22 (by cutting in two pieces of lengths 2 and 6)


length   | 1   2   3   4   5   6   7   8  
--------------------------------------------
price    | 1   5   8   9  10  17  17  20
And if the prices are as following, then the maximum obtainable value is 24 (by cutting in eight pieces of length 1)

length   | 1   2   3   4   5   6   7   8  
--------------------------------------------
price    | 3   5   8   9  10  17  17  20
*/

public class RodCutting{

	/**
	-use recursion
	
	*/
	public static int cutRodRecursive(int[] nums, int n){
		if(n<=0){
			return 0;
		}
		int max = Integer.MIN_VALUE;
		//recursively cut the rod in different pieces and check if we got max value
		for(int i=0;i<n; i++){
			max = Math.max(max, nums[i] + cutRodRecursive(nums, n-i-1));
		}
		return max;
	}
	
	public static int cutRodDP(int[] nums, int n){
		if(n<=0){
			return 0;
		}
		int[] dp = new int[n+1];
		dp[0] = 0;
		for(int i =1; i<=n; i++){//length
			int max = Integer.MIN_VALUE;
			for(int j=0; j<i; j++){//profit
				max = Math.max(max, nums[j] + dp[i - j-1]);
			}
			dp[i] = max;
		}
		return dp[n];
	}

	public static void main(String args[]) 
    { 
        int arr[] = new int[] {1, 5, 8, 9, 10, 17, 17, 20}; 
        int size = arr.length; 
        System.out.println("Maximum Obtainable Value Recursion is "+cutRodRecursive(arr, size)); 
		System.out.println("Maximum Obtainable Value dp is "+cutRodDP(arr, size)); 
  
    } 
}