package com.alg.ctci;

/**
 * the class with the comparator method
 */
class CompareHexToBinary {

    boolean compare(String hex, int hexBase, String bin, int binBase) {
        //check if the base is valid
        //check if base is not less than 0, greater than 10 and 16
        //lets get the digit of hex
        int hexToDigit = convertToDigit(hex, hexBase);
        //System.out.println("Digit of hex "+hex+" is:"+hexToDigit);
        //get the digit of binary
        int binToDigit = convertToDigit(bin, binBase);
        //System.out.println("Digit of bin "+bin+" is:"+binToDigit);
        //after getting the digits of the binary and hex format, we can simply compare them for equality
        return (hexToDigit == binToDigit);
    }

    /**
     * converts a given string value to digit using its base
     */
    int convertToDigit(String val, int base) {
        int totalNums = val.length();
        //get the digit format of every character present in the val and add them to get the complete value of the string
        double exp = 0;
        for (int i = totalNums - 1; i >= 0; i--) {
            int num = charToDigit(val.charAt(totalNums - i - 1), base);
            //the position of the num will drive its value
            double value = num * Math.pow(base, i);
            //System.out.println("char "+val.charAt(totalNums-i-1)+" has digit "+num+" and val is:"+value);
            exp += value;
        }
        return (int) exp;
    }

    //converts the char to a digit using the base
    int charToDigit(char a, int base) {
        //if the char is between 0 and 9
        if (a >= '0' && a <= '9') {
            return a - '0';
        } else if (Character.toUpperCase(a) >= 'A' && Character.toUpperCase(a) <= 'F') {//between 10 and 15
            return 10 + a - 'A';
        } else {//invalid character
            return -1;
        }
    }

}

//the main class
public class HexToBinary {

    //the main method
    public static void main(String args[]) {
        CompareHexToBinary hexToB = new CompareHexToBinary();
        String hexVal = "B";
        int hexBase = 16;
        String binVal = "1011";
        int binBase = 2;
        boolean equal = hexToB.compare(hexVal, hexBase, binVal, binBase);
        System.out.println("Equality of hex " + hexVal + " and binary " + binVal + " is " + equal);
    }
}
