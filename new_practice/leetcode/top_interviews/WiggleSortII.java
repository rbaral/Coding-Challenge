/**
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
	-sort the given array
	-use two pointers start and end and swap the elements at index start and end till start<end
	-find the median of the numbers in the array
	-put the numbers larger than median in the early odd indices
	-put the numbers smaller than median in the later even indices
	-keep the medians intact
	*/
	public static void wiggleSort1(int[] nums) {
		if(nums==null || nums.length<2){
			return;
		}
		int n = nums.length;
		int median = findKthLargest(nums, (n+1)/2);
		int i = 0, right = n-1, left = 0;
		while(i<=right){
			if(nums[newIndex(i, n)]>median){
				//numbers greater than median are put in earlier odd indices
				swap(nums, newIndex(left++, n), newIndex(i++, n));
			}else if(nums[newIndex(i,n)]<median){
				//numbers less than median are moved to later even indices
				swap(nums, newIndex(right--, n), newIndex(i, n));
			}else{
				i++;
			}
		}
    }
	
	//find the kth largest element in an array
	public static int findKthLargest(int[] nums, int k){
		int[] a = Arrays.copyOf(nums, nums.length);
		Arrays.sort(a);
		return a[a.length-1-(k-1)];
	}
	
	//swap the numbers in index a and b
	public static void swap(int[] nums, int a, int b){
		int temp= nums[a];
		nums[a] = nums[b];
		nums[b] = temp;
	}
	
	public static int newIndex(int index, int n){
		return (1+2*index)%(n|1);
	}
	
	
	public static void main(String args[]){
		int[] nums = new int[]{1, 5, 1, 1, 6, 4};
		nums =  new int[] {1, 3, 2, 2, 3, 1};
		nums = new int[]{1,2,2,1,2,1,1,1,1,2,2,2};
		nums = new int[] {4,5,5,5,5,6,6,6};
		System.out.println("Wiggle sort of "+Arrays.toString(nums)+" is ");
		wiggleSort1(nums);
		System.out.println(Arrays.toString(nums));
	}

}