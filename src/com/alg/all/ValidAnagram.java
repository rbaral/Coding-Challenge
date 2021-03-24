/**
Given two strings s and t , write a function to determine if t is an anagram of s.

Example 1:

Input: s = "anagram", t = "nagaram"
Output: true
Example 2:

Input: s = "rat", t = "car"
Output: false
Note:
You may assume the string contains only lowercase alphabets.

Follow up:
What if the inputs contain unicode characters? How would you adapt your solution to such case?
*/

public class ValidAnagram{
	
	
	/**
	-sort the two strings and compare if they are equal, if not they are not anagram
	O(nlogn) is the best soln
	*/
	public static boolean isanagram1(String s1, String s2){
		return false;
	}
	/**
	Method1:
	-check the character count of one string is equal to that of another string
	O(n), Space O(n), we can reduce space by storing only the 256 characters, for only lowercase letters we can store
	them in an array of size 26
	*/
	public static boolean isanagram2(String s1, String s2){
		//TODO:base cases
		if((s1==null &s2!=null)||(s2==null && s1!=null) ||(s1.length()!=s2.length())){
			return false;
		}
		//lets assume the string is ascii and store the count of charaters in one string in an array
		int[] counts = new int[256];
		for(int i=0;i<s1.length();i++){
			counts[(int)s1.charAt(i)]++;
		}
		//now check if the count matches on the second string
		for(int j = 0;j<s2.length();j++){
			if(--counts[(int)s2.charAt(j)]<0){
				return false;
			}
		}
		return true;
	}
	
	public static void main(String args[]){
		String s1 = "anagram";
		String s2= "nagaram";
		System.out.println("is anagram2:"+isanagram2(s1, s2));
	}
}