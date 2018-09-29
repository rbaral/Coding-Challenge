/**
Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

Example:

Input: "aab"
Output:
[
  ["aa","b"],
  ["a","a","b"]
]
*/

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class PalindromePartition{

	public static List<List<String>> palPartition(String s){
		//base case
		List<List<String>> lists = new ArrayList<List<String>>();
		palPartitionRecursive(lists, new ArrayList<String>(), s, 0);
		return lists;
	}
	
	public static void palPartitionRecursive(List<List<String>> lists, List<String> tempList, String s, int start){
		if(start==s.length()){
			lists.add(new ArrayList<>(tempList));
		}
		for(int i=start;i<s.length(); i++){
			if(isPalindrome(s, start, i)){
				tempList.add(s.substring(start, i+1));
				palPartitionRecursive(lists, tempList, s, i+1);
				tempList.remove(tempList.size()-1);	
			}
			
		}
		
	}
	
	public static boolean isPalindrome(String s, int start, int end){
		while(start<end){
			if(s.charAt(start)!=s.charAt(end)){
				return false;
			}
			start++;
			end--;
		}
		return true;
	}
	
	public static void main(String args[]){
		String s ="aab";
		
		List<List<String>> permsList = palPartition(s);
		for(List<String> intlist: permsList){
			String [] intarr = new String[intlist.size()];
			System.out.println(Arrays.toString(intlist.toArray(intarr)));
		}
	}
}