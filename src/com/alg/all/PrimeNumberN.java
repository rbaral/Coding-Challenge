/**
Find the nth prime number, where n is any positive integer

Ex: n =1
op: 2

Ex: n = 3
op: 5 (2,3,5 are the first three prime numbers, so 3 is the required answer)
*/

public class PrimeNumberN{

	public static int generatePrime(int n){
		//we iterate from 2 to sqrt(n) to check if the number is prime or not
		if(n==1){
			return 2;
		}
		int count = 1;//2 is already found
		int lastPrime = 2;
		while(count<n){
			if(isPrime(lastPrime++)){
				count++;
			}
		}
	}
	
	public static int isPrime(int n){
		for(int i=2; i*i<=n; i++){
			if(n%i==0){
				return false;
			}
		}
		return true;
	}
	
	public static void main(String args[]){
		System.out.println(generatePrime(2));
	}

}