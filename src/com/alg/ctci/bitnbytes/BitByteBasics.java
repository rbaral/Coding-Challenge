/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alg.ctci.bitnbytes;

/**
 *
 * @author rbaral
 */
public class BitByteBasics {
    /**
     * checks if the MSB is set or not,
     * when MSB is set in 32 bit representation, it is a negative number
     * else it is a positive number
     * @param n 
     */
    public static void testMSB(int n){
        String bin = Integer.toBinaryString(n);
        System.out.println("bin is:"+bin);
    }
    
    /**
     * check if MSB of a byte is set,
     * we repeatedly mask it with 1 and shift the mask,
     * or if we know the number is of 1 byte then use the mask
     * that has one in just MSB
     * @param n 
     */
    public static void testMSBInByte(int num){
        int mask = (int)Math.pow(2,7); //the MSB of a byte is only set
        boolean isMSBset = (num&mask) == mask;
        System.out.println("bit set:"+isMSBset);
    }
    
    /**
     * function to count bits in an integer
     * @param x
     * @return 
     */
    public static int countBits1(int x){
        String n = Integer.toBinaryString(x); //just get the binary of an int
        int mask = 1;
        int bitCount = 0;
        for(int i=0; i<n.length(); i++){
            bitCount+= mask&n.charAt(i);
        }
        System.out.println("bit count of "+x+" is:"+bitCount);
        return bitCount;
    }
    /**
     * function to count the number of bits set to 1
     * @param x
     * @return 
     */
    public static int countBits2(int x){
        int mask = 1;
        int count = 0;
        while(x>0){
            count+= mask&x;
            //now shift x to the right to check another bit
            x>>=1;
        }
        return count;
    }
    
    /**
     * converts a given int to a binary string
     * @param x
     * @return 
     */
    public static String intToBinary(int x){
        String binString = "";
        if(x==0){
            return "0";
        }
        int num = x;
        while(num>0){
            binString = num%2 + binString;
            num/=2;
        }
        System.out.println("binString for "+x+" is "+binString);
        return binString;
    }
    
    /**
     * get the binary representation of a negative number
     * @param x 
     */
    public static String getBinOfNegative(int x){
        //getting -5 in binary
        int dec = (((int)Math.pow(2,8)-1)^(-x))+1; //flip using XOR with max value of 2^8 and then add 1 to get two's complement
        String binary = intToBinary(dec);
        System.out.println(x+" has dec as:"+dec+" and binary as: "+binary);
        return binary;
    }
    
    /**
     * Describe a function that takes an int value, and returns true if the bit pattern of that int value 
     * is the same if you reverse it (i.e. it's a palindrome); i.e. boolean isPalindrome(int x)
     * @param x
     * @return 
     */
    public static boolean testBinaryPalindrome(int x){
        boolean isPalindrome = true;
        //we declare two pointers that point to the first and end of the binary string and check if the bits at that position are same
        //we repeat till two pointers meet
        String binary = intToBinary(x);
        int p1 = 0, p2 = binary.length()-1;
        while(p1<p2){
            if(binary.charAt(p1)!=binary.charAt(p2))
                return false;
            p1++;
            p2--;
        }
        return isPalindrome;
    }
    
    /**
     * get the value of the ith bit in the given number
     * @param num
     * @param i
     * @return 
     */
    boolean getBit(int num, int i){
        //shift the 1 i times left and and with num
        int mask = (1<<i);
        return ((num&mask)!=0);
    }
    
    /**
     * set the ith bit of num to 1
     * @param num
     * @param i
     * @return 
     */
    int setBit(int num, int i){
        int mask = 1<<i;
        num = num|mask;
        return num;
    }
    
    //clear the ith bit of num
    int clearBit(int num, int i){
        int mask = ~(1<<i); //shift i times and negate so that the ith bit is zero
        num = num&mask;
        return num;
    }
    
    //clear the bits from MSB to ith bit
    int clearBitsMSBthroughI(int num, int i){
        int mask = (1<<i)-1;
        num = num&mask;
        return num;
    }
    
    //clear the 0th to ith bit inclusive
    int clearBitsIthrouh0(int num, int i){
        int mask = ~((1<<(i+1)) -1);
        return (num&mask);
    }
    
    //update the ith bit with the vth bit
    int updateBit(int num, int i, int v){
        int mask = ~(1<<i);
        num = num&mask; //ith bit is reset
        //now use the vth bit to set the value
        num|=(v<<i);
        return num;
    }
    
    static void swap(int a, int b){
        System.out.println("before first is:"+a+" second is:"+b);
        a = a^b;
        b = a^b;
        a = a^b;
        System.out.println("after first is:"+a+" second is:"+b);
    }
    
    /**
     * check if a number has odd or even parity:
     * just check if we have an even or odd number of 1s
     * rather than counting them, we can do this with an exclusive
     * OR opertion.
     * returns 0 for even parity and 1 for odd parity
     * 
     * Complexity: O(n) where n  is the size of the number (the bits)
     * 
     * @param x
     * @return 
     */
    public static short parity1(long x){
        short result = 0;
        while(x>0){
            result^=x&1;
            x>>=1;
        }
        return result;
    }
    
    /**
     * finds if a number is odd or even parity by removing the rightmost
     * bit.
     * The complexity is O(k), where k is teh number of bits set to 1
     * 
     * @param x
     * @return 
     */
    public static short parity2(long x){
        short result = 0;
        while(x>0){
            result^=1;
            x&=x-1;
        }
        return result;
    }
    
    public static void main(String args[]){
        //testMSB(2);
        //testMSBInByte(128);
        //System.out.println(countBits1(12)+"..."+countBits2(12));
        //System.out.println(intToBinary(0)+" "+Integer.toBinaryString(-1));
        //System.out.println("binary of negative 5 is:"+getBinOfNegative(-5));
        //int num = 27;
        //System.out.println("testing binary palindrome for:"+testBinaryPalindrome(num));
        //swap(5,10);
        //System.out.println(String.valueOf(-16>>4)+"..."+String.valueOf(1<<10)); //-16 shift right by 4; 1 shifted left by 10 (2^10)
        //System.out.println(2^2); //an exclusive or
        //System.out.println('1'- '0'); // '1' - 0 will be in ascii; '1' -'0' will be in decimal
        System.out.println(parity1(11)+"..."+parity2(11));
     }
}
