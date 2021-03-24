/**
Implement a function to check if a binary tree is a binary search tree.
*/

/**
Method 1:
-perform in-order traversal and store the elements in an array
-if the array elements are sorted in ascending order, then the tree is BST
-however if there are duplicate elements, then we cannot identify if one of the duplicate
is on the left of another or on the right (if on the left, then it is a valid BST because left.val<=node.val<right.val is the
property of BST).
-O(n) for tree traversal and O(n) space
*/

/**
Method2: we can use the last node's value as the range for the next node
*/
import java.util.List;
import java.util.ArrayList;

public class BinaryTreeBST{
	
	/**
	recursively perform the in-order traversal
	*/
	public static void performInOrder(TreeNode root, List<TreeNode> nodesList){
		if(root==null){
			return;
		}else{
			if(root.left!=null)
				performInOrder(root.left, nodesList);
			nodesList.add(root);
			if(root.right!=null)
				performInOrder(root.right, nodesList);
		}
	}
	/**
	-perform inorder traversal and store the elements in an array
	-check if the array is sorted in ascending order, if so  it is BST
	-does not work for tree with duplicate nodes
	-we also need to know the size of array in advanced (else we need to store the elements in arraylist)
	*/
	public static boolean isBST1(TreeNode root){
		List<TreeNode> nodesList = new ArrayList<TreeNode>();
		if(root==null){
			return true;
		}else{
			//add all the nodes to the list
			performInOrder(root, nodesList);
			//now check if the elements in the list are in ascending order, if not then the tree is not a BST
			TreeNode prev = nodesList.get(0);
			for(int i=1; i<nodesList.size();i++){
				if(prev.val>=nodesList.get(i).val){
					return false;
				}
				prev = nodesList.get(i);
			}
		}
		return true;
	}
	
	/**
	-we can keep track of the last element we say and check the following:
	-- if left.val<= last element< INTEGER.MAX_VALUE
	-- if INTEGER.MIN_VALUE<= last element < right.val
	-if the above condition is voilated then return false 
	*/
	public static boolean isBST2(TreeNode root, int min, int max){
		if(root==null)
			return true;
		if(min>root.val || root.val>max){
			return false;
		}
		return isBST2(root.left, min, root.val) && isBST2(root.right, root.val, max);
	}
	
	/**
	we perform a recursive solution
	*/
	public static boolean isBST3(TreeNode root){
		if(root ==null)
			return true;
		if(root.left!=null){
			if(root.left.val>root.val){
				return false;
			}
			return isBST3(root.left);
		}
		if(root.right!=null){
			if(root.right.val<=root.val){
				return false;
			}
			return isBST3(root.right);
		}
		return true;
	}
	
	public static void main(String args[]){
		TreeNode root = new TreeNode(5);
		TreeNode one = new TreeNode(2);
		TreeNode two = new TreeNode(25);
		TreeNode three = new TreeNode(1);
		TreeNode four = new TreeNode(3);
		TreeNode five = new TreeNode(0);
		root.left = one;
		root.right = two;
		one.left = three;
		one.right = four;
		three.left = five;
		System.out.println("isBST1:"+isBST1(root));
		
		System.out.println("isBST2:"+isBST2(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
		
		System.out.println("isBST3:"+isBST3(root));
	}
	
}