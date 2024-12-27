package com.leetcode.leetcode75;

public class ContainerWithMostWater {
    public static int maxArea(int[] height){
        int l = 0, r = height.length-1, maxArea = Integer.MIN_VALUE;
        while(r > l){
            int area = Math.min(height[l], height[r]) * (r-l);
            maxArea = Math.max(area, maxArea);
            if(height[l] > height[r]){
                r--;
            }else{
                l++;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] height1 = {1,8,6,2,5,4,8,3,7};
        System.out.println("Container With Most Water {1,8,6,2,5,4,8,3,7} :  " + maxArea(height1));
        int[] height2 = {1,1};
        System.out.println("Container With Most Water {1,8,6,2,5,4,8,3,7} :  " + maxArea(height2));
    }
}
