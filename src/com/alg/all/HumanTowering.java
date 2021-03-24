/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.ctci;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author rbaral
 * 
 * 
 * A circus is designing a tower routine consisting of people standing atop one another’s shoulders. 
 * For practical and aesthetic reasons, each person must be both shorter and lighter than the person below him or her. 
 * Given the heights and weights of each person in the circus, write a method to compute the largest possible number 
 * of people in such a tower.
 * 
 * Solution:
 * Ref: https://codesolutiony.wordpress.com/2014/12/31/11-8-rank-node-bst/
 */
public class HumanTowering {
    class Person implements Comparable {

        int height;
        int weight;
        public Person(int h, int w) {
            this.height = h;
            this.weight = w;
        }
        
        public String toString(){
            return "("+this.height+","+this.weight+")";
        }

        @Override
        public int compareTo(Object o) {
            Person p2 = (Person)o;
            if(this.height!=p2.height){
                return ((Integer)this.height).compareTo(p2.height);
            }else{
                return ((Integer)this.weight).compareTo(p2.weight);
            }
        }
        
        public boolean isBefore(Person second){
            if(this.height<second.height && this.weight<second.weight){
                return true;
            }
            return false;
        }
    }
    
    public static ArrayList<Person> initBestStack(ArrayList<Person> l1, ArrayList<Person> l2){
        if(l1==null){
            return l2;
        }else if(l2==null){
            return l1;
        }else{
            return l1.size()>l2.size()?l1:l2;
        }
    }
    
    public static void getLongestStack(List<Person> persons, ArrayList<Person>[] sol, int curIndex){
        if(curIndex>=persons.size() || curIndex<0){
            return;
        }
        Person cur = persons.get(curIndex);
        ArrayList<Person> bestStack = null;
        //check the other persons who fit with this person
        for(int i=0;i<curIndex;i++){
            if(persons.get(i).isBefore(cur)){
                //that person fits with cur, maintain the longest stack
                bestStack = initBestStack(bestStack, sol[i]);
            }
        }
        
        //append the current element
        ArrayList<Person> newSol = new ArrayList<Person>();
        if(bestStack!=null){
            newSol.addAll(bestStack);
        }
        newSol.add(cur);
        //add this to the total list
        sol[curIndex] = newSol;
        getLongestStack(persons, sol, curIndex+1);
    }
    
    public static ArrayList<Person> getLongestStack(List<Person> persons){
        //track of the stack for each item
        ArrayList<Person> [] sol = new ArrayList[persons.size()];
        getLongestStack(persons, sol, 0);
        int maxLen = 0, maxIndex = -1;
        for(int i=0;i<sol.length;i++){
            List<Person> l = sol[i];
            if(l.size()>=maxLen){
                maxLen = l.size();
                maxIndex = i;
            }
        }
        for(ArrayList<Person> p: sol){
            System.out.println(p.size());
        }
        return sol[maxIndex];
    }
    
    public static List<Person> getStack(List<Person> persons){
        //sort by height
        Collections.sort(persons);
        //call the helper
        return getLongestStack(persons);
    }
    
    public static int stackPeople(Person[] persons) {
        Arrays.sort(persons, new Comparator<Person>() {
            public int compare(Person p1, Person p2) {
                return p1.height - p2.height;
            }
        });
        int[] store = new int[persons.length];
        int result = 0;
        for (int i = 0; i < persons.length; i++) {
            int cur = 0;
            for (int j = 0; j < i; j++) {
                if (persons[j].weight < persons[i].weight && store[j] >= cur) {
                    cur = store[j];
                }
            }
            store[i] = cur + 1;
            result = Math.max(result, store[i]);
        }
        System.out.println("elems:"+Arrays.toString(store));
        return result;
    }
    
    public static void main(String args[]){
       Person[] persons = new Person[5];
       persons[0] = new HumanTowering().new Person(10,15);
       persons[1] = new HumanTowering().new Person(10,5);
       persons[2] = new HumanTowering().new Person(11,14);
       persons[3] = new HumanTowering().new Person(12,15);
       persons[4] = new HumanTowering().new Person(9,1);
       //System.out.println(stackPeople(persons));
       List<Person> personsList = new ArrayList<Person>();
       for(Person p: persons){
           personsList.add(p);
       }
       personsList = getStack(personsList);
       for(Person p:personsList){
           System.out.println(" "+p.toString());
       }
    }
}
