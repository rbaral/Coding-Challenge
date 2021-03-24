/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.ccup;

/**
 *
 * @author rbaral
 * 
 * Given a string, complete the given function to recursively remove the adjacent duplicate characters and return the resultant string. 
 * If there are no characters left in the resultant string, return "-1" (without quotes). 
Sample Test Cases 
Sample Input: ABCCBCBA 
Output: ACBA 

Explanation: (ABCCBCBA --> ABBCBA --> ACBA) 
* 
Sample Input: AA 
Sample Output: -1 
* 
* Solution 1:
* 1)Use two pointers p1 pointing to first char and p2 to the second char
* 2)Repeat the following till p2 reaches the end or the length of string is zero
* 2 a)if char[p1]==char[p2], update the string by removing these chars, re-assign p1 to 0 and p2 to 1
* 2 b) if (a) is false advance p1 and p2
* 
* 
* Complexity: O(n)
 * 
 */
public class AdjacentCharacterRemover {
    
    public static String checkAdjacent(String a){
        //handle base cases
        char[] redChars = a.toCharArray();
        int p1 = 0, p2 =1;
        while(p2<a.length()){
            if(a.charAt(p1)==a.charAt(p2)){//a match
                redChars[p1] = '#';//replace the chars with something different than the input chars
                redChars[p2] = '#';
                //p1--; p2++;
                p1= p2; p2++;
            }else{
                p1 = p2; 
                p2++;
            }
        }
        StringBuffer sb = new StringBuffer();
        for(char c:redChars){
            if(c!='#')//if the char is the left over of the input
                sb.append(c);
        }
        return sb.toString().equals("")?"-1":sb.toString();
    }
    
    public static void main(String args[]){
        String a = "ABCCBCBA";
        System.out.println(a+"-->"+checkAdjacent(a));
        a = "AA";
        System.out.println(a+"-->"+checkAdjacent(a));
    }
}
