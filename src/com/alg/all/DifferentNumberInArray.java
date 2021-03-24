/**
Given an array of unique and non-negative integers, find a smallest integer that is not in the array

Even if your programming language of choice does not have restriction, assume
that the maximum value an integer can hold is MAX_INT = 2^31-1. So, for instance, the operation
MAX_INT + 1 would be undefined in our case.

Your algorithm should be efficient in terms of time and space complexity.

Solve first for the case when you are NOT allowed to modify the input array.
If successful, and still have some time, see if you can come up with an algorithm
with an improved peformance when modifying the array is allowed.
Do so without trading off time complexity.

Example1:
input: arr= [0,1,2,3]
output = 4

*/
import java.util.Arrays;
import java.util.HashMap;

public class DifferentNumberInArray{
	
	/**
	Method1:
	-a brute force approach is to start from 0 to arr.length and find if the number is present in the array
	-O(n^2) since we need to check for each element
	*/
	public static int getDifferentNumber1(int[] arr){
		int ans = 0;
		for(int i=0; i<=arr.length; i++){
			//check if the value i is present in the given array, if not it is the answer
			boolean found = false;
			for(int j=0; j<arr.length; j++){
				if(i==arr[j]){
					found = true;
					break;
				}
			}
			if(!found){
				ans = i;
				break;
			}
		}
		return ans;
	}
	
	/**
	Followup: we can use a hashmap to store the numbers ranging from 0 to arr.length and in second pass
	check if the number is present or not, if the number is not present then return that value
	*/
	public static int getDifferentNumber11(int[] arr){
		HashMap<Integer, Integer> mapnums = new HashMap<Integer, Integer>();
		//store all the elements in the arr into hash
		for(int i:arr){
			mapnums.put(i, i);
		}
		//now iterate through 0 to MAX_INT and check if that value is present in hash
		int maxint = (int)Math.pow(2, 31) -1;
		for(int i=0; i<=maxint; i++){
			if(!mapnums.containsKey(i)){
				return i;
			}
		}
		return maxint;
	}
	
	/**
	Method2:
	-use the formula sum = n*(n+1)/2 to find the sum taking n= arr.length
	-iterate through the elements of the array and subtract the value of each element from the sum
	-the remaining value in the sum is the required answer
	O(n)
	*/
	public static int getDifferentNumber2(int[] arr){
		int sum = (int)arr.length*(arr.length+1)/2;
		for(int i:arr){
			sum-=i;
		}
		return sum;
	}
	
	public static void main(String args[]){
		int[] arr = new int[]{0,1,2,3};
		System.out.println("Different number in array:"+Arrays.toString(arr)+" is:"+getDifferentNumber1(arr));
		System.out.println("Different number in array:"+Arrays.toString(arr)+" is:"+getDifferentNumber2(arr));
		System.out.println("Different number in array:"+Arrays.toString(arr)+" is:"+getDifferentNumber11(arr));
	}
}