/**
Given a non-empty array of integers, every element appears twice except for one. Find that single one.

Note:

Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Example 1:

Input: [2,2,1]
Output: 1
Example 2:

Input: [4,1,2,1,2]
Output: 4
*/

/**
Method1:
-store the count of each number in a HashMap and in second iteration return the number with count 1
O(n), Space O(n)

Method2:
-do exclusive OR of all the numbers, the duplicates cancel out because the exclusive OR of a number with
itself is always zero. The non-duplicate or single number will be the left out.
O(n)
*/

public class SingleNumber{
	/**
	we can do exclusive or to filter out duplicate because exclusive or of a number to itself is always 0
	*/
	public static int singleNumber(int[] nums){
		int single = 0;
		for(Integer num:nums){
			single^=num;
		}
		return single;
	}
	
	public static void main(String args[]){
		int[] nums = new int[] {2,2,1, 1};
		int single = singleNumber(nums);
		System.out.println("single number is:"+single);
	}
}