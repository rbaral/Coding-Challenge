/**
Given an array of numbers, find GCD of the array elements. In a previous post we find GCD of two number.

Examples:

Input  : arr[] = {1, 2, 3}
Output : 1

Input  : arr[] = {2, 4, 6, 8}
Output : 2
*/
import java.util.*;

public class ArrayGCDFinding{

	public static int generalGCD(int[] nums){
		//base cases
		if(nums==null){
			return 0;
		}
		if(nums.length==1){
			return nums[0];
		}
		int gcd = nums[0];
		for(int i=1;i<nums.length; i++){
			gcd = findGCD(gcd, nums[i]);
		}
		return gcd;
	}
	
	public static int findGCD(int a, int b){
		if(a==0){
			return b;
		}else{
			return findGCD(a%b, a);
		}
	}
	
	public static void main(String[] args){
		int[] arr = new int[]{1, 2, 3};
		arr = new int[]{2, 4, 6, 8};
		System.out.println("the gcd of array:"+Arrays.toString(arr)+" is:"+generalGCD(arr));
	}
}