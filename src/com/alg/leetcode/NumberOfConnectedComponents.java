/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.leetup;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author rbara012
 * 
 * Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), write a function to find the number of connected components in an undirected graph.
Example 1:
     0          3
     |          |
     1 --- 2    4
Given n = 5 and edges = [[0, 1], [1, 2], [3, 4]], return 2.
Example 2:
     0           4
     |           |
     1 --- 2 --- 3
Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [3, 4]], return 1.
Note:
You can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.
* 
* Solution 1:
* 1)Used DFS and keep track of the visited nodes
* 2 a) If no more unvisited nodes can be found and the set of input nodes is exhausted, return the number of connected components so far
* 2 b) If there are more nodes left in set of input nodes, start DFS from one of them and mark the visited nodes
* 
* Complexity: O(n)
* 
* Solution 2:
* 1)Union of the nodes that are in an edge
* 
* 
* Complexity: O(klog(n)) where k is the
 * 
 */
public class NumberOfConnectedComponents {
    int[] tempParent;
    public int findComponents(int n, int[][] edges){
        Set<Integer> parents = new HashSet<Integer>();
        tempParent = new int[n];//assume all nodes have different parent
        for(int i=0;i<n; i++){
            tempParent[i] = i;
        }
        for(int i=0;i<edges.length;i++){
            //the nodes connected to an edge are in same component so we unite them
            union(edges[i][0], edges[i][1]);
        }
        
        for(int i = 0;i<n; i++){
            parents.add(findParent(i));
        }
        return parents.size();
    }
    
    int findParent(int node){
        if(tempParent[node]==node){
            return node;
        }else{
            tempParent[node] = findParent(tempParent[node]);
            return tempParent[node];
        }
    }
    
    void union(int v1, int v2){
        tempParent[findParent(v1)] = findParent(v2);
    }
}
