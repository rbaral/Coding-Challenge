/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.basics;

/**
 *
 * Given a number in string in base b1, convert it to a base b2 number
 * 
 * Solution 1:
 * 1)Apply b1 to get the decimal form of the given number
 * 2)Apply b2 to get the desired answer
 * 
 * In this, we just repeatedly use the division and modulus operators
 * 
 * Complexity: O(n + n*log_b2(b1)), where n is the length of the givenn number in string
 * 
 * @author rbaral
 */
public class BaseConversion {
    
    /**
     * converts a given string number from one base to another
     * 
     * TODO:
     * check if the given string number is valid with the base b1 (e.g., base 2 should have 0s and 1s, base 3 should have 0, 1, 2 and so on)
     * 
     * 
     * @param s
     * @param b1
     * @param b2
     * @return 
     */
    public static String baseConversion(String s, int b1, int b2){
        int x = 0;
        //first apply the base b1 to get the decimal form
        //check if the number is negative
        boolean isNegative = s.charAt(0)=='-';
        int baseIndex = 0;
        for(int i=s.length()-1;i>=0;i--){
            if(isNegative && i==0){
                continue;
            }else{
                //the char can be digit or alphabet (for A to F)
                int asciDiff = s.charAt(i) - 0;
                if(asciDiff>=48 && asciDiff<58){//is a digit
                    x+=(s.charAt(i)-'0')*Math.pow(b1, baseIndex);
                }else if(asciDiff>=65 && asciDiff<=70){// A to F
                    x+=(s.charAt(i)-'A'+10)*Math.pow(b1, baseIndex);
                }else{
                    //invalid character in the string
                }
                baseIndex++;
            }
        }
        System.out.println("Decimal equivalent of "+ s+" base "+b1+" is:"+ x);
        String conv = decimalToBase(x, b2);
        return isNegative?"-"+conv:conv;
    }
    
    /**
     * checks if the parameter lies in range 11 to 15 and replaces
     * accordingly with A to F, else return the value of input
     * @param a
     * @return 
     */
    public static String getAlphanumeric(String a){
        String val = a;
        switch(a){
            case "10":
                val = "A";
                break;
            case "11":
                val = "B";
                break;
            case "12":
                val = "C";
                break;
            case "13":
                val ="D";
                break;
            case "14":
                val = "E";
                break;
            case "15":
                val = "F";
                break;
            default:
                System.out.println(a+" didn't match hex char");
                val = a;
                break;
        }
        return val;
    }
    /**
     * converts a given number from 10 base to a given base value
     * @param x
     * @param b
     * @return 
     */
    public static String decimalToBase(int x, int b){
        String num = "";
        int numIndex = 0;
        while(x>0){
            int rem = x%b;
            x = x/b;
            num=getAlphanumeric(""+rem)+num;
            numIndex++;
        }
        return num;
    }
    
    
    
    public static void main(String args[]){
        String s ="23";
        int b1 = 4;
        int b2 = 3;
        System.out.println("number "+s+" is in base:"+b1);
        System.out.println("conversion to base "+b2+" gives:"+baseConversion(s, b1, b2));
    }
    
}
