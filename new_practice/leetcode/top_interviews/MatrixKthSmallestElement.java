/**
Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the kth smallest element in the matrix.

Note that it is the kth smallest element in the sorted order, not the kth distinct element.

Example:

matrix = [
   [ 1,  5,  9],
   [10, 11, 13],
   [12, 13, 15]
],
k = 8,

return 13.
Note: 
You may assume k is always valid, 1 ≤ k ≤ n2.
*/

/**
https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/discuss/85173/Share-my-thoughts-and-Clean-Java-Code
*/

public class MatrixKthSmallestElement{

	/**
	Method1:
	-we use the concept of binary search as provided in above ref
	*/
	public static int kthSmallest1(int[][] mat, int k) {
        //TODO:handle base cases
		int low = mat[0][0];
		int high = mat[mat.length-1][mat[0].length-1] + 1;
		while(low<high){
			int mid = low +(high-low)/2; //to prevent int overflow and convert into int
			int count = 0;
			int j = mat[0].length-1;
			for(int i=0;i<mat[0].length; i++){
				while(j>=0 && mat[i][j]>mid){
					j--;
				}
				count+=j+1;
			}
			if(count<k){
				low = mid+1;
			}else{
				high = mid;
			}
		}
		return low;
    }
	
	public static void main(String args[]){
		int[][] mat = new int[][]{
				{1, 5, 9},
				{10, 11, 13},
				{12, 13, 15}
		};
		int k = 8;
		System.out.println(k+" th element is:"+kthSmallest1(mat, k));
	}
	
}