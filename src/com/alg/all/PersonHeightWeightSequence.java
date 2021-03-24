/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.test;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

/**
 * given the height and weight of a set of people, find the longest possible
 * tower of people, such that, a person above another person has less height and
 * weight
 *
 */
/**
 * Solution: -sort the items by height/weight (only one, lets say weight) -for
 * each element of the sorted array, find the longest sequence that can end with
 * this element, i.e., person[0] has the longest sequence as {person[0]},
 * person[1] has longest sequence {person[1]} if she has more height than
 * person[0], else it will be {person[0],person[1]}, and so on. So, we build on
 * top of the existing solutions by checking if the last element of the existing
 * solutions fits this item or not, if it does then we take the longest among
 * the one that fit.
 */
class Person implements Comparable {

    int height;
    int weight;

    public Person(int w, int h) {
        height = h;
        weight = w;
    }

    public int getHeight() {
        return height;
    }

    public int getWeight() {
        return weight;
    }
    
    public String toString(){
        return getWeight()+","+getHeight();
    }

    //can this object be before the person p in the sequence?
    //if this person has more height and weight then she can be
    public boolean isBefore(Person p) {
        return height > p.getHeight() && weight > p.getWeight();
    }

    //perform descending sort
    public int compareTo(Object p) {
        Person other = (Person) p;
        if (height != other.getHeight()) {
            return ((Integer) other.getHeight()).compareTo((Integer) height);
        } else {
            return ((Integer) other.getWeight()).compareTo((Integer) weight);
        }
    }

}

public class PersonHeightWeightSequence {

    //takes existing sequences, finds the one that fits the current person
    //and the one that gives maximum length
    public static void getSequences(List<Person> p, List<List<Person>> seq, int currentIndex) {
        if (p.size() == 0 || currentIndex >= p.size()) {
            return;
        }
        if (currentIndex == 0) {//the first person in the list
            List<Person> pList = new ArrayList<Person>();
            pList.add(p.get(currentIndex));
            seq.add(pList);
        } else {
            //from the list of sequences, find the one that fits it and is longest
            List<Person> pList = getBestSequence(p.get(currentIndex), seq);
            //add the current item to the best sequence
            pList.add(p.get(currentIndex));
            //add the list to the sequences obtained so far
            seq.add(pList);
        }
        //now get the sequence ending with the next person
        getSequences(p, seq, currentIndex + 1);
    }

    /**
     * among the available sequences, find the one that best fits the given
     * person
     */
    public static List<Person> getBestSequence(Person p, List<List<Person>> seq) {
        if (seq == null || seq.size() == 0) {
            return new ArrayList<Person>();//return empty
        } else {
            int bestIndex = -1;
            int curIndex = 0;
            for (List<Person> pList : seq) {
                if (pList.get(pList.size() - 1).isBefore(p)) {//it fits
                    //check if it is best
                    if (bestIndex<0 || pList.size() >= seq.get(bestIndex).size()) {
                        bestIndex = curIndex;
                    }
                }
                curIndex++;
            }
            //return the one with the best match
            if(bestIndex<0)
                return new ArrayList<Person>();
            System.out.println("for person:"+p.toString()+", best match index is:"+bestIndex+" of length"+seq.get(bestIndex).size());
            
            return seq.get(bestIndex);
        }
    }

    public static List<Person> initializePersons() {
        List<Person> persons = new ArrayList<Person>();
        persons.add(new Person(60, 130));
        persons.add(new Person(51, 120));
        persons.add(new Person(41, 115));
        persons.add(new Person(61, 140));
        persons.add(new Person(80, 143));
        return persons;
    }

    public static void main(String[] args) {
        //initialize person objects
        List<Person> persons = initializePersons();
        //sort them by weight
        Collections.sort(persons);
        for (Person p : persons) {
            System.out.println("sorted persons:" + p.getWeight() + ".." + p.getHeight());
        }
        List<List<Person>> listPersons = new ArrayList<List<Person>>();
        getSequences(persons, listPersons, 0);
        //now iterate the listPersons list and see which one is longest
        int curIndex = 0;
        for (List<Person> pList : listPersons) {
            System.out.println("for person " + curIndex+","+persons.get(curIndex).toString()+" seq length is:" + pList.size());
            curIndex++;
        }

    }

}
