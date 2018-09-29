/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.leetup.todo.sol;

/**
 *
 * Find the nth digit of the infinite integer sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...

Note:
n is positive and will fit within the range of a 32-bit signed integer (n < 231).

Example 1:

Input:
3

Output:
3
Example 2:

Input:
11

Output:
0

Explanation:
The 11th digit of the sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... is a 0, which is part of the number 10.
* 
* 
* Solution 1:
* 1 - 9  : 9
10 - 99 : 90 * 2
100 - 999 : 900 * 3
1000 - 9999 : 9000 * 4
... ... 
* Based on the number of digiits in n and above illustration:
* 
* 1) If we have a number n>9, we first subtract the 9 from it, the new value of this number will be the difference
* 2) Then we subtract 180 from it if it is greater than 180
* 3) Then we subtract 2700 from it and so on if it is greater than 2700
* 4)Repeat this process till the number is greater than the next window we use for subtraction
* 5)
* 
* 
* For example, for n=1000, we do the followings:
* 1)subtract 9
* 2)subtract 180
* As n=1000 is a 3 digit, we stop subtracting here
* which gives the remainder as 1000-9-180 = 811.
* The digit is (811-1)/3 + 370
* 
* 
 * 
 * @author rbaral
 */
public class NthDigitOfInfiniteSequence {
    public static int findNthDigit(int num){
        long n=num; // convert int to long 
        long digit=1,  len=1,  windowBy9=9;

        while(n>len*windowBy9){
            n=n-len*windowBy9;
            len++;
            windowBy9=windowBy9*10;
            digit=digit*10;
        }

        // identify the number
        digit = digit + (n-1)/len;
        System.out.println("digit is:"+digit+" len is:"+len+" n is:"+n);
        // identify the digit
        return String.valueOf(digit).charAt((int)((n-1)%len))-'0';
    }
    
    public static void main(String args[]){
        System.out.println(findNthDigit(1000));
    }
}
