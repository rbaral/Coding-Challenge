/**
Given an array of integers, find out whether there are two distinct indices i and j in the array such that the absolute difference between nums[i] and nums[j] is at most t and the absolute difference between i and j is at most k.

Example 1:

Input: nums = [1,2,3,1], k = 3, t = 0
Output: true
Example 2:

Input: nums = [1,0,1,1], k = 1, t = 2
Output: true
Example 3:

Input: nums = [1,5,9,1,5,9], k = 2, t = 3
Output: false
*/
import java.lang.Integer;
import java.util.TreeSet;

public class ArrayDuplicatesIII{

	/**
	Method1:
	-use two nested loops
	O(n^2)
	*/
	public static boolean containsNearbyAlmostDuplicate1(int[] nums, int k, int t){
		for(int i=0;i<nums.length; i++){
			for(int j=i+1;j<nums.length; j++){
				//last condition for integer max value and min value
				try{
				if((Math.abs(Math.subtractExact(nums[i],nums[j]))<=t) && (Math.abs(Math.subtractExact(nums[j],nums[i]))<=t) && (Math.abs(i-j)<=k)){
					return true;
				}}catch(ArithmeticException e){
					return false;
				}
			}
		}
		return false;
	}
	
	/**
	Method2:
	-accumulate elements in TreeSet so that the maximum and minimum can be accessed using ceil() and floor() methods
	-maintain only k elements in the TreeSet so that we can check the difference within the window size of k, whenever more than k elements are present, we remove the first element from the TreeSet
	*/
	public static boolean containsNearbyAlmostDuplicate2(int[] nums, int k, int t){
		//base cases
		if(k<=0 || nums==null || nums.length<2 || t<0){
			return false;
		}
		int index = 0;//to keep track of index of given array
		TreeSet<Long> treeitems = new TreeSet<Long>();
		for(int i:nums){
			Long smallsofar = treeitems.floor((long)i);
			Long bigsofar = treeitems.ceiling((long)i);
			//if the tree was empty null will be returned so handle them
			if(smallsofar!=null && (i-smallsofar)<=t){//we found a small item, so check if the difference is valid
				return true;
			}
			if(bigsofar!=null &&(bigsofar -i)<=t){
				return true;
			}
			//if already accumulated k elements, remove the first element from the treeset
			if(treeitems.size()==k){
				treeitems.remove((long)nums[index++]);
			}
			treeitems.add((long)i);
		}
		return false;
	}
	
	public static void main(String args[]){
		int nums[] = new int[]{1,2,3,1};
		int k = 3;
		int t = 0;
		
		//nums = new int[]{-1,2147483647};
		//k = 1;
		//t = 2147483647;
		
		//System.out.println("containsNearbyDuplicate1: "+containsNearbyAlmostDuplicate1(nums, k, t));
		System.out.println("containsNearbyDuplicate1: "+containsNearbyAlmostDuplicate2(nums, k, t));
		//System.out.println((Math.abs(Math.subtractExact(-1, 2147483647)))+"..."+(Math.abs(Math.subtractExact(2147483647,-1))));
		
	}
}