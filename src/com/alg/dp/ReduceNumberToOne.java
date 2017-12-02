/*
On a positive integer, you can perform any one of the following 3 steps. 
1.) Subtract 1 from it. ( n = n - 1 )  ,
2.) If its divisible by 2, divide by 2. ( if n % 2 == 0 , then n = n / 2  )  , 
3.) If its divisible by 3, divide by 3. ( if n % 3 == 0 , then n = n / 3  ). 
Now the question is, given a positive integer n, find the minimum number of steps that takes n to 1
eg: 1.)For n = 1 , output: 0       2.) For n = 4 , output: 2  ( 4  /2 = 2  /2 = 1 )    3.)  
For n = 7 , output: 3  (  7  -1 = 6   /3 = 2   /2 = 1 )
 */
package com.alg.dp;

/**
 *
 * @author rbaral
 */
public class ReduceNumberToOne {
    
    /**
     * recursive approach with Memoization
     * @param n
     * @param minStepsArr
     * @return 
     */
    public static int getMinStepsTopDown(int n, int[] minStepsArr){
        if(n<=1){
            return 0;
        }else if(n==2){
            return 1;
        }
        if(minStepsArr[n]!=-1){
            return minStepsArr[n];
        }
        int steps = 1+getMinStepsTopDown(n-1, minStepsArr);
        if(n%2==0)
            steps = Math.min(steps, 1 +getMinStepsTopDown(n/2, minStepsArr));
        if(n%3==0)
            steps = Math.min(steps, 1+ getMinStepsTopDown(n/3, minStepsArr));
        minStepsArr[n] = steps;
        return steps;
    }
    
    /**
     * a DP approach that solves smaller problems first
     * @param n
     * @param minStepsArr
     * @return 
     */
    public static int getMinStepsBottomUp(int n, int[] minStepsArr){
     int[] dp = new int[n+1];
     //base case
     //there is no way to reduce 1
     dp[1] = 0;
     for(int i=2;i<=n;i ++){
         dp[i] = dp[i-1] + 1;
         if(i%2==0)
             dp[i] = Math.min(dp[i], 1 + dp[i/2]);
         if(i%3==0)
             dp[i] = Math.min(dp[i], 1+ dp[i/3]);
     }
     return dp[n];
    }
    
    public static void main(String args[]){
        int n = 10;
        int minStepsArr[] = new int[n+1];
        //initialize all to -1
        for(int i = 0;i<minStepsArr.length;i++)
            minStepsArr[i]=-1;
        int steps1 = getMinStepsTopDown(n, minStepsArr);
        
        int steps2 = getMinStepsBottomUp(n, minStepsArr);
        System.out.println("min steps are:"+steps1+"...."+steps2);
    }
}
