/**
Valid sudoku

A sudoku board is represented in a two dimensional 9x9 array with the numbers 1,2,...,9 and blank spaces, and the function should fill the blank spaces with numbers such that the following rules apply:
In every row of the array, all numbers 1,2,...,9 appear exactly once.
In every column of the array, all numbers 1,2,...,9 appear exactly once.
In every 3x3 sub-board that is illustrated below, all numbers 1,2,...,9 appear exactly once.

Write the function sudokuSolve that checks whether a given sudoku board (i.e. sudoku puzzle) is solvable. If so, the function will returns True. Otherwise (i.e. there is no valid solution to the given sudoku board), returns False.

In sudoku, the objective is to fill a 9x9 board with digits so that each column, each row, and each of the nine 3x3 sub-boards that compose the board contains all of the digits from 1 to 9. The board setter provides a partially completed board, which for a well-posed board has a unique solution. As explained above, for this problem, it suffices to calculate whether a given sudoku board has a solution. No need to return the actual numbers that make up a solution.


*/
import java.util.*;

public class ValidSudoku{

	//store the values of each row and each column in a hash and check if the existing state is valid
	public static boolean isValidSudoku(char[][] board) {
		HashSet<Character> rowchars = new HashSet<Character>();
		HashSet<Character> colchars = new HashSet<Character>();
		HashSet<Character> cubes = new HashSet<Character>();
		for(int i=0;i<board.length; i++){
			for(int j=0;j<board[0].length; j++){
				//check if the character fits in the row
				if(board[i][j]!='.' && !rowchars.add(board[i][j])){
					return false;
				}
				//check if the character fits in the col
				if(board[j][i]!='.' && !colchars.add(board[j][i])){
					return false;
				}
				//check on the 3*3 cube
				if(board[3*(i/3) + j/3][3*(i%3) + j%3]!='.' && !cubes.add(board[3*(i/3) + j/3][3*(i%3) + j%3])){
					return false;
				}
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
			System.out.println(isValidSudoku(mat));

	}
}