/**
Given an integer (signed 32 bits), write a function to check whether it is a power of 4.

Example 1:

Input: 16
Output: true
Example 2:

Input: 5
Output: false
Follow up: Could you solve it without loops/recursion?
*/

public class PowerofFour{
	
	/**
	ref: https://leetcode.com/problems/power-of-four/discuss/80457/Java-1-line-(cheating-for-the-purpose-of-not-using-loops)
	0x55555555 is a hexametrical number，it is 1010101010101010101010101010101 in binary with a length of 32. To make sure the 1 locates in the odd location.
	*/
	public boolean isPowerofFour3(int num) {
        return num > 0 && (num&(num-1)) == 0 && (num & 0x55555555) != 0;
        //0x55555555 is to get rid of those power of 2 but not power of 4
        //so that the single 1 bit always appears at the odd position 
    }
	
	public static boolean isPowerofFour2(int n){
		return n>0 && Math.log10(n)/Math.log10(4)%1==0;
	}
	
	/**
	Method1:
	-use loop
	*/
	public static boolean isPowerofFour1(int n){
		if(n<=0)
			return false;
		int power = 1;
		while(power<n && power>=1){
			power = power*4;
		}
		return power==n;
	}
	
	
	public static void main(String args[]){
		int n = -44;
		System.out.println(n+" is power of four:"+isPowerofFour1(n));
	}

}