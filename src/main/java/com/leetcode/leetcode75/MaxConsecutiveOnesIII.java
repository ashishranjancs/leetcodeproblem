package com.leetcode.leetcode75;

/**
 * Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.
 *
 * Example 1:
 * Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
 * Output: 6
 * Explanation: [1,1,1,0,0,1,1,1,1,1,1]
 * Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
 *
 * Example 2:
 * Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
 * Output: 10
 * Explanation: [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
 * Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
 */
public class MaxConsecutiveOnesIII {
    public static int longestOnes(int[] nums, int k) {
        int leftP = 0,maxOne = 0, zeroCount = 0;
        for(int rightP = 0; rightP < nums.length; rightP++){
            if(nums[rightP] == 0){
                zeroCount++;
            }

            while(zeroCount > k){
                if(nums[leftP] == 0){
                    zeroCount--;
                }
                leftP++;
            }

            maxOne = Math.max(maxOne, (rightP-leftP+1));
        }
        return maxOne;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,1,1,0,0,0,1,1,1,1,0};
        int k = 2;
        System.out.println("Max Consecutive Ones III {1,1,1,0,0,0,1,1,1,1,0} k = 2 : " + longestOnes(nums1, k));
        int[] nums2 = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        k = 3;
        System.out.println("Max Consecutive Ones III {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1} k = 3 : " + longestOnes(nums2, k));
    }
}
