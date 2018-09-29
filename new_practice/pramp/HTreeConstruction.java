/**
#H-Tree Construction

An H-tree is a geometric shape that consists of a repeating pattern resembles the letter “H”.

It can be constructed by starting with a line segment of arbitrary length, drawing two segments of the same length at right angles to the first through its endpoints, and continuing in the same vein, reducing (dividing) the length of the line segments drawn at each stage by √2.

Here are some examples of H-trees at different levels of depth:

alt depth = 1

alt depth = 2

alt depth = 3

Write a function drawHTree that constructs an H-tree, given its center (x and y coordinates), a starting length, and depth. Assume that the starting line is parallel to the X-axis.

Use the function drawLine provided to implement your algorithm. In a production code, a drawLine function would render a real line between two points. However, this is not a real production environment, so to make things easier, implement drawLine such that it simply prints its arguments (the print format is left to your discretion).

Analyze the time and space complexity of your algorithm. In your analysis, assume that drawLine's time and space complexities are constant, i.e. O(1).

Constraints:

[time limit] 5000ms

[input] double x

[input] double y

[input] double length

[input] double depth

0 ≤ depth ≤ 10
*/

public class HTreeConstruction{

	/**
	Method1:
	-use recursion to draw tree of given depth and repeat for depth-1
	-for each depth we need to draw three lines - one horizontal and two vertical (to form the letter H)
	-afte that, we need to draw H on each of its edges, so there will be additional four H (if the depth is valid, i.e. >0)
	-we recurse until depth>0
	*/
	static void drawHTree(double x, double y, double length, int depth){
		//exit condition
		if(depth<1){
			return; //no H drawn for this case
		}
		//draw one H and recursively call this method to draw four H
		//one H requires three calls to drawLine method
		//assuming the x and y are the center of the horizontal lines
		drawLine(x -length/2, y, x + length/2, y);//for horizontal line
		drawLine(x - length/2, y - length/2, x - length/2, y + length/2);//for left vertical line
		drawLine( x + length/2, y - length/2, x + length/2, y + length/2);//for right vertical line
		
		//now draw four H for the next level by reducing the value of depth
		depth--;
		length = length/Math.pow(2, 0.5);
		drawHTree(x - length/2, y - length/2, length, depth);
		drawHTree(x - length/2, y + length/2, length, depth);
		drawHTree(x + length/2, y - length/2, length, depth);
		drawHTree(x + length/2, y + length/2, length, depth);
	}
	static void drawLine(double x1, double y1, double x2, double y2){
		for(int i=0;i<Integer.MAX_VALUE; i++){
			for(int j = 0; j<Integer.MAX_VALUE; i++){
				if(x1>= i && y1<=j){
					//positive x, y value
				}else if(){// x positive, y negative
					
				}else if(){//x negative, y positive
					
				}else{//both negative
					
				}
			}
		}
	}
	public static public void main( String args[] ) {
		System.out.println( "Practice makes Perfect!" );
	}

}