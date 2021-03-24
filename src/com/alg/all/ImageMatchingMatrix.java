/**
Image Matching Matrix:

Images are stored in the form of a grid. Image recognition is possible by comparing grids of two images and checking if they have matching regions.
You are given two grids where each cell of the grids contains either a 0 or a 1. If two cells share a side then they are adjacent. Cells that contain 1 form a connected region if any cell of that region can be reached by moving through the adjacent cells that contain 1. Overlay the first grid onto the second and if a region of the first grid completely matches a region of the second grid, the regions are matched. Count total number of such matched regions in the second grid.


For example, given two 3*3 grids 1 and 2

G1	G2

111	111
100	100
100	101

There are 2 regions in the scond grid :{(0,0), (0,1), (0,2), (1,0), (2,0)} and {(2,2)}.
Regions in grid1 covers the first region of grid2 but not the second region. There is 1 matching region.

Making a sligh alternation to the above example:

G1	G2

111	111
101	100
100	101

Now there are no matching regions. From the first graoh, the 1 at position (1,2) is not matched in the second grid's larger region. The second grid position (2,2) is not matched in grid 1.
*/
import java.util.*;

public class ImageMatchingMatrix{
	
	/**
	-iterate through the rows
	-check if there is atleast one matching 1 at same position to the previous row, if so, they are in same region
	-if every element of a row is zero, the previously accumulated cells form a region
	-take care of the first and last row
	*/
	public static int countMatches2(List<String> grid1, List<String> grid2){
		int count = 0;
		if(grid1==null || grid2==null || grid1.size()!=grid2.size()){
			return count;
		}
		
		List<List<String>> reg1 = findRegions(grid1);
		//if(reg1.size()==0){
		//	return 0;// grid1 cannot contain anyh common regions to grid2
		//}
		System.out.println("region in mat1 are:"+reg1.size());
		for(List<String> list:reg1){
			System.out.print(Arrays.toString(list.toArray(new String[list.size()])));
		}
		System.out.println();
		List<List<String>> reg2 = findRegions(grid2);
		System.out.println("region in mat2 are:"+reg2.size());
		for(List<String> list:reg2){
			System.out.print(Arrays.toString(list.toArray(new String[list.size()])));
		}
		System.out.println();
		return count;
	}
	
	public static List<List<String>> findRegions(List<String> grid){
		List<List<String>> res = new ArrayList<List<String>>();
		for(int i=0;i<grid.size(); i++){
			if(i==0){
				addCellsToRegion(i, grid.get(i), res);
			}else{
				boolean rowmatch = checkMatchingRows(grid.get(i-1), grid.get(i));
				if(rowmatch){
					addCellsToRegion(i-1, grid.get(i-1), res);
					addCellsToRegion(i, grid.get(i), res);
				}else{
					//if the first grid has 1s, we completed a region
					addCellsToRegion(i-1, grid.get(i-1), res);
					//if the second grid has 1s, we start a new region
					res.add(new ArrayList<>());
					addCellsToRegion(i, grid.get(i), res);
				}
			}
		}
		return res;
	}
	
	
	public static boolean checkMatchingRows(String s1, String s2){
		for(int i=0;i<s1.length(); i++){
			if(s1.charAt(i)=='1' && s2.charAt(i)=='1'){
				return true;
			}
		}
		return false;
	}
	
	public static void addCellsToRegion(int row, String grid, List<List<String>> res){
		for(int i =0;i<grid.length(); i++){
			if(grid.charAt(i)=='1'){
				String cellKey = "("+row+","+i+")";
				if(res.size()==0){
					res.add(new ArrayList<String>());
				}
				else if(!res.get(res.size()-1).contains(cellKey)){
					res.get(res.size()-1).add(cellKey);
				}
			}
		}
	}
	
	public static int countMatches(List<String> grid1, List<String> grid2){
	int count = 0;
	if(grid1==null || grid2==null || grid1.size()!=grid2.size()){
		return count;
	}
	char[] [] mat1 = new char[grid1.size()][grid1.get(0).length()];
	char[] [] mat2 = new char[grid2.size()][grid2.get(0).length()];
	//fill the matrix
	for(int i=0;i<grid1.size();i++){
		mat1[i] = grid1.get(i).toCharArray();
	}
	for(int i=0;i<grid2.size();i++){
		mat2[i] = grid2.get(i).toCharArray();
	}
	
	List<List<String>> reg1 = findRegions(mat1);
	System.out.println("region in mat1 are:"+reg1.size());
	for(List<String> list:reg1){
		System.out.print(Arrays.toString(list.toArray(new String[list.size()])));
	}
	System.out.println();
	List<List<String>> reg2 = findRegions(mat2);
	System.out.println("region in mat2 are:"+reg2.size());
	for(List<String> list:reg2){
		System.out.print(Arrays.toString(list.toArray(new String[list.size()])));
	}
	System.out.println();
	for(int i = 0;i<reg2.size(); i++){
		List<String> list1 = reg2.get(i);
		for(int j=0;j<reg1.size(); j++){
			if(list1.equals(reg1.get(j))){
				count++;
			}
		}
	}
	return count;
	}
	
