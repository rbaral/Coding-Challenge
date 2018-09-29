/**
Reverse a linked list from position m to n. Do it in one-pass.

Note: 1 ≤ m ≤ n ≤ length of list.

Example:

Input: 1->2->3->4->5->NULL, m = 2, n = 4
Output: 1->4->3->2->5->NULL
*/
import java.util.Stack;


public class LinkedListReversePosition{
	/**
	Method1:
	-reverse a linked list from position m to position n, and the rest of the linkedlist should remain intact
	-we have a constraint that we need to do it in one pass
	-we are also not provided with any clue if we have a link to prev node, so we assume there is no prev link
	*/
	public static Node getReversedPosition(Node root, int m, int n){
		//handle base cases
		if(m>=n || m<0 || n<0){
			return root;
		}
		//maintain the pointer to header so that we can return it at last
		Node orghead = root;
		//lets assume a dummy node to be the first node of our result, we can remove it later
		Node resulthead = new Node(0);
		Node resultcur = resulthead;
		Node tempNode = null;
		int temp;
		for(int i=1;i<=n;i++){
			if(i<=m){//the prior portion to be retained as it is
				resultcur.next = root;
				root = root.next;
				resultcur = resultcur.next;
				//printLinkedList(resultcur);
			}
			else if(i<=n){//the portion to be reversed
				//insert the node in front of the resultcur node, by swapping the value of resulcur node and this node's value
				temp = resultcur.val;
				resultcur.val = root.val;
				//tempNode = resultcur;
				resultcur.next = new Node(temp);
				resultcur = resultcur.next;
				root = root.next;
				System.out.println(resultcur.val+"..."+i);
			}
		}
		resultcur.next = root;//the trailing portion to be retained as it is
		return resulthead.next;//because we had a dummy node in the begining which we want to get rid of
		
	}
	
	public static void printLinkedList(Node root){
		if(root==null){
			return;
		}else{
			while(root!=null){
				System.out.print(root.val+"->");
				root = root.next;
			}
			System.out.print("NULL");
			System.out.println();
		}
	}
	
	public static void main(String args[]){
		Node root = new Node(1);
		Node two = new Node(2);
		Node three = new Node(3);
		Node four = new Node(4);
		Node five = new Node(5);
		root.next = two;
		two.next = three;
		three.next = four;
		four.next = five;
		//root = new Node(3);
		//root.next = new Node(5);
		//printLinkedList(root);
		int m = 2;
		int n= 4;
		Node rev1 = getReversedPosition(root, m, n);
		printLinkedList(rev1);
	}
}