package com.leetcode.leetcode75;

public class MaximumAverageSubarrayI {
    public static double findMaxAverage(int[] nums, int k){
        double maxSum = 0, currentSum = 0;
        for(int i = 0; i < k; i++){
            currentSum += nums[i];
        }
        maxSum = currentSum;
        for(int i = k; i < nums.length; i++){
            currentSum = currentSum - nums[i-k] + nums[i];
            maxSum = Math.max(currentSum, maxSum);
        }
        return maxSum/k;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,12,-5,-6,50,3};
        int k = 4;
        System.out.println("Maximum Average Subarray I  {1,12,-5,-6,50,3} k = 4 : " + findMaxAverage(nums1, k));
        int[] nums2 = {5};
        k = 1;
        System.out.println("Maximum Average Subarray I  {5} k = 1 : " + findMaxAverage(nums2, k));
        int[] nums3 = {0,-4,-6,-2,-9,-7};
        k = 3;
        System.out.println("Maximum Average Subarray I  {0,-4,-6,-2,-9,-7} k = 3 : " + findMaxAverage(nums3, k));

    }
}
