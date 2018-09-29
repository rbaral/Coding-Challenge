/**
Given a sorted (increasing order) array with unique integer elements, write an algorithm
to create a binary search tree with minimal height.

Method1:
-we find the item at the middle index and make it as a root and make the left half as left subtree and right half as right subtree
-the process is repeated recursively
*/
import java.util.List;
import java.util.LinkedList;
import java.util.Queue;
//a simple representation of Tree
enum NodeType{sep, reg}

class TreeNode{
	int val;
	NodeType type;
	TreeNode left;
	TreeNode right;
	TreeNode(int v){
		val = v;
		type = NodeType.reg;//by default it is a regular node
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

public class BinaryTeeFromSortedArray{

	/**
	we iteratively scan the root and its child nodes and add them to the queue and then finally return the linked list
	*/
	public static List<LinkedList<TreeNode>> getListfromBST(TreeNode root){
		if(root == null){
			return null;
		}
		//create a list of linked list to add the nodes at different level
		List<LinkedList<TreeNode>> nodesList = new LinkedList<LinkedList<TreeNode>>();
		//start with root by adding it to the queue
		Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
		nodeQueue.add(root);
		LinkedList<TreeNode> tempList = new LinkedList<TreeNode>();
		while(!nodeQueue.isEmpty()){
			//get the first node of this queue and proceed
			TreeNode first = nodeQueue.poll();
			if(nodesList.size()==0){
				nodesList.add(new LinkedList<TreeNode>());
			}
			//add the node to the last linked list
			nodesList.get(nodesList.size()-1).add(first);
			//fill the tempList for this level of nodes
			if(first.left!=null)
				tempList.add(first.left);
			if(first.right!=null)
				tempList.add(first.right);
			//if the queue is already empty, fill it with the entries from templist to start the new level
			if(nodeQueue.isEmpty()){
				while(tempList.size()>0){
					nodeQueue.add(tempList.removeFirst());
				}
				//create a new list to hold the nodes for next level
				nodesList.add(new LinkedList<TreeNode>());
			}
			
		}
		return nodesList;
		
	}
	public static TreeNode createMinimalBST(int[] arr, int start, int end){
		if(end<start){
			return null;
		}
		int mid = (start+end)/2;
		TreeNode root = new TreeNode(arr[mid]);
		root.left = createMinimalBST(arr, start, mid-1);
		root.right = createMinimalBST(arr, mid+1, end);
		return root;
	}
	
	public static void main(String args[]){
		int[] arr = new int[]{1,2,3,4,5,6,7};
		TreeNode root = createMinimalBST(arr, 0, arr.length-1);
		List<LinkedList<TreeNode>> nodesList = getListfromBST(root);
		//now print the nodes of each list
		for(LinkedList<TreeNode> list: nodesList){
			for(TreeNode node:list){
				System.out.print(node.val+" ");
			}
			System.out.println();
		}
		
	}
}