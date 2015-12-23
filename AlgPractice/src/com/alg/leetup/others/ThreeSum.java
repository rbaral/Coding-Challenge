package com.alg.leetup.others;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class ThreeSum {
	
	public static void main(String[] args) {
		DateFormat format = new SimpleDateFormat("YYYY-M-d:H:m:s:S");
		System.out.println(format.format(new Date()));
		int nums[]=new int[]{13,-5,3,3,-1,13,3,1,-9,-4,9,12,6,-9,-6,-12,-8,3,12,14,4,-15,2,-11,4,-12,10,9,-6,-3,-8,14,7,3,2,-8,-7,-10,8,-8,-7,-6,-11,6,-7,-2,9,-8,8,-2,13,-10,-2,0,-14,-13,-4,11,3,-3,-7,3,-4,8,13,13,-15,-9,10,0,-2,-12,1,2,9,1,8,-4,8,-7,9,7,-2,-15,14,0,-13,-13,-12,-2,-1,-11,8,10,12,6,8,4,12,3,11,-12,-2,-3,5,-15,6,-10,-4,-1,-1,-10,13};//{-1, 0, 1, 2, -1, -4};
		List<List<Integer>> triplets=threeSum(nums);
		for(List l:triplets){
		System.out.println(Arrays.toString(l.toArray()));
		}
		System.out.println(format.format(new Date()));

	}

	public static List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> answer = new LinkedList<List<Integer>>();
		if (nums.length < 3) {
			return answer;
		}
		Arrays.sort(nums);
		int find = 0;
		int prev_i = nums[0] - 1;
		for (int i = 0; i < nums.length - 2; i++) {
			if ((prev_i != nums[0] - 1) && (nums[i] == prev_i)) {
				continue;
			}
			prev_i = nums[i];
			int prev_j = nums[0] - 1;
			for (int j = i + 1; j < nums.length - 1; j++) {
				if ((prev_j != nums[0] - 1) && (nums[j] == prev_j)) {
					continue;
				}
				prev_j = nums[j];
				find = -(nums[i] + nums[j]);
				int prev_k = nums[0] - 1;
				for (int k = nums.length - 1; k > j; k--) {
					if ((prev_k != nums[0] - 1) && (find == prev_k)) {
						continue;
					}
					if (nums[k] == find) {
						List<Integer> solSet = new LinkedList<Integer>();
						solSet.add(nums[i]);
						solSet.add(nums[j]);
						solSet.add(nums[k]);
						answer.add(solSet);
						prev_k = find;
					} else if (find > nums[k]) {
						break;
					}
				}
			}
		}
		return answer;
	}

	}

