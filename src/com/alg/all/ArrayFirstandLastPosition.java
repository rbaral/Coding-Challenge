/**
Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
*/
import java.util.*;

public class ArrayFirstandLastPosition{
	
	/**
	first perform binary search to locate the element, if any
	then iterate on back and forward index, till the duplicate of the item previously found occur
	O(logn) due to the usage of binary search, Space is O(1)
	*/
	public static int[] searchRange(int[] nums, int tar) {
		int[] res = new int[2];
		res[0] = -1;
		res[1] = -1;
		//base cases
		if(nums==null || nums.length<1){
			return res;
		}
		int start = 0, end = nums.length-1;
		int mid = (start+end)/2;
		while(start<=end){
			mid = (start+end)/2;
			if(nums[mid]==tar){//found one, record its index
				res[0] = mid;
				res[1] = mid;
				break;
			}else if(nums[mid]<tar){
				start = mid+1;
			}else{
				end = mid-1;
			}
		}
		//if we have found the index, then check the neighbors
		while(res[0]!=-1 && res[0]>0 && nums[res[0]-1]==tar){
			res[0]-=1;
		}
		while(res[1]!=-1 && res[1]<nums.length-1 && nums[res[1]+1]==tar){
			res[1]+=1;
		}
		return res;
    }
	
	public static void main(String[] args){
		int[] arr = new int[]{5,7,7,8,8,10};
		int tar = 8;
		System.out.println(tar+" in :"+Arrays.toString(arr)+" is from:"+Arrays.toString(searchRange(arr, tar)));
		arr = new int[]{5,7,7,8,8,10};
		tar = 6;
		System.out.println(tar+" in :"+Arrays.toString(arr)+" is from:"+Arrays.toString(searchRange(arr, tar)));
		arr = new int[]{1,3};
		tar = 1;
		System.out.println(tar+" in :"+Arrays.toString(arr)+" is from:"+Arrays.toString(searchRange(arr, tar)));
		arr = new int[]{1};
		tar = 1;
		System.out.println(tar+" in :"+Arrays.toString(arr)+" is from:"+Arrays.toString(searchRange(arr, tar)));
		arr = new int[]{};
		tar = 1;
		System.out.println(tar+" in :"+Arrays.toString(arr)+" is from:"+Arrays.toString(searchRange(arr, tar)));
	}
}