/**
Given an array of n elements which contains elements from 0 to n-1, with any of these numbers appearing any number of times. Find these repeating numbers in O(n) and using only constant memory space.
For example, let n be 7 and array be {1, 2, 3, 1, 3, 6, 6}, the answer should be 1, 3 and 6.
*/
import java.util.*;

public class ArrayDuplicate{

	/**
	Method1:
	sort the array and keep on iterating the array to check if consecutive elements are duplicate
	O(nlogn)
	
	Can we do better? Can we do it in O(n) and constant space
	Use the concept of storing the negative value in abs[nums[i]] index, this is valid because we are given the range of elements between 0 to n-1
	
	// when find a number i, flip the number at position i-1 to negative. 
    // if the number at position i-1 is already negative, i is the number that occurs twice.
	Ref:https://leetcode.com/problems/find-all-duplicates-in-an-array/discuss/92387/Java-Simple-Solution
	*/
	public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i) {
            int index = Math.abs(nums[i])-1;
            if (nums[index] < 0)
                res.add(Math.abs(index+1));
            nums[index] = -nums[index];
        }
        return res;
    }
	
	
	public static void main(String args[]){
		int[] nums = new int[]{1, 2, 3, 1, 3, 6, 6};
		int n = 7;
		//nums = new int[]{4,3,2,7,8,2,3,1};
		List<Integer> dups = findDuplicates(nums);
		for(int i:dups){
			System.out.print(i+" ");
		}
		
	}

}