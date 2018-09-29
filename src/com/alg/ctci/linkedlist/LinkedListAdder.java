/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.ctci.linkedlist;

/**
 *
 * @author rbaral
 * 
 * 
 * Backward:
 * You have two numbers represented by a linked list, where each node contains a
single digit. The digits are stored in reverse order, such that the 1 's digit is at the head
of the list. Write a function that adds the two numbers and returns the sum as a
linked list
* 
* 
* Forward:
 * 
 * You have two numbers represented by a linked list, where each node contains a
single digit. The digits are stored in forward order,
* such that the 1 's digit is at the tail
of the list. 
* Write a function that adds the two numbers and returns the sum as a
linked list
 * 
 * 
 * Ref: CTCI
 */
public class LinkedListAdder {
    class SumResult{
        LinkedListNode sumNode;
        int carry;
    }
    public LinkedListNode sum = null;
    int carry = 0;
    LinkedListNode l1 = null;
    LinkedListNode l2 = null;
    
    public LinkedListAdder(LinkedListNode l1, LinkedListNode l2){
        this.l1 = l1;
        this.l2 = l2;
    }
    
    public LinkedListNode prepareAndAddBack(){
        int len1 = length(l1);
        int len2 = length(l2);
        //pad the shortes lists with zeros
        if(len1<len2){
            l1 = padZerosToEnd(l1, len2 -len1);
        }else if (len1>len2){
            l2 = padZerosToEnd(l2, len1-len2);
        }
        System.out.println("padded lists are:"+l1.printForward()+" of len:"+len1+" and "+l2.printForward()+" of len "+len2);
        return addListsBackward(l1, l2, 0);
    }
    
    public LinkedListNode prepareAndAddForward(){
        int len1 = length(l1);
        int len2 = length(l2);
        //pad the shortes lists with zeros
        if(len1<len2){
            l1 = padZerosToFront(l1, len2 -len1);
        }else if (len1>len2){
            l2 = padZerosToFront(l2, len1-len2);
        }
        System.out.println("padded lists are:"+l1.printForward()+" of len:"+len1+" and "+l2.printForward()+" of len "+len2);
        SumResult sum = addListsForward(l1, l2);
        if(sum.carry==0){
            return sum.sumNode;
        }else{
            LinkedListNode result = insertNodeBefore(sum.sumNode, sum.carry);
            return result;
        }
    }
    
    LinkedListNode insertNodeBefore(LinkedListNode list, int val){
        LinkedListNode node = new LinkedListNode(val, null, null);
        if(list!=null){
            list.prevNode = node;
            node.nextNode = list;
        }
        return node;
    }
    
    SumResult addListsForward(LinkedListNode l1, LinkedListNode l2){
        if(l1==null && l2 ==null){
            return new SumResult();
        }
        //add the smaller digits recursively
        SumResult sum = addListsForward(l1.nextNode, l2.nextNode);
        //handle the carry
        int val = sum.carry + l1.data +l2.data;
        
        //insert the sum of current digits
        LinkedListNode res = insertNodeBefore(sum.sumNode, val%10);
        //return sum so far and the carry
        sum.sumNode = res;
        sum.carry = val/10;
        return sum;
    }
    
    
    LinkedListNode addListsBackward(LinkedListNode l1, LinkedListNode l2, int carry){
        if(l1==null && l2 ==null && carry ==0){
            return null;
        }
        LinkedListNode result = new LinkedListNode(carry, null, null);
        int val = carry;
        if(l1!=null)
            val+= l1.data;
        if(l2!=null)
            val+=l2.data;
        
        
        
        result.data = val%10;
        carry = val/10;
        System.out.println("adding nodes "+(l1!=null?l1.data:null)+" and "+(l2!=null?l2.data:null)+" data is "+result.data+" carry is:"+carry);
        if(l1!=null || l2!=null){
            LinkedListNode more = addListsBackward(
                    l1==null?null:l1.nextNode, 
                    l2==null?null:l2.nextNode,
                    carry);
            result.setNext(more);
        }
        return result;
        
    }
    
    int length(LinkedListNode l){
        int len = 0;
        if(l!=null)
            len++;
        while(l.nextNode!=null){
            len++;
            l = l.nextNode;
        }
        return len;
    }
    
    LinkedListNode padZerosToEnd(LinkedListNode l, int count){
        LinkedListNode tail = l;
        while(tail.nextNode!=null){
            tail = tail.nextNode;
        }
        for(int i=0;i<count;i++){
            LinkedListNode cur = new LinkedListNode(0, null, null);
            tail.nextNode = cur;
            cur.prevNode = tail;
            tail = cur;
        }
        //System.out.println("tail append:"+l.printForward());
        return l;
    }
    
    LinkedListNode padZerosToFront(LinkedListNode l, int count){
        LinkedListNode head = l;
        for(int i=0;i<count;i++){
            LinkedListNode cur = new LinkedListNode(0, null, null);
            head.prevNode = cur;
            cur.nextNode = head;
            head = cur;
        }
        return head;
    }
    
    
    public static void main(String args[]){
        //lets create some nodes and add them to a linked list
        LinkedListNode head1 = new LinkedListNode(1);
        LinkedListNode second;
        LinkedListNode current = head1;
        //lets create linked list with 10 nodes
        for (int i = 2; i < 5; i++) {
            second = new LinkedListNode(i);
            current.nextNode = second;
            current = second;
        }

        LinkedListNode head2 = new LinkedListNode(7);
        head2.nextNode = new LinkedListNode(9);
        //System.out.println(head1.printForward());
        //System.out.println(head2.printForward());
        LinkedListAdder adder = new LinkedListAdder(head1, head2);
        //LinkedListNode resultNode = adder.prepareAndAddBack();
        LinkedListNode resultNode = adder.prepareAndAddForward();
        System.out.println("sum is:"+resultNode.printForward());
    }
            
}
