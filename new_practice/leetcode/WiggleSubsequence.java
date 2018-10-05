/**
A sequence of numbers is called a wiggle sequence if the differences between successive numbers strictly alternate between positive and negative. The first difference (if one exists) may be either positive or negative. A sequence with fewer than two elements is trivially a wiggle sequence.

For example, [1,7,4,9,2,5] is a wiggle sequence because the differences (6,-3,5,-7,3) are alternately positive and negative. In contrast, [1,4,7,2,5] and [1,7,4,5,5] are not wiggle sequences, the first because its first two differences are positive and the second because its last difference is zero.

Given a sequence of integers, return the length of the longest subsequence that is a wiggle sequence. A subsequence is obtained by deleting some number of elements (eventually, also zero) from the original sequence, leaving the remaining elements in their original order.

Example 1:

Input: [1,7,4,9,2,5]
Output: 6
Explanation: The entire sequence is a wiggle sequence.
Example 2:

Input: [1,17,5,10,13,15,10,5,16,8]
Output: 7
Explanation: There are several subsequences that achieve this length. One is [1,17,10,13,10,16,8].
Example 3:

Input: [1,2,3,4,5,6,7,8,9]
Output: 2
Follow up:
Can you do it in O(n) time?
*/
import java.util.*;
public class WiggleSubsequence{

	/**
     * the wiggle is an increase and then decrease or it can be a decrease and then increase
     * for instance, 10,2,5,3,15,9 is decreasing first and increasing and so on
     * 2, 10, 7, 8, 3, 12 is increasing first and decreasing and so on.
     * For every item in the array, we check the longest wiggle we can achieve and return 
     * the longest among them
     * @param arr
     * @return 
     */
    public static int getLongestWiggleLength(int[] arr){
		//handle base cases
		if(arr==null || arr.length<1){
			return 0;
		}
		if(arr.length==1){
			return 1;
		}
        int maxlength = 1;
        int j=0;
        for(int i=1;i<arr.length; i++){
            //first increasing and then decreasing
            if(arr[j]<arr[i]){
                maxlength++;
                while(i<arr.length-1 && arr[i]<=arr[i+1]){
                    i++;
                }
            }else if(arr[j]>arr[i]){//first decreasing and then increasing
                maxlength++;
                while(i<arr.length-1 && arr[i]>=arr[i+1]){
                    i++;
                }
            }
            
            j = i;
        }
        return maxlength;
    }
	
	public static void main(String args[]){
        int[] arr = {1, 3, 9, 12, 6, 0, 15, 11};
		arr = new int[]{1,7,4,9,2,5};
		arr= new int[]{};
        System.out.println("original array:"+Arrays.toString(arr));
        System.out.println("longest wiggle length:"+getLongestWiggleLength(arr));
    }
}