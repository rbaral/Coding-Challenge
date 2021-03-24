/**
Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1. In other words, one of the first string's permutations is the substring of the second string.
Example 1:
Input:s1 = "ab" s2 = "eidbaooo"
Output:True
Explanation: s2 contains one permutation of s1 ("ba").
Example 2:
Input:s1= "ab" s2 = "eidboaoo"
Output: False
Note:
The input strings only contain lower case letters.
The length of both given strings is in range [1, 10,000].
*/
import java.util.*;

public class StringPermutation{

	/**
	Method1:
	-use the concept of sliding window
	-store the character counts of s1 in an array
	-take a sliding window of width s1.length() and check if all the character counts reach zero, if so we found
	-if not found, advance the sliding window by 1, increase the count of the character that leaves the window, decrease the count of the character that enters the window
	*/
	public static boolean checkInclusion1(String s1, String s2){
		//base case
		if(s1.length()>s2.length()){
			return false;
		}
		if(s1.length()==0){
			return true;
		}
		int[] counts = new int[26]; //only lowercase letters are used in the input
		
		for (int i = 0; i < s1.length(); i++) {
            counts[s1.charAt(i)-'a']++;
            counts[s2.charAt(i)-'a']--;
			
        }
		System.out.println(samechars+".."+s1.length());
		//check if in the first window all characters are found
		if(isAllZero(counts)){
			return true;
		}
		//now update the count of rest of s2
		for(int i=s1.length(); i<s2.length(); i++){
			//increase the count of char that leaves the window
			counts[s2.charAt(i-s1.length())-'a']++;
			//decrease the count of char that enters the window
			counts[s2.charAt(i)-'a']--;
			
			System.out.println(samechars+".."+s1.length());
			//check if in the first window all characters are found
			if(isAllZero(counts)){
				return true;
			}
		}
		return false;
	}
	
	public static boolean isAllZero(int[] arr){
		for(int i:arr){
			if(i!=0){
				return false;
			}
		}
		return true;
	}
	
	/**
	Method2:
	-generate permutations from s1
	-for each permutation, check if it is contained in s2
	MEMORY EXCEEDED ON LEETCODE
	*/
	public static boolean checkInclusion2(String s1, String s2) {
        //base case
		if(s1.length()>s2.length()){
			return false;
		}
		if(s1.length()==0){
			return true;
		}
		if(s1.length()==1){
			return s2.contains(s1);
		}
		
		List<String> temp = new ArrayList<String>();
		temp.add(""+s1.charAt(0));
		List<List<String>>  result = new ArrayList<List<String>>(); 
		getPermutations(s1, temp, result, 1);
		for(String perm:result.get(result.size()-1)){
			if(s2.contains(perm)){
				return true;
			}
		}
		return false;
    }
	
	/**
	-accumulate the permutation of a given level by using the previous permutation and the character at index from s
	-add the final string of this level length to the result
	*/
	public static void getPermutations(String s, List<String> temp, List<List<String>> res, int index){
		if(index>=s.length()){
			return;
		}
		//for every permutation of previous level, add the character at position index to them
		List<String> perms = new ArrayList<String>();
		StringBuilder sb;
		for(String lastperm: temp){
			for(int i=0;i<=lastperm.length(); i++){
				//insert the character at position index into position i, which will give a new permutation
                sb = new StringBuilder();
                sb.append(lastperm.substring(0, i));
                sb.append(s.charAt(index));
                sb.append(lastperm.substring(i));
				perms.add(sb.toString());
			}
		}
		res.add(perms);
		getPermutations(s, perms, res, index+1);
	}
	
	public static void main(String args[]){
		String s1 = "abc";
		String s2 = "eidbcabooo";
		System.out.println(checkInclusion1(s1, s2));
		s1 = "abc";
		s2 = "eidbaooo";
		System.out.println(checkInclusion1(s1, s2));
		s1 = "a";
		s2 = "ab";
		System.out.println(checkInclusion1(s1, s2));
		//memory limit exceeded for
		s1 = "prosperity";
		s2 = "properties";
		System.out.println(checkInclusion1(s1, s2));
		
		
	}
}