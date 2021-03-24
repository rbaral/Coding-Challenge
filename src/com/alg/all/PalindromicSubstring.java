/**
Given a string, your task is to count how many palindromic substrings in this string.

The substrings with different start indexes or end indexes are counted as different substrings even they consist of same characters.

Example 1:
Input: "abc"
Output: 3
Explanation: Three palindromic strings: "a", "b", "c".
Example 2:
Input: "aaa"
Output: 6
Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
Note:
The input string length won't exceed 1000.
*/
import java.util.Arrays;

public class PalindromicSubstring{

	/**
	state[i][j] is true if substring s[i, j] is palindromic
	
	Aim State
	decide all possible state[i][j] and count the element that is true
	State Transition
	state[i][j] is true if s[i] == s[j] and state[i+1][j-1] is true (j - i >= 2)
	state[i][j] is true if s[i] == s[j] (j - i == 1)
	state[i][j] is true (j - i == 0)
	Ref: https://leetcode.com/problems/palindromic-substrings/discuss/144443/Logical-Thinking-with-Java-Code
	*/
	public static int countSubstrings(String s) {
		int n = s.length();
		int count = 0;
        boolean[][] dp = new boolean[n][n];
		//the starting at i and ending at i is always a palindrome
		for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
            count++;
        }
		//use 2-loops to check if the string starting at index i and ending at index j is a palindrome
		for(int i=n-1; i>=0; i--){
			for(int j=i; j<n; j++){
				int diff = j-i;
				if(diff==1){
					//a single character
					dp[i][j] = s.charAt(i)==s.charAt(j);
				}else if(s.charAt(i)==s.charAt(j) && (dp[i+1][j-1])){
					//if multiple character window and the two extreme ends match, then shrink the window and check for the smaller window
					dp[i][j] = true;
				}
				//if the string starting at index i and ending at index j is palindrome, increase the count
				if(dp[i][j]){
					count++;
				}
			}
		}
		return count;
    }
	
	public static void main(String[] args){
		System.out.println(countSubstrings("abc"));
		System.out.println(countSubstrings("aaa"));
		System.out.println(countSubstrings("abcdd"));
	}
}