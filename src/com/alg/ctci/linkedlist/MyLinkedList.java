/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.ctci.linkedlist;

import java.util.Iterator;

/**
 *
 * @author rbaral
 */
public class MyLinkedList<Integer> implements Iterable {

    
    public static class Node<Integer>{
        
        public Node(Integer d, Node<Integer> p, Node<Integer> n){
            data = d; 
            prev = p;
            next = n;
        }
        public Integer data;
        public Node<Integer> prev;
        public Node<Integer> next;
    }
    
    //default constructor
    public MyLinkedList(){
        doClear();
    }
    
    private void doClear(){
        beginMarker = new Node<Integer> (null, null, null);
        endMarker = new Node<Integer> (null, beginMarker, null);
        beginMarker.next = endMarker;
        
        theSize = 0;
        modCount++;
    }
    
    public int size(){
        return theSize;
    }
    
    public boolean isEmpty(){
        return size()==0;
    }
    
    public boolean add(Integer x){
        add(size(),x);
        return true;
    }
    
    public void add(int index, Integer x){
        addBefore(getNode(index, 0, size()), x);
    }
    
    public Integer set(int index, Integer newVal){
        Node<Integer> p = getNode(index);
        Integer oldVal = p.data;
        p.data = newVal;
        return oldVal;
    }
    
    public Integer remove(int index){
        return remove(getNode(index));
    }
    
    /**
     * Adds an item to this collection at
     * specified position p.
     * Items at or after that position are shifted
     * one position higher.
     * 
     * @param p
     * @param x 
     * @throws INdexOutOfBoundsException if index is not between 0 and size()
     */
    private void addBefore(Node<Integer>p, Integer x){
        Node<Integer> newNode = new Node<Integer>(x, p.prev, p);
        newNode.prev.next = newNode;
        p.prev = newNode;
        theSize++;
        modCount++;
    }
    
    /**
     * Removes the object contained in Node p.
     * 
     * @param p the Node containing the object.
     * @return the item that was removed from the Collection.
     */
    private Integer remove(Node<Integer> p){
        p.next.prev = p.prev;
        p.prev.next = p.next;
        theSize--;
        modCount++;
        return p.data;
    }
    
    /**
     * Gets the Node at position index, which must range
     * from 0 to size() -1
     * @param index is the index to search at
     * @return is the internal node corresponding to index
     * @throws IndexOutOfBoundsException if index is not
     * in the range 0 and size()-1, inclusive
     */
    private Node<Integer> getNode(int index){
        return getNode(index, 0, size() -1);
    }
    
    /**
     * Gets the Node at position index, which must range from lower to upper.
     * 
     * @param index is the index to search at
     * @param lower is the lowest valid index
     * @param upper is the highest upper index
     * @return internal node corresponding to index
     * @throws INdexOutOfBoundsException if index is not 
     * between lower and upper, inclusive
     */
    private Node<Integer> getNode(int index, int lower, int upper){
        Node<Integer> p;
        if(index< lower || index>upper)
            throw new IndexOutOfBoundsException();
        if(index<size()/2){
            p = beginMarker.next;
            for(int i=0; i<index;i++){
                p = p.next;
            }
        }else{
            p = endMarker;
            for(int i= size(); i>index;i--){
                p = p.prev;
            }
        }
        return p;
    }
    
    
    @Override
    public Iterator iterator() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return new LinkedListIterator();
    }
    
    private class LinkedListIterator implements java.util.Iterator<Integer>{
        private Node<Integer> current = beginMarker.next;
        private int expectedModCount = modCount;
        private boolean okToRemove = false;
        
        public boolean hasNext(){
            return current!=endMarker;
        }
        
        public Integer next(){
            if(modCount!=expectedModCount){
                throw new java.util.ConcurrentModificationException();
            }
            if(!hasNext())
                throw new java.util.NoSuchElementException();
            
            Integer nextItem = current.data;
            current = current.next;
            okToRemove = true;
            return nextItem;
        }
        
        
        public void remove(){
            if(modCount!=expectedModCount)
                throw new java.util.ConcurrentModificationException();
            
            if(!okToRemove)
                throw new IllegalStateException();
         
            MyLinkedList.this.remove(current.prev);
            expectedModCount++;
            okToRemove = false;
        }
    
        
    }
    
    private int theSize;
    private int modCount = 0;
    private Node<Integer> beginMarker;
    private Node<Integer> endMarker;
    
    public static void main(String args[]){
        MyLinkedList myList = new MyLinkedList();
        myList.add(1);
        myList.add(2);
        myList.add(3);
        Iterator it = myList.iterator();
        System.out.println("List size before:"+myList.size());
        /*
        int index=0;
        while(it.hasNext()){
            if(((int)it.next())%2==0){
              myList.remove(index);
            }
            index++;
        }
        */
        myList.remove(1);
        System.out.println("List size after:"+myList.size());
    }
    
}

