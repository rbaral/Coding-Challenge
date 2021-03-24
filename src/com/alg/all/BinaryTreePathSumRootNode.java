/**
You are given a binary tree in which each node contains a value. Design an algorithm
to print all paths which sum to a given value. The path does not need to start
or end at the root or a leaf.
*/
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class BinaryTreePathSumRootNode{

	/**
	Method1: check if there is any path from root node - we only care if there is a path, we don't need to collect all such paths and we don't need to have the path ending on leaf node
	-we assume that the root node should be included in the path, so the path starts from root and can end anywhere such that
	the sum of given value is obtained by adding all the nodes on the path
	
	*/
	public static boolean pathSumFromRootToAnyNode(TreeNode root, int sum){
		//base case
		if(root ==null){
			return false;
		}else if(root!=null && root.val ==sum){
			return true;
		}
		boolean isLeftSum = false;
		if(root.left!=null)
			isLeftSum = pathSumFromRootToAnyNode(root.left, sum - root.val);
		//only check on right child if we did not find the path with sum in the left child
		return isLeftSum?true:pathSumFromRootToAnyNode(root.right, sum-root.val);
		
	}
	
	
	
	/**
	check if there is a path of given sum from root node to any leaf node
	*/
	public static boolean hasPathSumRootToLeaf(TreeNode root, int sum) {
        //base case
		if(root ==null){
			return false;
		}
		//if the current node is leaf and the value till this node reaches sum
		if(root.left==null && root.right==null && sum-root.val==0)
			return true;
		else{
			boolean leftSum = hasPathSumRootToLeaf(root.left, sum-root.val);
			return leftSum==true?true:hasPathSumRootToLeaf(root.right, sum-root.val);
		}
		
    }
	
	public static void pathSumHelper2(TreeNode root, int sum, List<List<Integer>> result, List<Integer> currentResult) {
		if (root == null)
			return;
		currentResult.add(new Integer(root.val));
		if (root.left == null && root.right == null && sum == root.val) {
			result.add(new ArrayList(currentResult));
			currentResult.remove(currentResult.size() - 1);//don't forget to remove the last integer
			return;
		} else {
			pathSumHelper2(root.left, sum - root.val, result, currentResult);
			pathSumHelper2(root.right, sum - root.val, result, currentResult);
		}
		currentResult.remove(currentResult.size() - 1);
	}
	
	/**
	store the running path in pathSumList
	*/
	public static void pathSumHelper1(TreeNode root, int sum, List<List<Integer>> pathsList, List<Integer> curPath){
		if(root==null){
			return;
		}
		//now add the current node to the curPath
		curPath.add(new Integer(root.val));
		System.out.println("cur path is:"+Arrays.toString(curPath.toArray()));
		//now check if we reach the leaf node and get the sum
		if(root.left==null && root.right==null && root.val==sum){
			//we found a path with the given sum so we store it in our result
			pathsList.add(new ArrayList(curPath));
			System.out.println("removing node inside:"+curPath.get(curPath.size()-1));
			//remove the leaf node that formed a sum, so that we can still consider the path till its parent node and proceed with its sibling node
			curPath.remove(curPath.size()-1);
			return;
		}else{
			pathSumHelper1(root.left, sum - root.val, pathsList, curPath);
			pathSumHelper1(root.right, sum - root.val, pathsList, curPath);
		}
		//remove the last node that are leaf node but their path did not form a sum
		System.out.println("removing node outside:"+curPath.get(curPath.size()-1));
		curPath.remove(curPath.size()-1);
	}
	/**
	find all paths from root to leaf nodes that have the given sum
	-we need to store all the paths from root to leaf that give the sum
	*/
	public static List<List<Integer>> allRootLeafPathWithSum(TreeNode root, int sum) {
		List<List<Integer>> pathsList = new ArrayList<List<Integer>>();
		List<Integer> curPath = new ArrayList<Integer>();
		pathSumHelper1(root, sum, pathsList, curPath);
		return pathsList;
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
		//System.out.println("pathSumFromRoot for sum "+sum+" is:"+pathSumFromRootToAnyNode(root, sum));
		System.out.println("printing path from root to leaf with sum:"+sum);
		List<List<Integer>> pathsList = allRootLeafPathWithSum(root, sum);
		for(List<Integer> path: pathsList){
			for(Integer val:path){
				System.out.print(val+" ");
			}
			System.out.println();
		}
		
	}
}