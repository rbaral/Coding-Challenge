/**
Given an array A of non-negative integers, return an array consisting of all the even elements of A, followed by all the odd elements of A.

You may return any answer array that satisfies this condition.

 

Example 1:

Input: [3,1,2,4]
Output: [2,4,3,1]
The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
*/
import java.util.*;

public class ArrayParityOrdering{

	/**
	-Method1
	-iterate through the array and store the even and odd elements in separate list
	-later populate the result using the separte odd and even lists
	O(n) time, Space O(n)
	
	Can we do better?
	Method2
	-use two pointers one at start and another at end
	-if the element at start pointer is even, advance the start index
	-if the element at end pointer is odd, advance the end index
	-if the order is violated, swap the elements at start and end index
	-repeat till start<end
	*/
	public static int[] getParityOrdering(int[] nums){
		//base case
		if(nums==null || nums.length<2){
			return nums;
		}
		int start = 0, end = nums.length - 1;
		//advance the start and end index, if they satisfy the order, else swap the items at two end
		while(start<end){
			if(nums[start]%2==0){
				start++;
				continue;
			}
			if(nums[end]%2!=0){
				end--;
				continue;
			}
			//swap the items at start and end index
			int temp = nums[start];
			nums[start] = nums[end];
			nums[end] = temp;
		}
		return nums;
	}
	
	public static void main(String args[]){
		int[] nums = new int[]{3,1,2,4};
		System.out.println(Arrays.toString(nums)+" is sorted as:"+Arrays.toString(getParityOrdering(nums)));
	}
}