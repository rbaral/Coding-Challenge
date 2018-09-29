/**
given a sorted array that is rotated, find
the minimum element of the array
*/
public class MinSortedRotatedArray{

	public static int findMinElement(int[] arr, int start, int end){
		if (start == end) {
			return arr[start];		
		}
		int mid = (start + end)/2;
		//case 1: min is on the right
		if (arr[mid] >arr[end]){
			return findMinElement(arr, mid+1, end);		
		}else{
			return findMinElement(arr, start, mid);
		}
	}

	public static void main(String args[]){
		int [] arr = {1,2,3,4,5,6,7};
		arr = new int[]{3,4,5,6,7,1,2};
		arr = new int[]{5,6,7,1,2,3,4};
		arr = new int[]{6,7,1,2,3,4,5};

		//first we check if the mid element is greater than the right, if so then the smallest is on [mid,right]
		//second we check if the mid element is smaller than right, if so the smallest element can be on [left,mid]
		//we repeatedly use the binary search to find the smallest element

		int min = findMinElement(arr, 0, arr.length-1);
		System.out.println("smallest element is:"+min);
	}
}
