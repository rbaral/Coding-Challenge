/**

Longest Common subsequence

We have discussed Overlapping Subproblems and Optimal Substructure properties in Set 1 and Set 2 respectively. We also discussed one example problem in Set 3. Let us discuss Longest Common Subsequence (LCS) problem as one more example problem that can be solved using Dynamic Programming.

LCS Problem Statement: Given two sequences, find the length of longest subsequence present in both of them. A subsequence is a sequence that appears in the same relative order, but not necessarily contiguous. For example, "abc", "abg", "bdf", "aeg", "acefg", .. etc are subsequences of "abcdefg". So a string of length n has 2^n different possible subsequences.

It is a classic computer science problem, the basis of diff (a file comparison program that outputs the differences between two files), and has applications in bioinformatics.

Examples:
LCS for input Sequences "ABCDGH" and "AEDFHR" is "ADH" of length 3.
LCS for input Sequences "AGGTAB" and "GXTXAYB" is "GTAB" of length 4.
*/

public class LongestCommonSubsequence{
	/**
	-if the last character matches, then increase the match count
	-f not match, recurse on max(X-1, Y-2; X-2, Y-1)
	*/
	public static int lcsRecursive(char[] s1, char[] s2, int len1, int len2){
		//base case
		if(len1==0 || len2==0){
			return 0;
		}
		//if last char matches
		if(s1[len1-1] == s2[len2-1]){
			return 1 + lcsRecursive(s1, s2, len1-1, len2-1);
		}else{
			return Math.max(lcsRecursive(s1, s2, len1, len2-1), lcsRecursive(s1, s2, len1-1, len2));
		}
	}
	
	public static int lcsDP(char[] s1, char[] s2, int len1, int len2){
		//create the 2-D int array to hold the length when the two char pairs were used
		int[][] dp = new int[len1+1][len2+1];
		for(int i=0; i<=len1; i++){
			for(int j=0; j<=len2; j++){
				if(i==0 || j==0){//when one of the string has no character
					dp[i][j]=0;
				}else if(s1[i-1]==s2[j-1]){
					dp[i][j] = dp[i-1][j-1] + 1;
				}else{
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		return dp[len1][len2];
	}
	
	public static void main(String[] args) 
	{ 
    
    String s1 = "AGGTAB"; 
    String s2 = "GXTXAYB"; 
  
    char[] X=s1.toCharArray(); 
    char[] Y=s2.toCharArray(); 
    
    System.out.println("Length of LCS is" + " " + 
                                  lcsRecursive( X, Y, X.length, Y.length ) ); 
	System.out.println("Length of LCS is" + " " + 
                                  lcsDP( X, Y, X.length, Y.length ) );
  } 
}