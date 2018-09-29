/**
Binary tree subtree:
You are given a large binary tree T1 with millions of nodes and another binary tree T2 with hundreds of nodes.
Create an algorithm to find if T2 is a subtree of T1.
*/
import java.util.List;
import java.util.ArrayList;
public class BinaryTreeSubTree{

	//returns the inorder notation of a tree
	public static String getInorderTraversal(TreeNode root, StringBuffer sb){
		if(root == null){
			sb.append( " NULL ");
			return sb.toString();
		}
		getInorderTraversal(root.left, sb);
		sb.append(" "+root.val+" ");
		getInorderTraversal(root.right, sb);
		return sb.toString();
	}
	
	//returns the preorder notation of a tree
	public static String getPreorderTraversal(TreeNode root, StringBuffer sb){
		if(root == null){
			sb.append( " NULL ");
			return sb.toString();
		}
		sb.append(" "+root.val+" ");
		getPreorderTraversal(root.left, sb);
		getPreorderTraversal(root.right, sb);
		return sb.toString();
	}
	/**
	Method1:
	-we create inorder string for n1 and n2 and check if n2 is a substring of n1
	-we also create a preorder string for n1 and n2 and check if n2 is a substring of n1
	-sometimes when duplicate nodes are present in consecutive position its difficult to identify
	the correct order, so we rely on the two order notations to check if one string is a substring of another
	-when we reach a null node we append NULL to the string
	-this works for small and medium sized trees but for trees with million of nodes, storing the inorder and
	preorder traversal in additional space is not an efficient solution when we have large trees
	*/
	public static boolean isSubTree1(TreeNode n1, TreeNode n2){
		String inorderString1 = getInorderTraversal(n1, new StringBuffer());
		String inorderString2 = getInorderTraversal(n2, new StringBuffer());
		System.out.println("inorder1 is:"+inorderString1);
		System.out.println("inorder2 is:"+inorderString2);
		if(inorderString1.contains(inorderString2)){
			//now check if the preorder also matches
			String preorderString1 = getPreorderTraversal(n1, new StringBuffer());
			String preorderString2 = getPreorderTraversal(n2, new StringBuffer());
			System.out.println("preorder1 is:"+preorderString1);
			System.out.println("preorder2 is:"+preorderString2);
			if(preorderString1.contains(preorderString2)){
				return true;
			}
		}
		return false;
	}
	/**
	finds the node in the given tree and returns the list of nodes in the tree that match
	*/
	public static void findNodeinTree(TreeNode root, TreeNode node, List<TreeNode> nodesList){
		if(root==null || node==null){
			return;
		}
		if(root.val == node.val){
			nodesList.add(root);
		}
		findNodeinTree(root.left, node, nodesList);
		findNodeinTree(root.right, node, nodesList);
	}
	/**
	Method2.1:
	-first we check if the root node of t1 is present in t1
	-if for the first occurence of root2 in t1, the preoreder and inorder strings match then we have found the subtree
	-if for the first occurence of root2 in t1, there is no match, we search for another occurence of root2 and repeat the process.
	
	Method2.2
	-after finding the first occurence of root2 in t1, we traverse both trees to check if every node in t2 is found in t1 in the same strcuture, if not we find another occurence of root2
	Time: O(n +km) where n is the number of nodes in t1 and m is the number of nodes in t2, we might need to search k times for the root of t2 in t1.
	*/
	public static boolean isSubTree2(TreeNode n1, TreeNode n2){
		//base case
		if(n2==null){
			return true;
		}
		//now find the root of t2 in t1
		List<TreeNode> nodesList = new ArrayList<TreeNode>();
		findNodeinTree(n1, n2, nodesList);
		//if nodesList is empty the root of t2 was not found in t1
		System.out.println("nodes list is of size:"+nodesList.size());
		if(nodesList.size()<1){
			return false;
		}else{
			//for each of the match of root2 in t1, traverse the tree and check for equality of nodes
			for(TreeNode node:nodesList){
				//for this matched node traverse the t1 and check if every node in t2 and t1 are in same structure
				if(isNodeMatch(node, n2)){
					return true;
				}
			}
			return false;
		}
	}
	
	/**
	check if the two tree are equal
	*/
	public static boolean isNodeMatch(TreeNode n1, TreeNode n2){
		if(n1==null && n2==null){
			return true;
		}else if(n1!=null && n2==null){
			return false;
		}else if(n2!=null && n1==null){
			return false;
		}else if(n1.val!=n2.val){
			return false;
		}else{
			//System.out.println("isnodematch for nodes with val:"+n1.val+" and "+n2.val);
			//it was a match for this node now lets check for its child nodes
			return isNodeMatch(n1.left, n2.left) && isNodeMatch(n1.right, n2.right);
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
		one.left = three;
		one.right = four;
		three.left = five;
		
		//create another tree
		TreeNode root2 = new TreeNode(1);
		TreeNode three2 = new TreeNode(3);
		TreeNode four2 = new TreeNode(4);
		TreeNode five2 = new TreeNode(6);
		root2.left = three2;
		root2.right = four2;
		three2.left = five2;
		//System.out.println("Inorder traversal is:"+getInorderTraversal(root, new StringBuffer()));
		//System.out.println("Preorder traversal is:"+getPreorderTraversal(root, new StringBuffer()));
		System.out.println("issubtree 1:"+isSubTree1(root, root2));
		
		System.out.println("issubtree 2:"+isSubTree2(root, root2));
		
	}
}