/**
Compute and return the square root of x, where x is guaranteed to be a non-negative integer.

Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.

Example 1:

Input: 4
Output: 2
Example 2:

Input: 8
Output: 2
Explanation: The square root of 8 is 2.82842..., and since 
             the decimal part is truncated, 2 is returned.
*/

public class SquareRootFinder{

	/**
	Method1
	-assume 1 is the square root and iteratively increase the value till we reach the approx of the given number
	O(n), where n is the given number
	TIME LIMIT EXCEEDED in Leetcode
	*/
	public static int mySqrt1(int x) {
		//base case
		if(x<1)
			return 0;
        int val = 1;
		while(true){
			if(Math.ceil(val*val)==x){
				return val;
			}else if(Math.ceil(val*val)>x){
				return val-1;
			}
			val++;
		}
    }
	
	/**
	Method2:
	-use binary search
	- val*val<=x && (val+1)*(val+1)>x is the rul for the square root
	-define the low value as 1 and high value as x/2, and mid as (low+high)/2
	-if mid*mid<x, low++
	-if mid*mid>x, high--
	*/
	public static int mySqrt2(int x){
		if(x==0 || x==1)
			return x;
		int low = 1, high = x/2;
		long mid = 0; //to avoid int overflow
		int ans = 0;
		while(low<=high){
			mid = (low+high)/2;
			if((int)mid*mid==x){
				//found one
				return (int)mid;
			}else if((int)mid*mid>x){
				high = (int)mid-1;
			}else if((int)mid*mid<x){
				low = (int)mid+1;
				ans = (int)mid;//we keep the value because it might be the square root but without the fraction part (e.g., it might be 2*2 for 8 instead of 2.8*2.8)
			}
		}
		return ans;
	}
	
	public static void main(String args[]){
		int val = 8;
		System.out.println("the square root1 of "+val+" is "+mySqrt1(val));
		System.out.println("the square root2 of "+val+" is "+mySqrt2(val));
	}
}