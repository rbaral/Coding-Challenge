/**
Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example 1:

Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.
Example 2:

Input: "cbbd"
Output: "bb"
*/

public class LongestPalindromicSubstring{

	/**
	dp(i, j) represents whether s(i ... j) can form a palindromic substring, dp(i, j) is true when s(i) equals to s(j) and s(i+1 ... j-1) is a palindromic substring. When we found a palindrome, check if it's the longest one. Time complexity O(n^2).
	*/
	public static String longestPalindrome(String s) {
	  int n = s.length();
	  String res = "";
		
	  boolean[][] dp = new boolean[n][n];
		
	  for (int i = n - 1; i >= 0; i--) {
		for (int j = i; j < n; j++) {
		  System.out.println(i+"..."+j+"...n is:"+n);
		  dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]);
				
		  if (dp[i][j] && (j - i + 1 > res.length())) {
			res = s.substring(i, j + 1);
		  }
		}
	  }
		
	  return res;
	}

	public static void main(String args[]){
		String s= "babad";
		s = "bbbab";
		System.out.println("String :"+s+" has longest palindrome as:"+longestPalindrome(s));
	}
	
}