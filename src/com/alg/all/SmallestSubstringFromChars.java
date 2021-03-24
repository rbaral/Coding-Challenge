/**
Given an array of characters and a string, find the smallest substring from the string that contains
all the characters from the given array. If none can be found, return an empty string.

Example 1:
Input:
arr = ['x', 'y', 'z']
s = "xyyyzyx"

output: "zyx"
*/
import java.util.*;

public class SmallestSubstringFromChars{

	
	/**
	Method1:
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
		//put the chars and their count in hash
		HashMap<Character, Integer> charscount = new HashMap<Character, Integer>();
		for(char c:arr){
			charscount.put(c, charscount.getOrDefault(c,0)+1);
		}
		//now iterate through the given string to check if the corresponding characters are found
		int curLeft = 0, minLeft = 0; //to define the window
		int minLen = s.length()+1; //assume this is the length of the min window
		int count = 0;//the count of characters found in the given string
		for(int curRight = 0;curRight<s.length(); curRight++){
			char curchar = s.charAt(curRight);
			if(charscount.containsKey(curchar)){
				charscount.put(curchar, charscount.get(curchar)-1);
				if(charscount.get(curchar)>=0){
					count++;//this many characters from char array are found in the given string
				}
			}
			//check if the window length is reached
			while(count==arr.length){
				//if the current window is minimum window
				if(curRight - curLeft + 1<minLen){
					minLen = curRight - curLeft + 1;
					minLeft = curLeft;
				}
				//advance the window
				char leftchar = s.charAt(curLeft);
				if(charscount.containsKey(leftchar)){
					charscount.put(leftchar, charscount.get(leftchar)+1);
					//if char at left of current window was match with the charcount, increase for next window
					if(charscount.get(leftchar)>0){
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

	public static void main(String[] args){
		char[] arr = new char[]{'a', 'b', 'c'};
		String s = "xyyyzyx";
		String sub = findSmallestSubstring2(arr, s);
		System.out.println("Smallest substring is:"+sub);
	}
}