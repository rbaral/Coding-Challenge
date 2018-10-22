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

public class BitByteInsertOneNumberIntoAnother{

	public static int updateBits1(int n, int m, int i, int j){
		//create a mask to clear bits between i and j from the given number n
		int allOnes = ~0;
		int leftmask = allOnes<<(j+1);
		int rightmask = (1<<i) - 1;
		int mask = leftmask|rightmask;
		int n_cleared = n&mask;
		int m_shifted = m<<i;
		n_cleared = n_cleared | m_shifted;
		return n_cleared;
		
	}

	public static void main(String[] args) {
		int a = 103217;
		System.out.println(Integer.toBinaryString(a));
		int b = 13;
		System.out.println(Integer.toBinaryString(b));		
		int c = updateBits1(a, b, 4, 12);
		System.out.println(Integer.toBinaryString(c));
	}
}