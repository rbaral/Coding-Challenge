package com.alg.leetup;

import java.util.Arrays;
/**
There are two sorted arrays nums1 and nums2 of size m and n respectively. 
Find the median of the two sorted arrays. 
The overall run time complexity should be O(log (m+n)).
*/
/**
1) Calculate the medians m1 and m2 of the input arrays ar1[] 
   and ar2[] respectively.
2) If m1 and m2 both are equal then we are done.
     return m1 (or m2)
3) If m1 is greater than m2, then median is present in one 
   of the below two subarrays.
    a)  From first element of ar1 to m1 (ar1[0...|_n/2_|])
    b)  From m2 to last element of ar2  (ar2[|_n/2_|...n-1])
4) If m2 is greater than m1, then median is present in one    
   of the below two subarrays.
   a)  From m1 to last element of ar1  (ar1[|_n/2_|...n-1])
   b)  From first element of ar2 to m2 (ar2[0...|_n/2_|])
5) Repeat the above process until size of both the subarrays 
   becomes 2.
6) If size of the two arrays is 2 then use below formula to get 
  the median.
    Median = (max(ar1[0], ar2[0]) + min(ar1[1], ar2[1]))/2
*/
/**
 * TEST CASES
 * 1)int []a = new int[]{};		int [] b = new int[]{1};->1.0
 * 2)int []a = new int[]{1,7,9}; int [] b = new int[]{2,5,6};->5.5
 * @author rbaral
 *
 */
public class MedianOfTwoArrays {

	public static void main(String args[]){
		int []a = new int[]{1,7,9}; int [] b = new int[]{2,5,6};
		System.out.println(findMedianSortedArrays(a, b));
	}
	
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double med1=0,med2=0,med=0;
        int aStart=0,bStart=0;
        //handle base cases
        if(nums1.length==0 && nums2.length==0)
            return -1.0;
        else if(nums1.length==0){
            return findMedianOfAnArray(nums2);
        }
        else if(nums2.length==0){
            return findMedianOfAnArray(nums1);
        }else if(nums1.length==2 && nums2.length==2){
        	return (Math.max(nums1[0], nums2[0]) + Math.min(nums1[1], nums2[1]))/2;
        }
        med1=nums1[nums1.length/2];
        med2=nums1[nums2.length/2];
        if(med1==med2){//we are done
            //med= med1;
            return med1;
        }else if(med1>med2){ /* if m1 > m2 then median must exist in ar1[....m1] and ar2[m2...] */
            if(nums1.length%2==0)
            	aStart=nums1.length/2 -1;
            else
            	aStart=nums1.length/2;
            if(nums2.length%2==0)
            	bStart=nums2.length/2 -1;
            else
            	bStart=nums2.length/2;
        	return findMedianSortedArrays(Arrays.copyOfRange(nums1,0,aStart+1),Arrays.copyOfRange(nums2,bStart+1,nums2.length-1));
        }else{/* if m1 < m2 then median must exist in ar1[m1....] and ar2[....m2] */
        	if(nums1.length%2==0)
            	aStart=nums1.length/2 -1;
            else
            	aStart=nums1.length/2;
            if(nums2.length%2==0)
            	bStart=nums2.length/2 -1;
            else
            	bStart=nums2.length/2;
        	return findMedianSortedArrays(Arrays.copyOfRange(nums1,aStart+1,nums1.length-1),Arrays.copyOfRange(nums2,0,bStart+1));
        }
        
      //return med;  
    }
    
    //finds the median of an array
    public static double findMedianOfAnArray(int[] nums){
        double med=0;
        if(nums.length==1)
            med= nums[0];
        else if(nums.length==2)
            med= (double)(nums[0]+nums[1])/2;
        if(nums.length%2==0){//for even sized array
            med = (double)(nums[nums.length/2]+nums[nums.length/2 -1])/2;
        }else{
        //for odd size of array
            med = (double)(nums[nums.length/2]);
        }
        
        return med;
    }
}
