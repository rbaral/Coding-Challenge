/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.ctci;

import java.util.Iterator;

/**
 *Implement a Circular Array class that supports an array-like data structure which
can be efficiently rotated. The class should use a generic type, and should support
iteration via the standard for (Obj o : circuLarArray) notation
* 
 * @author rbaral
 */
public class CircularArray<T> implements Iterable<T>{
    private T[] items;
    private int head = 0;
    
    public CircularArray(int size){
        //create Object array and cast to array of type T
        items = (T[]) new Object[size];
    }
    
    private int convert(int index){
        if(index<0){ //if negative index, we rotate left
            index+=items.length;
        }
        return (head+index)%items.length;
    }
    
    public void rotate(int shiftRight){
        head = convert(shiftRight);
    }
    
    public T get(int i){
        if(i<0 || i>=items.length){
            throw new java.lang.IndexOutOfBoundsException("Array out of bounds");
        }
        return items[convert(i)];
    }
    
    public void set(int i, T item){
        items[convert(i)] = item;
    }

    @Override
    public Iterator<T> iterator() {
        return new CircularArrayIterator<T>(this);
    }
    
    class CircularArrayIterator<TI> implements Iterator<TI>{
        
        private int _current = -1; //the current item pointer
        private TI[] _items; //the array of type TI
        
        public CircularArrayIterator(CircularArray<TI> array){
            _items = array.items;
        }

        @Override
        public boolean hasNext() {
            return _current < items.length -1;
        }

        @Override
        public TI next() {
            _current++;
            TI item = (TI)_items[convert(_current)];
            return item;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
        
    }
    
    public static void main(String[] args) {
        int size = 10;
        CircularArray<String> array = new CircularArray<String>(size);
        for (int i = 0; i < size; i++) {
                array.set(i, String.valueOf(i));
        }
        System.out.println("original");
        for (int i = 0; i < size; i++) {
                System.out.print(array.get(i)+" ");
        }
        array.rotate(3);
        System.out.println("\nrotated by 3");
        for (int i = 0; i < size; i++) {
                System.out.print(array.get(i)+" ");
        }

        System.out.println("");
        System.out.println("\nrotate by 2");
        array.rotate(0);
        for (String s : array) {
                System.out.print(s+" ");
        }
    }
}
