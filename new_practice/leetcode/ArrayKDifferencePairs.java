/**
Pairs with Specific Difference

Given an array of integers and an integer k, you need to find the number of unique k-diff pairs in the array. Here a k-diff pair is defined as an integer pair (i, j), where i and j are both numbers in the array and their absolute difference is k.

Example 1:
Input: [3, 1, 4, 1, 5], k = 2
Output: 2
Explanation: There are two 2-diff pairs in the array, (1, 3) and (3, 5).
Although we have two 1s in the input, we should only return the number of unique pairs.
Example 2:
Input:[1, 2, 3, 4, 5], k = 1
Output: 4
Explanation: There are four 1-diff pairs in the array, (1, 2), (2, 3), (3, 4) and (4, 5).
Example 3:
Input: [1, 3, 1, 5, 4], k = 0
Output: 1
Explanation: There is one 0-diff pair in the array, (1, 1).
Note:
The pairs (i, j) and (j, i) count as the same pair.
The length of the array won't exceed 10,000.
All the integers in the given input belong to the range: [-1e7, 1e7].
*/

import java.util.*;

public class ArrayKDifferencePairs{
	/**
	-we only need to count the number of pairs that give the difference of k
	-use hashmap to store the array item <k-b, a> where a and b are the array values
	-check if there is any element with key (k-b), if so, we found a pair
	-its a variant of two sum problem
	*/
	public static int findPairs(int[] arr, int k) {
		if(arr==null || arr.length<2 || k<0){
			return 0;
		}
		HashMap<Integer, Integer> pairsmap = new HashMap<Integer, Integer>();
		int count = 0;
		//store the item and their count to entertain the duplicate items too
		for(int i=0; i<arr.length; i++){
			pairsmap.put(arr[i], pairsmap.getOrDefault(arr[i], 0)+1);
		}
		//now check if we have the pairs in the hash map
		for(int i: pairsmap.keySet()){
			//if the difference is zero, more than or two occurences of a key is considered as a single pair
			if(k==0 && pairsmap.get(i)>=2){
				count++;
			}else if(k!=0){
				//check if the hash has a complement in it
				if(pairsmap.containsKey(i+k)){
					count++;
				}
			}
		}
		return count;
	}
	
	public static void main(String args[]){
		int[] arr = new int[]{1,3,1,5,4};
		int k = 2;
		
		arr = new int[]{1, 2, 3, 4, 5};
		k = 1;
		//pass1: store 2, 3, ,4, 5, 6
		//pass2: found=2,3,4,5,
		
		
		
		//arr = new int[]{1,2,3,4,5};
		//k = -1;
		
		//arr = new int[]{1,2,3,4,5};
		//k = 4;
		
		//arr = new int[]{1,3,1,5,4};
		//k = 0;
		
		//arr = new int[]{1,1, 1, 1, 1};
		//k = 0;
		
		System.out.println("pairs count is:"+findPairs(arr, k));
	}

}