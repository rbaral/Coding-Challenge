package com.alg.leetup;

import com.sun.org.apache.xml.internal.utils.Trie;
import java.io.BufferedReader;
import java.io.FileReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Executor;

public class Test {

    
        public static void main(String[] args) {
            FileReader file = new FileReader("C:\\test\\a.txt");
            BufferedReader fileInput = new BufferedReader(file);

            // Print first 3 lines of file "C:\test\a.txt"
            for (int counter = 0; counter < 3; counter++) 
                System.out.println(fileInput.readLine());

            fileInput.close();
            
                
               
                
	}
        
        /**
         * ref: http://math.stackexchange.com/questions/437553/algorithm-to-find-greatest-significant-digit-of-long-integer
         * @param num
         * @return 
         */
        public static int findMSDigit(int num){
            //first find how many digits are there
            int digitsCount = (int)Math.log10(num)+1;
            //then divide by 10^(d-1) to get the most significant digit
            return num/((int)Math.pow(10, (digitsCount-1)));
        }
	
	public static int[] cloneArray(int[] nums,int index){
		int[] temp= new int[nums.length-1];
		//if it is the first element
		if(index ==0)
			System.arraycopy(nums, 1, temp, 0, temp.length);
		else if(index==nums.length-1)
			System.arraycopy(nums, 0, temp, 0, temp.length);
		else{//the index is somewhere in the middle
			System.arraycopy( nums, 0, temp, 0, index ) ;
			System.arraycopy( nums, index+1, temp, index, (nums.length -(index+1)) ) ;
		}
		return temp;
	}

}
