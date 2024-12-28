package com.leetcode.leetcode75;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MaxNumberOfKSumPairs {
    public static int maxOperations(int[] nums, int k) {
        int count = 0;
        Map<Integer, Integer> numberWithFrequency =  new HashMap<>();
        for(int num : nums){
            int complement = k - num;
            if(numberWithFrequency.containsKey(complement) && numberWithFrequency.get(complement) > 0){
                numberWithFrequency.put(complement,numberWithFrequency.get(complement) - 1);
                count++;
            }else{
                numberWithFrequency.put(num, numberWithFrequency.getOrDefault(num, 0) + 1);
            }
        }
        return count;
    }
    public static int maxOperationsUsingSort(int[] nums, int k) {
        int count = 0, i = 0, j = nums.length-1;
        Arrays.sort(nums);
        while(i < j){
            int sum = nums[i] + nums[j];
            if(sum == k){
                count++;
                i++;
                j--;
            }else if(sum < k){
                i++;
            }else{
                j--;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,4};
        int k = 5;
        System.out.println("Max Number of K-Sum Pairs {1,2,3,4} k = 5 : " + maxOperations(nums1, k));
        System.out.println("Max Number of K-Sum Pairs using sort {1,2,3,4} k = 5 : " + maxOperationsUsingSort(nums1, k));
        int[] nums2 = {3,1,3,4,3};
        k = 6;
        System.out.println("Max Number of K-Sum Pairs {3,1,3,4,3} k = 6 : " + maxOperations(nums2, k));
        System.out.println("Max Number of K-Sum Pairs using sort {3,1,3,4,3} k = 6 : " + maxOperationsUsingSort(nums2, k));
        int[] nums3 = {3,3,3,3,4,4,4,3,4,4};
        k = 7;
        System.out.println("Max Number of K-Sum Pairs {3,3,3,3,4,4,4,3,4,4} k = 7 : " + maxOperations(nums3, k));
        System.out.println("Max Number of K-Sum Pairs using sort {3,3,3,3,4,4,4,3,4,4} k = 7 : " + maxOperationsUsingSort(nums3, k));
    }
}
