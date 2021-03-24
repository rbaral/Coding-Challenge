/**
Design a class to find the kth largest element in a stream. Note that it is the kth largest element in the sorted order, not the kth distinct element.

Your KthLargest class will have a constructor which accepts an integer k and an integer array nums, which contains initial elements from the stream. For each call to the method KthLargest.add, return the element representing the kth largest element in the stream.

Example:

int k = 3;
int[] arr = [4,5,8,2];
KthLargest kthLargest = new KthLargest(3, arr);
kthLargest.add(3);   // returns 4
kthLargest.add(5);   // returns 5
kthLargest.add(10);  // returns 5
kthLargest.add(9);   // returns 8
kthLargest.add(4);   // returns 8
Note: 
You may assume that nums' length ≥ k-1 and k ≥ 1.
*/
import java.util.*;

class KthLargest {

	int k;
	PriorityQueue<Integer> pq;
	
	/**
	we build a priority queue or min heap and retain the order of elements in the heap
	*/
    public KthLargest(int kval, int[] nums) {
	   k = kval;
       pq = new PriorityQueue<Integer>();
	   //insert the array items into pq
	   for(int i=0; i<nums.length; i++){
		   add(nums[i]);
	   }
	}
    /**
	while adding, we check if the given val is smaller than the min element in the heap
	*/
    public int add(int val) {
		//if the heap has less than k elements
		if(pq.size()<k){
			pq.offer(val);
		}else if(pq.peek()<val){
			//else remove every element that is smaller than given val
			while(pq.size()>=k && pq.peek()<val){
				pq.poll();
			}
			//System.out.println("before adding:"+val+" peek is:"+pq.peek());
			pq.offer(val);
		}
		//now find the kth largest element by just popping the min element from the heap, because we always have k values in the heap
		//System.out.println("after adding:"+val+" peek is:"+pq.peek());
		return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
 
/**
Method1: use min heap=> O(k) space because we need to maintain at least k elements in the array

Method2: use max heap=>O(n) space because we don't bother of removing elements
*/
 
public class ArrayStreamKthLargest{
	
	public static void main(String args[]){
		int k = 3;
		int[] arr = {4,5,8,1};
		KthLargest kthLargest = new KthLargest(3, arr);
		System.out.println(kthLargest.add(3));// should return 4
		System.out.println(kthLargest.add(5));// should return 5
		System.out.println(kthLargest.add(10));// should return 5
		System.out.println(kthLargest.add(9));// should return 8
		System.out.println(kthLargest.add(4));// should return 8
	}
}