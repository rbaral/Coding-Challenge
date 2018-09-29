/**
Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in-place.

Example 1:

Input: 
[
  [1,1,1],
  [1,0,1],
  [1,1,1]
]
Output: 
[
  [1,0,1],
  [0,0,0],
  [1,0,1]
]
Example 2:

Input: 
[
  [0,1,2,0],
  [3,4,5,2],
  [1,3,1,5]
]
Output: 
[
  [0,0,0,0],
  [0,4,5,0],
  [0,3,1,0]
]
Follow up:

A straight forward solution using O(mn) space is probably a bad idea.
A simple improvement uses O(m + n) space, but still not the best solution.
Could you devise a constant space solution?
*/

public class MatrixSetToZeros{

	/**
	Method1:
	-iteratively scan all the elements of the matrix
	-save the row or col that have zero values (O(m) or O(n) space required)
	-in second pass, iterate through the zero values and set all the rows or cols correponding to the value to zeros
	O(mn) time and O(m+n) space
	*/
	public static void setZeroes1(int[][] mat) {
        int[] zerocols = new int[mat[0].length];
		int[] zerorows =  new int[mat.length];
		for(int i=0;i<mat.length; i++){
			for(int j=0;j<mat[i].length; j++){
				if(mat[i][j]==0){
					zerocols[j] = 1;
					zerorows[i] = 1;
				}
			}
		}
		//now set all items to zero if the corresponding row/col was set to 1 in zerocols or zerorows
		for(int i=0;i<mat.length; i++){
			for(int j = 0;j<mat[i].length; j++){
					if(zerorows[i]!=0 || zerocols[j]!=0){
						mat[i][j] = 0;
					}
				}
		}
		
    }
	
	/**
	Method2:
	-using constant space
	Ref: https://leetcode.com/problems/set-matrix-zeroes/discuss/26014/Any-shorter-O(1)-space-solution
	-store the presence of zeros on the first row and first col
	-in second pass if the first element of current row or current col is zero, set it to zero
	*/
	public static void setZeroes2(int[][] matrix){
		boolean col0=false;
		for(int i = 0; i < matrix.length; i++) {
			if(matrix[i][0]==0) col0=true;
			for(int j = 1; j < matrix[0].length; j++) {
				if(matrix[i][j] == 0) {
					matrix[0][j] = 0;
					matrix[i][0] = 0;
				}
			}
		}
		
		for(int i = matrix.length-1; i >=0; i--) {
			for(int j = matrix[0].length-1; j >=0; j--) {
				if(matrix[i][0] == 0 || matrix[0][j] == 0) {
					matrix[i][j] = 0;
				}
			}
			if(col0==true){
				matrix[i][0] = 0;
			}
		}
		
		
		//now use the first row and first col flag to set others to zeros
		
	}
	
	public static void main(String[] args){
		int[][] mat = new int[][]{{0,1,2,0},
								 {3,4,5,2},
								{1,3,1,5}};
		mat = new int[][] {{1},{0}};
		mat = new int[][]{						{1,1,1},						{0,1,2}};
		System.out.println("Org matrix is:");
		for(int i=0;i<mat.length; i++){
			for(int j=0;j<mat[i].length; j++){
				System.out.print(mat[i][j]);
			}
			System.out.println();
		}
		setZeroes2(mat);
		System.out.println("Zero set matrix is:");
		for(int i=0;i<mat.length; i++){
			for(int j=0;j<mat[i].length; j++){
				System.out.print(mat[i][j]);
			}
			System.out.println();
		}
	}
}