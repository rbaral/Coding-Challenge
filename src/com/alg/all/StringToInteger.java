/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.leetup.todo.sol;

/**
 * 
 * Implement atoi to convert a string to an integer.

Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.

Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.

Update (2015-02-10):
The signature of the C++ function had been updated. If you still see your function signature accepts a const char * argument, please click the reload button  to reset your code definition.

spoilers alert... click to show requirements for atoi.

Requirements for atoi:
The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.

The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.

If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.

If no valid conversion could be performed, a zero value is returned. If the correct value is out of the range of representable values, INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.
* 
* Solution 1:
* 1)Scan from the left by avoiding the whitespace chars
* 2)If the first found char is a sign char (+ or -) store it for later use
* 3)If the next character is not numeric, return 0 as this is an invalid parameter
* 4)If the next character is a numeric, advance to next element
* 5) the number of contiguous integers is the one to be converted to integer
* 6)we store the index of the beginning and ending of the valid numeric string portion
* 7) For every index starting from start and ending at end, do the following:
* a) char to number * Math.pow(10, end -index) and add to the sum
* b)repeat for every character
* 8)return the sum
 *
 * @author rbaral
 */
public class StringToInteger {
    
}
