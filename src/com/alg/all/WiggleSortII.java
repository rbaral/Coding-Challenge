/**
Wiggle SortII

Given an unsorted array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....

Example 1:

Input: nums = [1, 5, 1, 1, 6, 4]
Output: One possible answer is [1, 4, 1, 5, 1, 6].
Example 2:

Input: nums = [1, 3, 2, 2, 3, 1]
Output: One possible answer is [2, 3, 1, 3, 1, 2].
Note:
You may assume all input has valid answer.

Follow Up:
Can you do it in O(n) time and/or in-place with O(1) extra space?
*/
import java.util.Arrays;

public class WiggleSortII{

	/**
	Method1:
	sort the elements and find the median, operate to maintain the following constraints
	--the numbers less than median go to the last even index
	--the numbers greater than median go to the first odd index
	--the median goes to the remaining index
	-iterate through out the array and check the above constraint to swap the element to the correct position
	*/
	public static void wiggleSort1(int[] nums) {
		//base cases
		if(nums==null ||nums.length<2){
			return;
		}
		//now iterate through the elements in array and swap according to the above constraints
		int left = 0, right = nums.length-1, i = 0, n = nums.length;
		int median = findKthLargestElement(nums, (n+1)/2);
		while(i<=right){
			if(nums[newIndex(i, n)]>median){//bring the larger than median values to first odd slots
				swap(nums, newIndex(left++, n), newIndex(i++, n));
			}else if(nums[newIndex(i, n)]<median){
				swap(nums, newIndex(right--, n), newIndex(i, n));//bring the smaller than median values to the last even slots
			}else{
				i++;
			}
		}
	}
	
	//swap the items in the given indices
	public static void swap(int[] nums, int i, int j){
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	
	public static int newIndex(int index, int n){
		return (1+2*index)%(n|1);
	}
	
	//given an array, find the kth largest element
	public static int findKthLargestElement(int[] nums, int k){
		Arrays.sort(nums);
		return nums[nums.length -1-(k-1)];
	}
	
	
	public static void main(String[] args){
		int arr[] = {10, 5, 6, 3, 2, 20, 100, 80};
		arr = new int[]{1, 5, 1, 1, 6, 4};
		arr = new int[]{4,5,5,6};
		System.out.println("before:"+Arrays.toString(arr));
		wiggleSort1(arr);
		System.out.println("after:"+Arrays.toString(arr));
	}
	
}