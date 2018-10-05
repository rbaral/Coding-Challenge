/**
Given an array A of non-negative integers, return an array consisting of all the even elements of A, followed by all the odd elements of A.

You may return any answer array that satisfies this condition.

 

Example 1:

Input: [3,1,2,4]
Output: [2,4,3,1]
The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
*/
import java.util.*;

public class ArraysEvenOddSorting{
	
	/**
	Method1:
	-store the even elements in one list
	-store the odd elements in another list
	-combine the two lists to get the required order
	O(n), Space: O(n)
	*/
	public static int[] sortArrayByParity1(int[] A) {
        List<Integer> odds = new ArrayList<>();
		List<Integer> evens = new ArrayList<>();
		for(int i: A){
			if(i%2==0){
				evens.add(i);
			}else{
				odds.add(i);
			}
		}
		int index = 0;
		while(index<evens.size()){
			A[index] = evens.get(index);
			index++;
		}
		for(int i=0;i<odds.size();i++){
			A[index++] = odds.get(i);
		}
		return A;
    }
	
	/**
	Method2:
	-use two pointers start and end that point to the start and end of the array and check if the
	start element is even or not, if it is even, advance start, if not then swap the two items
	*/
	public static int[] sortArrayByParity2(int[] nums){
		//base case
		if(nums==null ||nums.length<2){
			return nums;
		}
		int start = 0, end = nums.length-1;
		int nexteven = 0, nextodd = nums.length-1;
		while(start<end){
			if(nums[start]%2==0){
				start++;
				continue;
			}
			if(nums[end]%2!=0){
				end--;
				continue;
			}
			//swap the items between start and end index
			int temp = nums[end];
			nums[end] = nums[start];
			nums[start] = temp;
			start++;
			end--;
		}
		return nums;
	}
	
	public static void main(String[] args){
		int[] nums = new int[]{3,1,2,4};
		System.out.println("result is:"+Arrays.toString(sortArrayByParity1(nums)));
		System.out.println("result is:"+Arrays.toString(sortArrayByParity2(nums)));
	}
}