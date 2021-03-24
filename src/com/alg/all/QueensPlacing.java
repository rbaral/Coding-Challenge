/**
NQueens

The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.



Given an integer n, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.

Example:

Input: 4
Output: [
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]
Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above.
*/
import java.util.*;

public class QueensPlacing{
	
	public static void placeQueensDFS(char[][] board, int col, List<List<String>> res){
		if(col == board.length){//reached end of the board size
			res.add(construct(board));
			return;
		}
		for(int i=0;i<board.length; i++){
			if(isValid(board, i, col)){
				board[i][col]='Q';
				placeQueensDFS(board, col+1, res);
				board[i][col] ='.';
			}
		}
	}
	
	public static boolean isValid(char[][] board, int row, int col){
		for(int i=0;i<board.length; i++){
			for(int j = 0; j<col; j++){
				if(board[i][j]=='Q'){
					if(row==i || col==j || Math.abs(row-i)==Math.abs(col-j)){
						return false;
					}
				}
			}
		}
		return true;
	}
	
	public static List<String> construct(char[][] board){
		List<String> res = new ArrayList<String>();
		for(int i=0;i<board.length; i++){
			String s = String.valueOf(board[i]);
			res.add(s);
		}
		return res;
	}

	public static void initBoard(char[][] board){
		for(int i=0;i<board.length; i++){
			for(int j=0;j<board[0].length; j++){
				board[i][j] = '.';
			}
		}
	}
	
	public static void main(String[] args){
		int n = 8;
		List<List<String>> res = new ArrayList<List<String>>();
		char[][] board = new char[n][n];
		initBoard(board);
		placeQueensDFS(board, 0, res);
		for(List<String> list:res){
			for(String s:list){
				System.out.print(s+" ");
				System.out.println();
			}
			System.out.println();
		}
	}
	
}