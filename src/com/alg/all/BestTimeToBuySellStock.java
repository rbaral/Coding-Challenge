/**
Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.

Note that you cannot sell a stock before you buy one.

Example 1:

Input: [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
             Not 7-1 = 6, as selling price needs to be larger than buying price.
Example 2:

Input: [7,6,4,3,1]
Output: 0
Explanation: In this case, no transaction is done, i.e. max profit = 0.
*/

import java.util.Arrays;
import java.lang.Math;

class Interval{
	int buy;
	int sell;
	int profit;
	Interval(int b, int s, int p){
		buy = b;
		sell = s;
		profit = p;
	}
}

public class BestTimeToBuySellStock{
	/**
	Sol1:
	-use two loops, the outer loop assumes the current item as the buying price and the inner loop's item as the selling price
	and keeps track of the profit made, if an item in inner loop gives more profit, we update the value of max profit

	O(n^2), Space O(1)
	*/
	public static int findMaxProfit1(int[] nums){
		int maxprofit = Integer.MIN_VALUE;//or -1 is ok
		int buying = -1;
		int selling = -1;
		for(int i=0;i<nums.length; i++){
			for(int j=i+1; j<nums.length; j++){
				if((nums[j] - nums[i])>maxprofit){
					maxprofit = nums[j] - nums[i];
					buying = nums[i];
					selling = nums[j];
				}
			}
		}
		return maxprofit>0?maxprofit:0;
	}
	
	/**
	check the maximum interval for the range start to end
	*/
	public static Interval findMaxProfit2HelperCrossing(int[] nums, int start, int mid, int end){
		//lets find the left sum and keep track of the point that gives the maximum sum on the left half
		int leftsum = Integer.MIN_VALUE;
		int leftmax = -1;
		int sum = 0;
		for(int i=mid; i>=start;i--){
			sum = sum + nums[i];
			if(sum>leftsum){
				leftsum = sum;
				leftmax = i;
			}
		}
		//lets find the right sum and keep track of the point that gives the maximum sum on the right half 
		int rightsum = Integer.MIN_VALUE;
		int rightmax = -1;
		sum = 0;
		for(int j=mid+1;j<=end; j++){
			sum = sum+nums[j];
			if(sum>rightsum){
				rightsum = sum;
				rightmax = j;
			}
		}
		return new Interval(leftmax, rightmax, leftsum+rightsum);
	}
	/**
	recursively call  itself to find the maximum sub array
	*/
	public static Interval findMaxProfit2Helper(int[] nums, int start, int end){
		if(start==end && end<nums.length){//only one element
			return new Interval(start, end, nums[start]);
		}else{
			int mid = (int)Math.floor((start+end)/2);
			Interval left = findMaxProfit2Helper(nums, start, mid);
			Interval right = findMaxProfit2Helper(nums, mid+1, end);
			Interval crossing = findMaxProfit2HelperCrossing(nums, start, mid, end);
			//System.out.println("left has profit:"+left.profit+" right has profit:"+right.profit+" crossing has profit:"+crossing.profit);
			//check which among three has maximum profit and return it
			if(left.profit>=right.profit && left.profit>=crossing.profit)
				return left;
			else if(right.profit>=left.profit && right.profit>=crossing.profit)
				return right;
			else
				return crossing;
		}
	}
	/**
	Sol2:
	-we use divide and conquer method
	-find the difference of the stock price in each consecutive day and build an array for the differences
	-find the maximum subarray on start...mid, find maximum subarray on mid+1...high, and find the same for start..end
	because the maximum sum can be on any portion of the array
	-the maximum subarray is the one that has maximum sum among the three subarrays
	O(nlogn) time because start...mid and mid+1...end subarrays are processed with O(logn) time
	-Ref: Cormen 3rd edn.
	*/
	public static int findMaxProfit2(int[] nums){
		//base cases
		if(nums==null || nums.length<=1){
			return -1;
		}
		
		//lets prepare the interval array that will be the input to the helper method
		int[] diff = new int[nums.length-1];
		for(int i=1;i<nums.length; i++){
			diff[i-1] = nums[i] - nums[i-1];
		}
		//System.out.println("Price array is:"+Arrays.toString(nums));
		//System.out.println("Difference array is:"+Arrays.toString(diff));
		int start = 0;
		int mid = diff.length/2;
		int end = diff.length-1;
		//find the max subarray in the three subarrays
		Interval maxinterval = findMaxProfit2Helper(diff, start, end);
		//diff[i] is the difference of nums[i] and nums[i+1]
		//System.out.println("the max profit of "+maxinterval.profit+" is when bought at:"+maxinterval.buy+" and sold at:"+(maxinterval.sell+1));
		return maxinterval.profit>0?maxinterval.profit:0;
	}
	
	/**
	-Method3:
	-for every index/array element, keep track of the profit we can get by including that index in our profit
	-if the profit ending at current index is greater than the profit we found before, then we include this point
	-if the profit ending at current index is smaller than the profit we found before, then we don't include this point
	O(n)
	*/
	public static int findMaxProfit3(int[] nums){
		//handle base cases
		if(nums==null || nums.length<2){
			return 0; //no profit on prices less than 2 days
		}
		//lets prepare the interval array that will be the input to the helper method
		int[] diff = new int[nums.length-1];
		for(int i=1;i<nums.length; i++){
			diff[i-1] = nums[i] - nums[i-1];
		}
		//check base cases with diff array
		if(diff.length<2){
			return diff[0]>0?diff[0]:0;
		}else{
			int maxwithCur = 0;
			int maxsoFar = 0;
			for(int i=0;i<diff.length; i++){
				maxwithCur = maxwithCur+diff[i];
				if(maxwithCur>maxsoFar){
					maxsoFar = maxwithCur;
				}if(maxwithCur<0){
					maxwithCur = 0;
				}
			}
			return maxsoFar>0?maxsoFar:0;
		}
	}
	
	/**
	Method4:
	-use dynamic programming
	-if sum[j] denotes the maximum sum among all the subarrays ending in arr[j], we can use the following recursvie relation:
	sum[j] = max(sum[j], sum[j-1] + arr[j])
	*/
	public static int findMaxProfitDP(int[] nums){
		//lets prepare the interval array that will be the input to the helper method
		int[] diff = new int[nums.length-1];
		for(int i=1;i<nums.length; i++){
			diff[i-1] = nums[i] - nums[i-1];
		}
		int sum[] = new int[diff.length];
		for(int i=1;i<diff.length; i++){
			sum[i] = Math.max(diff[i], sum[i-1] +diff[i]); 
		}
		System.out.println(Arrays.toString(sum));
		//find the maximum from the sum array
		int maxsum = Integer.MIN_VALUE;
		for(Integer cursum:sum){
			if(cursum>maxsum)
				maxsum = cursum;
		}
		return maxsum;
	}
	
	public static void main(String args[]){
		int[] nums = new int[]{7,1,5,3,6,4};//diff is {-6, 4, -2, 3, -2}
		//nums = new int[]{7,6,4,3,1};
		System.out.println("the maxprofit1 is:"+findMaxProfit1(nums));
		System.out.println("the maxprofit2 is:"+findMaxProfit2(nums));
		System.out.println("the maxprofit3 is:"+findMaxProfit3(nums));
		System.out.println("the maxprofitDP is:"+findMaxProfitDP(nums));
	}

}