/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.realtest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author rbaral
 */
public class NameAbbreviation_LytmusTest {
    public static String answer(String name){
        String [] tokens = name.split(" ");
        StringBuilder abname = new StringBuilder();
        for(int i=0;i<tokens.length; i++){
            if (i==0 || i==(tokens.length-1)){
                abname.append(tokens[i]+" ");
            }else{
                abname.append(tokens[i].charAt(0)+"."+" ");
            }
        }
        return abname.toString().trim();
    }
    
    public static int[] listToArr(){
        List<Integer> l = new ArrayList<Integer>();
        l.add(1);
        l.add(1);
        l.add(10);
        List<String> ls = new ArrayList<String>();
        ls.add("abc");
        ls.add("cd");
        //System.out.println(Collections.frequency(l, 100));
        //System.out.println(Collections.frequency(l, 1));
        if(ls.contains("cd")){
            System.out.println("contains cd");
        }
        int i=0;
        int[] a =new int[l.size()];
        for (Integer e : l)  
            a[i++] = e;
        return a;
    }
    
    public static void main(String args[]){
        //String name = "Anna Maria Simpson";//"Ramesh Raj Baral";
        //System.out.println(answer(name));
        //String aa ="GET /administrator/site HTTP";
        //if(aa.contains("/administrator")){
        //    System.out.println("admin page");
        //}
//        System.out.println((int)Double.parseDouble("1484860827.783"));
//        int[] arr = listToArr();
//        System.out.println(arr.length);
//        for(Integer a:arr){
//            System.out.println(a);
//        }
        String a =1+""+2;
        System.out.println("..."+a+"...");
                
    }
}
