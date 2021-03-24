package com.alg.ctci.stack;

/**
this is a basic representation of a Stack (LIFO),
where we provide basic stack operations.
We use the Node class (a representation of a LinkedList)
*/

import com.alg.ctci.linkedlist.LinkedListNode;
public class StackUsingLinkedList{
    //lets assume we have a pointer to a Node (like the head node of a Linked List)
    LinkedListNode top;
    int size;

    /**
    * a basic push operation
    */
    void push(Object item){
        //when we push, we get a new head node
        LinkedListNode newTop = new LinkedListNode((int)item);
        newTop.setNext(top);
        //we replace the existing top with the new top
        top = newTop;

    }

    /**
    a basic pop operation that removes the 
    Object at head and makes the next node
    as a new head node
    */
    Object pop(){
            //check if the headnode is null
        if(top==null){
            return null;
        }else{
            //get the top item that will be popped/removed
            Object popItem = top.getData();
            //now initialize the new top
            top = top.getNextNode();
            return popItem;
        }
    }

    /**
    this is a basic method that returns
    the item at top without removing the item
    */
    Object peek(){
        return top.getData();
    }
	
}