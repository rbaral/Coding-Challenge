/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * If you were only permitted to complete at most one transaction (ie, buy one and sell one 
 * share of the stock), design an algorithm to find the maximum profit.
 */
package com.alg.leetup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class MaxSubArraySumTestCase{
	int[] prices;
	int maxSum;
	public MaxSubArraySumTestCase(int price[], int max){
		this.maxSum = max;
		this.prices = price;
	}
	public int[] getPrices() {
		return prices;
	}
	public void setPrices(int[] prices) {
		this.prices = prices;
	}
	public int getMaxSum() {
		return maxSum;
	}
	public void setMaxSum(int maxSum) {
		this.maxSum = maxSum;
	}
	
	public String toString(){
		return Arrays.toString(prices)+"..expected.."+maxSum;
	}
}

/**
 * @author rbaral
 *
 */
public class BestTimeToBuyAndSellStock {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		boolean isTestMode = true;
		if(isTestMode){
			performTest();
		}else{
			int[] prices = new int[]{1,2};
			//this is the array that stores the price change on the consecutive days
			//prices = new int[]{13,-3,-25,20,-3,-16,-23,18,20,-7,12,-5,-22,15-4,7};
			prices = new int[]{1,3,2};
			prices = new int[]{1,3};
			System.out.println(maxProfit(prices));	
		}
	}
	
	/**
	 * find the difference in stock price for
	 * the consecutive days
	 * @param prices
	 * @return
	 */
	public static int[] getPriceChangeArray(int [] prices){
		int[] changeArr = new int[prices.length-1];
		for(int i=1;i<prices.length;i++){
			changeArr[i-1] = prices[i] - prices[i-1];
		}
		return changeArr;
	}
	
	/**
	 * here, we buy the stock, when it has minimum possible price
	 * and we sell the stock (after we purchase) when it has maximum possible price. The
	 * thing to remember is we are more interested in profit (difference between buying price
	 * and selling price) and the maximum profit should focus on the difference between
	 * two values, rather than the smallest possible and the largest possible, because the values
	 * are arbitrarily ordered. This problem is similar to the maximum subarray problem where we find the 
	 * subarray with maximum sum.
	 * <br/>
	 * The brute force approach is to try every possible combination of values and find the maximum difference.
	 * This approach works but is not optimal when there are many values.
	 * <br/>
	 * A better approach is to divide and conquer. We find the mid point of the array
	 * and find the maximum profit in the divided components and ultimately find the maximum
	 * among all those components.
	 * That is, we find the midpoint, say mid, of the subarray, and consider the subarrays A[low : mid] 
	 * and A[mid + 1 : high]. Any contiguous subarray A[i : j] of A[low : high] must lie in exactly one of the following places:
	 * i)entirely in the subarray A[low : mid], so that low &le; i &le; j &le; mid,
	 * ii) entirely in the subarray A[mid + 1 : high], so that mid &lt; i &le; j &le; high, or
	 * iii) crossing the midpoint, so that low &le; i &le; mid &lt; j &le high.
	 * @param prices
	 * @return
	 */
	public static int maxProfit(int[] prices) {
		System.out.println(Arrays.toString(prices));
		//handle base cases for original price array
		if(prices==null || prices.length<2)
			return 0;
		else if(prices.length == 2){
			if(prices[1]>prices[0])
				return prices[1]-prices[0];
			else
				return 0;
		}
		prices = getPriceChangeArray(prices);//the original array is the price of stock, we are finding the diff in consecutive days
		System.out.println("diff arr:"+Arrays.toString(prices));
		//handle base cases for the diff
		if(prices.length==1){
			if(prices[0]<0)
				return 0;
			return prices[0];
		}
		else if(prices.length==2 ){
			//if both price diff is negative then we won't get profit, so return 0
			if(prices[0]<0 && prices[1]<0)
				return 0;
			else if(prices[0]>0 && prices[1]>0)//both are positive then we can gain more if we sell on the last day
				return prices[0]+prices[1];
			return Math.max(prices[0], prices[1]);
		}
		//return findMaxSubArray(prices, 0, prices.length-1)[2];
		/*int[] resultArr = findMaxSubArray(prices, 0, prices.length-1);
		System.out.println("Max value is:"+resultArr[2]+" and in the range:"+resultArr[0]+"..."+resultArr[1]);
		return resultArr[2]>0?resultArr[2]:0;*/
		int result = findMaxSubArray(prices, 0, prices.length-1)[2];
		//if we got negative value, then it's a loss, so return 0
		return result>0?result:0;
		
	}
	public static int[] findMaxCrossSubArray(int[] A, int low, int mid, int high){
		int left_sum = Integer.MIN_VALUE, right_sum = Integer.MIN_VALUE;
		int sum = 0;
		int max_left = 0, max_right = 0;
		for(int i = mid; i>=low; i--){
			sum = sum + A[i];
			if(sum > left_sum){
				left_sum = sum;
				max_left = i;
			}
		}
		sum = 0;
		for(int j= mid+1; j<=high;j++){
			sum = sum + A[j];
			if(sum > right_sum){
				right_sum = sum;
				max_right = j;
			}
		}
		return new int[]{max_left, max_right, left_sum + right_sum};
	}
	
	public static int[] findMaxSubArray(int[] A, int low, int high){
		if(high == low){
			return new int[]{low, high, A[low]}; // base case: only one element
		}
		else{
			int mid =(int)Math.floor((low + high)/2);
			int left_low = 0,left_high = 0,left_sum = 0;
			int right_low = 0,right_high = 0,right_sum = 0;
			int cross_low = 0,cross_high = 0,cross_sum = 0;
			
			int[] leftResult = findMaxSubArray(A, low, mid);
			left_low = leftResult[0]; left_high = leftResult[1]; left_sum = leftResult[2];
			
			int[] rightResult = findMaxSubArray(A, mid+1, high);
			right_low = rightResult[0]; right_high = rightResult[1]; right_sum = rightResult[2];
			
			int[] crossResult = findMaxCrossSubArray(A, low, mid, high);
			cross_low = crossResult[0]; cross_high = crossResult[1]; cross_sum = crossResult[2];
			System.out.println("left low "+left_low+" left high:"+left_high+" left sum:"+left_sum+" right low:"+right_low+" right high:"+right_high+"..right sum:"+right_sum+" cross low:"+cross_low+" cross high:"+cross_high+"..cross sum:"+cross_sum);
			if(left_sum >= right_sum && left_sum >= cross_sum)
				return new int[]{left_low, left_high, left_sum};
			else if(right_sum >= left_sum && right_sum >= cross_sum)
				return new int[]{right_low, right_high, right_sum};
			else
				return new int[]{cross_low, cross_high, cross_sum};
		}
	}
	
	public static void performTest(){
		List<MaxSubArraySumTestCase> testCases = new ArrayList<MaxSubArraySumTestCase>();
		List<String> failedCases = new ArrayList<String>();
		int result;
		testCases.add(new MaxSubArraySumTestCase(new int[]{}, 0));
		testCases.add(new MaxSubArraySumTestCase(new int[]{1}, 0));
		testCases.add(new MaxSubArraySumTestCase(new int[]{-1,-2}, 0));
		testCases.add(new MaxSubArraySumTestCase(new int[]{-1,-2,-3}, 0));
		testCases.add(new MaxSubArraySumTestCase(new int[]{-1,-2,-3,-2,-4}, 1));
		
		testCases.add(new MaxSubArraySumTestCase(new int[]{1,2}, 1));
		testCases.add(new MaxSubArraySumTestCase(new int[]{100,113,110,85,105,102,86,63,81,101,94,106,101,79,94,90,97}, 43));
		testCases.add(new MaxSubArraySumTestCase(new int[]{1,3,2}, 2));
		testCases.add(new MaxSubArraySumTestCase(new int[]{1,3,2,5}, 4));
		testCases.add(new MaxSubArraySumTestCase(new int[]{1,3,2,5}, 4));
		testCases.add(new MaxSubArraySumTestCase(new int[]{1,2,4}, 3));
		
		testCases.add(new MaxSubArraySumTestCase(new int[]{7,4,2,1}, 0));
		
		
		for(MaxSubArraySumTestCase testCase:testCases){
			result = maxProfit(testCase.prices);
			if(result!=testCase.maxSum){
				failedCases.add("Failed for:"+testCase.toString()+"...got:"+result);
			}
		}
		System.out.println("TEST RESULT, PASSED:"+(testCases.size()-failedCases.size())+"...FAILED:"+failedCases.size());
		for(String res:failedCases)
			System.err.println(res);
	}

}
