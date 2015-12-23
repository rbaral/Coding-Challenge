package com.alg.leetup.others;

import java.util.Arrays;

public class MedianOfSortedArray {
	
	public static void main(String args[]){
		int []a = new int[]{1,7,9};
		int [] b = new int[]{2,5,6};
		System.out.println(findMedianSortedArrays(a, b));
				
	}
	
	public static double findMedianSortedArrays(int A[], int B[]) {
		int m = A.length;
		int n = B.length;
	 
		if ((m + n) % 2 != 0) // odd
			return (double) findKth(A, B, (m + n) / 2, 0, m - 1, 0, n - 1);
		else { // even
			return (findKth(A, B, (m + n) / 2, 0, m - 1, 0, n - 1) 
				+ findKth(A, B, (m + n) / 2 - 1, 0, m - 1, 0, n - 1)) * 0.5;
		}
	}
	 
	public static int findKth(int A[], int B[], int k, 
		int aStart, int aEnd, int bStart, int bEnd) {
		System.out.println(">>"+Arrays.toString(A)+".."+Arrays.toString(B)+"..."+ k+"..."+ aStart+".."+aEnd+"..."+ bStart+".."+bEnd);
		int aLen = aEnd - aStart + 1;
		int bLen = bEnd - bStart + 1;
	 
		// Handle special cases
		if (aLen == 0)
			return B[bStart + k];
		if (bLen == 0)
			return A[aStart + k];
		if (k == 0)
			return A[aStart] < B[bStart] ? A[aStart] : B[bStart];
	 
		int aMid = aLen * k / (aLen + bLen); // a's middle count
		int bMid = k - aMid - 1; // b's middle count
	 System.out.println("..."+aMid+"..."+bMid);
		// make aMid and bMid to be array index
		aMid = aMid + aStart;
		bMid = bMid + bStart;
		System.out.println(">>>"+aMid+"..."+bMid);
		if (A[aMid] > B[bMid]) {
			k = k - (bMid - bStart + 1);
			aEnd = aMid;
			bStart = bMid + 1;
		} else {
			k = k - (aMid - aStart + 1);
			bEnd = bMid;
			aStart = aMid + 1;
		}
		System.out.println(Arrays.toString(A)+".."+Arrays.toString(B)+"..."+ k+"..."+ aStart+".."+aMid+".."+aEnd+"..."+ bStart+".."+bMid+".."+bEnd);
		return findKth(A, B, k, aStart, aEnd, bStart, bEnd);
	}
}
