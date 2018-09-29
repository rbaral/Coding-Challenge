/**
Given two strings, check if one is permutation of another
*/

import java.util.Arrays;

public class CheckStringPermutations{


	/*
	this is the classic method that uses sorting of both strings and checks if they are equal.
	Complexity is O(nlogn)
	*/
	public static boolean isPermutation1(String s1, String s2){
		//add base case to compare the lengths of two strings, if unequal length, they cannot be permutation	
		char[] s1chars = s1.toCharArray();
		char[] s2chars = s2.toCharArray();
		Arrays.sort(s1chars);
		Arrays.sort(s2chars);
		s1 = new String(s1chars);
		s2 = new String(s2chars);
		System.out.println("after sorting, s1 is:"+s1+"..and s2 is:"+s2);
		if(s1.equals(s2))
			return true;
		else
			return false;
	}

	/*
	we assume that the string has ASCII characters, so we use a constant space to store teh count of characters in one string
	and compare the count with the other string. If the count of each character reaches zero after comparing, the two strings are
	permutations of each other.
	Complexity: O(n), where n is the length of string
	Space: O(1), constant space to store the count of characters
	*/
	public static boolean isPermutation2(String s1, String s2){
		//add base case to compare the lengths of two strings, if unequal length, they cannot be permutation
		if(s1.length()!=s2.length())
			return false;
		//lets store the count of characters in s1
		int[] charCounts = new int[256];
		for(char c: s1.toCharArray()){
			charCounts[c]+=1;
		}
		//now lets iterate over s2 and decrease the character count
		for(char c:s2.toCharArray()){
			if(--charCounts[c]<0){
				return false;//if the count is already exhausted, there are more such characters in second string		
			}
		}
		
		return true;
	}

	public static void main(String args[]){
		String s1 = "waterbottles";
		String s2 = "bottleswater";
		if (isPermutation2(s1, s2)){
			System.out.println("String "+s1+" .."+s2+" are permutations of each other");	
		}else{
			System.out.println("String "+s1+" .."+s2+" are not permutations");	
		}
	}
}
