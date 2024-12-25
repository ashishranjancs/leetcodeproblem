package com.leetcode.leetcode75;

import java.util.Arrays;

public class IncreasingTripletSubsequence {
    public static boolean increasingTriplet(int[] nums){
        if(nums == null || nums.length < 3)
            return false;
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;
        for(int num : nums){
            if(num <= first)
                first = num;
            else if(num <= second)
                second = num;
            else return true;
        }
        return false;
    }

    public static int[] increasingTripletWithIndex(int[] nums){
        if(nums == null || nums.length < 3)
            return new int[0];
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;
        int firstIndex = -1;
        int secondIndex = -1;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] <= first) {
                first = nums[i];
                firstIndex = i;
            }
            else if(nums[i] <= second){
                second = nums[i];
                secondIndex = i;
            }
            else{
                return new int[]{firstIndex, secondIndex, i};
            }
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        System.out.println("Increasing Triplet Subsequence for {1,2,3,4,5} : " + increasingTriplet(nums));
        System.out.println("Increasing Triplet Subsequence index for {1,2,3,4,5} : " + Arrays.toString(increasingTripletWithIndex(nums)));
        nums = new int[]{5,4,3,2,1};
        System.out.println("Increasing Triplet Subsequence for {5,4,3,2,1} : " + increasingTriplet(nums));
        System.out.println("Increasing Triplet Subsequence index for {5,4,3,2,1} : " + Arrays.toString(increasingTripletWithIndex(nums)));
        nums = new int[]{2,1,5,0,6,4};
        System.out.println("Increasing Triplet Subsequence for {2,1,5,0,6,4} : " + increasingTriplet(nums));
        System.out.println("Increasing Triplet Subsequence index for {2,1,5,0,6,4} : " + Arrays.toString(increasingTripletWithIndex(nums)));
        nums = new int[]{20,100,10,12,5,13};
        System.out.println("Increasing Triplet Subsequence for {20,100,10,12,5,13} : " + increasingTriplet(nums));
        System.out.println("Increasing Triplet Subsequence index for {20,100,10,12,5,13} : " + Arrays.toString(increasingTripletWithIndex(nums)));
    }
}
