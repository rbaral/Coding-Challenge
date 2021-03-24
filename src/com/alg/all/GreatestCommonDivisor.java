
/**
GCD (Greatest Common Divisor) or HCF (Highest Common Factor) of two numbers is the largest number that divides both of them.

A simple solution is to find all prime factors of both numbers, then find intersection of all factors present in both numbers. Finally return product of elements in the intersection.

An efficient solution is to use Euclidean algorithm which is the main algorithm used for this purpose. The idea is, GCD of two numbers doesn’t change if smaller number is subtracted from a bigger number.
*/
public class GreatestCommonDivisor{

	public static int findGCD(int a, int b){
		if(a==0){
			return b;
		}
		if(b==0)
			return a;
		if(a>b){
			return findGCD(a-b, b);
		}else
			return findGCD(a, b-a);
	}
	
	public static void main(String args[]){
		int a = 5;
		int b = 15;
		int gcd = findGCD(a, b);
		System.out.println(gcd);
	}
}