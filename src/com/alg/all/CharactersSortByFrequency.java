/**
Given a string, sort it in decreasing order based on the frequency of characters.

Example 1:

Input:
"tree"

Output:
"eert"

Explanation:
'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
Example 2:

Input:
"cccaaa"

Output:
"cccaaa"

Explanation:
Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
Note that "cacaca" is incorrect, as the same characters must be together.
Example 3:

Input:
"Aabb"

Output:
"bbAa"

Explanation:
"bbaA" is also a valid answer, but "Aabb" is incorrect.
Note that 'A' and 'a' are treated as two different characters.
*/
import java.util.*;

public class CharactersSortByFrequency{

	/**
	we declare and initialize and integer aray of size 256 and store the count of each char
	-create a hash map to store the characters by their count as key and the char as value
	-later iterate through the hash and put on stringbuilder
	O(n), Space is O(n)
	*/
	public static String frequencySort(String s) {
		int[] chars = new int[256];
		for(char c:s.toCharArray()){
			chars[c]++;
		}
		HashMap<Integer, List<Character>> charsmap = new HashMap<>();
		for(int i = 0;i<chars.length; i++){
			if(chars[i]>0){
				charsmap.putIfAbsent(chars[i], new ArrayList<Character>());
				charsmap.get(chars[i]).add((char)i);
			}
		}
		//now create stringbuilder to create the string with all chars
		StringBuilder sb = new StringBuilder();
		//iterate through end to have the largest count at the beginning of result string
		for(int i=s.length(); i>0;i--){
			if(charsmap.containsKey(i)){
				for(char c:charsmap.get(i)){
					//append all the characters with their count
					int count = 0;
					while(count<i){
						sb.append(c);
						count++;
					}
				}
			}
		}
		return sb.toString();
	}
	
	public static void main(String args[]){
		String s ="tree";
		System.out.println(s+" has freq order as:"+frequencySort(s));
		s = "cccaaa";
		System.out.println(s+" has freq order as:"+frequencySort(s));
	}

}
