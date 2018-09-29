/**
Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.

Example:
Given a = 1 and b = 2, return 3.
*/

/**
-this is a bit manipulation problem
-we take the addition as a two step process
-step1 just taking care of sum and ignoring the carries from previous positions
-step2 just taking care of carries and ignoring the sum
-the sum is 0 if and only if both digits at the position have same value (i.e. 0+0 = 0 and 1+1 = 10 -where 1 will be the carry and 0 will be the part of the sum)
-the carry will be 1 only if both values are 1 in the previous position
-hence the sum operation is equivalent to exclusive OR (0^0=0 and 1^1 = 0)
-the carry operation is equivalent to AND (0&0 = 0, 1&1 = 1)
-so, first we find the sum and the carry separately and recursively call the add operation for the sum and carry to get the final result
*/

public class SumWithoutAddition{

	public static int getSum(int a, int b){
		//base case
		if(b==0)
			return a;
		int sum = a^b;
		int carry = (a&b)<<1;
		return getSum(sum, carry);
	}
	
	public static void main(String args[]){
		int a = 500;
		int b = 10;
		System.out.println("sum of:"+a+" and "+b+" is:"+getSum(a, b));
	}
}