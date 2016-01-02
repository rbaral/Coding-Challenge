/**
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

    For example, given array S = {-1 2 1 -4}, and target = 1.

    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */
package com.alg.leetup;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

class TestCase{
	int[] nums;
	int target;
	int closest;
	TestCase(int[] nums, int target, int closest){
		this.nums = nums;
		this.closest = closest;
		this.target = target;
	}
	public int[] getNums() {
		return nums;
	}
	public void setNums(int[] nums) {
		this.nums = nums;
	}
	public int getTarget() {
		return target;
	}
	public void setTarget(int target) {
		this.target = target;
	}
	public int getClosest() {
		return closest;
	}
	public void setClosest(int closest) {
		this.closest = closest;
	}
	
	public String toString(){
		return "Test case for:"+Arrays.toString(getNums())+" with target:"+getTarget()+" has expected 3closestsum:"+getClosest();
	}
	
}

/**
 * @author rbaral
 *
 */
public class ThreeSumClosest {

	private static DateFormat format = new SimpleDateFormat("YYYY-M-d:H:m:s:S");
	private static List<TestCase> testCases= new ArrayList<TestCase>();
	private static List<String> failedCases= new ArrayList<String>();
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		boolean isTestMode = false;
		if(isTestMode){
			performTest();
		}else{
			int nums[] = new int[]{0,0,1};
			int target = 1;
			nums = new int[]{13,2,0,-14,-20,19,8,-5,-13,-3,20,15,20,5,13,14,-17,-7,12,-6,0,20,-19,-1,-15,-2,8,-2,-9,13,0,-3,-18,-9,-9,-19,17,-14,-19,-4,-16,2,0,9,5,-7,-4,20,18,9,0,12,-1,10,-17,-11,16,-13,-14,-3,0,2,-18,2,8,20,-15,3,-13,-12,-2,-19,11,11,-10,1,1,-10,-2,12,0,17,-19,-7,8,-19,-17,5,-5,-10,8,0,-12,4,19,2,0,12,14,-9,15,7,0,-16,-5,16,-12,0,2,-16,14,18,12,13,5,0,5,6};
			target = -59;
			System.out.println(format.format(new Date()));
			System.out.println(threeSumClosest(nums, target));	
			System.out.println(format.format(new Date()));
		}
		
	}
	
	/**
	 * the overall idea is to work as the 3SUM problem,
	 * here we maintain the closeness of the triplets and
	 * update the closeness if the triplets are more closer than
	 * the previous one. Similar to the 3SUM problem, we maintain
	 * the two end pointers and keep on updating the pointers based on
	 * the difference of {sum of the triplets} and the given target.
	 * At the end, we get the triplet closest to the target.
	 * @param nums
	 * @param target
	 * @return
	 */
	public static int threeSumClosest(int[] nums, int target) {
		// base case
		if (nums.length == 3)
			return nums[0] + nums[1] + nums[2];
		// WLOG, we assume that the size of nums is atleast three
		Arrays.sort(nums);
		int closest = 0;
		int diff = 100000000;//a very large number
		int tempDiff,low, high;// define the two pointers to be used on the two ends of the array
		Arrays.sort(nums);// sort the elements in ascending order
		for (int i = 0; i < nums.length - 2; i++) {
			// we iterate till the third last element as after that we won't find any triplets
			low = i + 1;
			high = nums.length - 1;// check from the next index of the current element
			/**
			 * if current element is zero (or greater) and the
			 *  next index has greater value, then we won't 
			 *  find the triples for zero (or greater) as the array is sorted in increasing order
			 */
			while (low < high) {
				//if it was closer than the previous one then update
				tempDiff = nums[i] + nums[low] + nums[high] - target;
				if(Math.abs(tempDiff) < Math.abs(diff)){
					 closest = nums[i] + nums[low] + nums[high];
					 diff = tempDiff;
				 }
				//choose which direction to go for the pointers
				if(tempDiff==0){
					return nums[i] + nums[low] + nums[high];//we are done
				}else if(tempDiff < 0){
					low++;
				}else{
					high --;
				}
			}
		}
		return closest;
	}
	
	public static void performTest(){
		int nums[] = new int[]{0,0,1};
		int target = 1;
		int closest = 1;
		testCases.add(new TestCase(nums, target, closest));
		nums= new int[]{-1, 2, 1, -4};
		target =2;
		closest = 2;
		testCases.add(new TestCase(nums, target, closest));
		nums = new int[]{5,1,0};
		target = 1;
		closest = 6;
		testCases.add(new TestCase(nums, target, closest));
		nums =new int[]{1,1,1,0};
		target = 100;
		closest = 3;
		testCases.add(new TestCase(nums, target, closest));
		nums = new int[]{0,2,1,-3};
		target = 1;
		closest = 0;
		testCases.add(new TestCase(nums, target, closest));
		nums = new int[]{1,1,-1,-1,3};
		target = -1;
		closest = -1;
		testCases.add(new TestCase(nums, target, closest));
		nums = new int[]{1,2,4,8,16,32,64,128};
		target = 82;
		closest = 82;
		testCases.add(new TestCase(nums, target, closest));
		nums = new int[]{13,2,0,-14,-20,19,8,-5,-13,-3,20,15,20,5,13,14,-17,-7,12,-6,0,20,-19,-1,-15,-2,8,-2,-9,13,0,-3,-18,-9,-9,-19,17,-14,-19,-4,-16,2,0,9,5,-7,-4,20,18,9,0,12,-1,10,-17,-11,16,-13,-14,-3,0,2,-18,2,8,20,-15,3,-13,-12,-2,-19,11,11,-10,1,1,-10,-2,12,0,17,-19,-7,8,-19,-17,5,-5,-10,8,0,-12,4,19,2,0,12,14,-9,15,7,0,-16,-5,16,-12,0,2,-16,14,18,12,13,5,0,5,6};
		target = -59;
		closest = -58;
		testCases.add(new TestCase(nums, target, closest));
		int result;
		for(TestCase testCase:testCases){
			result = threeSumClosest(testCase.getNums(), testCase.getTarget());
			if(result!=testCase.getClosest()){
				failedCases.add("Failed for:"+testCase.toString()+".... got:"+result);
			}
		}
		System.out.println("TEST RESULT, Passed:"+(testCases.size()-failedCases.size())+" failed:"+failedCases.size());
		for(String failure:failedCases)
			System.err.println(failure);
		
		
	}

}
