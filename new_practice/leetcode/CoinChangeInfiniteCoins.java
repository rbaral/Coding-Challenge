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
	Method1: greedy approach
	-greedily use the largest possible coin, when the amount>=that coin
	-works in most cases but fails ins some cases like:
	{15,20,25}, n = 35
	-greedily we select 25 and the for the leftover amount (35-25=10), we don't have any valid coins to use
	-however there is a solution {15,20} for n = 35
	*/
	public static int coinChange(int[] coins, int amount) {
        int coinsused=0;
		if(amount==0 || coins==null || coins.length==0){
			return 0;
		}
		//use biggest possible coin
		Arrays.sort(coins);
		for(int i=coins.length-1;i>=0; i--){
			if(amount>= coins[i]){
				int rem = amount%coins[i];
				coinsused+=amount/coins[i];
				amount = rem;
			}
		}
		return (coinsused>0 && amount==0)?coinsused:-1;
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