/**
CoinChangeCombination


You are given coins of different denominations and a total amount of money. Write a function to compute the number of combinations that make up that amount. You may assume that you have infinite number of each kind of coin.

Note: You can assume that

0 <= amount <= 5000
1 <= coin <= 5000
the number of coins is less than 500
the answer is guaranteed to fit into signed 32-bit integer
 

Example 1:

Input: amount = 5, coins = [1, 2, 5]
Output: 4
Explanation: there are four ways to make up the amount:
5=5
5=2+2+1
5=2+1+1+1
5=1+1+1+1+1
 

Example 2:

Input: amount = 3, coins = [2]
Output: 0
Explanation: the amount of 3 cannot be made up just with coins of 2.
 

Example 3:

Input: amount = 10, coins = [10] 
Output: 1

*/

public class CoinChangeCombinations{

	/**
	-use dynamic programming
	*/
	public static int change(int amount, int[] coins) {
        //base cases
		if(amount==0 || coins==null || coins.length==0){
			return 0;
		}
		if(coins.length==1 && amount%coins[0]!=0){
			return -1;
		}
		int[] changes = new int[amount+1];
		changes[0] = 1;
		for(int i=0;i<coins.length; i++){
			for(int j =1; j<=amount; j++){
				if(j>=coins[i]){
					changes[j]+= changes[j-coins[i]];
				}
			}
		}
		return changes[amount];
    }
	
	public static void main(String args[]){
		int n = 5;
		int[] coins = new int[]{1, 2, 5};
		System.out.println(change(n, coins));
	}

}