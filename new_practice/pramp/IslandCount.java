/**
#Island Count

Given a 2D matrix M, filled with either 0s or 1s, count the number of islands of 1s in M. An island is a group of adjacent values that are all 1s. Every cell in M can be adjacent to the 4 cells that are next to it on the same row or column.

Explain and code the most efficient solution possible and analyze its runtime complexity.

Example: the matrix below has 6 islands:

    0  1  0  1  0
    0  0  1  1  1
    1  0  0  1  0
    0  1  1  0  0
    1  0  1  0  1
*/

public class IslandCount{

	/**
	Method1:
	-start scanning the matrix from left, and by using two nested loops
	-whenever a 1 is found, increase the islandcount and set its adjacent neighbours (left, right, bottom, top) to 0
	so that the adjacent entries are not duplicately considered in island count in future.
	O(n^2) time
	*/
	public static int islandCounts(int[][] mat){
		//base cases
		if(mat==null || mat.length<1){
			return 0;
		}
		int count = 0;
		for(int i=0;i<mat.length; i++){
			for(int j = 0;j<mat[0].length; j++){
				if(mat[i][j]==1){
					count++;
					setNeighbors(mat, i, j);
				}
			}
		}
		return count;
	}
	
	public static void setNeighbors(int[][] mat, int i, int j){
		//if we reached outside the matrix or the element is not 1, we don't need to do anything
		if(i<0 || j<0 || i>=mat.length || j>=mat[0].length || mat[i][j]!=1){
			return;
		}
		//reset itself to zero
		mat[i][j] = 0;
		//reset left neighbor
		setNeighbors(mat, i-1, j);
		//reset top neighbor
		setNeighbors(mat, i, j-1);
		//reset right neighbor
		setNeighbors(mat, i+1, j);
		//reset bottom neighbor
		setNeighbors(mat, i, j+1);
	}
	
	
	public static void main(String args[]){
		int[][] mat = new int[][]{ {0 , 1,  0,  1,  0}, 
									{0,  0,  1,  1,  1}, 
									{1,  0,  0,  1,  0}, 
									{0,  1,  1,  0,  0},
									{1,  0,  1,  0,  1}};
		int islandCount = islandCounts(mat);
		System.out.println("Island count is:"+islandCount);
	}
}