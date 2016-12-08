/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.ctci;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Write a method to return all subsets of a set.
 * @author rbaral
 */
public class SubsetOfSet {
    
    static ArrayList<ArrayList<Object>> getSubsets(ArrayList<Object> set, int index){
        ArrayList<ArrayList<Object>> allsubsets;
        if(set.size()==index){ //base case- just add empty set
            allsubsets = new ArrayList<ArrayList<Object>>();
            allsubsets.add(new ArrayList<Object>());
        }else{
            allsubsets = getSubsets(set, index+1);
            Object item = set.get(index);
            ArrayList<ArrayList<Object>> moresubsets = new ArrayList<ArrayList<Object>>();
            for (ArrayList<Object> subset:allsubsets){
                ArrayList<Object> newsubset = new ArrayList<Object>();
                newsubset.addAll(subset); //get all of the elements of last subset to this new list - flattens them
                System.out.println("adding item "+item+" as:"+newsubset.toString()+"...to:"+allsubsets.toString());
                newsubset.add(item); //add the item at current index to the flattened list
                moresubsets.add(newsubset);
            }
            allsubsets.addAll(moresubsets);
            System.out.println("for index "+index+" the subset is:"+allsubsets.toString());
        }
        return allsubsets;
    }
    
    public static void main(String[] args) {
        ArrayList<Object> list = new ArrayList<Object>();
        for (int i = 0; i < 3; i++) {
                list.add(i);
        }
        
        System.out.println("original set:"+list.toString());
        ArrayList<ArrayList<Object>> subsets = getSubsets(list, 0);
        System.out.println(subsets.toString());

        //ArrayList<ArrayList<Object>> subsets2 = getSubsets2(list);
        //System.out.println(subsets2.toString());		
    }
    
}
