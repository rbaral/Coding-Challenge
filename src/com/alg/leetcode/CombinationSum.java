/**
 * Given a set of candidate numbers (C) and a target number (T), 
 * find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, � , ak) must be in non-descending order. (ie, a1 &le; a2 &le;  &le; ak).
The solution set must not contain duplicate combinations.
For example, given candidate set 2,3,6,7 and target 7, 
A solution set is: 
[7] 
[2, 2, 3] 
 */
package com.alg.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author rbaral
 *
 */
public class CombinationSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int candidates[] = new int[]{2,3,6,7};
		int target = 7;
		//candidates = new int[]{1,2};
		//target = 3;
		List<List<Integer>> results = combinationSum(candidates, target);
		for(List<Integer> result:results){
			System.out.println(Arrays.toString(result.toArray()));
		}
	}
	
	/**
	 * finds the combination sum for the target in the array with positive numbers
	 * @param candidates
	 * @param target
	 * @return
	 */
	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		//base case, if target is 0, then we can get division by zero error
		if(target==0){
	           result.add(new ArrayList<Integer>());
	           return result;
	     }else if(target<0){
	    	 return result;//return empty
	     }
		
		int quot =0;//keep track of quotient
		int rem = 0;//keep track of reminder
		int count =0;
		List<Integer> combination = new ArrayList<Integer>();
		for(int i=0;i<candidates.length;i++){
			if(target%candidates[i]==0){
				quot = target/candidates[i];
				count =0;
				combination = new ArrayList<Integer>();
				while(count<quot){
					combination.add(candidates[i]);
					count++;
				}
				Arrays.sort(combination.toArray());
				if(!result.contains(combination))
					result.add(combination);
			}else{
				rem = target%candidates[i];
				quot = target/candidates[i];
				//check if we can get the reminder or (candidates[i]+reminder) from other numbers
				for(int j=0;j<candidates.length;j++){
					if(rem == candidates[j]){//we found the combination
						count = 0;
						combination = new ArrayList<Integer>();
						combination.add(rem);
						while(count<quot){
							combination.add(candidates[i]);
							count++;
						}
						if(!result.contains(combination))
							result.add(combination);
					}else if(candidates[j]==(candidates[i]+rem)){
						count = 0;
						combination = new ArrayList<Integer>();
						while(count<(quot-1)){
							combination.add(candidates[i]);
							count++;
						}
						combination.add(candidates[j]);
						if(!result.contains(combination))
							result.add(combination);
					}
				}
				
			}
		}
		return result;
    }

}
