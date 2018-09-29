/**
Check if a given binary tree is balanced or not.
-A binary tree is balanced if the left and right child trees of a node differ no more than 1 in height.
*/
import java.lang.Math;

//a simple representation of Tree
class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int v){
		val = v;
	}
	void setRight(TreeNode r){
		right = r;
	}
	void setLeft(TreeNode l){
		left = l;
	}
	
	TreeNode getRight(){
		return right;
	}
	
	TreeNode getLeft(){
		return left;
	}
}
public class CheckBinaryTreeBalance{

public static int getHeight1(TreeNode root){
	if(root==null){
		return 0;
	}else{
		return 1 + Math.max(getHeight1(root.left), getHeight1(root.right));
	}
}

/**
Method1: 
-we do recursive call to check if a node is balanced by checking if its left and right child are balanced or not
-we find the height of the node and recursively find the height of child nodes to check if they maintain the difference of 1 to
have balanced tree
*/
public static boolean isBalanced1(TreeNode root){
	if(root==null){
		return true;
	}else{
		int leftHeight = getHeight1(root.left);
		int rightHeight = getHeight1(root.right);
		int diff = Math.abs(leftHeight - rightHeight);
		if(diff>1){
			return false;
		}else{//recursively check if the sub child are also balanced
			return isBalanced1(root.left) && isBalanced1(root.right);
		}
	}
}


/**
-check the height and find the difference rather than iterating to the child node
*/
public static int getHeight2(TreeNode root){
	if(root==null)
		return 0;
	int leftHeight = getHeight2(root.left);
	if(leftHeight==-1)
		return -1;
	int rightHeight = getHeight2(root.right);
	if(rightHeight==-1)
		return -1;
	if(Math.abs(leftHeight-rightHeight)>1)
		return -1;
	return 1 + Math.max(leftHeight, rightHeight);
		
}

/**
Method2:
-we make recursive calls using the help of getHeight2() method which checks if the height difference is more than 1
at the same time it finds the height of the tree.
-this makes isBalanced2() run in O(n), contrary to isBalanced2() which runs in O(n^2) because it finds the height recursively
and then again checks if the nodes are balanced
O(n)
*/
public static boolean isBalanced2(TreeNode root){
	if(root==null)
		return true;
	if(getHeight2(root)==-1)
		return false;
	return true;
}


public static void main(String args[]){
	//lets create a tree instance and check if it is balanced
	TreeNode root = new TreeNode(0);
	TreeNode one = new TreeNode(1);
	TreeNode two = new TreeNode(2);
	TreeNode three = new TreeNode(3);
	TreeNode four = new TreeNode(4);
	TreeNode five = new TreeNode(5);
	root.left = one;
	root.right = two;
	one.left = three;
	one.right = four;
	three.left = five;
	System.out.println(isBalanced1(root));
	System.out.println(isBalanced2(root));
}
}