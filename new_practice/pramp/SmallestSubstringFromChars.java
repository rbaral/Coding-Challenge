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
	-use two nested loops to iterate the characters in the string and for each char in outer loop, check when all three chars are found, if found, record the length
	O(n^2), Space O(k)-> to store the unique characters encountered in a hash, where k is the length of the char array
	*/
	public static String findSmallestSubstring1(char[] arr, String s){
		//base cases
		if(arr==null || s==null || s.trim().length()==0 || arr.length>s.length()){
			return "";
		}
		int start = 0;
		int end = s.length()-1;
		for(int i=0;i<s.length(); i++){
			HashMap<Character, Integer> hashChars = new HashMap<Character, Integer>();
			hashChars.put(s.charAt(i), hashChars.getOrDefault(s.charAt(i), 0)+1);
			for(int j=i+1; j<s.length();j++){
				hashChars.put(s.charAt(j), hashChars.getOrDefault(s.charAt(j), 0) +1);
				//check if all the entries in count are <=0
				if(hashChars.size()==arr.length){
					if((j-i)<(end - start)){
						end = j;
						start = i;
					}
				}
			}
		}
		//we have found one substring
		System.out.println("the shortest substring is from start "+start+" and end: "+end+" "+s.substring(start, end+1));
		return s.substring(start, end+1);
	}
	
	
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
		//put the chars and their count in hash
		HashMap<Character, Integer> charscount = new HashMap<Character, Integer>();
		for(char c:arr){
			charscount.putIfAbsent(c, 0);
			charscount.get(c)++;
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
				char leftchar = s.charAt(curLeft);
				if(charscount.containsKey(leftchar)){
					charscount.put(leftchar, );
				}
			}
		}
		
		return "";
	}

	public static void main(String[] args){
		char[] arr = new char[]{'x', 'y', 'z'};
		String s = "xyyyzyx";
		String sub = findSmallestSubstring1(arr, s);
		System.out.println("Smallest substring is:"+sub);
	}
}