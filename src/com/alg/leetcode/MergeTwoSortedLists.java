package com.alg.leetcode;
/**
 * Merge two sorted linked lists and return it as a new list. 
 * The new list should be made by splicing together the nodes of the first two lists.
 * @author rbaral
 *
 */

public class MergeTwoSortedLists {

    public static void main(String args[]) {
        
        ListNode l1 = new ListNode(5);
        l1.next = new ListNode(7);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(6);
        if (l1 != null && l2 != null) {
            System.out.println("Merging: " + l1.toString() + "..and.." + l2.toString());
        }
        ListNode mergedList = mergeTwoLists(l1, l2);
        if (mergedList != null) {
            System.out.println("merged list:" + mergedList);
        }
        
    }

    /**
     * merges two sorted linked lists and returns a single liked list. First we
     * handle the base cases. Next, we find the smallest of the first elements
     * of the two linked lists and recursively call the function to merge the
     * remaining elements
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        } else if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else {
            ListNode resultNode = null;
            if (l1.val <= l2.val) {
                resultNode = l1;
                resultNode.next = mergeTwoLists(l1.next, l2);
            } else {
                resultNode = l2;
                resultNode.next = mergeTwoLists(l1, l2.next);
            }
            return resultNode;
        }

    }

}
