/**
Knapsack01

Given weights and values of n items, put these items in a knapsack of capacity W to get the maximum total value in the knapsack. In other words, given two integer arrays val[0..n-1] and wt[0..n-1] which represent values and weights associated with n items respectively. Also given an integer W which represents knapsack capacity, find out the maximum value subset of val[] such that sum of the weights of this subset is smaller than or equal to W. You cannot break an item, either pick the complete item, or don’t pick it (0-1 property).
*/

public class KnapSack01{

	/**
	-recursively solve the problem
	O(2^n) time
	*/
	public static int knapSackRecursive(int cap, int[] weights, int[] vals, int n){
		//base cases
		if(cap==0 || n==0){
			return 0;
		}
		//if last item cannot fit, skip it
		if(weights[n-1]>cap){
			knapSackRecursive(cap, weights, vals, n-1);
		}
		
		//find max by either taking this item or not taking this item
		int taking = vals[n-1]+knapSackRecursive(cap-weights[n-1], weights, vals, n-1);
		int nottaking = knapSackRecursive(cap, weights, vals, n-1);
		return Math.max(taking, nottaking);
	}

	/**
	-use dp
	O(n^2)
	*/
	public static int knapSackDP(int cap, int[] weights, int [] vals, int n){
		//base cases
		if(cap==0 || n==0){
			return 0;
		}
		
		//create a matrix to hold max value by taking some weights
		//dp[i][j] means taking ith item to get j total weights
		int[][] dp = new int[n+1][cap+1];
		for(int i=0;i<=n; i++){
			for(int j=0; j<=cap; j++){
				if(i==0||j==0){
					//if there is no item or if there is no capacity left
					dp[i][j] =0;
				}else if(weights[i-1]<=j){
					//if the current item can be fit
					//select the max from (a) taking this item (b) not taking this item
					int taking = vals[i-1] + dp[i-1][j - weights[i-1]];
					int nottaking = dp[i-1][j];
					dp[i][j] = Math.max(taking, nottaking);
				}else{
					//the item doesn't fit so can't take this item
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		return dp[n][cap];
	}
	
	public static void main(String args[]){ 
        int val[] = new int[]{60, 100, 120}; 
        int wt[] = new int[]{10, 20, 30}; 
		int  W = 50; 
		int n = val.length; 
		System.out.println("recursive:"+knapSackRecursive(W, wt, val, n)); 
		System.out.println("dp:"+knapSackDP(W, wt, val, n)); 
    } 

}