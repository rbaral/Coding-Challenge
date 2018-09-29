/**
You are given two 32-bit numbers, N andM, and two bit positions, i and j. Write a
method to insert M into Nsuch that M starts at bit j and ends at bit i. You can assume
that the bits j through i have enough space to fit all ofM. That is, ifM= 10011,
you can assume that there are at least 5 bits between j and i. You would not, for
example, have j-3 and i=2, because M could not fully fit between bit 3 and bit 2.
EXAMPLE:
Input: N = 16000000000, M = 10011, i = 2, j = 6
Output: N = 10001001100
*/



/**
Soln:
-we need to clear the j through i bits of N
-then we shift M left by i bits so that it aligns to the correct position to be inserted
-we do OR of the above two to get the desired result
-Clearing the j through it bits of N
--prepare a mask of all ones on all the bits position except from j through i
--apply the mask to N to clear the bits from j through i
--we can create two masks- the one that has all ones on left part and the one that has all ones for the right part
*/
public class BitnByteInsertMIntoN{

	public static int mergenumbers(int n, int m, int i, int j){
		System.out.println("Before n is: "+n);
		//prepare the mask to retain 1s from msb to j+1 bit
		int allOnes = ~0;
		//shift them by j+1 bits
		int leftMask = allOnes<<(j+1);
		//prepare another mask that retains 1s from lsb to i-1th bit
		int rightMask = (1<<i)-1;
		//now prepare the final mask
		int mask = leftMask|rightMask;
		//clear the j through i bits of n by doign AND with the mask
		int n_masked = n&mask;
		//now shift m by j bits to align it to the correct position
		int m_shifted = m<<i;
		int result = n_masked|m_shifted;
		return result;
	}
	public static void main(String args[]){
		int n = 103217; //first number=> 11001001100110001
		int m = 13; //second number=>1101
		int i=2, j= 5; //bits
		//merged result is:11001001100110101  11001001100 1101 01
		n = mergenumbers(n, m, i,  j);
		System.out.println("after n is:"+n);
	}
}
