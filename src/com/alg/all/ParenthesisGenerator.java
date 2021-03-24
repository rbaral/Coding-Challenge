/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.test;

import java.util.List;
import java.util.ArrayList;

/**
 * Given a value of n, write a method to generate all possible combinations of
 * valid parenthesis
 */
/**
 * Sol1: we use a simple recursive approach and build on top of the existing
 * string. We insert the kth pair of parenthesis after every left parenthesis of
 * the string we obtained from (k-1)th pair
 */
public class ParenthesisGenerator {

    public static List<String> getParenthesis(int count) {
        if (count < 0) {
            return null;
        }
        List<List<String>> listParList = new ArrayList<List<String>>();
        List<String> emptyPar = new ArrayList<String>();
        emptyPar.add("");
        listParList.add(emptyPar);

        for (int i = 1; i <= count; i++) {
            List<String> parList = getParenthesisBuild(listParList.get(i - 1));//send the list of strings generated from previous value of count
            listParList.add(parList);
        }

        return listParList.get(count);
    }

    public static List<String> getParenthesisBuild(List<String> parString) {
        //for every string in the parString, add a pair of parentheis after every '(' character
        List<String> newPairs = new ArrayList<String>();
        for (String s : parString) {
            String temp = s;
            //insert the new pair after every '(' character
            char[] charArr = s.toCharArray();
            for (int i = 0; i < charArr.length; i++) {
                if (charArr[i] == '(') {
                    String newPair = insertCharAt(temp, i + 1);
                    newPairs.add(newPair);
                }
            }
            //also insert at the begininig
            temp = insertCharAt(temp, 0);
            newPairs.add(temp);
        }
        return newPairs;
    }
    //insert the parenthesis pair at the pos

    public static String insertCharAt(String a, int pos) {
        StringBuilder sb = new StringBuilder();
        //get the part from 0 to pos
        String a1 = a.substring(0, pos);
        if (a1.length() > 0) {
            sb.append(a1);
        }
        //now append the parenthesis pair
        sb.append("()");
        String a2 = a.substring(pos);
        sb.append(a2);
        return sb.toString();
    }

    //recursively add parenthesis to a string, add left parenthesis and right parenthesis
    //recursively, till we have rightParenCount>=leftParentCount
    public static void generateParenRec(List<String> pars, int leftRem, int rightRem, char[] s, int count) {
        if (rightRem < leftRem) {//invalid state, we used more right than left
            return;
        }
        if (leftRem == 0 && rightRem == 0) {
            pars.add(new String(s));
        }
        if (leftRem > 0) {
            s[count] = '(';
            generateParenRec(pars, leftRem - 1, rightRem, s, count + 1);
        }
        if (rightRem > 0) {
            s[count] = ')';
            generateParenRec(pars, leftRem, rightRem - 1, s, count + 1);
        }

    }

    public static void main(String args[]) {
        int count = 3;
        List<String> parPairsList = getParenthesis(count);
        for (String parPair : parPairsList) {
            System.out.println(parPair);
        }
        //lets generate the pairs recursively
        char[] s = new char[count * 2];//we need to store count pairs in every valid parenthesis string
        int leftRem = count;
        int rightRem = count;
        List<String> listPars = new ArrayList<String>();
        generateParenRec(listPars, leftRem, rightRem, s, 0);
        System.out.println("************");
        for (String ss : listPars) {
            System.out.println(ss);
        }
    }

}
