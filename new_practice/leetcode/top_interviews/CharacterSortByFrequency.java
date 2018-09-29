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

public class CharacterSortByFrequency{

	/**
	-store the character count in hash
	-later iterate through the count and compute a new string
	*/
	public static String frequencySort(String s) {
        HashMap<Integer, List<Character>> charsMap = new HashMap<>();
		int[] counts = new int[256];//assume the character is stored in ASCII
		for(char c:s.toCharArray()){
			counts[c]++;
		}
		for(int i=0;i<256; i++){
			if(counts[i]>0){
				charsMap.putIfAbsent(counts[i], new ArrayList<Character>());
				charsMap.get(counts[i]).add((char)i);
			}
		}
		//now build the string using the characters by their descending count order
		StringBuilder sb = new StringBuilder();
		for(int i=s.length(); i>0;i--){
			//if the hash contains this index as the count
			if(charsMap.containsKey(i)){
				for(char c:charsMap.get(i)){
					//append as many characters as the count was stored in hash key
					for(int j =0;j<i;j++){
						sb.append(c);//append all the characters that have this count
					}
					System.out.println("string is:"+sb.toString());
				}
			}
		}
		return sb.toString();
    }
	
	public static void main(String args[]){
		String s = "cccaaa"; //Expected output is "cccaaa"
		System.out.println("String "+s+" sorted by char frequency is:"+frequencySort(s));
	}
}