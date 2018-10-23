/**
Box stacking

You have a stack of n boxes, with widths w., heights l\ and depths dr The boxes
cannot be rotated and can only be stacked on top of one another if each box in the
stack is strictly larger than the box above it in width, height, and depth. Implement
a method to build the tallest stack possible, where the heigh t of a stack is the sum of
the heights of each box.
*/
import java.util.*;

class Box{
	int length, width, height;
	
	Box(){}
	
	Box(int l, int w, int h){
		length = l;
		width = w;
		height = h;
	}
	//if this box can be above another box b
	boolean canBeAbove(Box b){
		if(b==null)
			return true;
		if(length<b.length && width<b.width && height<b.height){
			return true;
		}
		return false;
	}
	//if this box can be below another box b
	boolean canBeBelow(Box b){
		if(b==null)
			return false;
		return b.canBeAbove(this);
	}
	
	public String toString() {
		return "Box(" + length + "," + width + "," + height + ")";
	}
}
public class BoxStacking{

	/**
	use dp to solve the problem
	*/
	public static List<Box> createStackDP(Box[] boxes, Box bottom, HashMap<Box, List<Box>> boxmap){
		if(bottom!=null && boxmap.containsKey(bottom)){
			return boxmap.get(bottom);//.clone();
		}
		
		int maxheight = 0;
		List<Box> maxstack = null;
		for(int i=0;i<boxes.length; i++){
			if(boxes[i].canBeAbove(bottom)){
				List<Box> newstack = createStackDP(boxes, boxes[i], boxmap);
				int newheight = findStackHeight(newstack);
				if(newheight>maxheight){
					maxheight = newheight;
					maxstack = newstack;
				}
			}
		}
		if(maxstack==null){
			maxstack = new ArrayList<Box>();
		}
		if(bottom!=null){
			maxstack.add(0, bottom);
		}
		boxmap.put(bottom, maxstack);
		return maxstack;
	}

	public static int findStackHeight(List<Box> boxlist){
		int height = 0;
		for(Box b:boxlist){
			height+=b.height;
		}
		return height;
	}
	
	public static void main(String[] args) {
		Box[] boxes = { new Box(3, 4, 1), new Box(8, 6, 2), new Box(7, 8, 3), new Box(1,1,0)};

		List<Box> stack = createStackDP(boxes, null, new HashMap<Box, List<Box>>());
		//ArrayList<Box> stack = createStackR(boxes, null);		
		for (int i = stack.size() - 1; i >= 0; i--) {
			Box b = stack.get(i);
			System.out.println(b.toString());
		}
	}

}