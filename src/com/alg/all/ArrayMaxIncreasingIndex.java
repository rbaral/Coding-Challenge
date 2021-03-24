/**
Given an array arr[], find the maximum j – i such that arr[j] > arr[i].
Examples :

  Input: {34, 8, 10, 3, 2, 80, 30, 33, 1}
  Output: 6  (j = 7, i = 1)

  Input: {9, 2, 3, 4, 5, 6, 7, 8, 18, 0}
  Output: 8 ( j = 8, i = 0)

  Input:  {1, 2, 3, 4, 5, 6}
  Output: 5  (j = 5, i = 0)

  Input:  {6, 5, 4, 3, 2, 1}
  Output: -1 
*/
import java.util.*;

public class ArrayMaxIncreasingIndex{
	
	/**
	Method 1:
	-use two nested loops and for each possible pairs, check if they satisfy a[i]<a[j], if so, record the j-i
	-whenever a pair with greater j-i is found, update the max value 
	O(n^2), Space O(1)
	*/
	public static int findMaxIncreasingIndex1(int[] nums){
		int maxdiff = -1;
		for(int i=0; i<nums.length; i++){
			for(int j=i+1; j<nums.length; j++){
				if(nums[j]>nums[i] &&(j-i)>maxdiff){
					maxdiff = j-i;
				}
			}
		}
		return maxdiff;
	}
	
	/**
	Method 2
	-REf: https://www.geeksforgeeks.org/given-an-array-arr-find-the-maximum-j-i-such-that-arrj-arri/
	-we store the min on left side using an auxiliary array, min[i] holds the minimum on left side of nums[i]
	-we store the max on the right side using an auxiliary array, max[i] holds the maximum on right side of nums[i]
	-
	
	O(n), Space O(n)
	*/
	public static int findMaxIncreasingIndex2(int[] nums){
		int max = -1;
		int[] Lmin = new int[nums.length];
		int[] Rmax = new int[nums.length];
		Lmin[0] = nums[0];
		Rmax[nums.length-1] = nums[nums.length-1];
		for(int i=1; i<nums.length; i++){
			Lmin[i] = Math.min(Lmin[i-1], nums[i]);
		}
		
		for(int j = nums.length-2; j>=0;j--){
			Rmax[j] = Math.max(Rmax[j+1], nums[j]);
		}
		
		//now iterate through the leftmin and rightmax array and check the point where lmin<rmax, that point gives one potential window we are looking for
		int i = 0;
		int j = 0;
		while(i<nums.length && j<nums.length){
			//if this gives a window, retain the max of the window so far
			if(Lmin[i]<Rmax[j]){
				max = Math.max(max, j-i);
				j++;
			}else{
				//the left of lmin[i] can be even greater, so lets look on the right side of lmin
				i++;
			}
		}
		return max;
	}
	
	public static void main(String[] args){
		int[] nums = {34, 8, 10, 3, 2, 80, 30, 33, 1};
		System.out.println(findMaxIncreasingIndex1(nums));
		System.out.println(findMaxIncreasingIndex2(nums));
		nums = new int[]{9, 2, 3, 4, 5, 6, 7, 8, 18, 0};
		System.out.println(findMaxIncreasingIndex1(nums));
		System.out.println(findMaxIncreasingIndex2(nums));
		nums = new int[]{1, 2, 3, 4, 5, 6};
		System.out.println(findMaxIncreasingIndex1(nums));
		System.out.println(findMaxIncreasingIndex2(nums));
		nums = new int[]{6, 5, 4, 3, 2, 1};
		System.out.println(findMaxIncreasingIndex1(nums));
		System.out.println(findMaxIncreasingIndex2(nums));
		
	}

}