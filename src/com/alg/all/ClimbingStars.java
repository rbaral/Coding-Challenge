/**
You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Note: Given n will be a positive integer.

Example 1:

Input: 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps
Example 2:

Input: 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step
*/
import java.util.HashMap;
import java.lang.Integer;

public class ClimbingStars{

	public static int getStepsRecursive(int n){
		if(n<=1)
			return 1;
		else if(n==2)
			return 2;
		else{
			return getStepsRecursive(n-1) + getStepsRecursive(n-2);
		}
	}
	
	/**
	-iteratively scan the array and store the number of possible steps
	-use the already stored steps count if possible
	-uses the concept of Dynamic programming (use stored values rather than computing again and again)
	*/
	public static int getStepsIterative(int n){
		//base cases
		if(n<=0){
			return 0;
		}else if(n==1)
			return 1;
		//lets store the values of step counts in a Map
		HashMap<Integer, Integer> counts = new HashMap<Integer, Integer>();
		counts.put(0, 0);
		counts.put(1, 1);
		counts.put(2, 2);
		for(int i = 3; i<=n; i++){
			counts.put(i, counts.get(i-1) + counts.get(i-2));
		}
		return counts.get(n);
	}
	
	public static void main(String args[]){
		int stairs = 5;
		int steps1 = getStepsRecursive(stairs);
		System.out.println("Steps for:"+stairs+" in Recursive are:"+steps1);
		steps1 = getStepsIterative(stairs);
		System.out.println("Steps for:"+stairs+" in Iterative are:"+steps1);
		
	}
}