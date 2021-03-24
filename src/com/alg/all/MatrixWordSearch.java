/**
Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

Example:

board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

Given word = "ABCCED", return true.
Given word = "SEE", return true.
Given word = "ABCB", return false.
*/

public class MatrixWordSearch{
	static boolean[][] visited;
	public static void printMat(char[][] mat){
		for(int i=0;i<mat.length; i++){
			for(int j=0;j<mat[0].length; j++){
				System.out.print(mat[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}

	/**
	use recursive approach
	*/
	public static boolean exist(char[][] board, String word){
		visited = new boolean[board.length][board[0].length];
        for(int i=0;i<board.length; i++){
			for(int j=0;j<board[i].length; j++){
				if(board[i][j]==word.charAt(0) && found(board, word, i, j)){
					return true;
				}
			}
		}
		return false;
    }
	
	public static boolean found(char[][] mat, String word, int row, int col){
		if(word.equals("")){
			return true;
		}
		if(row<0 || col<0 || row>=mat.length || col>=mat[0].length || mat[row][col]!=word.charAt(0) || visited[row][col]){
			return false;
		}
		
		word = word.substring(1);
		//mark as visited
		visited[row][col] = true;
		
		boolean res = false;
		
		if(found(mat, word, row, col+1) || found(mat, word, row, col-1) || found(mat, word, row+1, col) || found(mat, word, row-1, col)){
            return true;
        }
		
		visited[row][col]= false;
		return false;
	}
	
	public static void main(String[] args){
		char[][] mat = new char[3][4];
		mat[0] = "ABCE".toCharArray();
		mat[1] = "SFCS".toCharArray();
		mat[2] = "ADEE".toCharArray();
		
		String word = "ABCCED";
		System.out.println(exist(mat, word));
		
		mat[0] = "ABCE".toCharArray();
		mat[1] = "SFCS".toCharArray();
		mat[2] = "ADEE".toCharArray();
	
		word = "AB";
		System.out.println(exist(mat, word));
		
		mat[0] = "ABCE".toCharArray();
		mat[1] = "SFCS".toCharArray();
		mat[2] = "ADEE".toCharArray();
		word = "SEE";
		System.out.println(exist(mat, word));
		
		mat[0] = "ABCE".toCharArray();
		mat[1] = "SFCS".toCharArray();
		mat[2] = "ADEE".toCharArray();
		
		word = "ABCB";
		System.out.println(exist(mat, word));
		
		mat[0] = "ABCE".toCharArray();
		mat[1] = "SFCS".toCharArray();
		mat[2] = "ADEE".toCharArray();
		
		word = "ABCESE";
		System.out.println(exist(mat, word));
		
		mat[0] = "ABCE".toCharArray();
		mat[1] = "SFCS".toCharArray();
		mat[2] = "ADEE".toCharArray();
		
		word = "RARA";
		System.out.println(exist(mat, word));
		
		mat = new char[3][3];
		mat[0] = "CAA".toCharArray();
		mat[1] = "AAA".toCharArray();
		mat[2] = "BCD".toCharArray();
		word = "AAB";
		System.out.println(exist(mat, word));
		
	}
}