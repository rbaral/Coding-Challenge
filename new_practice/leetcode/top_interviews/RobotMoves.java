/**
A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?


Above is a 7 x 3 grid. How many possible unique paths are there?

Note: m and n will be at most 100.

Example 1:

Input: m = 3, n = 2
Output: 3
Explanation:
From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
1. Right -> Right -> Down
2. Right -> Down -> Right
3. Down -> Right -> Right
Example 2:

Input: m = 7, n = 3
Output: 28
*/

public class RobotMoves{

	/**
	Method1: Recursive solution
	-we start the count from the bottom right corner and build upwards
	*/
	public static int uniquePaths(int m, int n) {
        //base cases
		if(m<=0 || n<=0)
			return 0;
		int[][] mat = new int[m][n];
		//initialize the mat to all -1s
		for(int i=0;i<m; i++){
			for(int j=0;j<n; j++){
				mat[i][j] = -1;
			}
		}
		return getUniquePathsRecursive(mat, m-1, n-1);
    }
	
	public static int  getUniquePathsRecursive(int[][] mat, int row, int col){
		if(row==0 && col==0){
			return 1;
		}else if(row<0 || col<0){
			return 0;
		}
		if(mat[row][col]==-1){
			mat[row][col] = getUniquePathsRecursive(mat, row-1, col) + getUniquePathsRecursive(mat, row, col-1);
		}
		return mat[row][col];
	}
	
	
	public static void main(String args[]){
		int m = 3;
		int n = 2;
		m = 7;
		n = 3;
		//m=23;
		//n =12;
		System.out.println("total possible ways:"+uniquePaths(m , n));
	}
}