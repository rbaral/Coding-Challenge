/**
Suppose you have a sorted array of infinite numbers, how would you search an element in the array?

Source: Amazon Interview Experience.
Since array is sorted, the first thing clicks into mind is binary search, but the problem here is that we don’t know size of array.
If the array is infinite, that means we don’t have proper bounds to apply binary search. So in order to find position of key, first we find bounds and then apply binary search algorithm.

Let low be pointing to 1st element and high pointing to 2nd element of array, Now compare key with high index element,
->if it is greater than high index element then copy high index in low index and double the high index.
->if it is smaller, then apply binary search on high and low indices found.
*/
import java.util.*;
public class ArraySearchUnknownSize{

	/**
	-we assume the array is infinite in size, so the bound exception is not cheked
	-we also assume that the array has at least two elements
	-we take the first two elements and set lowe=0, and high = 1and check if the target is smaller than the high index, if so, we search between the low and high
	-if the target is greater than low, then copy the value of high into low and double the high index
	-if the target is smaller than low, then apply binary search between high and low
	*/
	public static int findPos(int[] nums, int key){
		int low = 0, high = 1, val = nums[low];
		while(val< key){
			low = high;
			high = 2*high;
			val = nums[high];
		}
		return binarySearch(nums, low, high, key);
	}
	
	public static int binarySearch(int[] nums, int start, int end, int val){
		while(start<=end){
			int mid = (start+end)/2;
			if(nums[mid] == val){
				return mid;
			}else if(nums[mid]<val){
				start=mid+1;
			}else{
				end = mid-1;
			}
		}
		return -1;
	}
	
	// Driver method to test the above function 
    public static void main(String[] args)  
    { 
        int arr[] = new int[]{3, 5, 7, 9, 10, 90,  
                             100, 130, 140, 160, 170}; 
		int k = 10;
        int ans = findPos(arr, k); 
        System.out.println("Searching "+k+" in array:"+Arrays.toString(arr));
        if (ans==-1) 
            System.out.println("Element not found"); 
        else
            System.out.println("Element found at index " + ans); 
   } 

}