/**
Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

Example 1:

Input: n = 12
Output: 3 
Explanation: 12 = 4 + 4 + 4.
Example 2:

Input: n = 13
Output: 2
Explanation: 13 = 4 + 9.
*/

public class PerfectSquareSum{

	/**
	Method1: using DP
	sum[0] = 0 = 0
	sum[1] = 1 = sum[0] +1 = 1
	sum[2] = 1 + 1 = sum[1] + 1 = 2
	sum[3] = 1 + 1 + 1 = sum[2] + 1 = 3
	sum[4] = 4	= min(sum[4-1*1]+1, sum[4-2*2]+1) = min(sum[2]+1, sum[0]+1) = 1
	sum[5] = 1 + 4 = min(sum[5-1*1]+1, sum[5-2*2]+1) = min(sum[3]+1, sum[1]+1) = min(4, 2) = 2
	and so on
	so, we have the general formula as:
	sum[n] = 
	*/
	public static int numSquares(int n) {
        int[] sum = new int[n+1];
		for(int i = 1;i<=n; i++){
			int j = 1;
			int minValue = Integer.MAX_VALUE;
			while(i-j*j>=0){
				minValue = Math.min(minValue, sum[i-j*j]+1);
				j++;
			}
			sum[i] = minValue;
		}
		return sum[n];
    }
	
	public static void main(String args[]){
		int n= 12;
		n = 13;
		n=100;
		System.out.println("min no of perfect squares for "+n+" is:"+numSquares(n));
	}
}