/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.ctci;

/**
 * 
 * Write a method to replace all spaces in a string with'%20'. You may assume that
the string has sufficient space at the end of the string to hold the additional
characters, and that you are given the "true" length of the string. (Note: if implementing
in Java, please use a character array so that you can perform this operation
in place.)
EXAMPLE
Input: "Mr_John_Smith_ _ _ _"
Output: "Mr%20Dohn%20Smith"
* 
* Solution 1:
* 1)Create another char array with same length as of the input string
* 2)Iteratively copy the characters from beginning
* 2 a) if the characater is a space character then add %20 to the newly created array
* 
* Complexity: O(n); Space O(n) for the additional array
* 
* 
* Solution 2:
* As the given input array has enough space to hold the %20 chars instead of a single space char,
* we need to try to use the input array instead of an additional array. We need to shift the elements
* on right so that we create enough slot for the space chars
* 1)We assume that the space within the string is only considered, as the trailing spaces have no importance in this case
* 2)Create two pointers p1 and p2, where p1 points to the last non-space character of the string and p2 points to the last index
* of the string 
* 3)Repeat while p1<p2
* 3 a)If the s.charAt(p1) is not a space char, copy that char to p2, advance p1 and p2 (p1--, p2--)
* 3 b) If the s.charAt(p1) is a space char, we use the index p2-2, p2-1, and p2 to copy %,2, and 0 respectively,
* advance p1 (p1--) and p2 (p2-=3)
* 
* Complexity: O(n); Space: O(1)
* 
 *
 * @author rbaral
 */
public class ReplaeSpaceInString {
    public static String replaceSpace(String s){
        //handle base cases
        /**
         * 1)string is empty, null
         * 2)string has no space
         * 3)string has no enough slot to replace the space with %20
         */
        if(s==null || s.length()<1){
            return s;
        }else if(s.length()==s.trim().length()){//no empty slots at the end
            return s;
        }
        int spaceCount=0, extraSlotCount=0;
        //iterate the string char and keep track of the space and the extra slot
        char[] chars = s.toCharArray();
        //iterate from end to find the extraSlotcount
        for(int i=chars.length-1;i>=0;i--){
            if((int)chars[i]==32){//a space character from the end
                extraSlotCount++;
            }else{//we reached the character portion
                break;
            }
        }
        for(int i =0; i<(chars.length-extraSlotCount);i++){
            if((int)chars[i]==32){//a space character from the end
                spaceCount++;
            }
        }
        System.out.println("spacecoutn is:"+spaceCount+" extra slot is:"+extraSlotCount);
        //for every space there should be two additional slots
        if(extraSlotCount!=2*spaceCount){
            //not enough slot or invalid combination
            return s;
        }
        
        int p1 = chars.length - extraSlotCount-1;
        int p2 = chars.length - 1;
        String newString = "";
        //we iterate and replace the space with the %20 character
        while(p1<p2 && spaceCount>0){
             System.out.println("p1 is at:"+p1+" and p2 is at:"+p2);
            //check if p1 is a space character
            if((int)chars[p1]!=32){
                //just shift it to the right
                chars[p2] = chars[p1];
                //advance the indices
                p1--;
                p2--;
            }else{
                //this is a space character so replace by %20
                chars[p2-2] = '%';
                chars[p2-1] = '2';
                chars[p2] = '0';
                //advance the indices
                p1--;
                p2-=3;
                spaceCount--;
            }
            System.out.println("got the string:"+new String(chars));
        }
        
        return new String(chars);
    }
    
    public static void main(String args[]){
        String s = "Mr John Smith Boga      ";
        System.out.println("string is:"+s+" length is:"+s.length());
        
        s = replaceSpace(s);
        System.out.println("new string is:"+s);
    }
}
