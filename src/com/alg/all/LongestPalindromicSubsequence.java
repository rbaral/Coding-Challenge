/**
Given a string s, find the longest palindromic subsequence's length in s. You may assume that the maximum length of s is 1000.

Example 1:
Input:

"bbbab"
Output:
4
One possible longest palindromic subsequence is "bbbb".
Example 2:
Input:

"cbbd"
Output:
2
One possible longest palindromic subsequence is "bb".
*/


public class LongestPalindromicSubsequence{

	public static int longestPalindromeSubseq(String s) {
		if (s == null || s.isEmpty()) return 0;
        int len = s.length();
        int[][] dp = new int[len + 1][len + 1];
        String t = new StringBuilder(s).reverse().toString();
        for (int i = len - 1; i >= 0; i--) {
            for (int j = len - 1; j >= 0; j--) {
                if (s.charAt(i) == t.charAt(j)) {
                    dp[i][j] = 1 + dp[i+1][j+1];
                } else {
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j+1]);
                }
            }
        }
        return dp[0][0];
	}
		
	public static void main(String args[]){
		String s= "babad";
		s = "bbbab";
		System.out.println("String :"+s+" has longest palindrome as:"+longestPalindromeSubseq(s));
	}
	
}