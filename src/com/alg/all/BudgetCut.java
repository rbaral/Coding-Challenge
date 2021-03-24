/**
The awards committee of your alma mater (i.e. your college/university) asked for your assistance with a budget allocation problem they’re facing. Originally, the committee planned to give N research grants this year. However, due to spending cutbacks, the budget was reduced to newBudget dollars and now they need to reallocate the grants. The committee made a decision that they’d like to impact as few grant recipients as possible by applying a maximum cap on all grants. Every grant initially planned to be higher than cap will now be exactly cap dollars. Grants less or equal to cap, obviously, won’t be impacted.

Given an array grantsArray of the original grants and the reduced budget newBudget, write a function findGrantsCap that finds in the most efficient manner a cap such that the least number of recipients is impacted and that the new budget constraint is met (i.e. sum of the N reallocated grants equals to newBudget).

Analyze the time and space complexities of your solution.

Example:

input:  grantsArray = [2, 100, 50, 120, 1000], newBudget = 190

output: 47 # and given this cap the new grants array would be
           # [2, 47, 47, 47, 47]. Notice that the sum of the
           # new grants is indeed 190
Constraints:

[time limit] 5000ms

[input] array.double grantsArray

0 ≤ grantsArray.length ≤ 20
0 ≤ grantsArray[i]
[input] double newBudget

[output] double
*/
import java.util.*;

public class BudgetCut{
	
	/**
	Method1:
	-sort the array
	-divide the given budget equally into all the elements (call it as cap) assuming all the elements will take some part of it
	-iterate on the sorted array and keep on assigning the cap to each element
	-- if the number is smaller than cap, we don't assign the cap but keep the value intact, so we can use its portion to other items on right of it, hence the cap will be increased by cap= cap + cap/(arr.length - i), where i is the current iteration index
	-- if the number is larger than cap, just replace this and all the following elements with the cap and we are done
	O(nlogn) to sort the array, O(n) to iterate the array and check which element will remain intact and which will be replaced by the cap
	O(1) Space
	*/
	static double findGrantsCap1(double[] grantsArray, double newBudget){
		//base case
		if(grantsArray==null || grantsArray.length<1 || newBudget<=0){
			return 0;
		}
		System.out.println("org array is:"+Arrays.toString(grantsArray));
		//sort the array so that for items less than cap, we can accumulate the values to get the updated cap
		Arrays.sort(grantsArray);
		//the initial assumed cap for each element
		double cap = newBudget/grantsArray.length;
		//now assign the cap to the elements that have high value
		for(int i=0;i<grantsArray.length; i++){
			if(grantsArray[i]<cap){
				//the cap for others increase because it will be left intact
				cap+=(cap-grantsArray[i])/(grantsArray.length - (i+1));
			}else{
				//this and all the elements following this will get the value cap
				grantsArray[i] = cap;
			}
		}
		System.out.println("new allocation is:"+Arrays.toString(grantsArray));
		return cap;
	} 
	
	public static void main(String args[]){
		double[] nums = new double[]{2, 100, 50, 120, 1000};
		nums = new double[]{2, 40, 50, 120, 1000};
		double newbudget = 190;
		System.out.println("the cap1 is:"+findGrantsCap1(nums, newbudget));
	}


}