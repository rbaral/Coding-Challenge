/**
Given an array of n unique integers where each element in the array is in range [1, n]. The array has all distinct elements and size of array is (n-2). Hence Two numbers from the range are missing from this array. Find the two missing numbers.

Examples :

Input  : arr[] = {1, 3, 5, 6}
Output : 2 4

Input : arr[] = {1, 2, 4}
Output : 3 5

Input : arr[] = {1, 2}
Output : 3 4
*/
import java.util.*;

public class ArrayTwoMissingNumbers{

	/**
	-use XOR of 1..n and all elements of nums
	-the XOR of same elements is always zero, so this will cancel out the elements that are present in both the given array and in the range 1...n, only the xor value of the missing numbers will be present.
	-A bit is set in xor only if corresponding bits in X and Y are different. This is the crucial step to understand.
	-find the right most set bit of the result and do XOR all the elements of nums and 1...n that have rightmost bit set, this will give one missing number
	-find the XOR of all the elements of nums and 1...n that have rightmost bit not set, this will give the second missing number
	Ref: https://www.geeksforgeeks.org/find-two-missing-numbers-set-2-xor-based-solution/
	*/
	public static int[] findTwoMissingNumbers(int[] arr){
		int n = arr.length+2;
		int xor = arr[0]; 
        for (int i = 1; i < n-2; i++) 
            xor ^= arr[i]; 
        for (int i = 1; i <= n; i++) 
            xor ^= i; 
		/**
		now xor has xor of the two missing elements because the xor of common elements between 1..n and nums[..] are cancelled out by the xor operation.
		Any bit that is set must be set in one of the missing and unset in anohter missing number
		*/
		int set_bit_no = xor & ~(xor-1); 
		//now we divide the elements in two set by comparing rightmost set bit of xor with bit at same position on each element
		int x = 0, y =0;
		for(int i=0;i<n-2;i++){
			if((arr[i] & set_bit_no)>0){
				x = x ^ arr[i];
			}else{
				y = y ^ arr[i];
			}
		}
		for(int i=1;i<=n; i++){
			if((i & set_bit_no)>0){
				x = x ^ i;
			}else{
				y = y ^ i;
			}
		}
		int[] res = {x, y};
		return res;
	}
	
	static int[] findTwoMissingNumbers2(int arr[]) 
    { 
		int n = arr.length+2;
        /* Get the XOR of all elements in arr[] and 
           {1, 2 .. n} */
        int XOR = arr[0]; 
        for (int i = 1; i < n-2; i++) 
            XOR ^= arr[i]; 
        for (int i = 1; i <= n; i++) 
            XOR ^= i; 
       
        // Now XOR has XOR of two missing elements. 
        // Any set bit in it must be set in one missing 
        // and unset in other missing number 
       
        // Get a set bit of XOR (We get the rightmost 
        // set bit) 
        int set_bit_no = XOR & ~(XOR-1); 
       
        // Now divide elements in two sets by comparing 
        // rightmost set bit of XOR with bit at same  
        // position in each element. 
        int x = 0, y = 0; // Initialize missing numbers 
        for (int i = 0; i < n-2; i++) 
        { 
            if ((arr[i] & set_bit_no) > 0) 
                  
                /*XOR of first set in arr[] */
                x = x ^ arr[i];  
            else
                /*XOR of second set in arr[] */
                y = y ^ arr[i];  
        } 
          
        for (int i = 1; i <= n; i++) 
        { 
            if ((i & set_bit_no)>0) 
              
                /* XOR of first set in arr[] and 
                   {1, 2, ...n }*/
                x = x ^ i;  
            else
                /* XOR of second set in arr[] and 
                    {1, 2, ...n } */
                y = y ^ i;  
        } 
       
        System.out.println("Two Missing Numbers are "); 
        System.out.println( x + " " + y); 
		int[] res = new int[2];
		res[0] = x;
		res[1] = y;
		return res;
    }
	
	public static void main(String[] args){
		int[] nums = new int[]{1, 3, 5, 6};
		nums = new int[]{1,2,4};
		nums = new int[]{1,2};
		System.out.println("for the array:"+Arrays.toString(nums)+" two missing are:"+Arrays.toString(findTwoMissingNumbers(nums)));
		System.out.println("for the array:"+Arrays.toString(nums)+" two missing are:"+Arrays.toString(findTwoMissingNumbers2(nums)));
	}

}