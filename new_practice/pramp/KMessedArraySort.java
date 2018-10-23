/**
#K-Messed Array Sort

Given an array arr of length n where each element is at most k places away from its sorted position,

Plan and code an efficient algorithm to sort arr.

Analyze the runtime and space complexity of your solution.

Given an array of n elements, where each element is at most k away from its target position, devise an algorithm that sorts in O(n log k) time. 

Input : arr[] = {6, 5, 3, 2, 8, 10, 9}
            k = 3 
Output : arr[] = {2, 3, 5, 6, 8, 9, 10}

Input : arr[] = {10, 9, 8, 7, 4, 70, 60, 50}
         k = 4
Output : arr[] = {4, 7, 8, 9, 10, 50, 60, 70}
*/
import java.util.*;

public class KMessedArraySort{

	/**
	Method1: - use other sorting algorithm to sort the array , it taks O(nlogn), but this is trivial and is not what is asked by the question
	Method2: use min heap
	-push first k+1 elements in the heap, so that we get the first element in its correct position
	-pop the smallest element from heap and insert into the beginning of the array
	-keep on adding the other elements to the heap and retrieving the smaller element from it and adding it to the array
	O(logk) where k is the given value, Space O(k) because we have heap of size k at a time
	*/
	public static void sortMessedArray(int[] nums, int k){
		//base cases
		if(nums==null || nums.length<1 || nums.length<k){
			return;
		}
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		//push the first k+1 elements into the heap
		for(int i=0;i<=k; i++){
			pq.add(nums[i]);
		}
		int index = 0;
		//now keep on retrieving the smallest from heap and adding it to the array
		for(int j = k+1; j<nums.length; j++){
			//get the smallest from heap and add it to the array
			nums[index++] = pq.poll();
			pq.add(nums[j]);
		}
		//retrieve the remaining elements from the heap and add it to the array
		while(pq.size()>0){
		nums[index++] = pq.poll();
		}
	}

	public static void main(String []args){
		int [] nums = new int[] {6, 5, 3, 2, 8, 10, 9};
		int k = 3;
		System.out.println("org array is:"+Arrays.toString(nums));
		sortMessedArray(nums, k);
		System.out.println("sorted array is:"+Arrays.toString(nums));
		
	}
}