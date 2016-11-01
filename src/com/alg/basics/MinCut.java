package com.alg.basics;
import java.io.*;
import java.util.*;

/**
 * KargerMinCut.java
 * <p>
 * Randomized contraction algorithm for the minimize cut problem.
 */

// class for node in graph
class Node {
        public int id;
        public LinkedList<Integer> nodeEdge;
}

// AdjacencyLists for graph
class AdjacencyLists {
        public int len = 200; // number of node
        public Hashtable<Integer, Node> nodeHash = new Hashtable(); 
        // add vertex(node),id from 1
        public void addVertex(int id) {
                Node node = new Node();
                node.id = id; // from index of 0
                node.nodeEdge = new LinkedList();
                nodeHash.put(id, node);
        }

        public void addAdjvex(int start, int end) {
                nodeHash.get(start).nodeEdge.addLast(end);
        }

        public int getAdjvex(int node, int index) {
                return nodeHash.get(node).nodeEdge.get(index);
        }

        public void contractVertex(int nodeA, int nodeB) {
                deleteEdge(nodeA, nodeB); // delete the edge nodeB in nodeA
                findEnd(nodeA, nodeB); // change nodeB to a in node change
                addList(nodeA, nodeB); // add nodeB in the last of nodeA
                nodeHash.remove(nodeB);// remove nodeB
        }

        // delete edge,number of edge need be changed is >=1, even >2...
        public void deleteEdge(int nodeA, int nodeB) {
                while (nodeHash.get(nodeA).nodeEdge.contains(nodeB)) {
                        int index = nodeHash.get(nodeA).nodeEdge.indexOf(nodeB);
                        nodeHash.get(nodeA).nodeEdge.remove(index);
//                        print(nodeA);
                }
                while (nodeHash.get(nodeB).nodeEdge.contains(nodeA)) {
                        int index = nodeHash.get(nodeB).nodeEdge.indexOf(nodeA);
                        nodeHash.get(nodeB).nodeEdge.remove(index);
//                        print(nodeB);
                }
        }

        public void findEnd(int nodeA, int nodeB) {
                boolean record[] = new boolean[len];// check the node which has been changed yet
                for (int index = 0; index < nodeHash.get(nodeB).nodeEdge.size(); index++) {
                        int change = nodeHash.get(nodeB).nodeEdge.get(index);
                        if (record[change-1] == false) {
                                changeToEnd(nodeA, nodeB, change);
                                record[change-1] = true;
                        }
                }
        }

        public void changeToEnd(int nodeA, int nodeB, int change) {
                for (int index = 0; index < nodeHash.get(change).nodeEdge.size(); index++) {
                        if (nodeHash.get(change).nodeEdge.get(index) == nodeB) {
                                nodeHash.get(change).nodeEdge.set(index, nodeA);
                        }
                }
        }

        public void addList(int nodeA, int nodeB) {
                while (!nodeHash.get(nodeB).nodeEdge.isEmpty()) {
                        nodeHash.get(nodeA).nodeEdge.addLast(nodeHash.get(nodeB).nodeEdge
                                        .pop());
                }
//                print(nodeA);
        }

        // computer the edge number of nodeHash.get(0)
        public int computerEdge(int node) {
                int n = nodeHash.get(node).nodeEdge.size();
                return n;
        }

        // print edges of nodeA, for test
        public void print(int nodeA) {
                if (!nodeHash.get(nodeA).nodeEdge.isEmpty()) {
                        System.out.print("[" + nodeA + "]:");
                        for (int index = 0; index < nodeHash.get(nodeA).nodeEdge.size(); index++) {
                                System.out.print(nodeHash.get(nodeA).nodeEdge.get(index) + "-");
                        }
                        System.out.println();
                }
        }
}

// Randomized contraction algorithm for the minimize cut problem
public class MinCut {
        private AdjacencyLists graph = new AdjacencyLists();
        private int nodeLen = graph.len;
        private int cutNum;
        private int nodeA, nodeB;
        private int min = nodeLen - 1;
        private ArrayList<Integer> arraySet = new ArrayList();
        private int count = 0;

        public MinCut() {
                for (count = 0; count < 10; count++) {
                        input();
                        contract();
                }
                System.out.println(min);
        }

        // input the graph file
        public void input() {
                cutNum = nodeLen - 1;
                graph = new AdjacencyLists();
                arraySet = new ArrayList();
                try {
                        String file = "C:\\Users\\rbaral\\PycharmProjects\\AlgPractice\\coursera\\data\\kargerMinCut.txt";
                        FileReader in = new FileReader(file);
                        BufferedReader br = new BufferedReader(in);
                        String s;
                        int x;
                        while ((s = br.readLine()) != null) {
                                Scanner sca = new Scanner(s);
                                x = sca.nextInt();
                                graph.addVertex(x);
                                // System.out.print(x); //test
                                while (sca.hasNext()) {
                                        int y = sca.nextInt();
                                        graph.addAdjvex(x, y);
                                }
                        }
                } catch (Exception e) {
                        e.printStackTrace();
                }
                initSet();
        }

        // initialize the arraySet for the random set
        public void initSet() {
                for (int j = 0; j < nodeLen; j++) {
                        arraySet.add(j, j+1);
                        // System.out.println(arraySet.get(j)); //test
                }
        }

        // contract two random node until there are only two node left
        public void contract() {
                int num;
                while (arraySet.size() > 2) {
                        // System.out.println(arraySet.size()); //test
                        randEdge();
                        graph.contractVertex(nodeA, nodeB);
                        // System.out.println(graph.getLen()); //test
                        tempNum(nodeA);
                }
                // when the contract is end, print the current and in all minNum
                if (arraySet.size() == 2) {
                        if (cutNum < min) {
                                min = cutNum;
                        }
                        // if(graph.UFO < min){
                        // min = graph.UFO;
                        // } //test
                        System.out.println("///" + cutNum + " - " + min + "///" + count); // test
                }
        }

        // computer the edge number of node chosen
        public void tempNum(int a) {
                int num = graph.computerEdge(a); // computer edge of a after contract
                if (num < cutNum) {
                        cutNum = num;
                }
                // graph.print(a); //test
                // System.out.println("///////"+num + "///////"); //test
        }

        // randomize a edge
        public void randEdge() {
                Random rand = new Random();
                int indexOfNodeA;
                int indexOfNodeB;
                indexOfNodeA = rand.nextInt(arraySet.size());// from 0 to getLen()-1
                nodeA = arraySet.get(indexOfNodeA); // from 1 to size
                int randomSeed = graph.nodeHash.get(nodeA).nodeEdge.size();//nodeEdge index start from 0
                indexOfNodeB = rand.nextInt(randomSeed); // from 0 to
                                                                                                        // nodeA.nodeEdge.size()
                nodeB = graph.getAdjvex(nodeA, indexOfNodeB);        
                arraySet.remove(arraySet.indexOf(nodeB));
//                System.out.println(nodeA + "+++" + nodeB); // test
        }

        public static void main(String[] args) {
                MinCut test = new MinCut(); // test
        }
}