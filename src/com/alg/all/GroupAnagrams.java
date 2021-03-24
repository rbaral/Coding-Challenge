/**
Given an array of strings, group anagrams together.

Example:

Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
Note:

All inputs will be in lowercase.
The order of your output does not matter
*/
import java.util.*;

public class GroupAnagrams{

	/**
	Method1:
	-for each item in the array, sort it and check if it is already present in a hash
	-if already present, add to the same list with the key in the hash, else add under the new key
	-iterate through the hash and return the values
	O(n) iterate through the array, O(nlogn) to sort the array
	Space O(n) for the hash
	*/
	public static List<List<String>> groupAnagrams1(String[] strs) {
        List<List<String>> lists = new ArrayList<>();
		//base case
		if(strs==null || strs.length<1){
			return lists;
		}
		HashMap<String, List<String>> hashanagrams = new HashMap<>();
		for(String s: strs){
			char[] s1 = s.toCharArray();
			Arrays.sort(s1);
			System.out.println("sorted is:"+String.valueOf(s1));
			if(!hashanagrams.containsKey(String.valueOf(s1))){
				hashanagrams.put(String.valueOf(s1), new ArrayList<String>());
			}
			hashanagrams.get(String.valueOf(s1)).add(s);
		}
		//return the list of anagrams
		for(String ana:hashanagrams.keySet()){
			lists.add(hashanagrams.get(ana));
		}
		return lists;
    }
	
	public static void main(String[] args){
		String [] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
		List<List<String>> lists = groupAnagrams1(strs);
		for(List<String> list:lists){
			System.out.println(Arrays.toString(list.toArray(new String[list.size()])));
		}
	}
}