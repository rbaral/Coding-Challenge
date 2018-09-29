/**
Given a MxN matrix, if an entry is zero, set its entire row and columnt to zero.
*/

/**
-we solve the problem in two scannings
-in the first scanning, we keep track of the rows/columns that have zero entris
-in the second scanning, set the entries with the previously recorded rows/cols to zero

NOTE: If we just set the rows/cols of a cell whose entry is zero, then we get all the entries as zero easily, so we
need to do the operation in two steps
*/

public class MatrixZeroEntries{
	
	/**
	given a matrix, first record the rows/cols with zero entries, in the second round, set the entries to
	zero for the row/cols that were recorded in the previous step
	
	O(n^2) complexity, space O(n) - to save the rows/cols that have zero entries
	*/
	public static int[][] matrixZeroFill(int[][] mat){
		//we don't know the row/col that has zero entry, so we can use a simple boolean array and set the rows/cols that have zero entries to true
		boolean[] rowsZero = new boolean[mat.length];
		boolean[] colsZero = new boolean[mat[0].length];
		for(int i=0;i<mat.length; i++){
			for(int j = 0;j<mat[i].length; j++){
				if(mat[i][j] ==0){
					//record the row i and col j as having a zero entry
					rowsZero[i] = true;
					colsZero[j] = true;
				}
			}
		}
		//in the second round, fill the rows and cols that were recorded in the first round with zeros
		for(int i=0;i<mat.length; i++){
			for(int j=0;j<mat[i].length; j++){
				if(rowsZero[i] || colsZero[j]){
					//fill the cell with zero
					mat[i][j] = 0;
				}
			}
		}
		return mat;
	}
	
	public static void printMatrix(int [][] mat){
		System.out.println("****************");
		for(int i=0;i<mat.length; i++){
			for(int j =0;j<mat[i].length; j++){
				System.out.print(" "+ mat[i][j]);
			}
			System.out.println();
		}
	}
	public static void main(String args[]){
		int[][] mat = new int[3][3];
		mat[0] = new int[]{1, 2, 3};
		mat[1] = new int[]{0, 11, 12};
		mat[2] = new int[]{1, 22, 33};
		printMatrix(mat);
		int[][] mat2 = matrixZeroFill(mat);
		printMatrix(mat2);
	}
}