/**
You are given a binary tree in which each node contains an integer value.

Find the number of paths that sum to a given value.

The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).

The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.

Example:

root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8

      10
     /  \
    5   -3
   / \    \
  3   2   11
 / \   \
3  -2   1

Return 3. The paths that sum to 8 are:

1.  5 -> 3
2.  5 -> 2 -> 1
3. -3 -> 11
*/
import java.util.*;

public class BinaryTreePathSumStartEndAnywhere{

	public static void print(int[] nums, int start, int end){
		for(int i=start;i<=end; i++){
			System.out.print(nums[i]+" ");
		}
		System.out.println();
	}

	public static void findSum(TreeNode node, int sum, List<Integer> path, int level, List<List<Integer>> paths){
		if(node==null){
			return;
		}
		//insert current node to the path
		path.add(node.val);
		//now check if we found a sum
		int cursum = 0;
		List<Integer> pathitems = new ArrayList<Integer>();
		for(int i = level; i>=0; i--){
			cursum+=path.get(i);
			pathitems.add(path.get(i));
			if(cursum==sum){
				//print(path, i, level);
				paths.add(pathitems);
			}
		}
		//now call the method recursively on child nodes
		findSum(node.left, sum, path, level+1, paths);
		findSum(node.right, sum, path, level+1, paths);
		
	}
	
	public static int findDepth(TreeNode root){
		if(root==null){
			return 0;
		}
		return 1 + Math.max(findDepth(root.left), findDepth(root.right));
	}
	
	//return number of paths that give the sum
	public static int pathSum(TreeNode root, int sum){
		int depth = findDepth(root);
		//int[] path = new int[depth];
		List<Integer> path = new ArrayList<Integer>();
		List<List<Integer>> paths = new ArrayList<List<Integer>>();
		findSum(root, sum, path, 0, paths);
		return paths.size();
	}
	
	public static void main(String args[]){
		TreeNode ten = new TreeNode(10);
		TreeNode five = new TreeNode(5);
		TreeNode minthree = new TreeNode(-3);
		TreeNode three = new TreeNode(3);
		TreeNode two = new TreeNode(2);
		TreeNode eleven = new TreeNode(11);
		TreeNode three2 = new TreeNode(3);
		TreeNode min2 = new TreeNode(-2);
		TreeNode one = new TreeNode(1);
		ten.left = five;
		ten.right = minthree;
		five.left = three;
		five.right = two;
		minthree.right = eleven;
		three.left = three2;
		three.right = min2;
		two.right = one;
		int sum = 8;
		System.out.println(pathSum(ten, sum));
	}

}