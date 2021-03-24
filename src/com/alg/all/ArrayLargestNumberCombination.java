/**
Given a list of non negative integers, arrange them such that they form the largest number.

Example 1:

Input: [10,2]
Output: "210"
Example 2:

Input: [3,30,34,5,9]
Output: "9534330"
Note: The result may be very large, so you need to return a string instead of an integer.
*/
import java.util.*;

public class ArrayLargestNumberCombination{

	/**
	The idea here is basically implement a String comparator to decide which String should come first during concatenation. Because when you have 2 numbers (let's convert them into String), you'll face only 2 cases:
	For example:

	String s1 = "9";
	String s2 = "31";

	String case1 =  s1 + s2; // 931
	String case2 = s2 + s1; // 319

	Apparently, case1 is greater than case2 in terms of value.
	So, we should always put s1 in front of s2.
	*/
	public static String largestNumber(int[] nums) {
		//handle base cases here
		if(nums==null || nums.length==0){
			return "";
		}
		//convert the int array to string array
		String[] snums = new String[nums.length];
		for(int i=0; i<nums.length; i++){
			snums[i] = String.valueOf(nums[i]);
		}
		//now we use string comparator and sort the string array
		Comparator<String> comp = new Comparator<String>(){
			@Override
			public int compare(String s1, String s2){
				String cat1 = s1 + s2;
				String cat2 = s2 + s1;
				return cat2.compareTo(cat1);
			}
		};
		//now sort the string array using this comparator
		Arrays.sort(snums, comp);
		//if we have all zeros
		if(snums[0].charAt(0)=='0'){
			return "0";
		}
		StringBuilder sb = new StringBuilder();
		for(String s:snums){
			sb.append(s);
		}
		return sb.toString();
	}
	
	
	public static void main(String[] args){
		int[] nums = new int[]{3,30,34,5,9};
		System.out.println(largestNumber(nums));
	}
}