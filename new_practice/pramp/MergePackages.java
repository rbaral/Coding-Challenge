/**
#Merging 2 Packages

Given a package with a weight limit and an array arr of item weights, how can you most efficiently find two items with sum of weights that equals the weight limit?

example:
findComplementingWeights([2, 4, 8, 14], 12);
// [1, 2] or [2, 1]


Your function should return 2 such indices of item weights or -1 if such pair doesn't exist. What is the runtime and space complexity of your solution?
*/
import java.util.*;

public class MergePackages{

	/**
	Method1:
	-this is a classic two sum problem
	-use the items in hash in first pass
	-in second pass check if the complement of an item is present in the hash or not
	O(n) time and O(n) space
	*/
	public static int[] findComplementingWeights(int[] arr, int limit){
		
	}
	public static void main(String args[]){
		
	}

}