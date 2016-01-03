/**
 *
You are given coins of different denominations and a total amount of money amount. 
Write a function to compute the fewest number of coins that you need to make up that amount. 
If that amount of money cannot be made up by any combination of the coins, return -1.
Example 1:
coins = [1, 2, 5], amount = 11
return 3 (11 = 5 + 5 + 1)
Example 2:
coins = [2], amount = 3
return -1.
Note:
You may assume that you have an infinite number of each kind of coin.
 
 */
package com.alg.leetup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author rbaral
 *
 */

class CoinChangeTestCase{
	int[] coins;
	int amount;
	int coinsRequired;
	
	public CoinChangeTestCase(int[] coins, int amount, int coreq){
		this.coins = coins;
		this.amount = amount;
		this.coinsRequired = coreq;
	}

	public int[] getCoins() {
		return coins;
	}

	public void setCoins(int[] coins) {
		this.coins = coins;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getCoinsRequired() {
		return coinsRequired;
	}

	public void setCoinsRequired(int coinsRequired) {
		this.coinsRequired = coinsRequired;
	}
	
	public String toString(){
		return "For coins:"+Arrays.toString(coins)+"...for amount:"+getAmount()+"..expected return coins:"+getCoinsRequired();
	}
}
public class Coinchange {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		boolean isTestMode = false;
		if(isTestMode){
			performTest();
		}else{
			int coins[];
			int amount = 0;
			int coreq=0;
			coins = new int[]{186,419,83,408};
			amount = 6249;
			//coreq = 20;
			//coins = new int[]{1,2,3};
			//amount = 5;
			//coins = new int[]{384,324,196,481};
			//amount= 285;
			//coins = new int[]{1,2,5};
			//amount= 11;//3
			System.out.println(coinChange(coins, amount));
			//System.out.println(minimumCoinBottomUp(coins, amount));
			//Map<Integer, Integer> map = new HashMap<>();
	        //System.out.println(minimumCoinTopDown(coins, amount,  map));
		}

	}
	
		
	/**
	 * using DP approach
	 * @param coins
	 * @param amount
	 * @return
	 */
	public static int coinChange(int[] coins, int amount) {
		//handle the base cases
		if(coins==null || coins.length==0 || amount<0)
			return -1;
		else if(coins.length==1 && amount%coins[0]!=0){//we have only one coin that doesn't divide the amount
			return -1;
		}else{
			//an array to hold the minimum coins required for the indexed amount,i.e. we store temp[amount] = min # of coins
			int minChanges[] = new int[amount+1];
			minChanges[0] = 0;//no change possible for amount 0
	        for(int i=1; i <= amount; i++){
	        	minChanges[i] = Integer.MAX_VALUE -1;//let's assume we need arbitrarily large no of coins
	        }
	        int prev=0, curr =0;
	        for(int i=0; i < coins.length; i++){
	            for(int j=1; j <= amount; j++){
	            	 if(j >= coins[i]){//if amount is at least the value of the coin, then we can find a change
 	                    //be careful here. Max_val + 1 can result in very small negative number.
 	                	prev = minChanges[j-coins[i]] +1;
 	                	curr = minChanges[j];
 	                	minChanges[j] = Math.min(curr, prev);
 	                }	
	            }
	        }
	        if(minChanges[amount]==(Integer.MAX_VALUE-1))//we didn't set this element, so that means we didn't find the solution
	        	return -1;
	        return minChanges[amount];
		}
	}
	
	
	
	public static int minimumCoinBottomUp(int arr[], int total){
        int temp[] = new int[total+1];
        temp[0] = 0;
        for(int i=1; i <= total; i++){
            temp[i] = Integer.MAX_VALUE-1;
        }
        for(int i=0; i < arr.length; i++){
            for(int j=1; j <= total; j++){
                if(j >= arr[i]){
                    //be careful here. Max_val + 1 can result in very small negative number.
                    temp[j] = Math.min(temp[j], temp[j-arr[i]] +1);
                }else{
                	//temp[j] = -1;
                }
            }
        }
        return temp[total];
    }
	
	/**
     * Top down dynamic programing. Using map to store intermediate results.
     * 
     */
	/*public static int minimumCoinTopDown( int coins[],int total, Map<Integer, Integer> map) {

		//if total is 0 then there is nothing to do. return 0.
        if ( total == 0 ) {
            return 0;
        }

        //if map contains the result means we calculated it before. Lets return that value.
        if ( map.containsKey(total) ) {
            return map.get(total);
        }

        //iterate through all coins and see which one gives best result.
        int min = Integer.MAX_VALUE;
        for ( int i=0; i < coins.length; i++ ) {
            //if value of coin is greater than total we are looking for just continue.
            if( coins[i] > total ) {
                continue;
            }
            //recurse with total - coins[i] as new total
            int val = minimumCoinTopDown(coins,total - coins[i], map);

            //if val we get from picking coins[i] as first coin for current total is less
            // than value found so far make it minimum.
            if( val < min ) {
                min = val;
            }
        }

        //if min is MAX_VAL dont change it. Just result it as is. Otherwise add 1 to it.
        min =  (min == Integer.MAX_VALUE ? min : min + 1);

        //memoize the minimum for current total.
        map.put(total, min);
        return min;
    }*/
	
	public static void performTest(){
		List<CoinChangeTestCase> testCases = new ArrayList<CoinChangeTestCase>();
		List<String> failedCases = new ArrayList<String>();
		int coins[];
		int amount = 0;
		int coreq=0;
		coins = new int[]{1, 2, 5};
		amount = 11;
		coreq = 3;//5,5,2
		testCases.add(new CoinChangeTestCase(coins, amount, coreq));
		coins = new int[]{2};
		amount = 3;
		coreq = -1;// not possible to make changes
		testCases.add(new CoinChangeTestCase(coins, amount, coreq));
		coins = new int[]{186,419,83,408};
		amount = 6249;
		coreq = 20;
		testCases.add(new CoinChangeTestCase(coins, amount, coreq));
		coins = new int[]{1,2,3};
		amount = 5;
		testCases.add(new CoinChangeTestCase(coins, amount, 2));
		coins = new int[]{384,324,196,481};
		amount= 285;
		testCases.add(new CoinChangeTestCase(coins, amount, -1));
		int result = 0;
		
		for(CoinChangeTestCase testCase:testCases){
			result = coinChange(testCase.getCoins(), testCase.getAmount());
			Map<Integer, Integer> map = new HashMap<>();
			result = minimumCoinBottomUp( testCase.getCoins(),testCase.getAmount());
			//result = minimumCoinTopDown(coins,amount, map);
			if(result!=testCase.getCoinsRequired()){
				failedCases.add("FAILED FOR:"+testCase.toString()+"...got:"+result);
			}
		}
		System.out.println("TEST RESULT: PASSED:"+(testCases.size() - failedCases.size())+"...FAILED:"+failedCases.size());
		for(String res:failedCases){
			System.err.println(res);
		}
		
	}

}
