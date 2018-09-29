/**
 * Given an array of integers, find two numbers such that they add up to a specific target number.
 *
 * The function twoSum should return indices of the two numbers such that they add up to the target,
 * where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
 *
 * You may assume that each input would have exactly one solution.
 *
 * Input: numbers={2, 7, 11, 15}, target=9
 * Output: index1=1, index2=2
 */
package com.alg.leetup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * Solution 1:
 * 1) use two nested loops and check if there is a sum that gets the target and index is greater
 * 
 * Complexity: O(n^2)
 * 
 * 
 * Solution 2:
 * If we don't have the array sorted:
 * 1)simply scan all the elements of the array and add them to hash (element, index in array)
 * 2)in second pass, again scan the elements and check if (target-current element) is found in hash and the index of the found element is greater than the current one
 * 2 a) if found and index is greater, return the two indices (1 based indices)
 * 2 b) if not found or index is not greater, then continue with another array element
 * 
 * Complexity: O(n)
 * 
 * @author rbaral
 *
 */
public class TwoSum {

    public static int[] twoSum1(int[] nums, int target) {
        List<Integer> keysList = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            keysList.add(nums[i]);
        }
        int diff = 0;
        int indices[] = new int[2];
        indices[0] = -1;
        indices[1] = -1;
        for (int j = 0; j < nums.length; j++) {
            diff = target - nums[j];
            if (diff == nums[j]) {
                keysList.remove(Integer.valueOf(nums[j]));//to exclude itself from comparison, for cases like 2+2=4
            }
            if (keysList.contains(diff)) {
                System.out.println("Target:" + target + " found at:" + j);
                indices[0] = j + 1;
                break;
            }
            //get back to original state
            if (diff == nums[j]) {
                keysList.add(nums[j]);
            }
        }
        //find the second index by iterating the array
        for (int k = 0; k < nums.length; k++) {
            if (nums[k] == diff) {
                indices[1] = k + 1;
                //break;
            }
        }
        return indices;
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] indices = new int[2];
        indices[0] = -1; indices[1] = -1;
        Map<Integer,Integer> diffMap = new HashMap<Integer,Integer>();
        int index = 0;
        for(Integer num:nums){
            index++;
            diffMap.put(target - num,index);
        }
        for(int i=0;i<nums.length;i++){
            if(diffMap.containsKey(nums[i]) && (i+1)<diffMap.get(nums[i])){
                indices[0] = i+1;
                indices[1] = diffMap.get(nums[i]);
            }
        }
        return indices;
    }

    public static void main(String args[]) {
        int[] nums = new int[]{7, 7, 1, 2, 15};
        int target = 9;
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }
}
