/**
Makechanges

Given an infinite number of quarters (25 cents), dimes (10 cents), nickels (5 cents)
and pennies (1 cent), write code to calculate the number of ways of representing n
cents.
*/

public class MakeChangeWaysInfiniteCoins{

	public static int makeChange(int amount, int[] denoms, int index) {
		if (index >= denoms.length - 1) return 1; // one denom remaining -> one way to do it
		int denomAmount = denoms[index];
		int ways = 0;
		for (int i = 0; i * denomAmount <= amount; i++) {
			int amountRemaining = amount - i * denomAmount;
			ways += makeChange(amountRemaining, denoms, index + 1); // go to next denom
		}
		return ways;
	}
	
	public static int makeChange(int n) {
		int[] denoms = {25, 10, 5, 1};
		return makeChange(n, denoms, 0);
	}
	
	public static void main(String[] args) {
		for (int i = 0; i <= 100; i++) {
			System.out.println("makeChange(" + i + ") = " + makeChange(i));
		}
	}
}