/**
 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
 *
 * Given two integers x and y, calculate the Hamming distance.
 *
 * Note:
 * 0 ≤ x, y < 231.
 *
 * Example:
 *
 * Input: x = 1, y = 4
 *
 * Output: 2
 *
 * Explanation:
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 * ↑   ↑
 *
 * The above arrows point to positions where the corresponding bits are different.
 */
package com.alg.leetcode;

/**
 *
 * @author rbaral
 *
 * Solution 1: 1) Find the binary strings of the two digits 2) Iterate over the
 * longer string and check from the last position if the two strings have
 * matching values, if not increment the distance by 1 3) If the shorter string
 * is exhausted, for the rest of the longer string, if the position has value of
 * 1, increment distance by 1
 *
 * Complexity: O(n/2) to find the binary value of digits O(n/2) to compare the
 * values of the two binary strings Total complexity is: O(n), where n is the
 * input number
 *
 *
 * Solution 2:
 *
 *
 */
public class HammingDistance {

    public static String digitToBase(int num, int base) {
        String bin = "";
        if (num <= 0 || base <= 0) {
            return "0";
        }
        while (num > 0) {
            bin = num % base + bin;
            num = num / base;
        }
        return bin;
    }
    
    public static int hammingDistance2(int a, int b){
        int val = a ^ b;
        int dist = 0;
        while(val != 0) {
            System.out.println("val is:"+val);
            val = val & (val-1);
            dist++;
        }
        return dist;
    }
     public static int hammingDistance(int x, int y) {
        String bin1 = digitToBase(x, 2);
        String bin2 = digitToBase(y, 2);
        int dist = 0;
        int lenDiff = 0;
        //append the zeros in front of the shorter binary
        if (bin1.length()> bin2.length()){
            lenDiff = bin1.length() - bin2.length();
            for(int i=0;i<lenDiff; i++){
                bin2 = "0"+bin2;
            }
            
        }else if(bin2.length()> bin1.length()){
            lenDiff = bin2.length() - bin1.length();
            for(int i=0;i<lenDiff; i++){
                bin1 = "0"+bin1;
            }
        }
        //now check if the value at every position matches
        for(int i=0;i<bin1.length();i++){
            if(bin1.charAt(i)!= bin2.charAt(i)){
                dist++;
            }
        }
        return dist;
    }

     public static void main(String args[]){
         int num1 = 4,  num2 = 1;
         int dist = hammingDistance(num1, num2);
         System.out.println("distance is:"+dist +" another method:"+hammingDistance2(num1, num2));
     }
}
