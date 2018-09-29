/**
post-order traversal of a tree
*/

public class TreeTraversalPostOrder{
	/**
	recursively perform the post-order traversal
	*/
	public static void performPostOrder(TreeNode root, List<TreeNode> nodesList){
		if(root==null){
			return;
		}else{
			if(root.left!=null)
				performPostOrder(root.left, nodesList);
			
			if(root.right!=null)
				performPostOrder(root.right, nodesList);
			nodesList.add(root);
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
		performPostOrder(root, nodesList);
		//lets print and check the order
		System.out.println("Post-order traversal is:");
		for(TreeNode node:nodesList){
			System.out.print(" "+node.val);
		}
	}

}