/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.basics;

/**
 * A network consists of M cities and M-1 roads connecting them is given.
 * Cities are labeled with distinct integers wirhtin the range [0..M-1].
 * Roads connect cities in such a way that each pair of distinct cities is connected
 * either by a direct road or along a path consistiing of direct roads.
 * there is exactly one way to reach any city from any other city. In other words, cities
 * and direct roads form a tree.
 * the number of direct roads that must be traversed is called the distance between
 * these two cities.
 * 
 * 
 * One of the cities is the capital and the goal is to count the number fo cities
 * positioned away from it at each of the distances 1,2,...,M-1.
 * 
 * Write a function that given a non-empty zero indexted array T consistin of M integers
 * describing a network of M cities and M-1 roads, returns an array consisting of M-1 intgers,
 * specifiying the number of cities positioned at each distance 1,2,...,M-1
 * 
 * The array T descrives a network of cities as follows:
 * 1) if T[P] = Q and P=Q then P is the capital
 * 2) If T[P] = Q and P<>Q then there is a direct road between cities P and Q
 *
 * 
 * For ex:, in teh following array:
 * 
 * T[0] = 9    T[1] = 1    T[2] = 4
 T[3] = 9    T[4] = 0    T[5] = 4
 T[6] = 8    T[7] = 9    T[8] = 0
 T[9] = 1
 * 
 * the function should return [1,3,2,3,0,0,0,0,0]
 * 
 * Complexity: O(M), space: O(M)
 * 
 * @author rbaral
 */
import java.util.*;
public class CityConnectivity {
    
    public static int[] solution(int[] T) {
        //first we identify the capital city
        //and also keep track of the cities which can be directly reached from a city
        int capital = -1;
        Map<Integer,List<Integer>> con = new HashMap<Integer,List<Integer>>(); //store the connectivity between cities
        for(int i=0;i<T.length;i++){
            if(i==T[i]){
                capital = i;
            }
            //there is a single road path between these cities
            if(!con.containsKey(i)){
                con.put(i, new ArrayList<Integer>());
            }
            if(i!=T[i])
                con.get(i).add(T[i]);
            //we can also go other way round
            if(!con.containsKey(T[i])){
                con.put(T[i], new ArrayList<Integer>());
            }
            if(i!=T[i])
                con.get(T[i]).add(i);
            //System.out.println("adding pairs:"+T[i]+" and:"+i);
               
        }
        //for(Integer ii:con.keySet()){
        //    System.out.println("node "+ii+" has neighbors:"+Arrays.toString(con.get(ii).toArray()));
        //}
        //after initializing the one-road connectivity between the cities, we need to count the
        //number of cities at each distance
        int[] citCount = new int[T.length-1];
        // assume it starts from 0 but has the equivalence to 1 index array, i.e. we store citCount[0] as the no. of cities having 1 dist to capital
        HashSet<Integer> visitedCities = new HashSet<Integer>();
        List<Integer> lastCities = null;
        for(int i=0;i<T.length;i++){
            //last iteration cities
            if(i==0){
                lastCities = con.get(capital);
                citCount[i] = lastCities.size(); //the nodes directly connected to capital city
                visitedCities.addAll(con.get(capital));
                visitedCities.add(capital);
                System.out.println("the "+(i+1)+" neighbors of "+capital+"..are:"+Arrays.toString(con.get(capital).toArray()));
            }else{
                //get the neighbor of the last cities
                int neighborcount = 0;
                List<Integer> newCities = new ArrayList<Integer>();
                for(Integer ii:lastCities){
                    List<Integer> n = con.get(ii);
                    for(Integer nn:n){
                        if(!visitedCities.contains(nn)){
                            neighborcount++;
                            newCities.add(nn);
                        }
                    }
                }
                visitedCities.addAll(lastCities);
                citCount[i] = neighborcount;
                System.out.println("the "+(i+1)+" neighbors of "+capital+"..are:"+Arrays.toString(newCities.toArray()));
                lastCities.clear();
                lastCities.addAll(newCities);
                //lastCities.removeAll(visitedCities);
            }
            
        }
        
        
        return citCount;
    }
    
    public static void main(String args[]){
        int[] T = {9,1,4,9,0,4,8,9,0,1};
        System.out.println("distance is:"+Arrays.toString(solution(T)));
    }
}
