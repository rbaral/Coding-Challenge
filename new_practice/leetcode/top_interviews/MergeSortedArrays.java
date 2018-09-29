/**
Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:

The number of elements initialized in nums1 and nums2 are m and n respectively.
You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
Example:

Input:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3

Output: [1,2,2,3,5,6]
*/
import java.util.Arrays;

public class MergeSortedArrays{

	/**
	Method1:
	-m is the end of elements of nums1 and the rest of space is for elements of nums2
	-n is the length of nums2
	-index1 points first element of nums1 and index2 for nums2
	-compare the elements and advance the pointers till the elements of nums1 (or nums2) are smaller
	*/
	public static void merge1(int[] nums1, int m, int[] nums2, int n) {
		//TODO: base case
		if(nums2.length==0 || nums1.length==0){
			return;
		}
        int index1 = 0;
		int index2 = 0;
		int count = 0;
		//skip the elements of nums1 that are smaller than the nums2
		while(count<n && index1<m && index2<n){
			if(nums1[index1]<=nums2[index2] &&index1<m && index2<n){
				index1++;
			}else{
				//the item at index2 has found its position, insert it into nums1 at index1, shift items in nums1 backward
				int nums2item = nums2[index2];
				for(int i=m;i>index1;i--){
					nums1[i] = nums1[i-1];
				}
				m++;//the valid numbers in m1 is increased now by 1
				//put the item from index2 to index1
				nums1[index1] = nums2item;
				System.out.println("after shifting nums1 is:"+Arrays.toString(nums1));
				index2++;
			}
			//System.out.println("array1 now is:"+Arrays.toString(nums1) +" arry2 is "+Arrays.toString(nums2));
		}
		//if the index1 has reached m, the rest of the items in nums2 goes in nums1 directly
		while(index1<nums1.length && index2<n){
			nums1[index1++] = nums2[index2++];
		}
    }
	
	/**
	Method2:
	-we start comparing from the end and inserting the elements in nums1
	*/
	public static void merge2(int[] nums1, int m, int[] nums2, int n){
		if(nums1.length==0 || nums2.length==0 ||n==0){
			return;
		}
		int i=m-1;
		int j=n-1;
		int k= m+n-1;//total elements in both arrays
		while(i>=0 && j>=0){
			if(nums1[i]<=nums2[j]){
				nums1[k] = nums2[j];
				k--;
				j--;
			}else{
				nums1[k] = nums1[i];
				k--;
				i--;
			}
		}
		//check the rest of the items in nums2
		while(j>=0){
			nums1[k] = nums2[j];
			k--;
			j--;
		}
	}
	
	public static void main(String args[]){
		int[] nums1 = new int[]{1,2,3,0,0,0};
		int[] nums2 = new int[]{2,5,6};
		int m = 3; //the actual number of elements
		int n = nums2.length;
		/*
		nums1 = new int[]{1};
		m = 1;
		nums2 = new int[]{};
		n = 0;
		
		nums1 = new int[]{4,5,6,0,0,0};
		m = 3;
		nums2 = new int[]{1,2,3};
		n = 3;
		
		*/
		System.out.println("before arr1 is:"+Arrays.toString(nums1)+" and arr2 is:"+Arrays.toString(nums2));
		merge2(nums1, m, nums2, n);
		System.out.println("merged arr is:"+Arrays.toString(nums1));
		
	}
}