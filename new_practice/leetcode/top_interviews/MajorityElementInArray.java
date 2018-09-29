/**
Given an array of size n, find the majority element. 
The majority element is the element that appears more than n/2 times.

You may assume that the array is non-empty and the majority element always exist in the array.

Example 1:

Input: [3,2,3]
Output: 3
Example 2:

Input: [2,2,1,1,1,2,2]
Output: 2
*/
import java.util.Map;
import java.util.HashMap;

public class MajorityElementInArray{

	/**
	-as given in question, we assume that the array is non-empty and the majority element always exists in the array
	-we can use additional storage (e.g., hashmap) to keep the count of elements as they appear in the iteration
	-whenever the count reaches n/2 we can return or we can do second round of iteration of the hashmap to find the majority element
	O(n), Space: O(n)
	*/
	public static int getMajority1(int[] arr){
		//TODO:base case
		int majorityCount = arr.length/2;
		Map<Integer, Integer> counts = new HashMap<Integer, Integer>();
		for(Integer i:arr){
			counts.put(i, counts.getOrDefault(i,0)+1);
			if(counts.get(i)>majorityCount){
				return i;
			}
		}
		return 0;
	}
	/**
	-we assume the first element is the candidate for the majority and iterate through the elements of the array starting at index 1
	-if the current element of the array is equal to the assumed candidate, we increase the count
	-if the current element of the array differs than the candidate, we decrease the count and wait till it reaches zero because we haven't found any element with more count than the previously assumed candidate
	-if the count reaches zero, we assume the current iteration element as the new candidate and repeat
	O(n), Space O(1)
	*/
	public static int getMajority2(int[] nums){
		int count = 1;
		int candidate = nums[0];
		for(int i=1; i<nums.length; i++){
			if(count==0){
				candidate = nums[i];
			}
			if(nums[i] == candidate){
				count++;
			}else{
				count--;
			}
		}
		return count>=nums.length/2?candidate:0;
	}
	
	public static void main(String args[]){
		int arr [] = new int[]{3,2,3};
		//arr = new int[]{2,2,1,1,1,2,2};
		//arr = new int[] {3,3,4};
		System.out.println("Majority element from method1 is:"+getMajority1(arr));
		System.out.println("Majority element from method2 is:"+getMajority2(arr));
		System.out.println("Majority element from method2 is:"+getMajority1(new int[]{1,2,3,4,5,5,5,7}));
		System.out.println("Majority element from method2 is:"+getMajority2(new int[]{1,2,3,4,5,5,5,7}));
	}
}