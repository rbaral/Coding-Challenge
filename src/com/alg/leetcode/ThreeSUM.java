package com.alg.leetcode;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * TIME LIMIT EXCEEDED
 */
/**
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? 
 * Find all unique triplets in the array which gives the sum of zero.

Note:
Elements in a triplet (a,b,c) must be in non-descending order. (ie, a &le; b &le; c)
The solution set must not contain duplicate triplets.
    For example, given array S = {-1 0 1 2 -1 -4},

    A solution set is:
    (-1, 0, 1)
    (-1, -1, 2)
    
 * @author rbaral
 * ref: http://www.programcreek.com/2012/12/leetcode-3sum/
 *
 */
public class ThreeSUM {

	private static DateFormat format = new SimpleDateFormat("YYYY-M-d:H:m:s:S");
	private static Map<Integer[], List<List<Integer>>> testCases= new HashMap<Integer[], List<List<Integer>>>();
	public static void main(String[] args) {
		boolean test = true;
		if(test){
			performTest();
		}else{
			System.out.println(format.format(new Date()));
			int nums[]=new int[]{13,-5,3,3,-1,13,3,1,-9,-4,9,12,6,-9,-6,-12,-8,3,12,14,4,-15,2,-11,4,-12,10,9,-6,-3,-8,14,7,3,2,-8,-7,-10,8,-8,-7,-6,-11,6,-7,-2,9,-8,8,-2,13,-10,-2,0,-14,-13,-4,11,3,-3,-7,3,-4,8,13,13,-15,-9,10,0,-2,-12,1,2,9,1,8,-4,8,-7,9,7,-2,-15,14,0,-13,-13,-12,-2,-1,-11,8,10,12,6,8,4,12,3,11,-12,-2,-3,5,-15,6,-10,-4,-1,-1,-10,13};//{-1, 0, 1, 2, -1, -4};
			nums = new int[]{7,-13,-1,1,-6,14,10,-2,1,9,11,-10,8,-10,14,13,-1,4,-6,-3,-5,3,3,12,-5,11,5,-6,-2,0,-6,12,3,0,-2,12,-1,-7,-5,8,10,13,13,3,10,12,-7,-6,-7,-5,-1,3,5,-13,-8,-15,13,13,-14,-12,-2,-5,-15,8,11,-1,6,-13,-1,8,10,-14,-1,0,-4,-6,-3,5,-4,-2,7,10,8,-3,12,-14,-10,3,14,-9,-2,-11,-6,-9,13,12,-3,4,14,3,-11,2,5,-5,-13,-14,-3,-8};
			nums = new int[]{7,-1,14,-12,-8,7,2,-15,8,8,-8,-14,-4,-5,7,9,11,-4,-15,-6,1,-14,4,3,10,-5,2,1,6,11,2,-2,-5,-7,-6,2,-15,11,-6,8,-4,2,1,-1,4,-6,-15,1,5,-15,10,14,9,-8,-6,4,-6,11,12,-15,7,-1,-9,9,-1,0,-4,-1,-12,-2,14,-9,7,0,-3,-4,1,-2,12,14,-10,0,5,14,-1,14,3,8,10,-8,8,-5,-2,6,-11,12,13,-7,-12,8,6,-13,14,-2,-5,-11,1,3,-6};
			threeSum(nums);
			System.out.println(format.format(new Date()));
		}
	}
	
