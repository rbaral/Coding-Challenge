package com.alg.ctci.linkedlist;

import java.util.Hashtable;

/**
 *
 * Write code to remove duplicates from an unsorted linked list. FOLLOW UP How
 * would you solve this problem if a temporary buffer is not allowed?
 */
public class RemoveDuplicateFromLinkedList {

    /**
     * We can store the LinkedList nodes in a hash table and check if the entry
     * has already been made, if so, simply update the links of the duplicate
     * entry, else we just make an entry in the hash table. We can just start
     * with the first node (header node) and the rest will be taken care of.
     *
     * Solution:O(N); Space: O(N)
     */
    public static void removeDuplicates(LinkedListNode n) {
        Hashtable table = new Hashtable();
        LinkedListNode previous = null;
        while (n != null) {//repeat till we reach the tail node or sentinel
            if (table.containsKey(n.data)) {//this is a duplicate
                //we update the links
                previous.nextNode = n.nextNode;
            } else {
                table.put(n.data, true);
                previous = n;
            }
            n = n.nextNode;
        }
    }

    /**
     * In this method we attempt to remove the duplicates without using the
     * buffer to store the intermediate result. We can use two pointers: one is
     * a current pointer which iterates throughout the linked list and another
     * is a runner pointer which checks all subsequent nodes for duplicates.
     *
     * Solution: O(N^2)
     */
    public static void removeDuplicateWithoutBuffer(LinkedListNode n) {
        if (n == null) {
            return;
        }

        LinkedListNode current = n;
        while (current != null) {
            LinkedListNode runner = current; // for all the following nodes
            while (runner.nextNode != null) {//till there are some next nodes of current node
                if (runner.nextNode.data == current.data) {//a duplicate
                    runner.nextNode = runner.nextNode.nextNode; //update the next link
                } else {
                    runner = runner.nextNode;
                }
            }
            //update the current node
            current = current.nextNode;
        }

    }

    public static void main(String args[]) {
        LinkedListNode head = new LinkedListNode(0);
        LinkedListNode second;
        LinkedListNode current = head;
        for (int i = 1; i < 8; i++) {
            second = new LinkedListNode(i % 2);
            current.nextNode = second;
            current = second;
        }

        System.out.println(head.printForward());
        LinkedListNode clone = head.clone();
        System.out.println(clone.printForward());
        //now delete the duplicates
        //removeDuplicates(head);
        removeDuplicateWithoutBuffer(head);
        System.out.println(head.printForward());
    }
}
