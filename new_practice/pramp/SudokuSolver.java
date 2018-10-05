/**
#Sudoku Solver

Write the function sudokuSolve that checks whether a given sudoku board (i.e. sudoku puzzle) is solvable. If so, the function will returns True. Otherwise (i.e. there is no valid solution to the given sudoku board), returns False.

In sudoku, the objective is to fill a 9x9 board with digits so that each column, each row, and each of the nine 3x3 sub-boards that compose the board contains all of the digits from 1 to 9. The board setter provides a partially completed board, which for a well-posed board has a unique solution. As explained above, for this problem, it suffices to calculate whether a given sudoku board has a solution. No need to return the actual numbers that make up a solution.

A sudoku board is represented in a two dimensional 9x9 array with the numbers 1,2,...,9 and blank spaces, and the function should fill the blank spaces with numbers such that the following rules apply:

In every row of the array, all numbers 1,2,...,9 appear exactly once.
In every column of the array, all numbers 1,2,...,9 appear exactly once.
In every 3x3 sub-board that is illustrated below, all numbers 1,2,...,9 appear exactly once.
A solved sudoku is a board with no blank spaces, i.e. all blank spaces are filled with numbers that abide to the constraints above. If the function succeeds in solving the sudoku board, it'll return true (false, otherwise).

Example (more examples can be found here):



A typical Sudoku board setter



The same board with solution numbers marked in red

Write a readable an efficient code, explain how it is built and why you chose to build it that way.
*/

public class SudokuSolver{

	/**
	method1:
	-solve using backtracking
	-for each cell, check if it is '.', if so randomly assign some value between 1 to 9 and check if the 3*3 cube that contains this cell is valid, if not valid, backtrack
	Ref: https://leetcode.com/problems/sudoku-solver/discuss/15752/Straight-Forward-Java-Solution-Using-Backtracking
	O(n^4)
	*/

	public static void solveSudoku(char[][] board) {
        //base cases
		if(board==null || board.length<1){
			return;
		}
		solve(board);
    }
	
	public static boolean solve(char[][] board){
		for(int i=0;i<board.length; i++){
			for(int j=0;j<board[0].length; j++){
				if(board[i][j]=='.'){
					for(char c ='1'; c<='9'; c++){
						if(isValidState(board, i, j, c)){
							board[i][j] = c;
							if(solve(board)){
								return true;
							}else{
								board[i][j] = '.';
							}
						}
					}
				return false;
				}
			}
		}
		return true;
	}
	
	//check if putting a character in the given cell is valid
	public static boolean isValidState(char[][] board, int row, int col, char c){
		for(int i=0;i<9; i++){
			if(board[row][i]!='.' && board[row][i]==c){
				return false;
			}
			if(board[i][col]!='.' && board[i][col]==c){
				return false;
			}
			/*
			if(board[3*(row/3) + i/3][3*(col/3) + i%3] !='.' && board[3*(row/3) + i/3][3*(col/3) + i%3]==c){
				return false;
			}
			*/
			if(board[3*(row/3) + i%3][3*(col/3) + i/3] !='.' && board[3*(row/3) + i%3][3*(col/3) + i/3]==c){
				return false;
			}
		}
		
		return true;
	}
	
	public static void main(String[] args){
		char[][] mat = new char[][] {{'5', '3', '.','.', '7', '.', '.', '.', '.'},
			{'6', '.', '.', '1', '9', '5', '.', '.', '.'},
				{'.', '9', '8', '.', '.', '.', '.', '6', '.'},
					{'8', '.', '.', '.', '6', '.', '.', '.','3'},
						{'4', '.', '.', '8', '.', '3', '.', '.', '1'},
							{'7', '.', '.', '.', '2', '.', '.', '.', '6'},
								{'.', '6', '.', '.', '.', '.', '2', '8', '.'},
									{'.', '.', '.', '4', '1', '9', '.', '.', '5'},
										{'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
		solveSudoku(mat);
		for(int i=0;i<mat.length; i++){
			for(int j=0;j<mat[0].length; j++){
				System.out.print(mat[i][j]+" ");
			}
			System.out.println();
		}
	}
}