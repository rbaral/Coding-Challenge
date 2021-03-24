/**
Preorder traversal of a tree
*/
import java.util.List;
import java.util.ArrayList;

public class TreeTraversalPreOrder{
	
	/**
	recursively perform the pre-order traversal
	*/
	public static void performPreOrder(TreeNode root, List<TreeNode> nodesList){
		if(root==null){
			return;
		}else{
			nodesList.add(root);
			
			if(root.left!=null)
				performPreOrder(root.left, nodesList);
			
			if(root.right!=null)
				performPreOrder(root.right, nodesList);
		}
	}
	public static void main(String args[]){
		List<TreeNode> nodesList = new ArrayList<TreeNode>();
		//create a tree
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
		performPreOrder(root, nodesList);
		//lets print and check the order
		System.out.println("Pre-order traversal is:");
		for(TreeNode node:nodesList){
			System.out.print(" "+node.val);
		}
	}
}