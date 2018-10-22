/**
Given a non-empty list of words, return the k most frequent elements.

Your answer should be sorted by frequency from highest to lowest. If two words have the same frequency, then the word with the lower alphabetical order comes first.

Example 1:
Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
Output: ["i", "love"]
Explanation: "i" and "love" are the two most frequent words.
    Note that "i" comes before "love" due to a lower alphabetical order.
Example 2:
Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
Output: ["the", "is", "sunny", "day"]
Explanation: "the", "is", "sunny" and "day" are the four most frequent words,
    with the number of occurrence being 4, 3, 2 and 1 respectively.
Note:
You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
Input words contain only lowercase letters.
Follow up:
Try to solve it in O(n log k) time and O(n) extra space.

https://leetcode.com/problems/top-k-frequent-words/discuss/108346/My-simple-Java-solution-using-HashMap-and-PriorityQueue-O(nlogk)-time-and-O(n)-space
*/
import java.util.*;

class Word{
	String text;
	int count;
	Word(){
	}
	Word(String t, int c){
		text = t;
		count = c;
	}
}
public class TopKFrequentWords{

	/**
	Method1:
	-use hash to store the words and their count as word,count key value pairs
	-create another hash to store the words by their count
	-sort the key (i.e.) count of the words by storing them in a separate array
	-iterate the array by the largest value and use that word in the resulting array, if there are more than one words in a particular count, sort the words so that they appear alphabetically
	
	complexity: O(n) to store the words in hash and use their count to align words by their count, O(nlogn) to sort the words with same count
	Space: O(n) space for the hash to store the words by count, O(n) for the sorted counts
	
	Can we do better?
	-use hashmap to store the words and accumulate their count
	-use priority queue to hold k elements at a time so that the queue always holds the top-k frequent items, we need to customize the comparator of the priority queue to make it a min heap and sort the words with same frequency by their alphabetical ordering
	-always make the size of the heap equal to K by popping the smallest frequency element from the top
	-pop the k items from the queue
	Complexity: O(n) to collect the count of words
	Space: O(n) for the hash, and O(k) for the heap
	
	*/
	public static List<String> topKFrequent(String[] words, int k) {
        List<String> freqwords = new ArrayList<String>();
		//base cases
		if (words == null || words.length == 0 || k == 0) {
            return freqwords;
        }
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for(int i=0;i<words.length; i++){
			map.put(words[i], map.getOrDefault(words[i], 0)+1);
		}
		//now put the words in heap, by using their freq
		PriorityQueue<Word> pq = new PriorityQueue<Word>(new Comparator<Word>(){
			@Override
			public int compare(Word w1, Word w2){
				if(w1.count<w2.count){
					return 1;
				}else if(w1.count>w2.count){
					return -1;
				}else{
					return w1.text.compareTo(w2.text);
				}
			}
		});
		for(String s:map.keySet()){
			Word w = new Word(s, map.get(s));
			pq.offer(w);
			//we need to maintain the size of the queue to save space, so just get rid of the word that is of smallest count
			/*
			if(pq.size()>k){
				pq.poll();
			}*/
		}
		//now get the top-k frequen words from the heap
		while(!pq.isEmpty() && k>0){
			Word w = pq.poll();
			freqwords.add(w.text);
			k--;
		}
		return freqwords;
    }
	
	public static void main(String[] args){
		String[] words = {"i", "love", "leetcode", "i", "love", "coding"};
		int k = 2;
		List<String> freqwords = topKFrequent(words, k);
		System.out.println("freq words are:"+Arrays.toString(freqwords.toArray(new String[freqwords.size()])));
		
		words = new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
		k = 4;
		freqwords = topKFrequent(words, k);
		System.out.println("freq words are:"+Arrays.toString(freqwords.toArray(new String[freqwords.size()])));
	}

}