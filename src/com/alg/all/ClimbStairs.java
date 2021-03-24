/**
A child is running up a staircase with n steps, and can hop either 1 step, 2 steps, or
3 steps at a time. Implement a method to count how many possible ways the child
can run up the stairs.
*/
import java.util.*;

public class ClimbStairs{

	/**
	Method1:
	-use the concept of fibonacci series
	fn = fn-1 + fn-2 + fn-3
	O(n^3) and O(1) space
	*/
	public static int findWays1(int n){
		if(n<2){
			return 1;
		}
		if(n==2){
			return 2;
		}
		if(n==3){
			return 4;
		}
		return findWays1(n-1) + findWays1(n-2) + findWays1(n-3);
	}
	
	/**
	Method2:
	-use DP to memoize the result and use it later rather than computing the values again and again
	O(n) time and O(n) space
	*/
	public static int findWays2(int n){
		if(n<=1){
			return 1;
		}
		if(n==2){
			return 2;
		}
		if(n==3){
			return 4;
		}
		HashMap<Integer, Integer> maps = new HashMap<>();
		maps.put(0, 0);
		maps.put(1, 1);
		maps.put(2, 2);
		maps.put(3, 4);
		return findWays2Helper(n, maps);
	}
	
	public static int findWays2Helper(int n, HashMap<Integer, Integer> maps){
		if(maps.containsKey(n)){
			return maps.get(n);
		}
		int val = findWays2Helper(n-1, maps) + findWays2Helper(n-2, maps) + findWays2Helper(n-3, maps);
		maps.put(n, val);
		return maps.get(n);
	}
	
	/**
	Method3
	-using three counters
	-just keep track of the values of the previous three values of n
	-add the three values to find the value for n+1
	O(n) time and O(1) space
	*/
	public static int findWays3(int n){
		if(n<=1){
			return 1;
		}
		if(n==2)
			return 2;
		if(n==3)
			return 4;
		int prev1 = 1;
		int prev2 = 2;
		int prev3 = 4;
		for(int i=4; i<=n; i++){
			int val = prev1 + prev2 + prev3;
			prev1 =prev2;
			prev2 = prev3;
			prev3 = val;
		}
		return prev3;
	}
	
	public static void main(String args[]){
		int n = 4;
		System.out.println(findWays1(n));
		System.out.println(findWays2(n));
		System.out.println(findWays3(n));
	}

}