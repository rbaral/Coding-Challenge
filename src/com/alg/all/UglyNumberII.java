/**
Write a program to find the n-th ugly number.

Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. 

Example:

Input: n = 10
Output: 12
Explanation: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
Note:  

1 is typically treated as an ugly number.
n does not exceed 1690.
*/
import java.util.*;
public class UglyNumberII{

	/**
	-use heap to store the prime factors
	-repeat till the counter is less than n
	-poll the minimum element from the heap and multiply it with 2, 3, 5 and store the result in heap
	*/
	public static int nthUglyNumber(int n) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		pq.offer(1);
		int count = 1;
		int prod = 1;
		while(count<n){
			int min = pq.poll();
			System.out.println("min is:"+min);
			prod = min*2;
			pq.offer(prod);
			//System.out.println("adding:"+prod);
			count++;
			if(count==n){
				return prod;
			}
			prod = min*3;
			pq.offer(prod);
			//System.out.println("adding:"+prod);
			count++;
			if(count==n){
				return prod;
			}
			prod = min*5;
			pq.offer(prod);
			//System.out.println("adding:"+prod);
			count++;
			if(count==n){
				return prod;
			}
		}
		return 1;
    }
	
	public static void main(String[] args){
		int n = 10;
		System.out.println(n+" th ugly number is:"+nthUglyNumber(n));
	}

}