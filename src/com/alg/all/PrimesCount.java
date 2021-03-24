/**
Count the number of prime numbers less than a non-negative number, n.

Example:

Input: 10
Output: 4
Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.

Ref: https://leetcode.com/problems/count-primes/
*/
import java.util.*;

public class PrimesCount{

	public static int countPrimes(int n) {
        boolean primes[] = new boolean[n];
		//lets assume every number from 2 onwards is a prime
		for(int i=2; i<n; i++){
			primes[i] = true;
		}
		int count = 0;
		for(int i=2; i<n; i++){
			if(primes[i]){//if i is a prime, its multiple is not prime
				count++;
				for(int j=2; j*i<n; j++){//2*i, 3*i,...,k*i are not prime
					primes[j*i] = false;
				}
			}
		}
        return count;
    }

	public static void main(String[] args){
		int n = 5;
		System.out.println(countPrimes(n));
		System.out.println(countPrimes(10));
		System.out.println(countPrimes(499979));
		
	}

}