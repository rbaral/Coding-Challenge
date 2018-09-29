/**
Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

Example 1:

Input: [3,2,1,5,6,4] and k = 2
Output: 5
Example 2:

Input: [3,2,3,1,2,4,5,5,6] and k = 4
Output: 4
Note: 
You may assume k is always valid, 1 ≤ k ≤ array's length.
*/
import java.util.PriorityQueue;
import java.util.Arrays;
import java.util.Comparator;

public class ArrayKthLargestElement{

	/**
	Method1:
	-use max heap to store the elements
	-pop k-1 elements from the heap
	-the top element of the heap is the desired answer
	*/
	public static int findKthLargest1(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(1, new Comparator<Integer>(){
			@Override
			public int compare(Integer o1, Integer o2){
				return o2 - o1; //for min heap use default constructor or use O1 - O2 in comparator
			}
		});
		//insert all elements into max heap
		for(int i:nums){
			pq.offer(i);
		}
		//now pop and remove k-1 elements, then the peek of the heap will be the kth max element
		for(int i=0;i<k-1;i++){
			pq.poll();
		}
		return pq.peek();
    }
	
	/**
	Method2:
	-sort the elements using some sorting algorithm
	-return the kth element from the sorted array
	O(nlogn) if efficient sorting algorithm is used
	*/
	public static int findKthLargest2(int[] nums, int k){
		Arrays.sort(nums);
		return nums[nums.length-1-(k-1)];
	}
	
	public static void main(String args[]){
		int[] nums = new int[] {3,2,1,5,6,4};
		int k = 2;
		//nums = new int[] {3,2,3,1,2,4,5,5,6};
		//k = 4;
		System.out.println(k+" th largest element in:" +Arrays.toString(nums)+" is:"+findKthLargest1(nums, k));
		System.out.println(k+" th largest element in:" +Arrays.toString(nums)+" is:"+findKthLargest2(nums, k));
	}
}