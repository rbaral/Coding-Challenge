/**
Given an integer, write a function to determine if it is a power of three.

Example 1:

Input: 27
Output: true
Example 2:

Input: 0
Output: false
Example 3:

Input: 9
Output: true
Example 4:

Input: 45
Output: false
Follow up:
Could you do it without using any loop / recursion?
*/

public class PowerOfThree{

	public static boolean isPowerthree1(int num){
		double rem = num;
		while(rem>1){
			rem = rem/3;
		}
		if(rem==1.0){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	In particular, n is of type int. In Java, this means it is a 4 byte, signed integer [ref]. 
	The maximum value of this data type is 2147483647.
	Knowing the limitation of n, we can now deduce that the maximum value of n that is also a power of three is 1162261467.
	Therefore, the possible values of n where we should return true are 3^0,...3^19
	Since 3 is a prime number, the only divisors of 3^{19} are 3^0, 3^1,...,3^19.
	, therefore all we need to do is divide 3^{19}  by n. 
	A remainder of 0 means n is a divisor of 3^{19}​  and therefore a power of three.
	https://leetcode.com/articles/power-of-three/
	*/
	public static boolean isPowerthree2(int n){
		return n > 0 && 1162261467 % n == 0;
	}
	
	public static void main(String args[]){
		int num = 27;
		System.out.println(num+" is power of 3:"+isPowerthree1(num));
	}
}