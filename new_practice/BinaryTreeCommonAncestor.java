/**
find common ancestor of two nodes in a binary tree. Avoid storing additional nodes in a data structure. NOTE: This is not
necessarily a binary search tree.
*/

/**
Method1:
-first we find on which side of the root node, the two nodes are located
-if both the nodes are on different side of a root node, the root node will be the common ancestor
-if the nodes are on same side, then we recursively check to find the node that splits the node into different subtree
*/

public class BinaryTreeCommonAncestor{
	
	/**
	check if the root node covers the node
	*/
	public static boolean nodeCovers(TreeNode root, TreeNode node){
		if(root == null){
			return false;
		}
		if(root==node){
			return true;
		}
		return nodeCovers(root.left, node) || nodeCovers(root.right, node);
	}
	
	/**
	find the common ancestor of node1 and node2 in the tree with root node at root
	*/
	public static TreeNode findCommonAncestor(TreeNode root, TreeNode node1, TreeNode node2){
		if(root ==null){
			return null;
		}
		if(root==node1 || root==node2)
			return root;
		
		//first check if the nodes are present in the tree, if not return null
		if(!nodeCovers(root, node1) || !nodeCovers(root, node2)){
			return null;
		}
		//check if node1 is covered by left
		boolean isLeft1 = nodeCovers(root.left, node1);
		//check if node2 is covered by left
		boolean isLeft2 = nodeCovers(root.left, node2);
		
		if(isLeft1!=isLeft2){//both are on different side
			return root;
		}else{
			if(isLeft1==isLeft2){//both are on left side
				return findCommonAncestor(root.left, node1, node2);
			}else{//both are on right side
				return findCommonAncestor(root.right, node1, node2);
			}
		}
	}
	
	public static void main(String args[]){
		//create a tree
		TreeNode root = new TreeNode(0);
		TreeNode one = new TreeNode(1);
		TreeNode two = new TreeNode(2);
		TreeNode three = new TreeNode(3);
		TreeNode four = new TreeNode(4);
		TreeNode five = new TreeNode(5);
		root.left = one;
		root.right = two;
		one.parent = root;
		two.parent = root;
		one.left = three;
		one.right = four;
		three.parent = one;
		four.parent = one;
		three.left = five;
		five.parent = three;
		TreeNode node1 = three;
		TreeNode node2 = five;
		TreeNode anc = findCommonAncestor(root, node1, node2);
		System.out.println("common ancestor of "+node1.val+" and "+node2.val+" is "+(anc==null?"NONE":anc.val));
	}
}