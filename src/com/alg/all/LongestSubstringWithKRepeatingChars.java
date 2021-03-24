/**
Find the length of the longest substring T of a given string (consists of lowercase letters only) such that every character in T appears no less than k times.

Example 1:

Input:
s = "aaabb", k = 3

Output:
3

The longest substring is "aaa", as 'a' is repeated 3 times.
Example 2:

Input:
s = "ababbc", k = 2

Output:
5

The longest substring is "ababb", as 'a' is repeated 2 times and 'b' is repeated 3 times.
*/

public class LongestSubstringWithKRepeatingChars{

	/**
	Method1: use recursive solution
	-accumulate the count of each characters
	-check with a flag if every character has at least k count, and if so return the length of whole string as the longest substring
	-iterate from start=0 and for each character
	--check if count is less than k, if so, advance the position of substring to be considered for the next recursion
	--recurse on the substring with the leftover
	--if the count is greater than or equal to k, continue checking the next characters
	--keep track of the maximum length of substring when a character with less than k count is encountered
	*/
	public static int longestSubstring(String s, int k) {
        //base cases
		if(s==null || s.length()<k){
			return 0;
		}
		//keep the count of each characters
		int[] charcount = new int[26];
		for(char c:s.toCharArray()){
			charcount[c-'a']+=1;
		}
		//check with a flag if all characters have>=k count
		boolean allCountValid = true;
		for(int i:charcount){
			if(i>0 && i<k){//for every character in this string
				allCountValid = false;
				break;
			}
		}
		//if all valid count return the whole string
		if(allCountValid){
			return s.length();
		}
		//now recurse on the string
		int start = 0;
		int result = 0;
		int cur = 0;
		while(cur<s.length()){
			if(charcount[s.charAt(cur)-'a']<k){
				result = Math.max(result, longestSubstring(s.substring(start, cur), k));
				start=cur+1;
			}
			cur++;
		}
		result = Math.max(result, longestSubstring(s.substring(start), k));
		return result;
    }
	
	public static void main(String[] args){
		String s= "aaabb";
		int k =3;
		System.out.println(s+" with at least "+k+" char repeats has substring:"+longestSubstring(s, k));	
	}

}