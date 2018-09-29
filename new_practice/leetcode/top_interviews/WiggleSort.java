/**
Given an unsorted array nums, reorder it in-place such that nums[0] <= nums[1] >= nums[2] <= nums[3]....

For example, given nums = [3, 5, 2, 1, 6, 4], one possible answer is [1, 6, 2, 5, 3, 4].
*/
import java.util.Arrays;

public class WiggleSort{

	/**
	Method1:
	-sort the given array
	-use two pointers start and end and swap the elements at index start and end till start<end
	O(nlogn) time
	*/
	public static void wiggleSort1(int[] nums) {
		if(nums==null || nums.length<2)
			return;
        Arrays.sort(nums);
		int start = 1; //second element
		int end = nums.length-2; //second last	
		while(start<end){
			int temp = nums[start];
			nums[start] = nums[end];
			nums[end] = temp;
			start+=2;
			end-=2;
		}		
    }
	
	/**
	Method2:
	-without sorting
	-simply check if the number at odd index is greater than its previous indexed element, if not swap
	i.e., make sure the following properties hold, if not then swap
	if i%2 == 1, nums[i] >= nums[i-1];
	if i%2 == 0, nums[i] <= nums[i-1];
	O(n) time
	*/
	public static void wiggleSort2(int[] nums){
		for(int i=1; i<nums.length; i++){
			if(i%2==0 && nums[i]>nums[i-1]){
				int temp = nums[i-1];
				nums[i-1] = nums[i];
				nums[i] = temp;
			}else if(i%2!=0 && nums[i]<nums[i-1]){
				int temp = nums[i-1];
				nums[i-1] = nums[i];
				nums[i] = temp;
			}
		}
	}
	
	public static void main(String args[]){
		int[] nums = new int[]{1, 5, 1, 1, 6, 4};
		nums =  new int[] {1, 3, 2, 2, 3, 1};
		//nums = new int[]{1,2,2,1,2,1,1,1,1,2,2,2};
		System.out.println("Wiggle sort of "+Arrays.toString(nums)+" is ");
		wiggleSort1(nums);
		System.out.println(Arrays.toString(nums));
	}
}