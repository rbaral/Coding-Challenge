/**
Reverse bits of a given 32 bits unsigned integer.

Example:

Input: 43261596
Output: 964176192
Explanation: 43261596 represented in binary as 00000010100101000001111010011100, 
             return 964176192 represented in binary as 00111001011110000010100101000000.
Follow up:
If this function is called many times, how would you optimize it?
*/

public class BitsReverse{

	/**
	Method1:
	-convert given int to a binary string
	-reverse the binary string by using string operation
	
	-inefficient for long strings,
	*/
    public static int reverseBits1(int n) {
        return n;
    }
	
	/**
	Method2:
	-use bit mask to shift 1 on left and check if the value is greater than zero, 
	if so the bit is one and we	increase the resulting value by 2 to the power
	*/
	public static int reverseBits2(int n){
		int sum = 0;
		int mul = 1;//the value to multiply
		for(int i=31;i>=0;i--){
			if( (n&(1<<i))!=0){
				sum+=mul;
			}
			mul*=2;//increase the power as we go on the reverse direction
		}
		return sum;
	}
	
	
	public static void main(String args[]){
		int n = 43261596;
		System.out.println("Reverse bit of:"+n+" is "+reverseBits2(n));
	}
}