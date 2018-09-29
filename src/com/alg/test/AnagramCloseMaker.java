/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.test;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class AnagramCloseMaker {

    public static List<String> anagramProc(String[] str) {
        //create a hash table and store the sorted version of word as key and the anagrams as values in list

        Map<String, List<String>> mapAna = new HashMap<String, List<String>>();
        //sort the string iteratively
        for (String s : str) {
            String temp = s;
            Arrays.sort(temp.toCharArray());
            if (!mapAna.containsKey(temp)) {
                List<String> anaList = new ArrayList<String>();
                anaList.add(s);
                mapAna.put(temp, anaList);
            } else {
                mapAna.get(temp).add(s);
            }
        }
        //now add all the anagrams from the hash to a list and return it
        List<String> anagrams = new ArrayList<String>();
        for (String ana : mapAna.keySet()) {
            anagrams.addAll(mapAna.get(ana));
        }
        return anagrams;

    }

    public static void main(String args[]) {
        String[] s = {"aba", "def", "baa", "fed", "cow", "owc"};
        List<String> anaList = anagramProc(s);
        for(String ss : anaList) {
            System.out.println(ss);
        }
    }

}
