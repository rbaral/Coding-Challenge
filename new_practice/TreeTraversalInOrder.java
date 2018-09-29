/**
InOrder Traversal of a tree
*/

public class TreeTraversalInOrder{

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
		performInOrder(root, nodesList);
		//lets print and check the order
		System.out.println("In-order traversal is:");
		for(TreeNode node:nodesList){
			System.out.print(" "+node.val);
		}
	}

}