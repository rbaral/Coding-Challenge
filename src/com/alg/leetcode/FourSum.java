/**
 * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

Note:
Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a &le; b &le; c &le; d)
The solution set must not contain duplicate quadruplets.
    For example, given array S = {1 0 -1 0 -2 2}, and target = 0.

    A solution set is:
    (-1,  0, 0, 1)
    (-2, -1, 1, 2)
    (-2,  0, 0, 2)
 */
package com.alg.leetup;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

class TestCaseFourSum{
	int[] nums;
	int target;
	List<List<Integer>> triplets;
	TestCaseFourSum(int[] nums, int target, List<List<Integer>> triplets){
		this.nums = nums;
		this.triplets = triplets;
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
	
	public List<List<Integer>> getTriplets() {
		return triplets;
	}
	public void setTriplets(List<List<Integer>> triplets) {
		this.triplets = triplets;
	}
	public String toString(){
		return "Test case for:"+Arrays.toString(getNums())+" with target:"+getTarget()+" has expected "+Arrays.toString(triplets.toArray());
	}
	
}
/**
 * @author rbaral
 *
 */
public class FourSum {
	private static DateFormat format = new SimpleDateFormat("YYYY-M-d:H:m:s:S");
	private static List<TestCaseFourSum> testCases= new ArrayList<TestCaseFourSum>();
	private static List<String> failedCases= new ArrayList<String>();
	private static List<List<Integer>> results= new ArrayList<List<Integer>>();
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		boolean isTestMode = false;
		if(isTestMode){
			performTest();
		}else{
			System.out.println(format.format(new Date()));
			int target =0;
			int nums[]=new int[]{1, 0, -1, 0, -2, 2};
			nums = new int[]{-1,0,1,2,-1,-4};
			target = -1;
			System.out.println(Arrays.toString(fourSum(nums, target).toArray()));
			System.out.println(format.format(new Date()));
		}
		

	}

	public static List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> triplets = new ArrayList<List<Integer>>();
		Integer triplet[];
		if(nums==null||nums.length<4)//if null array or if the size of the array is less than 3, return blank
			return triplets;
		else if(nums.length==4){//if only three elements and the sum is zero, then return the sorted integers, else return blank
			if(nums[0]+nums[1]+nums[2]+nums[3]==target){
				triplet = new Integer[]{nums[0], nums[1], nums[2], nums[3]};
				Arrays.sort(triplet);
				triplets.add(Arrays.asList(triplet));
			}
			return triplets;
		}
		else{
			Arrays.sort(nums);//sort the elements in ascending order
			System.out.println("OPERATING WITH:"+Arrays.toString(nums)+" and target:"+target);
			int low, high, tempSum, tempDiff;//define the two pointers to be used on the two ends of the array
			//we iterate till the third last element as after that we won't find any triplets
			for(int i=0;i<nums.length-3;i++){
				for(int j=i+1;j<nums.length-2;j++){
					low =j+1; high = nums.length-1;//check from the next index of the current element
					if(nums[j]>=0 && nums[low]>nums[j])//if current element is zero (or greater) and the next index has greater value, then we won't find the triples for zero (or greater) as the array is sorted in increasing order
						continue;
					else{
						//avoid duplicate solutions
						//if(j==0 || nums[j]>nums[j-1]){
						while(low<high){
							tempSum = nums[low]+nums[high]+nums[j];
							tempDiff = target - nums[i];
							if(tempSum==tempDiff){
								triplet = new Integer[]{nums[i],nums[j],nums[low], nums[high]};
								triplets.add(Arrays.asList(triplet));
								low++;
								high--;
								//avoid duplicate solutions
								//while (low < high && nums[high] == nums[high + 1])
								//	high--;
								//avoid duplicate solutions
								//while (low < high && nums[low] == nums[low - 1])
								//	low++;
							}
							else if(tempSum<tempDiff){
								low++;
							}else{
								high--;
							}
						}	
						//}
							
					}	
				}
				
			}
		}
		return triplets;
    }
	
	public static void performTest(){
		int nums[] = new int[]{1, 0, -1, 0, -2, 2};
		int target = 0;
		results = new ArrayList<List<Integer>>();
		results.add(Arrays.asList(new Integer[]{-2, -1, 1, 2}));
		results.add(Arrays.asList(new Integer[]{-2,  0, 0, 2}));
		results.add(Arrays.asList(new Integer[]{-1,  0, 0, 1}));
		//testCases.add(new TestCaseFourSum(nums, target, results));
		nums = new int[]{-1,0,1,2,-1,-4};
		target = -1;
		results = new ArrayList<List<Integer>>();
		results.add(Arrays.asList(new Integer[]{-4,0,1,2}));
		results.add(Arrays.asList(new Integer[]{-1,-1,0,1}));
		testCases.add(new TestCaseFourSum(nums, target, results));
		List<List<Integer>> expected= new ArrayList<List<Integer>>();
		for(TestCaseFourSum testCase:testCases){
			expected = testCase.getTriplets();
			results = fourSum(testCase.getNums(), testCase.getTarget());
			if(results.size()!= expected.size()){
				String msg1="Failed for:{"+Arrays.toString(testCase.getNums())+"} with target:"+testCase.getTarget()+" got:[",msg2=" Expected: ";
				for(int k=0;k<results.size();k++){
					msg1+=Arrays.toString(expected.get(k).toArray());
				}
				for(int k=0;k<expected.size();k++){
					msg2+=Arrays.toString(expected.get(k).toArray());
				}
				failedCases.add(msg1+"] "+msg2);
			}else{
				for(int i=0; i<results.size();i++){
					//System.out.println(Arrays.toString(result.get(i).toArray()));
					//System.out.println("..."+Arrays.toString(expected.get(i).toArray()));
					if (!Arrays.toString(results.get(i).toArray()).equals(Arrays.toString(expected.get(i).toArray()))) {
						String msg1="Failed for:{"+Arrays.toString(testCase.getNums())+"} with target:"+testCase.getTarget()+" got:",msg2=" Expected: ";
						for(int k=0;k<results.size();k++){
							msg1+=Arrays.toString(results.get(k).toArray());
							msg2+=Arrays.toString(expected.get(k).toArray());
						}
						failedCases.add(msg1+" "+msg2);
						break;
					}
				}	
			}
			
		}
		System.out.println("TEST RESULT, Passed:"+(testCases.size()-failedCases.size())+" failed:"+failedCases.size());
		for(String failure:failedCases)
			System.err.println(failure);
	}
}
