/**
BinaryTree path sum from any node to any other node

*/

public class BinaryTreePathSumAyNode{
	/**
	-we check if there is a path downard the given tree that sum to the given value
	-the path can start from any node (not necessarily root node) and can end anywhere (not necessarily leaf node)
	-we save the path in an array list and keep on updating the sum so far and the sum we need to obtain
	-if we reach the leaf node and did not get the sum, we
	*/
	
	public static void findAllPathSum(TreeNode root, int sum, int[] path, int level){
		if(root ==null)
			return;
		
		//add the current node to the path
		path[level] = root.val;
		
		//now check if this node would act as the end node for the path with the given sum
		int val = 0;
		for(int i= level; i>=0;i--){
			val+=path[i];
			if(val==sum){
				printPath(path, i, level);
			}
			
		}
		//recursively extend the path to the child nodes
		findAllPathSum(root.left, sum, path, level+1);
		findAllPathSum(root.right, sum, path, level+1);
	}
	
	public static int findLevel(TreeNode root){
		if(root==null)
			return 0;
		return 1+Math.max(findLevel(root.left), findLevel(root.right));
	}
	
	public static void printPath(int[] path, int start, int end){
		for(int i=start;i<=end; i++){
			System.out.print(path[i]+" ");
		}
		System.out.println();
	}
	
	public static void findSum(TreeNode root, int sum){
		int level = findLevel(root);
		int[] path = new int[level];
		findAllPathSum(root, sum, path, 0);
	}
	
	public static void main(String args[]){
		//create a tree
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(3);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(8);
		root.right.left = new TreeNode(2);
		root.right.right = new TreeNode(6);
		root.right.right.left = new TreeNode(1);
		int sum = 8;
		findSum(root, sum);
	}
}