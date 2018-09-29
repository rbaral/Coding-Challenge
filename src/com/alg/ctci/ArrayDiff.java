import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    static int pairs(int[] a,int k) {
      /* Complete this function */
        //sort the array first
        Arrays.sort(a);
        int pairsCount = 0;
        /**
        //nested loop approach
        for(int i=0;i<a.length; i++){
            for(int j = i+1; j<a.length; j++){
                if(a[i] == a[j]-k){
                    pairsCount++;
                }
            }
        }*/
        //two pointer technique
        for(int i = 0;i<a.length; i++){
            int start = i, end = a.length-1;
            while(start<end && (a[start] +k <a[end])){
                end--;
            }
            if(a[start] + k ==a[end]){
                 pairsCount++;
           }
        }
        //System.out.println(Arrays.toString(a));
        return pairsCount;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int res;
        
        String n = in.nextLine();
        String[] n_split = n.split(" ");
        
        int _a_size = Integer.parseInt(n_split[0]);
        int _k = Integer.parseInt(n_split[1]);
        
        int[] _a = new int[_a_size];
        int _a_item;
        String next = in.nextLine();
        String[] next_split = next.split(" ");
        
        for(int _a_i = 0; _a_i < _a_size; _a_i++) {
            _a_item = Integer.parseInt(next_split[_a_i]);
            _a[_a_i] = _a_item;
        }
        
        res = pairs(_a,_k);
        System.out.println(res);
    }
}