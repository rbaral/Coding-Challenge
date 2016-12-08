/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.ccup;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *Given a long string s and short substrings t1, t2, t3 (which have
 * different length), find the shortest substring of s which contains
 * t1, t2, and t3.
 * 
 * Solution:
 * Find the list of occurrences of all the substrings
 * pos[1]->[] //array to hold starting position of string t1
 * pos[2]
 * pos[3]
 * 
 * This can be found by scanning all the characters of string s or by using the Pattern matching technique - O(n)
 * Now, we can use the sliding window technique
 * 1)After we found the one occurence of all the substrings (t1,t2,t3), we compute and store the window length
 * 2)Repeat and update the window if shorter one is found
 * 
 * 
 * 
 * Ref: https://careercup.com/page?pid=google-interview-questions&job=software-engineer-intern-interview-questions&topic=algorithm-interview-questions
 * @author rbaral
 */
public class ShortestSubstrings {
   
    
    /**
     * find the indices where the target string t starts
     * in the source string text
     * @param text
     * @param t
     * @return 
     */
    static int[] getSubIndex(String text, String t){
        int[] pos = new int[text.length()]; //we assume that in worst case the string t is a character and the string text is just composed of this character
        int k;
        for(int i=0;i<text.length();i++){
            k = text.indexOf(t, i); //index of t starting from i
            if(k==-1){
                //no occurence of t in text when counted from index i
                break;
            }
            pos[k] = 1;
            i = k+1; //advance the index to look for next possible occurence of t
        }
        return pos;
    }
    
    static List<String> findShortestString(String text, String t1, String t2, String t3){
        List<String> ans = new LinkedList<String>();
        
        int[] index1 = getSubIndex(text, t1);
        int[] index2 = getSubIndex(text, t2);
        int[] index3 = getSubIndex(text, t3);
        
        int matched[] = {-1, -1, -1};
        int sLen = text.length(); //for now, we assume that the whole string acts as a matching window
        int start = 0;
        
        for(int i=0; i<text.length(); i++){
            //check if till this index has match for the substrings
            if(index1[i]==1){
                matched[0] = i;
            }
            if(index2[i]==1){
                matched[1] = i;
            }
            if(index3[i]==1){
                matched[2] = i;
            }
            
            
            //the moment when we have found all the matching index of t1, t2, and t3
            if(matched[0]>-1 && matched[1]>-1 && matched[2]>-1){
                //find the max index among the three indices
                int maxEnd = Math.max(Math.max(matched[0] +t1.length() -1, matched[1] +t2.length()-1), matched[2]+t3.length()-1);
                //find the min index among the three indices
                int minStart = Math.min(Math.min(matched[0], matched[1]),matched[2]);
                
                int currLen = maxEnd - minStart +1;
                if(currLen <= sLen){
                    sLen = currLen;
                    start = minStart;
                }
                //if we already have some entry in the result and this one is shorter than that, update it
                if(ans.size()>0 && (sLen-start)< ans.get(0).length()){
                    ans.clear();
                    ans.add(text.substring(start, start + sLen));
                }else
                    ans.add(text.substring(start, start + sLen));
            }
        }
        return ans;
    }
    
    public static void main(String args[]){
        String s = "00as0de00000as00bp1000de000bp000as000de120bp";
        String [] t = { "bp1", "de", "as" };
        System.out.println(findShortestString(s, t[0], t[1], t[2]));
    }
}
