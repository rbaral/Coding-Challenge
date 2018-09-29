/**
check if two given strings are permutations of each other
*/
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

public class Permutations{
	
	public static String sortString(String s){
		char[] chars = s.toCharArray();
		Arrays.sort(chars);
		return new String(chars);
	}
	/**
	sorts the two strings and check if they are same
	O(nlogn), space O(n)
	*/
	public static boolean isPerm1(String s1, String s2){
		//if length differs then not permutation
		if(s1.length()!=s2.length())
			return false;
		if(sortString(s1).equals(sortString(s2))){
			return true;
		}
		return false;
	}
	
	/**
	we store the count of characters from one string and check if
	same count is present in the second string
	We can store the count in HashMap or in an array
	O(n), space O(n)
	*/
	public static boolean isPerm2(String s1, String s2){
		if(s1.length()!=s2.length())
			return false;
		int[] charCounts = new int[256];// we assume the characters are in ASCII
		for(char s:s1.toCharArray()){
			charCounts[s]+=1;
		}
		for(char s:s2.toCharArray()){
			if(--charCounts[s]<0){
				return false;
			}
		}
		//the following loop is not required because if there is different characters in s1, then there will be another characetr in place of this in s2, hence the count will be negative for this char anyway
		//there might be a case that some of the characters from s1 were not in s2, the count will still be non-zero so check for such entries
		/*
		for(int i=0;i<charCounts.length; i++){
			if(charCounts[i]>0){
				return false;
			}
		}
		*/
		return true;
		
	}
	
	/**
	we use HashMap to store the count, the rest logic is similar to isPerm2(..)
	*/
	public static boolean isPerm3(String s1, String s2){
		//base case-check if strings are of same length
		if(s1.length()!=s2.length())
			return false;
		Map<Character, Integer> charsCount = new HashMap<Character, Integer>();
		for(char s: s1.toCharArray()){
			
			if(!charsCount.containsKey(s)){
				charsCount.put(s, 0);
			}
			charsCount.put(s, charsCount.get(s));
		}
		//now use second string to check if same count exist
		for(char s:s2.toCharArray()){
			//if this character is not found then not permutation
			if(!charsCount.containsKey(s)){
				return false;
			}
			charsCount.put(s, charsCount.get(s) -1);
		}
		return true;
	}
	
	public static void main(String args[]){
		String s1= "abcdefg";
		String s2 = "cdebafg";
		
		System.out.println("is permutation from method1: "+isPerm1(s1, s2));
		System.out.println("is permutation from method2: "+isPerm2(s1, s2));
		System.out.println("is permutation from method3: "+isPerm3(s1, s2));
	}
}