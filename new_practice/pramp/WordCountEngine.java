/**
#Word Count Engine

Implement a document scanning engine that receives a text document doc and returns a list of all unique words in it and their number of occurrences, sorted by the number of occurrences in descending order.

Example:

    for doc: "practice makes perfect. get perfect by practice. just practice!"

    the engine returns the list: { practice: 3, perfect: 2,  makes: 1, get: 1, by: 1, just: 1 }.
The engine should ignore punctuation and white-spaces.

Find the minimal runtime complexity and analyze it.
*/

import java.util.*;

class Word{
	String word;
	int count;
	Word(String w, int c){
		word = w;
		count = c;
	}
}
public class WordCountEngine{
	
	/**
	-for every word, store the word and its count in hash
	-build a priority queue or max heap using the hash entries
	Ref: https://leetcode.com/problems/top-k-frequent-words/discuss/108346/My-simple-Java-solution-using-HashMap-and-PriorityQueue-O(nlogk)-time-and-O(n)-space
	*/
	public static List<String> getWordLists(String doc, int k){
		//remove punctuation and white spaces
		doc = doc.replaceAll("!", "");
		doc = doc.replaceAll("\\.","");
		doc = doc.trim();
		System.out.println(doc);
		String[] words = doc.split(" ");
		List<String> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<words.length; i++)
        {
            if(map.containsKey(words[i]))
                map.put(words[i], map.get(words[i])+1);
            else
                map.put(words[i], 1);
        }
        
		PriorityQueue<Word> pq = new PriorityQueue<>(
                 (a,b) -> a.count==b.count ? b.word.compareTo(a.word) : a.count-b.count
        );
        
        for(String s: map.keySet())
        {	Word w = new Word(s, map.get(s));
			pq.offer(w);
			/*
			if(pq.size()>k)
                pq.poll();
			*/
        }

        while(!pq.isEmpty()){
			Word w = pq.poll();
            result.add(0, w.word+""+w.count);
        }
        return result;
	}
	
	
	public static void main(String args[]){
		String doc = "practice makes perfect. get perfect by practice. just practice!";
		List<String> wordsList = getWordLists(doc, 3);
		for(String word:wordsList){
			System.out.println(word);
		}
	}
}