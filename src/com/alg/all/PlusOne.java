/**
Given a non-empty array of digits representing a non-negative integer, plus one to the integer.

The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.

You may assume the integer does not contain any leading zero, except the number 0 itself.

Example 1:

Input: [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.
Example 2:

Input: [4,3,2,1]
Output: [4,3,2,2]
Explanation: The array represents the integer 4321.
*/

/**
NOTE:
this question is either incomplete or has incorrect test cases:
For the input {-1,1,2} the question expects output to be {1,9,1,3} which is quite weird, so I did not complete it.
*/
import java.util.Arrays;

public class PlusOne{
	
	/**
	Method1:
	-simply iterate the array from end to begin and keep on tracking the sum and the carry
	*/
	public static int[] getPlusOne(int[] nums){
		int carry = 1;//the carry 1 at the beginning is equivalent to adding one to the whole digit
		for(int i=nums.length-1; i>=0; i--){
			nums[i] = nums[i] + carry;
			carry = nums[i]>9?1:0;
			nums[i] = nums[i]%10;
		}
		//if the carry is still non-zero, we need to have an additional element at the begining of the array
		if(carry>0){
			int[] res = new int[nums.length + 1];
			int index = 0;
			res[index] = 1;
			index++;
			for(int val:nums){
				res[index] = nums[index-1];
				index++;
			}
			return res;
		}
		return nums;
	}
	
	public static void main(String args[]){
		int[] nums = new int[]{4,3,2,2};
		nums = new int[] {9,9};
		int[] nums1 = getPlusOne(nums);
		System.out.println(" plus one array is:"+Arrays.toString(nums1));
	}
}