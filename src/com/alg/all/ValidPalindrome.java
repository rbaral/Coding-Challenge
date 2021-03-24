/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.leetup;

/**
 *
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.

Note:
Have you consider that the string might be empty? This is a good question to ask during an interview.

For the purpose of this problem, we define empty string as valid palindrome.
* 
* 
* Solution 1:
* 1)we create two pointers p1 and p2, p1 points to the start of string and p2 to the end of the string
* 2) we repeat till p1 and p2 intersect
* 3)if the char at p1 is equal to char at p2, we continue, else return false
* 4) if all the chars have been tried and p1 intersects p2, return true
* 
* Complexity: O(logn)
* 
 * 
 * @author rbaral
 */
public class ValidPalindrome {
    public static boolean isPalindrome(String s) {
        if(s.length()<=1){
            return true;
        }else{
            //check if there is some other character (for instance comma periods semicolons)
            StringBuilder sb = new StringBuilder();
            int index = 0;
            int charAsci;
            while(index<s.length()){
                //97-122 ; 65-90; 48-57 - alphanumeric range
                charAsci = (int)s.charAt(index);
                if( (97<= charAsci && charAsci<=122)|| (65<=charAsci && charAsci<=90) || (48<=charAsci && charAsci<=57)){
                    System.out.println("char "+s.charAt(index)+" has asci of:"+charAsci);
                    sb.append(s.charAt(index));
                }
                index++;
            }
            
            int p1 = 0;
            int p2 = sb.length()-1;
            int charAsci1, charAsci2;
            boolean equal;
            while(p1<p2){
                charAsci1 = (int)sb.charAt(p1);
                charAsci2 = (int)sb.charAt(p2);
                //compare both of these only if they are of same type (alphabet or number)
                if((48<=charAsci1 && charAsci1<=57) &&(48<=charAsci2 && charAsci2<=57)){//both numbers
                    equal= charAsci1==charAsci2;
                }else if((97<=charAsci1 && charAsci1<=122) &&(97<=charAsci2 && charAsci2<=122)){//both lower case characters
                    equal= charAsci1==charAsci2;
                }else if((65<=charAsci1 && charAsci1<=90) &&(65<=charAsci2 && charAsci2<=90)){//both upper case
                    equal= charAsci1==charAsci2;
                }else if(((65<=charAsci1 && charAsci1<=90) &&(97<=charAsci2 && charAsci2<=122))||((97<=charAsci1 && charAsci1<=122) &&(65<=charAsci2 && charAsci2<=90))){ //one upper and one lower
                    equal= ((charAsci1-'a') ==(charAsci2 -'A')) || ((charAsci1-'A') ==(charAsci2 -'a'));
                }else
                    equal = false;
                
                System.out.println("comparing "+sb.charAt(p1)+" and "+sb.charAt(p2)+"..returning:"+equal);
                if(equal){
                    p1++;
                    p2--;
                }else{
                    return false;
                }
            }
        }
        return true;
    }
    
    public static void main(String args[]){
        String s= "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s));
        System.out.println(isPalindrome("0P"));
    }
}
