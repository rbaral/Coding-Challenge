/**
 * Implement an algorithm to determine if a string has all unique characters. What
if you cannot use additional data structures?
 */
package com.alg.ctci;

/**
 * @author rbaral
 *
 */
public class CheckUniqueCharsinString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s = "Abcde12A";
		System.out.println(hasUniqueChars1(s));
		System.out.println(hasUniqueChars2(s));

	}
	
	/**
	 * Approach1:
	 * first we check if the length of string is more than 256,
	 * if so then certainly it has duplicate entries. Else, we
	 * can use an array of boolean values and whenever a character is
	 * encountered, set it's index to true. If it has already been set
	 * then it is duplicate. This will work in O(n) time.
	 * Approach2: we can just use the divide and conquer approach till we reach
	 * the base case of subarray with size 2. Then we merge and check if the two
	 * subarrays being merged have duplicate values or not. This will take O(nlogn) 
	 * time, similar to that of the merge sort.
	 * @param s
	 * @return
	 */
	public static boolean hasUniqueChars1(String s){
		if(s.length()>256)
			return false;
		boolean[] charArray = new boolean[256];
		for(int i=0; i < s.length(); i++){
			if(charArray[s.charAt(i)]){//we already found one, so this is duplicate
				return false;
			}
			charArray[s.charAt(i)] = true;
		}
		return true;
	}
	
	/**
	 * here we attempt to reduce the space consumption by using
	 * the bit vector rather than the boolean array.
	 * @param s
	 * @return
	 */
	public static boolean hasUniqueChars2(String s) {
		int checker = 0, charValue = 0;
		for (int i = 0; i < s.length(); i++) {
			/*
			 * WLOG we assume that the string uses only the lower case letters,
			 * when there is a mix of upper and lower case letters, this approach fails.
			 * To prevent from failure, we can convert the string to all lower case before 
			 * execution, but this will add the cost of the toLowerCase() method as well.
			 */
			charValue = s.charAt(i) - 'a';
			if ((checker & (1 << charValue)) > 0) {
				return false;
			}
			checker |= (1 << charValue);
		}
		return true;
	}

}
