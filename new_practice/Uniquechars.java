/**
check if a given string has unique characters or not
-we assume that the given string contains ASCII characters (total 256 unique)
-we can also check the length of the string and if it is ASCII then it cannot be
longer than 256 characters and have all unique characters.
*/
import java.util.Map;
import java.util.HashMap;

public class Uniquechars{
	
	public static boolean isUniqueMethod0(String s){
		//base case
		if(s.length()>256)
			return false;
		
		//sort the string and check if the consecutive characters are duplicate
		//sorting: O(nlogn), iteratively scanning O(n); can take additional space
		return false;
	}
	
	/**
	we use a nested loop 
	O(n^2)
	*/
	public static boolean isUniqueMethod1(String s){
		//base case
		if(s.length()>256)
			return false;
		for(int i=0;i<s.length(); i++){
			for(int j=i+1; j<s.length(); j++){
				if(s.charAt(i) == s.charAt(j)){
					return false;
				}
			}
		}
		return true;
	}
	
	
	/**
	We use a hahsmap to store the character and its count
	O(n), space O(n)
	*/
	public static boolean isUniqueMethod2(String s){
		//base case
		if(s.length()>256)
			return false;
		Map<Character, Integer> charMap = new HashMap<Character, Integer>();
		for(int i=0;i<s.length(); i++){
			if(charMap.containsKey(s.charAt(i))){
				return false;
			}
			charMap.put(s.charAt(i), 1);
		}
		return true;
	}
	
	/**
	We use a boolean array to store the occurence of a character
	as we use ASCII characters, we can use an array of fixed size of 256
	O(n), space O(1)
	*/
	public static boolean isUniqueMethod3(String s){
		//base case
		if(s.length()>256)
			return false;
		boolean[] chars = new boolean[256];
		for(int i=0; i<s.length(); i++){
			if(chars[s.charAt(i)]==true){
				return false;
			}
			chars[s.charAt(i)]= true;
		}
		return true;
	}
	
	/**
	We use the concept of bit and store the occurence of characters
	int an integer variable, if the bit position is already set, the
	characters is a duplicate. However, this method works insensitive to case.
	It is efficient is space.
	O(n), space: O(1)
	
	*/
	public static boolean isUniqueMethod4(String s){
		//base case
		if(s.length()>256)
			return false;
		int val =0;
		for(int i=0; i<s.length(); i++){
			int charVal = s.charAt(i) -'a';
			if((val & (1<<charVal))>0){
				return false;
			}
			val=val|(1<<charVal);
		}
		return true;
	}
	
	public static void main(String args[]){
		String s = "abcdeA";
		System.out.println("is unique from method1 "+isUniqueMethod1(s));
		System.out.println("is unique from method2 "+isUniqueMethod2(s));
		System.out.println("is unique from method3 "+isUniqueMethod3(s));
		System.out.println("is unique from method4 "+isUniqueMethod4(s));
	}
}