	public static List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> triplets = new ArrayList<List<Integer>>();
		Integer triplet[];
		if(nums==null||nums.length<3)//if null array or if the size of the array is less than 3, return blank
			return triplets;
		else if(nums.length==3){//if only three elements and the sum is zero, then return the sorted integers, else return blank
			if(nums[0]+nums[1]+nums[2]==0){
				triplet = new Integer[]{nums[0], nums[1], nums[2]};
				Arrays.sort(triplet);
				triplets.add(Arrays.asList(triplet));
			}
			return triplets;
		}
		else{
			Arrays.sort(nums);//sort the elements in ascending order
			int low=0, high=nums.length-1;//define the two pointers to be used on the two ends of the array
			//we iterate till the third last element as after that we won't find any triplets
			for(int i=0;i<nums.length-3;i++){
				low =i+1; high = nums.length-1;//check from the next index of the current element
				if(nums[i]>=0 && nums[low]>nums[i])//if current element is zero (or greater) and the next index has greater value, then we won't find the triples for zero (or greater) as the array is sorted in increasing order
					continue;
				else{
					//avoid duplicate solutions
					if(i==0 || nums[i]>nums[i-1]){
						while(low<high){
							if(nums[low]+nums[high]+nums[i]==0){
								triplet = new Integer[]{nums[i],nums[low], nums[high]};
								//Arrays.sort(triplet);//this approach to skip duplicates took more time
								//if(!triplets.contains(Arrays.asList(triplet)))
								triplets.add(Arrays.asList(triplet));
								low++;
								high--;
								//avoid duplicate solutions
								while (low < high && nums[high] == nums[high + 1])
									high--;
								//avoid duplicate solutions
								while (low < high && nums[low] == nums[low - 1])
									low++;
							}
							else if(nums[low]+nums[high]+nums[i]<0){
								low++;
							}else{
								high--;
							}
						}	
					}
						
				}
			}
		}
		return triplets;
    } 
	
	/**
	 * this method is required only if testing is
	 * to be done. It just adds some test cases and checks
	 * if the system passes the unit test
	 * 7 test cases defined, the program should pass all the test cases, irrespective of any modification
	 */
	public static void performTest(){
		List<String> failedCases = new ArrayList<String>();
		List<List<Integer>> result=new ArrayList<List<Integer>>();
		List<List<Integer>> expected = new ArrayList<List<Integer>>();
		Integer input[] = new Integer[]{-1, 0, 1, 2, -1, -4};
		List<List<Integer>> output = new ArrayList<List<Integer>>();
		output.add(Arrays.asList(new Integer[]{-1, -1, 2}));
		output.add(Arrays.asList(new Integer[]{-1, 0, 1}));
		testCases.put(input, output);
		input = new Integer[]{0,0};
		output = new ArrayList<List<Integer>>();
		output.add(Arrays.asList(new Integer[]{}));
		testCases.put(input, output);
		
		input = new Integer[]{1,-1};
		output = new ArrayList<List<Integer>>();
		output.add(Arrays.asList(new Integer[]{}));
		testCases.put(input, output);
		input = new Integer[]{0,0,0};
		output = new ArrayList<List<Integer>>();
		output.add(Arrays.asList(new Integer[]{0,0,0}));
		testCases.put(input, output);
		input = new Integer[]{1,2,-2,-1};
		output = new ArrayList<List<Integer>>();
		output.add(Arrays.asList(new Integer[]{}));
		testCases.put(input, output);
		input = new Integer[]{-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};
		output = new ArrayList<List<Integer>>();
		output.add(Arrays.asList(new Integer[]{-4,-2,6}));output.add(Arrays.asList(new Integer[]{-4,0,4}));output.add(Arrays.asList(new Integer[]{-4,1,3}));output.add(Arrays.asList(new Integer[]{-4,2,2}));output.add(Arrays.asList(new Integer[]{-2,-2,4}));output.add(Arrays.asList(new Integer[]{-2,0,2}));
		testCases.put(input, output);
		output = new ArrayList<List<Integer>>();
		input = new Integer[]{13,-5,3,3,-1,13,3,1,-9,-4,9,12,6,-9,-6,-12,-8,3,12,14,4,-15,2,-11,4,-12,10,9,-6,-3,-8,14,7,3,2,-8,-7,-10,8,-8,-7,-6,-11,6,-7,-2,9,-8,8,-2,13,-10,-2,0,-14,-13,-4,11,3,-3,-7,3,-4,8,13,13,-15,-9,10,0,-2,-12,1,2,9,1,8,-4,8,-7,9,7,-2,-15,14,0,-13,-13,-12,-2,-1,-11,8,10,12,6,8,4,12,3,11,-12,-2,-3,5,-15,6,-10,-4,-1,-1,-10,13};
		output.add(Arrays.asList(new Integer[]{-15,1,14}));output.add(Arrays.asList(new Integer[]{-15,2,13}));output.add(Arrays.asList(new Integer[]{-15,3,12}));output.add(Arrays.asList(new Integer[]{-15,4,11}));output.add(Arrays.asList(new Integer[]{-15,5,10}));output.add(Arrays.asList(new Integer[]{-15,6,9}));output.add(Arrays.asList(new Integer[]{-15,7,8}));output.add(Arrays.asList(new Integer[]{-14,0,14}));output.add(Arrays.asList(new Integer[]{-14,1,13}));output.add(Arrays.asList(new Integer[]{-14,2,12}));output.add(Arrays.asList(new Integer[]{-14,3,11}));output.add(Arrays.asList(new Integer[]{-14,4,10}));output.add(Arrays.asList(new Integer[]{-14,5,9}));output.add(Arrays.asList(new Integer[]{-14,6,8}));output.add(Arrays.asList(new Integer[]{-14,7,7}));output.add(Arrays.asList(new Integer[]{-13,-1,14}));output.add(Arrays.asList(new Integer[]{-13,0,13}));output.add(Arrays.asList(new Integer[]{-13,1,12}));output.add(Arrays.asList(new Integer[]{-13,2,11}));output.add(Arrays.asList(new Integer[]{-13,3,10}));output.add(Arrays.asList(new Integer[]{-13,4,9}));output.add(Arrays.asList(new Integer[]{-13,5,8}));output.add(Arrays.asList(new Integer[]{-13,6,7}));output.add(Arrays.asList(new Integer[]{-12,-2,14}));output.add(Arrays.asList(new Integer[]{-12,-1,13}));output.add(Arrays.asList(new Integer[]{-12,0,12}));output.add(Arrays.asList(new Integer[]{-12,1,11}));output.add(Arrays.asList(new Integer[]{-12,2,10}));output.add(Arrays.asList(new Integer[]{-12,3,9}));output.add(Arrays.asList(new Integer[]{-12,4,8}));output.add(Arrays.asList(new Integer[]{-12,5,7}));output.add(Arrays.asList(new Integer[]{-12,6,6}));output.add(Arrays.asList(new Integer[]{-11,-3,14}));output.add(Arrays.asList(new Integer[]{-11,-2,13}));output.add(Arrays.asList(new Integer[]{-11,-1,12}));output.add(Arrays.asList(new Integer[]{-11,0,11}));output.add(Arrays.asList(new Integer[]{-11,1,10}));output.add(Arrays.asList(new Integer[]{-11,2,9}));output.add(Arrays.asList(new Integer[]{-11,3,8}));output.add(Arrays.asList(new Integer[]{-11,4,7}));output.add(Arrays.asList(new Integer[]{-11,5,6}));output.add(Arrays.asList(new Integer[]{-10,-4,14}));output.add(Arrays.asList(new Integer[]{-10,-3,13}));output.add(Arrays.asList(new Integer[]{-10,-2,12}));output.add(Arrays.asList(new Integer[]{-10,-1,11}));output.add(Arrays.asList(new Integer[]{-10,0,10}));output.add(Arrays.asList(new Integer[]{-10,1,9}));output.add(Arrays.asList(new Integer[]{-10,2,8}));output.add(Arrays.asList(new Integer[]{-10,3,7}));output.add(Arrays.asList(new Integer[]{-10,4,6}));output.add(Arrays.asList(new Integer[]{-9,-5,14}));output.add(Arrays.asList(new Integer[]{-9,-4,13}));output.add(Arrays.asList(new Integer[]{-9,-3,12}));output.add(Arrays.asList(new Integer[]{-9,-2,11}));output.add(Arrays.asList(new Integer[]{-9,-1,10}));output.add(Arrays.asList(new Integer[]{-9,0,9}));output.add(Arrays.asList(new Integer[]{-9,1,8}));output.add(Arrays.asList(new Integer[]{-9,2,7}));output.add(Arrays.asList(new Integer[]{-9,3,6}));output.add(Arrays.asList(new Integer[]{-9,4,5}));output.add(Arrays.asList(new Integer[]{-8,-6,14}));output.add(Arrays.asList(new Integer[]{-8,-5,13}));output.add(Arrays.asList(new Integer[]{-8,-4,12}));output.add(Arrays.asList(new Integer[]{-8,-3,11}));output.add(Arrays.asList(new Integer[]{-8,-2,10}));output.add(Arrays.asList(new Integer[]{-8,-1,9}));output.add(Arrays.asList(new Integer[]{-8,0,8}));output.add(Arrays.asList(new Integer[]{-8,1,7}));output.add(Arrays.asList(new Integer[]{-8,2,6}));output.add(Arrays.asList(new Integer[]{-8,3,5}));output.add(Arrays.asList(new Integer[]{-8,4,4}));output.add(Arrays.asList(new Integer[]{-7,-7,14}));output.add(Arrays.asList(new Integer[]{-7,-6,13}));output.add(Arrays.asList(new Integer[]{-7,-5,12}));output.add(Arrays.asList(new Integer[]{-7,-4,11}));output.add(Arrays.asList(new Integer[]{-7,-3,10}));output.add(Arrays.asList(new Integer[]{-7,-2,9}));output.add(Arrays.asList(new Integer[]{-7,-1,8}));output.add(Arrays.asList(new Integer[]{-7,0,7}));output.add(Arrays.asList(new Integer[]{-7,1,6}));output.add(Arrays.asList(new Integer[]{-7,2,5}));output.add(Arrays.asList(new Integer[]{-7,3,4}));output.add(Arrays.asList(new Integer[]{-6,-6,12}));output.add(Arrays.asList(new Integer[]{-6,-5,11}));output.add(Arrays.asList(new Integer[]{-6,-4,10}));output.add(Arrays.asList(new Integer[]{-6,-3,9}));output.add(Arrays.asList(new Integer[]{-6,-2,8}));output.add(Arrays.asList(new Integer[]{-6,-1,7}));output.add(Arrays.asList(new Integer[]{-6,0,6}));output.add(Arrays.asList(new Integer[]{-6,1,5}));output.add(Arrays.asList(new Integer[]{-6,2,4}));output.add(Arrays.asList(new Integer[]{-6,3,3}));output.add(Arrays.asList(new Integer[]{-5,-4,9}));output.add(Arrays.asList(new Integer[]{-5,-3,8}));output.add(Arrays.asList(new Integer[]{-5,-2,7}));output.add(Arrays.asList(new Integer[]{-5,-1,6}));output.add(Arrays.asList(new Integer[]{-5,0,5}));output.add(Arrays.asList(new Integer[]{-5,1,4}));output.add(Arrays.asList(new Integer[]{-5,2,3}));output.add(Arrays.asList(new Integer[]{-4,-4,8}));output.add(Arrays.asList(new Integer[]{-4,-3,7}));output.add(Arrays.asList(new Integer[]{-4,-2,6}));output.add(Arrays.asList(new Integer[]{-4,-1,5}));output.add(Arrays.asList(new Integer[]{-4,0,4}));output.add(Arrays.asList(new Integer[]{-4,1,3}));output.add(Arrays.asList(new Integer[]{-4,2,2}));output.add(Arrays.asList(new Integer[]{-3,-3,6}));output.add(Arrays.asList(new Integer[]{-3,-2,5}));output.add(Arrays.asList(new Integer[]{-3,-1,4}));output.add(Arrays.asList(new Integer[]{-3,0,3}));output.add(Arrays.asList(new Integer[]{-3,1,2}));output.add(Arrays.asList(new Integer[]{-2,-2,4}));output.add(Arrays.asList(new Integer[]{-2,-1,3}));output.add(Arrays.asList(new Integer[]{-2,0,2}));output.add(Arrays.asList(new Integer[]{-2,1,1}));output.add(Arrays.asList(new Integer[]{-1,-1,2}));output.add(Arrays.asList(new Integer[]{-1,0,1}));output.add(Arrays.asList(new Integer[]{0,0,0}));
		testCases.put(input, output);
		int[] inputparam;
		for(Integer[] testCase: testCases.keySet()){
			inputparam = new int[testCase.length];
			for(int j=0;j<testCase.length;j++){
				inputparam[j] = testCase[j];
			}
			result = threeSum(inputparam);
			expected = testCases.get(testCase);
			for(int i=0; i<result.size();i++){
				//System.out.println(Arrays.toString(result.get(i).toArray()));
				//System.out.println("..."+Arrays.toString(expected.get(i).toArray()));
				if (!Arrays.toString(result.get(i).toArray()).equals(Arrays.toString(expected.get(i).toArray()))) {
					String msg1="Failed for:{"+Arrays.toString(testCase)+"} got:",msg2=" Expected: ";
					//failedCases.add("Failed for:{"+Arrays.toString(testCase)+"} got:");//+Arrays.toString(result.get(i).toArray())+" expected:"+Arrays.toString(expected.get(i).toArray()));
					for(int k=0;k<result.size();k++){
						msg1+=Arrays.toString(result.get(k).toArray());
						msg2+=Arrays.toString(expected.get(k).toArray());
					}
					failedCases.add(msg1+" "+msg2);
					break;
				}
	
			}
		}
		System.out.println("TEST RESULT, Passed:"+(testCases.size()-failedCases.size())+" failed:"+failedCases.size());
		for(String failure:failedCases)
			System.err.println(failure);
	}

}
