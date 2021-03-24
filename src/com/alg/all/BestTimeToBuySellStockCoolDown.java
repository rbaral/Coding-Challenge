/**
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times) with the following restrictions:

You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
Example:

Input: [1,2,3,0,2]
Output: 3 
Explanation: transactions = [buy, sell, cooldown, buy, sell]
*/

public class BestTimeToBuySellStockCoolDown{

	public static int maxProfit(int[] prices){
		if(prices==null || prices.length<=1){
			return 0;
		}
		/**
		there can be two types of profit we need to track
		sellProf[i] - profit earned by selling on ith day
		restProf[i] - profit earned by resting on ith day
		*/
		int sellProf = 0;
		int restProf = 0;
		int lastProf = 0;
		for(int i = 1;i<prices.length; i++){
			lastProf = sellProf;
			//the current sellProf is either by selling on ith day or by resting on ith day
			sellProf = Math.max(sellProf + prices[i] - prices[i-1], restProf);
			restProf = Math.max(lastProf, restProf);
		}
		return Math.max(sellProf, restProf);
	}

	public static void main(String args[]){
		int[] prices = new int[]{1,2,3,0,2};
		System.out.println(maxProfit(prices));
	}
}