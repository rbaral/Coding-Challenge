package com.alg.leetup;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
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
    
    [0,0] ->[]
    [1,-1] ->[]
    [0,0,0]->[[0,0,0]]
    [1,2,-2,-1]->[]
    [-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6]->[[-4,-2,6],[-4,0,4],[-4,1,3],[-4,2,2],[-2,-2,4],[-2,0,2]]
    [13,-5,3,3,-1,13,3,1,-9,-4,9,12,6,-9,-6,-12,-8,3,12,14,4,-15,2,-11,4,-12,10,9,-6,-3,-8,14,7,3,2,-8,-7,-10,8,-8,-7,-6,-11,6,-7,-2,9,-8,8,-2,13,-10,-2,0,-14,-13,-4,11,3,-3,-7,3,-4,8,13,13,-15,-9,10,0,-2,-12,1,2,9,1,8,-4,8,-7,9,7,-2,-15,14,0,-13,-13,-12,-2,-1,-11,8,10,12,6,8,4,12,3,11,-12,-2,-3,5,-15,6,-10,-4,-1,-1,-10,13]->
 * @author rbaral
 *
 */
public class ThreeSUM {

	public static void main(String[] args) {
		DateFormat format = new SimpleDateFormat("YYYY-M-d:H:m:s:S");
		System.out.println(format.format(new Date()));
		int nums[]=new int[]{13,-5,3,3,-1,13,3,1,-9,-4,9,12,6,-9,-6,-12,-8,3,12,14,4,-15,2,-11,4,-12,10,9,-6,-3,-8,14,7,3,2,-8,-7,-10,8,-8,-7,-6,-11,6,-7,-2,9,-8,8,-2,13,-10,-2,0,-14,-13,-4,11,3,-3,-7,3,-4,8,13,13,-15,-9,10,0,-2,-12,1,2,9,1,8,-4,8,-7,9,7,-2,-15,14,0,-13,-13,-12,-2,-1,-11,8,10,12,6,8,4,12,3,11,-12,-2,-3,5,-15,6,-10,-4,-1,-1,-10,13};//{-1, 0, 1, 2, -1, -4};
		threeSum(nums);
		System.out.println(format.format(new Date()));

	}
	
	public static List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> triplets = new ArrayList<List<Integer>>();
		List<String> tripString = new ArrayList<String>();
		if(nums==null||nums.length<3)
			return triplets;
		else{
			//instead of looking for a+b+c=0, we look for a+b=-c
			//sort the numbers
			
			//System.out.println(Arrays.toString(nums));
			Arrays.sort(nums);
			//System.out.println(Arrays.toString(nums));
			int low=0, high=nums.length-1,curNum=0;
			int tempNums[] = new int[nums.length];
			for(int i=0;i<nums.length;i++){
				curNum = -nums[i];
				tempNums=cloneArray(nums,i);//assume that this number is not present in the array
				low =0; high = tempNums.length-1;
				//check if ther are two numbers that sum to it
				while(low!=high){
					//System.out.println("low:"+low+" high:"+high+" finding nums for:"+curNum+" in array:"+Arrays.toString(tempNums));
					//find the two numbers, whose sum is -curNum
					if(tempNums[low]+tempNums[high]<curNum){
						low++;
					}else if(tempNums[low]+tempNums[high]>curNum){
						high--;
					}else{
						//found one
						Integer triplet[] = new Integer[]{-curNum, tempNums[low], tempNums[high]};
						Arrays.sort(triplet);
						if(!tripString.contains(Arrays.toString(triplet))){
							tripString.add(Arrays.toString(triplet));
							triplets.add(Arrays.asList(triplet));
							//System.out.println("---> found "+Arrays.toString(triplet));
						}else{
							//System.out.println("--> already inserted:"+Arrays.toString(triplet));
						}
						//System.out.println("for "+-curNum+" found triplets:"+Arrays.toString(triplet));
						//break;
						//check if another triplet gives the same number
						//arbitrarily increase low
						low++;
					}
				}
			}
		}
		/**
		 * TODOS
		 * need to sort the triplets by their increasing order of numbers, eg: this program produces
		 * [[-1,0,1],[-1,-1,2]] but the expected answer is [[-1,-1,2],[-1,0,1]]
		 */
		/*for(List l:triplets){
			System.out.println(Arrays.toString(l.toArray()));
		}*/
		return triplets;
        
    } 
	
	public static int[] cloneArray(int[] nums,int index){
		int[] temp= new int[nums.length-1];
		int copyIndex=0;
		for(int i=0;i<nums.length;i++){
			if(i!=index){
				temp[copyIndex]=nums[i];
				copyIndex++;
			}
		}
		return temp;
	}

}
