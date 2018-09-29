/**
Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

Example:

Input: S = "ADOBECODEBANC", T = "ABC"
Output: "BANC"
Note:

If there is no such window in S that covers all characters in T, return the empty string "".
If there is such window, you are guaranteed that there will always be only one unique minimum window in S.
*/
import java.util.*;

public class MinimimWindowSubstring{

	
	/**
	Method2:
	-store the count of each char in a hash
	-scan the given string and for each character encountered reduce the count by 1
	-check if the count of each char reaches less than or equal to zero
	O(nk), where n is the length of the string and k is the length of the array
	because for each char in the string, we need to check if the count of the char in the array has reached <=0
	*/
	public static String findSmallestSubstring2(char[] arr, String s){
		//base cases
		if(arr==null || s==null || s.trim().length()==0 || arr.length>s.length()){
			return "";
		}
		return "";
	}

	/**
	Method2:
	-
	Ref: https://leetcode.com/problems/minimum-window-substring/discuss/26810/Java-solution.-using-two-pointers-+-HashMap
	*/
	public static String minWindow(String s, String t) {
        //base cases
		if(t==null || s==null || s.trim().length()==0 || t.trim().length()==0 || t.length()>s.length()){
			return "";
		}
		HashMap<Character, Integer> charCount = new HashMap<>();
		//add the count of all the chars in String t
		for(char c:t.toCharArray()){
			charCount.put(c, charCount.getOrDefault(c, 0)+1);
		}
		int left = 0;
		int minLeft = 0;
		int minLen = s.length()+1;//lets assume this is the min length by default
		int count = 0;
		for(int right = 0;right<s.length(); right++){
			if(charCount.containsKey(s.charAt(right))){
				charCount.put(s.charAt(right),charCount.get(s.charAt(right))-1);
				//if the previous line has removed some character that was part of t
				if(charCount.get(s.charAt(right))>=0){
					count++;
				}
				while(count==t.length()){//found a window
					if(right-left+1<minLen){
						minLeft = left;
						minLen = right - left +1;
					}
					if(charCount.containsKey(s.charAt(left))){
						charCount.put(s.charAt(left), charCount.get(s.charAt(left))+1);
						//if the previous line has added some character that was part of s
						if(charCount.get(s.charAt(left))>0){
							count--;
						}
					}
					left++;
				}
			}
		}
		if(minLen>s.length()){
			return "";
		}
		return s.substring(minLeft, minLeft+minLen);
		
	}
	
	public static String minWindow3(String s, String t){
		//base cases
		if(s==null || t==null || s.length()==0 || s.length()<t.length()){
			return "";
		}
		//put all the characters from t into a hash
		HashMap<Character, Integer> charcount = new HashMap<>();
		for(char c:t.toCharArray()){
			charcount.put(c, charcount.getOrDefault(c, 0)+1);
		}
		//initialize some pointers to represent the processing window
		int curLeft = 0; //the current left pointer
		int minLeft = 0; //to hold the left pointer that gave min window so far
		int count = 0; //to hold the count of matches found
		int minLen = s.length() + 1;//the min window length
		//repeat for every chars in s and check the match with the one put in hash
		for(int curRight=0; curRight<s.length(); curRight++){
			if(charcount.containsKey(s.charAt(curRight))){
				charcount.put(s.charAt(curRight), charcount.get(s.charAt(curRight))-1);
				//if this reduced the char due to t
				if(charcount.get(s.charAt(curRight))>=0){
					count++;
				}
			}
			//now check if we matched all the characters in t with the chars in s
			while(count==t.length()){
				//a window is found, lets check if this is the minimum window or not
				if(curRight - curLeft+1<minLen){
					minLen = curRight - curLeft + 1;
					minLeft = curLeft;
				}
				//if the map contains the character at leftmost position of s, put it into the map
				if(charcount.containsKey(s.charAt(curLeft))){
					charcount.put(s.charAt(curLeft), charcount.get(s.charAt(curLeft))+1);
					//if the char at left was not in balance with the char in t
					if(charcount.get(s.charAt(curLeft))>0){
						count--;
					}
				}
				curLeft++;
			}
		}
		if(minLen>s.length()){
			return "";
		}
		return s.substring(minLeft, minLeft + minLen);
	}
	
	/**
	Ref: leetcode, runs in 3ms, but currently has some problem in my code, need to fix it
	*/
	public static String minWindow4(String s, String t){
		if(s==null || t== null || s.length()<t.length()){
            return "";
        }
        return getMinimumWindowWithArray(s, t);
	}
	
	public static String getMinimumWindowWithArray(String s, String t){
		char[] tchars = t.toCharArray();
		char[] schars = s.toCharArray();
		int start = 0;
		int curleft = 0, curright = 0;
		int len = Integer.MAX_VALUE; //maximum possible window size
		int count = s.length();
		int[] charcount = new int[256];
		for(char c:tchars){
			charcount[c]++;
		}
		while(curright<schars.length){
			int rightchar = schars[curright];
			if(charcount[rightchar]-- >0){
				//this was due to chars from s
				count--;
			}
			//if all the chars in t are found
			while(count==0){
				if(len > curright-curleft+1){
					len = curright-curleft+1;
					start = curleft;
				}
				int leftchar = schars[curleft];
				if(charcount[leftchar]++ >=0){
					count++;
				}
				curleft++;
			}
			curright++;
		}
		return len==Integer.MAX_VALUE?"":s.substring(start, start+len);
		
	}
	
	
	public static void main(String args[]){
		String s ="ADOBECODEBANC";
		String t ="ABC";
		s= "xyyzyzyx";
		t = "xyz";
		System.out.println("string t "+t+" within String "+s+" has min window substring... "+minWindow3(s, t)+" ...");
		System.out.println("string t "+t+" within String "+s+" has min window substring... "+minWindow4(s, t)+" ...");
		
	}

}