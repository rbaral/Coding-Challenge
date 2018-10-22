/**
We are given a binary tree (with root node root), a target node, and an integer value K.

Return a list of the values of all nodes that have a distance K from the target node.  The answer can be returned in any order.

 

Example 1:

				3
		5				1
	6		2		0		8
		7		4

Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, K = 2

Output: [7,4,1]

Explanation: 
The nodes that are a distance 2 from the target node (with value 5)
have values 7, 4, and 1.



Note that the inputs "root" and "target" are actually TreeNodes.
The descriptions of the inputs above are just serializations of these objects.
 

Note:

The given tree is non-empty.
Each node in the tree has unique values 0 <= node.val <= 500.
The target node is a node in the tree.
0 <= K <= 1000.

*/
import java.util.*;

//Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class BinaryTreeKNodesApart{
	static HashMap<TreeNode, List<TreeNode>> map = new HashMap<TreeNode, List<TreeNode>>();
	/**
	-we first maintain a hashmap that contains a node and its connected node as key,value pair
	-so the hashmap maintains a 1 distance relation between the nodes
	-we start with the target node and perform BFS until the 1 distance relation from the hashmap are accessed, marking the visited nodes to avoid duplicates
	-after recursively performing BFS k times, the bfs queue holds all the desired nodes
	
	Complexity: O(n)
	Space: O(n)
	Ref:https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/discuss/143752/JAVA-Graph-+-BFS
	*/
	public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
       List<Integer> result = new ArrayList<Integer>();
	   if(root==null || k<0){
		   return result;
	   }
	   buildMap(root, null);
	   //if the node is not found in the map
	   if(!map.containsKey(target)){
		   return result;
	   }
	   HashSet<TreeNode> visited = new HashSet<TreeNode>();
	   Queue<TreeNode> q = new LinkedList<TreeNode>();
		//start BFS from the target node
		q.add(target);
		visited.add(target);
		while(!q.isEmpty()){
			int size = q.size();
			//if we have feteched enough items from teh queue, add all the elements to the result
			if(k==0){
				while(!q.isEmpty()){
					result.add(q.poll().val);
				}
				return result;
			}
			//perform BFS iteratively
			for(int i=0;i<size; i++){
				TreeNode node = q.poll();
				//mark all of the 1-node away relation as visited and add them to the q
				for(TreeNode nextnode:map.get(node)){
					if(visited.contains(nextnode)){
						continue;
					}
					visited.add(nextnode);
					q.add(nextnode);
				}
			}
			k--;
		}
		return result;
    }
	
	/**
	build a hash map to maintain the parent-child and child-parent relation
	*/
	public static void buildMap(TreeNode node, TreeNode parent){
		if(node==null){
			return;
		}
		if(!map.containsKey(node)){
			map.put(node, new ArrayList<TreeNode>());
			if(parent!=null){
				//add the parent as its 1-node away relation
				map.get(node).add(parent);
				//add itself as 1-node away relation to the parent
				map.get(parent).add(node);
			}
			//recursively build the map on the left and right child nodes
			buildMap(node.left, node);
			buildMap(node.right, node);
		}
	}
}