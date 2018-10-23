/**
CoinChangeInfiniteCoins

You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

Example 1:

Input: coins = [1, 2, 5], amount = 11
Output: 3 
Explanation: 11 = 5 + 5 + 1
Example 2:

Input: coins = [2], amount = 3
Output: -1
Note:
You may assume that you have an infinite number of each kind of coin.
*/
import java.util.*;
public class CoinChangeInfiniteCoins{

	/**
	Method1:
	-use DP
	*/
	public static int coinChange(int[] coins, int amount) {
        //handle the base cases
		if(coins==null || coins.length==0 || amount<0)
			return -1;
		else if(coins.length==1 && amount%coins[0]!=0){//we have only one coin that doesn't divide the amount
			return -1;
		}else{
			//an array to hold the minimum coins required for the indexed amount,i.e. we store temp[amount] = min # of coins
			int temp[] = new int[amount+1];
	        temp[0] = 0;//no change possible for amount 0
	        for(int i=1; i <= amount; i++){
	            temp[i] = Integer.MAX_VALUE -1;//let's assume we need arbitrarily large no of coins
	        }
	        int prev=0, curr =0;
	        for(int i=0; i < coins.length; i++){
	            for(int j=1; j <= amount; j++){
	            	 if(j >= coins[i]){//if amount is at least the value of the coin, then we can find a change
 	                    //be careful here. Max_val + 1 can result in very small negative number.
 	                	prev = temp[j-coins[i]] +1;
 	                	curr = temp[j];
 	                    temp[j] = Math.min(curr, prev);
 	                }	
	            }
	        }
	        if(temp[amount]==(Integer.MAX_VALUE-1))//we didn't set this element
	        	return -1;
	        return temp[amount];
			}
		}
    }
	
	public static void main(String args[]){
		int n = 11;
		int[] coins = new int[]{1, 2, 5};
		System.out.println(coinChange(coins, n));
		n = 3;
		coins = new int[]{2};
		System.out.println(coinChange(coins, n));
		n = 0;
		coins = new int[]{1};
		System.out.println(coinChange(coins, n));
	}
}