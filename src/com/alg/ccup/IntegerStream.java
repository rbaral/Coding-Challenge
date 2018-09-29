/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.ccup;

import java.util.Iterator;

/**
 *
 * @author rbaral
 * 
 * Design an iterator for a given stream of integers, with next() and hasnext() 
 * being called in any sequence, but skipping any 0's in the stream.
 * 
 * 
 * Solution:
 * 
 * REf: https://careercup.com/question?id=5693294772224000
 */
public class IntegerStream  implements Iterable<Integer>{
    
    class Node{
        Node next = null;
        Node head = null;
        Integer data;
    }
    
    private Node head;
    
    @Override
    public Iterator<Integer> iterator() {
        return new IntegerStreamIterator<Integer>();
    }
    
    class IntegerStreamIterator<Integer> implements Iterator{

        Node cur = head;
        
        @Override
        public boolean hasNext() {
            return cur!=null;
        }

        @Override
        public Object next() {
            while(hasNext() && cur.data==0)
                cur = cur.next;
            Integer item = null;
            if(hasNext()){
                item = (Integer) cur.data;
                cur = cur.next;
            }
            return item;
        }

        @Override
        public void remove() {
            if(cur.next!=null){
                cur = cur.next;
            }
        }
        
    }
    
}
