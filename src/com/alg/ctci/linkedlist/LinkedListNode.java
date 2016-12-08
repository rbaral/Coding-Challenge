package com.alg.ctci.linkedlist;


/**
class representing a linked list
*/
public class LinkedListNode{
	//lets say we have just int values for this node
	int data;
	//lets create a next node
	LinkedListNode nextNode = null;
        //previous node
        LinkedListNode prevNode = null;
        //the last node
        LinkedListNode lastNode = null;
        
	
	public LinkedListNode(int d){
		this.data = d;
	}
        
        public LinkedListNode(int d, LinkedListNode n, LinkedListNode p){
            data = d;
            setNext(n);
            setPrevious(p);
        }
	
        /**
         * sets nextnode of the current node
         * @param n 
         */
        public void setNext(LinkedListNode n){
            //set the nextnode
            nextNode = n;
            //if current node was the tailnode make n as the tailnode
            if(this==lastNode){
                lastNode = n;
            }
            //update the previous of the new node
            if(n!=null && n.prevNode!=this){
                n.setPrevious(this);
            }
        }
        
        /**
         * sets the previousnode of the current node
         * @param p 
         */
        public void setPrevious(LinkedListNode p){
            //set the previous node
            prevNode = p;
            if(p!=null && p.nextNode!=this){
                p.setNext(this);
            }
        }
        
        /**
         * prints the nodes from the current node onwards
         * @return 
         */
        public String printForward(){
            if(this==null){
                return "";
            }
            if(nextNode!=null){
                return this.data+"->"+nextNode.printForward();
            }else{
                return String.valueOf(this.data);
            }
        }
        
	/*
	appends a node at the end
	of a linked list
	*/
	void append(int d){
		LinkedListNode next = null;
		LinkedListNode current = this;
		while(current.nextNode!=null){
			current = current.nextNode; //just scan to the tail node
		}
		next = new LinkedListNode(d);
		current.nextNode = next;
	}
        
        public LinkedListNode clone(){
            LinkedListNode newList = null;
            if(nextNode!=null){
                newList = nextNode.clone();
            }
            LinkedListNode newHead = new LinkedListNode(data, newList, null);
            return newHead;
        }
	
	/*
	delete the node with data d by scanning
	through the headNode and return the pointer to new headNode
	*/
	LinkedListNode deleteNode(LinkedListNode headNode, int d){
		LinkedListNode currentNode = headNode;
		if (currentNode.data==d){// head node is to be deleted
			//return the next node as the new head node
			return currentNode.nextNode;
		}
		//now we scan through the other nodes to check if the data is d
		while(currentNode.nextNode!=null){
			if(currentNode.nextNode.data==d){
				currentNode.nextNode = currentNode.nextNode.nextNode;
				return headNode;
			}
			currentNode = currentNode.nextNode; //advance the pointer for next iteration
		}
		//the data d was not found, so return the default headNode
		return headNode;
	}
        
        public int getData(){
            return data;
        }
        
        public LinkedListNode getNextNode(){
            return nextNode;
        }
        
        public LinkedListNode getPreviousNode(){
            return prevNode;
        }
}
