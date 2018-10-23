/**
Given two strings str1 and str2 and below operations that can performed on str1. Find minimum number of edits (operations) required to convert "str1" into "str2".

Insert
Remove
Replace
All of the above operations are of equal cost.

Examples:

Input:   str1 = "geek", str2 = "gesek"
Output:  1
We can convert str1 into str2 by inserting a 's'.

Input:   str1 = "cat", str2 = "cut"
Output:  1
We can convert str1 into str2 by replacing 'a' with 'u'.

Input:   str1 = "sunday", str2 = "saturday"
Output:  3
Last three and first characters are same.  We basically
need to convert "un" to "atur".  This can be done using
below three operations. 
Replace 'n' with 'r', insert t, insert a
*/

public class EditDistance{

	/**
	-given the strings and their lengths, recursively check if there is a match if not find the operation that gives minimal cost
	O(3^m) time because same subproblems are solved multiple times
	*/
	public static int editDistRecursive(String s1, String s2, int len1,int len2){
		//base cases
		if(len1==0){
			return len2;
		}
		if(len2==0){
			return len1;
		}
		//now check if there is a match on the last character of both
		if(s1.charAt(len1-1)== s2.charAt(len2-1)){
			return editDistRecursive(s1, s2, len1-1, len2-1);
		}else{
			//find the best among all the operations
			return 1+ Math.min(editDistRecursive(s1, s2, len1, len2-1), Math.min(editDistRecursive(s1, s2, len1-1, len2), editDistRecursive(s1, s2, len1-1, len2-1)));
		}
	}
	
	/**
	-use dynamic programming to memoize the result of subproblems and later use it
	O(mn)
	*/
	public static int editDistDP(String s1, String s2, int len1,int len2){
		//base cases
		if(len1==0){
			return len2;
		}
		if(len2==0){
			return len1;
		}
		int[][] dp = new int[len1+1][len2+1];
		for(int i=0;i<=len1; i++){
			for(int j=0;j<=len2; j++){
				if(i==0){
					dp[i][j] = j;
				}else if(j==0){
					dp[i][j] = i;
				}else if(s1.charAt(i-1)==s2.charAt(j-1)){
					dp[i][j] = dp[i-1][j-1];
				}else{
					dp[i][j] = 1 + Math.min(dp[i-1][j-1], Math.min(dp[i][j-1], dp[i-1][j]));
				}
				
			}
		}
		return dp[len1][len2];
	}
	

	public static void main(String args[]) 
    { 
        String str1 = "sunday"; 
        String str2 = "saturday"; 
   
        System.out.println( editDistRecursive( str1 , str2 , str1.length(), str2.length()) ); 
		System.out.println( editDistDP( str1 , str2 , str1.length(), str2.length()) ); 
    } 
}