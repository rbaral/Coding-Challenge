/**
Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.


In Pascal's triangle, each number is the sum of the two numbers directly above it.

Example:

Input: 6
Output:
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
[1,5,10,10,5,1]
]
*/

import java.util.List;
import java.util.ArrayList;

public class PascalTriangle{

	/**
	-we use the property that for each row, the consecutive numbers increase by row-1 and reach the max value on the middle
	then the values start decreasing and reach 1 at the end
	-there are some base cases, for e.g., in row1, there are total 1 elements (all 1) and in row2 there are 2 elements all 2
	- we can use the following relation:
	-row[2][0] = 1, row[2][1] = row[1][1] + row[1][0], row[2][2] = 1
	-row[3][0] = 1, row[3][1] = row[2][1] + row[2][0], row[3][2] = row[2][2] + row[2][1] , row[3][3] = 1
	-in general, row[i][j] = row[i-1][j] + row[i-1][j-1] 
	*/
	public static List<List<Integer>> generateRows(int numRows) {
        //base cases
		List<List<Integer>> rows = new ArrayList<List<Integer>>();
		if(numRows<=0){
			return rows;
		}
		//lets add the row entries for row1
		List<Integer> row1 = new ArrayList<Integer>();
		row1.add(1);
		rows.add(row1);
		if(numRows==1)
			return rows;
		//lets add the row entries for row2
		List<Integer> row2 = new ArrayList<Integer>();
		row2.add(1);
		row2.add(1);
		rows.add(row2);
		//lets use the logic for rest of the rows
		List<Integer> curRow;
		int itemscount = 0;
		for(int i=2; i<numRows; i++){
			curRow = new ArrayList<Integer>();
			//the first element and last element of all rows are always 1
			curRow.add(1);
			//add the succesive elements of the array
			itemscount = i -1;//because the first and last element are always 1
			//now we use the formula row[i][j] = row[i-1][j] + row[i-1][j-1]
			for(itemscount = 1; itemscount<i; itemscount++){
				curRow.add(rows.get(i-1).get(itemscount) + rows.get(i-1).get(itemscount-1));
			}
			//add the last element
			curRow.add(1);
			rows.add(curRow);
		}
		return rows;
    }
	
	public static void main(String args[]){
		int rowcount = 5;
		rowcount = 1;
		List<List<Integer>> rows = generateRows(rowcount);
		for(List<Integer> row:rows){
			for(Integer item:row){
				System.out.print(item+" ");
			}
			System.out.println();
		}
		
	}
}