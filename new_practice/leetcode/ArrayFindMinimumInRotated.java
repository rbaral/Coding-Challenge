/**
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).

Find the minimum element.

You may assume no duplicate exists in the array.

Example 1:

Input: [3,4,5,1,2] 
Output: 1
Example 2:

Input: [4,5,6,7,0,1,2]
Output: 0
*/
public class ArrayFindMinimumInRotated{

	/**
	-use binary search
	-find the peak from where the sorted order is violated, this gives the two halves of the array
	-if the peak is in the middle, then the smallest element will be just after the peak
	-if the peak is at the end, then the smallest element is at 0 index
	-we assume there is no duplicate
	*/
	public static int findMin(int[] nums) {
        //base cases
		if(nums==null || nums.length<1){
			return -1;
		}
		int index = 0;
		int start = 0, end = nums.length;
		while((index+1)<end && nums[index]<nums[index+1]){
			index++;
		}
		//now if the index is at the middle, then the smallest will be just after the index
		if(index<end-1){
			return nums[index+1];
		}else{
			return nums[0];
		}
    }

	public static void main(String[] args){
		 int[] nums = {4,5,6,7,0,1,2};
		 System.out.println("min is found as:"+findMin(nums));
		 nums = new int[]{3,4,5,1,2};
		 System.out.println("min is found as:"+findMin(nums));
		 nums = new int[]{1, 3};
		 System.out.println("min is found as:"+findMin(nums));
	 }

}