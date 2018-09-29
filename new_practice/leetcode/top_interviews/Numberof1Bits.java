/**
Write a function that takes an unsigned integer and returns the number of '1' bits it has (also known as the Hamming weight).

Example 1:

Input: 11
Output: 3
Explanation: Integer 11 has binary representation 00000000000000000000000000001011 
Example 2:

Input: 128
Output: 1
Explanation: Integer 128 has binary representation 00000000000000000000000010000000
*/
import java.lang.Integer;

public class Numberof1Bits{
	
	/**
	>> is arithmetic shift right, >>> is logical shift right.

	In an arithmetic shift, the sign bit is extended to preserve the signedness of the number.

	For example: -2 represented in 8 bits would be 11111110 (because the most significant bit has negative weight). Shifting it right one bit using arithmetic shift would give you 11111111, or -1. Logical right shift, however, does not care that the value could possibly represent a signed number; it simply moves everything to the right and fills in from the left with 0s. Shifting our -2 right one bit using logical shift would give 01111111.
	*/
	public static int hammingWeight1(int n) {
        int res = 0;
        for(int i=0; i<32; i++){
            res += n & 1; 
            n >>>= 1; // unsign right shift
        }
        return res;
    }
	
	/**
	it works but time limit exceeds for large inputs
	*/
	public static int hammingWeight2(int n){
		int mask = 1;
		int count = 0;
		while(n>0){
			if((mask&n)!=0){
				count++;
			}
			n>>>=1;
		}
		//for the last remaining 1
		if((n&mask)==1)
			count++;
		return count;
	}
	
	public static void main(String args[]){
		int n = 7;
		n =   Integer.MAX_VALUE;// (10000000000000000000000000000000)
		System.out.println(hammingWeight1(n));
		System.out.println(hammingWeight2(n));
	}
}