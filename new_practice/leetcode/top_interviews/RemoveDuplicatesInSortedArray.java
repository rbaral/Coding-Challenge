/**
Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.

Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

Example 1:

Given nums = [1,1,2],

Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.

It doesn't matter what you leave beyond the returned length.
Example 2:

Given nums = [0,0,1,1,1,2,2,3,3,4],

Your function should return length = 5, with the first five elements of nums being modified to 0, 1, 2, 3, and 4 respectively.

It doesn't matter what values are set beyond the returned length.
Clarification:

Confused why the returned value is an integer but your answer is an array?

Note that the input array is passed in by reference, which means modification to the input array will be known 
to the caller as well.

Internally you can think of this:

// nums is passed in by reference. (i.e., without making a copy)
int len = removeDuplicates(nums);

// any modification to nums in your function would be known by the caller.
// using the length returned by your function, it prints the first len elements.
for (int i = 0; i < len; i++) {
    print(nums[i]);
}
*/
import java.util.Arrays;

public class RemoveDuplicatesInSortedArray{
	
	/**
	Method1:
	-we check the consecutive elements and if they are duplicate then keep count of the duplicates and advancing the index
	-bring the other elements forward as many times as the number of duplicates were detected earlier
	-copy the duplicates at the end
	O(n^2): o(n) for each element and O(n) for shifting all the elements from end to forward
	*/
	public static int removeDuplicates1(int[] nums) {
        int startindex = 0;//the starting index to bring items to front
		int endindex = 0;// the end index to bring items to front
		int dupcount = 0;//the duplicates count for an item
		int totdupcount = 0;
		for(int i=0;i<nums.length-1-totdupcount; i++){
			while(i<nums.length-1-totdupcount && nums[i]==nums[i+1]){//keep track of the duplicates in consecutive position
				dupcount++;
				i++;
			}
			
			totdupcount+=dupcount;
			//now bring dupcount elements into front
			startindex = i-dupcount;// +1;
			endindex = 0;
			System.out.println("for item: "+nums[i]+" start index is:"+startindex+" dupcount is:"+dupcount);
			System.out.println("arr is:"+Arrays.toString(nums));
			while((startindex+dupcount)<nums.length){
				nums[startindex] = nums[startindex+dupcount];
				startindex++;
			}
			if(dupcount>0)
				i-=dupcount;
			dupcount=0;
		}
		return nums.length-totdupcount;
    }
	
	/**
	Method2
	-we use two pointers and keep track of duplicates and shifting of the elements
	O(n)
	*/
	public static int removeDuplicates2(int[] nums){
		//base case
		if(nums==null)
			return 0;
		if(nums.length<2){
			return nums.length;
		}
		int start = 0;
		int end = 1;
		int dupcount=0;
		while(end<nums.length){
			if(nums[start]==nums[end]){
				end++;
				dupcount++;
			}else{
				//do the shifting of the duplicates detected so far
				nums[++start] = nums[end++];
			}
		}
		return nums.length - dupcount;
		
	}
	
	public static void main(String args[]){
		int nums[] = new int[]{1,1,2};
		//nums = new int[]{0,0,1,1,1,2,2,3,3,4};
		nums = new int[]{0,0,1,1,1,1,3,3,3,3,3};
		int newlen = removeDuplicates1(nums);
		System.out.println("new array1 is:"+Arrays.toString(nums)+" nondup array length is:"+newlen);
		newlen = removeDuplicates2(nums);
		System.out.println("new array2 is:"+Arrays.toString(nums)+" nondup array length is:"+newlen);
	}
}