	//recursively find the region
	public static List<List<String>> findRegions(char[][] mat){
		List<List<String>> res = new ArrayList<List<String>>();
		List<String> temp = new ArrayList<String>();
		for(int i=0;i<mat.length; i++){
			for(int j=0;j<mat[0].length; j++){
				if(mat[i][j]=='1'){
					//System.out.println("calling recursive method for row"+i+" and col:"+j);
					findRegionsRecursive(mat, i, j, temp, res);
					//check the elements of count
					if(temp.size()>0){
						res.add(new ArrayList<String>(temp));
						System.out.println("emptying temp when row was:"+i+" and col was:"+j+" list was:"+Arrays.toString(temp.toArray(new String[temp.size()])));
						temp.clear();
					}
				}
			}
		}
		return res;
	}
	
	public static void findRegionsRecursive(char[][] mat, int row, int col, List<String> temp, List<List<String>> res){
		if(row<0 || col<0 || row>=mat.length || col>=mat[0].length || mat[row][col]!='1'){
			return;
		}
		String cellKey = "("+row+","+col+")";
		if(!temp.contains(cellKey)){
			temp.add(cellKey);
			mat[row][col] = '2';//mark as visited
		}
		
		
		//findRegionsRecursive(mat, col, row, temp, res);
		
		findRegionsRecursive(mat, row, col+1, temp, res);
		
		findRegionsRecursive(mat, row+1, col, temp, res);
		
		findRegionsRecursive(mat, row, col-1, temp, res);
		
		findRegionsRecursive(mat, row-1, col, temp, res);
		
		/*
		if(temp.size()>0){
			res.add(new ArrayList<String>(temp));
			//System.out.println("emptying temp when row was:"+row+" and col was:"+col+" list was:"+Arrays.toString(temp.toArray(new String[temp.size()])));
		}
		temp.clear();
		*/
	}
	
	public static void main(String[] args){
		int expected = 0;
		int count = 0;
		int casecount = 6;
		int passcount = 0;
		
		List<String> grid1 = null;
		List<String> grid2 = null;
		
		
		grid1 = new ArrayList<String>();
		grid2 = new ArrayList<String>();
		grid1.add("111");
		grid1.add("100");
		grid1.add("100");
		
		grid2.add("111");
		grid2.add("100");
		grid2.add("101");
		//match 1
		
		
		expected = 1;
		count = countMatches(grid1, grid2);
		passcount+=expected==count?1:0;
		System.out.println("regions matches:"+count+" expected is:"+expected+" "+((expected==count)?"PASSED":"FAILED"));
		
		grid1 = new ArrayList<String>();
		grid2 = new ArrayList<String>();
		grid1.add("111");
		grid1.add("101");
		grid1.add("100");
		
		grid2.add("111");
		grid2.add("100");
		grid2.add("101");
		//match 0
		
		expected = 0;
		count = countMatches(grid1, grid2);
		passcount+=expected==count?1:0;
		System.out.println("regions matches:"+count+" expected is:"+expected+" "+((expected==count)?"PASSED":"FAILED"));
		
		
		grid1 = new ArrayList<String>();
		grid2 = new ArrayList<String>();
		grid1.add("001");
		grid1.add("011");
		grid1.add("100");
		
		grid2.add("001");
		grid2.add("011");
		grid2.add("101");
		//match 1
		
		expected = 1;
		count = countMatches(grid1, grid2);
		passcount+=expected==count?1:0;
		System.out.println("regions matches:"+count+" expected is:"+expected+" "+((expected==count)?"PASSED":"FAILED"));
		
		grid1 = new ArrayList<String>();
		grid2 = new ArrayList<String>();
		grid1.add("0100");
		grid1.add("1001");
		grid1.add("0011");
		grid1.add("0011");
		
		grid2.add("0101");
		grid2.add("1001");
		grid2.add("0011");
		grid2.add("0011");
		//match 2
		
		expected = 2;
		count = countMatches(grid1, grid2);
		passcount+=expected==count?1:0;
		System.out.println("regions matches:"+count+" expected is:"+expected+" "+((expected==count)?"PASSED":"FAILED"));
		
		
		
		grid1 = new ArrayList<String>();
		grid2 = new ArrayList<String>();
		grid1.add("0010");
		grid1.add("0111");
		grid1.add("0100");
		grid1.add("1111");
		
		grid2.add("0010");
		grid2.add("0111");
		grid2.add("0110");
		grid2.add("1111");
		//match 0
		
		expected = 0;
		count = countMatches(grid1, grid2);
		passcount+=expected==count?1:0;
		System.out.println("regions matches:"+count+" expected is:"+expected+" "+((expected==count)?"PASSED":"FAILED"));
		
		
			
		grid1 = new ArrayList<String>();
		grid2 = new ArrayList<String>();
		grid1.add("001");
		grid1.add("011");
		grid1.add("100");
		
		grid2.add("001");
		grid2.add("011");
		grid2.add("101");
		//match 1
		
		expected = 1;
		count = countMatches(grid1, grid2);
		passcount+=expected==count?1:0;
		System.out.println("regions matches:"+count+" expected is:"+expected+" "+((expected==count)?"PASSED":"FAILED"));
		
		
		System.out.println("Total test cases:"+casecount+" passed:"+passcount);
		
	}

}