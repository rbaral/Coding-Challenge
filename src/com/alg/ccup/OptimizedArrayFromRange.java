/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.ccup;

import java.util.ArrayList;
import java.util.List;

/**
 *Given an array of "array ranges", return an optimized array
 * by deleting subarrays.
 * 
 * NOTE: Array range (2,6) represents (2,3,4,5,6)
 * 
 * Ex:
 * Input: [(2,6), (3,5), (7,21), (20,21)]
 * Output: [(2,6), (7,21)]
 * Reason: (3,5) is subarray of (2,6) and (20,21) is subarray of (7,21)
 * 
 * @author rbaral
 */
public class OptimizedArrayFromRange {
    
    class Tuple{
        int begin;
        int end;
        
        public Tuple(int b, int e){
            begin = b;
            end = e;
        }
        
        public int getBegin(){
            return begin;
        }
        
        public int getEnd(){
            return end;
        }
        
        public void printTuple(){
            System.out.print("("+getBegin()+","+getEnd()+")");
        }
        
        /**
         * checks if this tuple includes the other
         * 
         * @param t
         * @return 1 if this includes the other, -1 if other includes this, 0 if non overlapping
         */
        public int includes(Tuple t){
            if(begin <= t.getBegin() && end>=t.getEnd()){
                return 1;
            }else if(t.getBegin()<begin && t.getEnd()>end){
                return -1;
            }else{
                return 0;
            }
        }
    }
    
    /**
     * We can compare each tuple against the next one in the list
     * and eliminate the one that is included by the other
     * Runs in O(nlogn) time if we sort the tuples
     * @param tuples 
     */
    static List<Tuple> findRange(List<Tuple> tuples){
        List<Tuple> resultSoFar = new ArrayList<Tuple>();
        int contains = 0;
        int index = 0;
        if(tuples==null || tuples.size()==1){
            return tuples;
        }
        while(tuples.size()>0 && index<tuples.size()-1){
            contains = tuples.get(index).includes(tuples.get(index+1));
            if(contains==1){
                tuples.remove(index+1);
            }
            else if(contains==-1){
                tuples.remove(index);
            }else{
                //they are non overlapping, so store the first one to the result
                //advance the index
                index++;
            }
        }
        return tuples;
    }
    
    public static void main(String args[]){
        //[(2,6), (3,5), (7,21), (20,21)]
        List<Tuple> tuples = new ArrayList<Tuple>();
        tuples.add(new OptimizedArrayFromRange().new Tuple(2, 6));
        tuples.add(new OptimizedArrayFromRange().new Tuple(3, 5));
        tuples.add(new OptimizedArrayFromRange().new Tuple(3, 21));
        tuples.add(new OptimizedArrayFromRange().new Tuple(7, 21));
        tuples.add(new OptimizedArrayFromRange().new Tuple(20, 21));
        List<Tuple> result = findRange(tuples);
        for(Tuple t:result){
            t.printTuple();
        }
    }
}
