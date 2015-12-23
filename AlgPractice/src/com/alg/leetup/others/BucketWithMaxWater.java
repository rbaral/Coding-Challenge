package com.alg.leetup.others;
/**
 * ref:http://rafal.io/posts/leetcode-11-container-with-most-water.html
 * @author rbaral
 *
 */
public class BucketWithMaxWater {
    public int maxArea(int[] height) {
        int maxA = 0;
        int i = 0;
        int j = height.length-1;
          int curArea=0;
        while(i < j){
            if(height[i]- height[j]<=0)
                  curArea = (j-i) * height[i];
          else
              curArea = (j-i) * height[j];
          maxA = Math.max(curArea,maxA);
          if(height[i] < height[j]) i++;
          else j--;
        }
      
        return maxA;
          }
}
