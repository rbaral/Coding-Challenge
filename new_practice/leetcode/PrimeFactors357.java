/**
Design an algorithm to find the kth number such that the only prime factors are 3,
5, and 7.

{1, 3, 5, 7, 9, 15, 21, 25, 27, 35, 49, 105};
*/
import java.util.*;

public class PrimeFactors357{
	
	public static int findKthPrime(int k){
		
		if(k<=1){
			return 1;
		}
		//store the previous primes in min heap
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		pq.add(1);//1 is already a valid value
		//now repeatedly fetch the minimum value and multiply by 3, 5, and 7 and put back into the min heap
		int min = 0;
		int count = 1;
		while(count<k){
			System.out.println("pq size is:"+pq.size()+" and min is:"+pq.peek());
			min = pq.poll();
			int prod1 = min*3;
			pq.offer(prod1);
			count++;
			if(count==k){
				return prod1;
			}
			
			int prod2 = min*5;
			pq.offer(prod2);
			count++;
			if(count==k){
				return prod2;
			}
			
			int prod3 = min*7;
			pq.offer(prod3);
			count++;
			if(count==k){
				return prod3;
			}
		}
		return 1;
	}

	public static void main(String args[]){
		int k = 6;
		int num = findKthPrime(k);
		System.out.println(k+" th prime is:"+num);
	}
}