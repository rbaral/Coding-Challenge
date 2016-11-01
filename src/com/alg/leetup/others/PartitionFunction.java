package com.alg.leetup.others;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class PartitionFunction {

    static final private Map<String, BigInteger> cache = new HashMap<>();
    
    /**
     * Counts the number of ways of representing n as a distinct sum of
     * positive integers <= m.
     * 
     * @param n number to sum to
     * @param m restriction on the component numbers
     * @return number of ways
     */
    public static BigInteger p(final long n, final long m) {
        if (n <= 1) {
            // recursive stopping condition
            return BigInteger.ONE;
        }
        
        if (m > n) {
            // using component numbers > n doesn't contribute any more
            // ways to sum to n
            return p(n, n);
        }
        
        String cacheKey = n + "," + m;
        BigInteger sum = cache.get(cacheKey);
        if (sum != null) {
            return sum;
        }
        
        sum = BigInteger.ZERO;
        for (long k = 1; k <= m; k++) {
            sum = sum.add(p(n-k, k));
        }

        cache.put(cacheKey, sum);
        return sum;
    }

    /**
     * Counts the number of ways of representing n as a distinct
     * sum of positive integers.
     * 
     * @param n number to sum to 
     * @return number of ways
     */
    public static BigInteger p(final long n) {
        return p(n, n);
    }    
    
    public static void main(String[] args) {
        final long n = 10;
        System.out.println("p(" + n + ") = " + p(n));
    }
}
