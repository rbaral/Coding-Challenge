/**
ContiguousSubArrayWithSumK: 

Given an unsorted array of nonnegative integers, find a
  continous subarray which adds to a given number.
 
  Examples:
 
  Input: arr[] = {1, 4, 20, 3, 10, 5}, sum = 33 Ouptut: Sum found between
  indexes 2 and 4
 
  Input: arr[] = {1, 4, 0, 0, 3, 10, 5}, sum = 7 Ouptut: Sum found between
  indexes 1 and 4
 
  Input: arr[] = {1, 4}, sum = 0 Output: No subarray found
 
*/
import java.util.*;

public class ContiguousSubArrayWithSumK{

	/**
	Method1: use two nested loops and for ever possible subarray check if the target sum is found
	O(n^2), O(1) Space
	*/
	public static int[] findSubArrayWithKSum1(int[] nums, int k){
		//handle base cases
		int[] ind = new int[2];
		ind[0]= -1;
		ind[1] = -1;
		int sum = 0;
		for(int i=0;i<nums.length; i++){
			sum = nums[i];
			for(int j = i+1; j<nums.length; j++){
				sum+=nums[j];
				if(sum>k){
					break;
				}
				if(sum==k){
					ind[0] = i;
					ind[1] = j;
					return ind;
				}
			}
		}
		return ind;
	}
	
	/**
	Method2:
	-accumulate the current sum to a variable and keep on iterating over the given array
	-if accumulated sum equals the given sum, return the indices
	-if accumulated sum is greater than the given sum, subtract the earlier values (staring from the beginning of array) until the accumulates sum becomes less than or equal to the given sum
	-add the current element to the acumulated sum
	O(n) time, Space: O(1)
	NOTE: it only works for positive numbers
	*/
	public static int[] findSubArrayWithKSum2(int[] nums, int k){
		int cursum = nums[0];
		int start = 0;
		int[] ind = new int[2];
		ind[0]= -1;
		ind[1] = -1;
		for(int i=1;i<nums.length; i++){
			while(cursum>k && start<i-1){
				cursum-=nums[start++];
			}
			if(cursum==k){//found one
				ind[0] = start;
				ind[1] = i-1;
				return ind;
			}
			//add the current item to the sum
			cursum+=nums[i];
		}
		return ind;
	}
	
	/**
	Method3: using hashmap
	-take the curent sum and check if k-cursum is present in the hash, if not, push it into a hash
	-O(n), Space O(n)
	*/
	public static int[] findSubArrayWithKSum3(int[] nums, int k){
		int cursum = 0;
		int[] ind = new int[2];
		ind[0] = -1;
		ind[1] = -1;
		HashMap<Integer, Integer> summap = new HashMap<Integer, Integer>();
		for(int i=0;i<nums.length; i++){
			cursum+=nums[i];
			if(!summap.containsKey(cursum-k)){
				summap.put(cursum, i);
			}else{
				//found one
				System.out.println("for array "+Arrays.toString(nums)+" the sum:"+k+" is found the sum between:"+summap.get(k-cursum)+" and:"+i);
				ind[0] = summap.get(cursum-k) + 1;
				ind[1] = i;
				return ind;
			}
		}
		return ind;
	}
	
	
	public static void main(String[] args){
		int[] arr = new int[] {1, 4, 20, 3, 10, 5};
		int k =33;
		System.out.println(Arrays.toString(arr)+" has sum of:"+k+" within:"+Arrays.toString(findSubArrayWithKSum1(arr, k)));
		System.out.println(Arrays.toString(arr)+" has sum of:"+k+" within:"+Arrays.toString(findSubArrayWithKSum2(arr, k)));
		System.out.println(Arrays.toString(arr)+" has sum of:"+k+" within:"+Arrays.toString(findSubArrayWithKSum3(arr, k)));
		arr = new int[]{1, 4, 0, 0, 3, 10, 5};
		k = 7;
		System.out.println(Arrays.toString(arr)+" has sum of:"+k+" within:"+Arrays.toString(findSubArrayWithKSum1(arr, k)));
		System.out.println(Arrays.toString(arr)+" has sum of:"+k+" within:"+Arrays.toString(findSubArrayWithKSum2(arr, k)));
		System.out.println(Arrays.toString(arr)+" has sum of:"+k+" within:"+Arrays.toString(findSubArrayWithKSum3(arr, k)));
		arr = new int[]{1, 4};
		k = 0;
		System.out.println(Arrays.toString(arr)+" has sum of:"+k+" within:"+Arrays.toString(findSubArrayWithKSum1(arr, k)));
		System.out.println(Arrays.toString(arr)+" has sum of:"+k+" within:"+Arrays.toString(findSubArrayWithKSum2(arr, k)));
		System.out.println(Arrays.toString(arr)+" has sum of:"+k+" within:"+Arrays.toString(findSubArrayWithKSum3(arr, k)));
	}
}