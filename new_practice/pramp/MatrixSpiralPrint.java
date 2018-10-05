/**
#Matrix Spiral Print

Given a 2D array (matrix) named M, print all items of M in a spiral order, clockwise.

For example:

M  =  1   2   3   4   5
      6   7   8   9  10
     11  12  13  14  15
     16  17  18  19  20
	 
The clockwise spiral print is: 1 2 3 4 5 10 15 20 19 18 17 16 11 6 7 8 9 14 13 12
*/
import java.util.*;

public class MatrixSpiralPrint{

	/**
	Method1:
	-recursively print the entires
	
	*/
	public static String getSpiralPrint(int[][] mat){
		//base case
		if(mat==null || mat.length<1){
			return "";
		}
		int rowend = mat.length-1;
		int colend = mat[0].length-1;
		int rowstart = 0, colstart = 0;
		StringBuilder sb = new StringBuilder();
		spiralPrintHelper(mat, rowstart, rowend, colstart, colend, sb);
		return sb.toString();
	}
	
	/**
	-always print the outer elements of the matrix and recursively call for smaller matrix
	-after printing the outer elements, shrink the matrix
	*/
	public static void spiralPrintHelper(int[][] mat, int rowstart, int rowend, int colstart, int colend, StringBuilder sb){
		if(rowend<rowstart || colend<colstart){
			return;
		}
		
		//print row forward
		for(int i=colstart; i<colend; i++){
			sb.append(" ");
			sb.append(mat[rowstart][i]);
		}
		//print col top to bottom
		for(int j = rowstart; j<rowend; j++){
			sb.append(" ");
			sb.append(mat[j][colend]);
		}
		//print row backward
		for(int k= colend; k>colstart; k--){
			sb.append(" ");
			sb.append(mat[rowend][k]);
		}
		//print col bottom to top
		for(int l = rowend; l>rowstart; l--){
			sb.append(" ");
			sb.append(mat[l][colstart]);
		}
		//shrink the matrix
		rowstart++;
		rowend--;
		colstart++;
		colend--;
		spiralPrintHelper(mat, rowstart, rowend, colstart, colend, sb);
	}
	
	/**
	this is a leetcode problem 
	https://leetcode.com/problems/spiral-matrix/description/
	-we use the same solution as above
	*/
	public static List<Integer> spiralOrder(int[][] mat) {
        //base case
		if(mat==null || mat.length<1){
			return new ArrayList<Integer>();
		}
		
		int rowstart = 0, colstart = 0;
		int rowend = mat.length-1;
		int colend = mat[0].length-1;
		
		List<Integer> list = new ArrayList<>();
		spiralPrintHelperMethod(mat, rowstart, rowend, colstart, colend, list);
		return list;
    }
	
	/**
	-always print the outer elements of the matrix and recursively call for smaller matrix
	-after printing the outer elements, shrink the matrix
	*/
	public static void spiralPrintHelperMethod(int[][] mat, int rowstart, int rowend, int colstart, int colend, List<Integer> list){
		System.out.println("rowstart is:"+rowstart+" rowend is:"+rowend+" colstart is:"+colstart+" colend is:"+colend);
		if(rowend<rowstart || colend<colstart){
			return;
		}
		//for a single entry element or single row matrix, when rowstart and rowend are equal or colstart and colend are equal
		if(rowstart==rowend ){
			for(int i=colstart; i<=colend; i++){
				list.add(mat[rowstart][i]);
			}
			return;
		}
		if(colstart==colend){
			for(int i=rowstart;i<=rowend; i++){
				list.add(mat[i][colstart]);
			}
			return;
		}
		
		//print row forward
		for(int i=colstart; i<colend; i++){
			list.add(mat[rowstart][i]);
		}
		//print col top to bottom
		for(int j = rowstart; j<rowend; j++){
			list.add(mat[j][colend]);
		}
		//print row backward
		for(int k= colend; k>colstart; k--){
			list.add(mat[rowend][k]);
		}
		//print col bottom to top
		for(int l = rowend; l>rowstart; l--){
			list.add(mat[l][colstart]);
		}
		//shrink the matrix
		rowstart++;
		rowend--;
		colstart++;
		colend--;
		spiralPrintHelperMethod(mat, rowstart, rowend, colstart, colend, list);
	}
	
	
	public static void main(String[] args){
		int[][] mat = new int[][]{
				{1,   2,   3,   4,   5},
				{6,   7,   8,   9,  10},
				{11,  12,  13,  14,  15},
				{16,  17,  18,  19,  20}
				};
		//String spiral = getSpiralPrint(mat);
		//System.out.println("spiral print is:"+spiral);
		//mat = new int[][]{{ 1, 2, 3 }, { 4, 5, 6 },{ 7, 8, 9 }};
		//mat = new int[][]{{ 1, 2, 3, 4 }, {5, 6, 7, 8 },{9, 10, 11, 12 }};
		//mat = new int[][]{{1}};
		//mat = new int[][]{{}};
		//mat = new int[][]{{1,2,3,4,5,6,7,8,9,10}};
		mat = new int[][]{{1,2,3,4,5,6,7,8,9,10},{11,12,13,14,15,16,17,18,19,20}};
		mat = new int[][]{{3,2}};
		mat = new int[][]{{3},{2}};
		List<Integer> list = spiralOrder(mat);
		for(Integer i:list){
			System.out.print(i+",");
		}
	}
}