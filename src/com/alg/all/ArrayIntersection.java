/**
Given two arrays, write a function to compute their intersection.

Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2,2]
Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [4,9]
Note:

Each element in the result should appear as many times as it shows in both arrays.
The result can be in any order.

Follow up:

What if the given array is already sorted? How would you optimize your algorithm?
What if nums1's size is small compared to nums2's size? Which algorithm is better?
What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
*/
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.lang.Integer;
import java.util.Map;
import java.util.HashMap;

public class ArrayIntersection{
	
	/**
	Method1:
	-use two loops to check if the element in nums1 is present in nums2
	-for the element found in both, add them to a list
	-convert list to array and return
	O(nm), Space: O(k) where k is the no. of common elements between the two arrays
	*/
	public static int[] getInter1(int[] nums1, int[] nums2){
		List<Integer> commonList = new ArrayList<Integer>();
		for(int i = 0;i<nums1.length; i++){
			for(int j = 0;j<nums2.length; j++){
				if(nums1[i] == nums2[j] && nums1[i]!=Integer.MIN_VALUE){//Integer.MIN_VALUE used to mark already used item
					commonList.add(nums1[i]);
					nums1[i] = Integer.MIN_VALUE;
					nums2[j] = Integer.MIN_VALUE;
					break;
				}
			}
		}
		if(commonList.size()>0){
			int[] inter = new int[commonList.size()];
			int index = 0;
			for(Integer com:commonList){
				inter[index++] = com;
			}
			return inter;
		}else{
			return new int[]{};
		}
	}
	
	/**
	Method2:
	-use additional storage to keep track of the count of elements in nums1
	-when a common element from nums2 is found in the stored elements, add it to a new list, decrease its count by 1
	-when checking a match we need to check if the stored element has count>0
	O(n1+n2), Space O(n1+k), where n1 is the size of nums1 and k is the number of common elements
	*/
	public static int[] getInter2(int nums1[], int nums2[]){
		//TODO:base cases
		if(nums1==null || nums2==null || nums1.length<1 || nums2.length<1){
			return new int[] {};
		}
		HashMap<Integer, Integer> num1Map = new HashMap<Integer, Integer>();
		for(int i:nums1){
			num1Map.put(i,num1Map.getOrDefault(i,0)+1);
		}
		//now for every occurence of item in num1Map in nums2, decrease the counter and add it to a list
		List<Integer> inter = new ArrayList<Integer>();
		for(int j:nums2){
			if(num1Map.containsKey(j) && num1Map.get(j)>0){//found an intersection if the count>0
				inter.add(j);
				num1Map.put(j, num1Map.get(j)-1);
			}
		}
		//now convert the arraylist to array and return
		if(inter.size()>0){
			int[] result = new int[inter.size()];
			int index=0;
			for(Integer item:inter){
				result[index++] = item;
			}
			return result;
		}
		return new int[]{};
	}
	
	
	public static void main(String args[]){
		int[] nums1 = new int[] {1,2,2,1};
		int[] nums2 = new int[] {2,2};
		
		//nums1 = new int[]{4,9,5};
		//nums2 = new int[]{9,4,9,8,4};
		
		//nums1 = new int[]{1,2,2,1};
		//nums2 = new int[]{2};
		//int[] inter = getInter1(nums1, nums2);
		//System.out.println("intersection1 of:"+Arrays.toString(nums1)+" and "+Arrays.toString(nums2)+" is "+Arrays.toString(inter));
		int[] inter = getInter2(nums1, nums2);
		System.out.println("intersection2 of:"+Arrays.toString(nums1)+" and "+Arrays.toString(nums2)+" is "+Arrays.toString(inter));
	}
}