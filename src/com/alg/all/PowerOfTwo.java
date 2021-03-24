/**
Given an integer, write a function to determine if it is a power of two.

Example 1:

Input: 1
Output: true 
Explanation: 20 = 1
Example 2:

Input: 16
Output: true
Explanation: 24 = 16
Example 3:

Input: 218
Output: false
*/

public class PowerOfTwo{
	
	/**
	Method1:
	-use loop to divide the number by 2 repeatedly
	*/
	public static boolean isPowerofTwo1(int n){
		if(n<=0)
			return false;
		while(n>1){
			if(n%2!=0){
				return false;
			}
			n = n/2;
		}
		return true;
	}
	
	/**
	Method2
	-use recursive solution for n/2, and then for n/4, and so on.
	
	-another variant is to multiply a number (say power=1) by 2 repeatedly till it is less than n and is greater than or equal to 1 and after the loop is finished, check if power==n, if so return true, else return false;
	*/
	public static boolean isPowerofTwo2(int n){
		//base case
		if(n==1 || n==2){
			return true;
		}else{
			if(n<=0 ||n%2!=0){
				return false;
			}
			//recurse on n/2
			return isPowerofTwo2(n/2);
		}
	}
	
	/**
	/**
	In particular, n is of type int. In Java, this means it is a 4 byte, signed integer [ref]. 
	The maximum value of this data type is 2147483647.
	Knowing the limitation of n, we can now deduce that the maximum value of n that is also a power of two is 1073741824.
	Therefore, the possible values of n where we should return true are 2^0,...2^30
	Since 2 is a prime number, the only divisors of 2^{30} are 2^0, 2^1,...,2^30.
	, therefore all we need to do is divide 2^{30}  by n. 
	A remainder of 0 means n is a divisor of 2^{30}​  and therefore a power of two.
	https://leetcode.com/articles/power-of-three/
	*/
	*/
	public static boolean isPowerofTwo3(int n){
		return n>0 && 1073741824%n==0;
	}
	
	public static void main(String args[]){
		int n =8;
		System.out.println(n+" is power1 of two:"+isPowerofTwo1(n));
		System.out.println(n+" is power2 of two:"+isPowerofTwo2(n));
		System.out.println(n+" is power3 of two:"+isPowerofTwo3(n));
	}
	
}