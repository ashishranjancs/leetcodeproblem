package com.leetcode.leetcode75;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
 *
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 *
 * You must write an algorithm that runs in O(n) time and without using the division operation.
 *
 * Example 1:
 * Input: nums = [1,2,3,4]
 * Output: [24,12,8,6]
 *
 * Example 2:
 * Input: nums = [-1,1,0,-3,3]
 * Output: [0,0,9,0,0]
 */
public class Product_Of_Array_Except_Self {
    public static int[] productExceptSelf_WithN2(int[] nums) {
        int[] output = new int[nums.length];
        for(int i = 0; i < nums.length-1; i++){
            int prefixProduct = product(0,i-1, nums);
            int suffixProduct = product(i+1,nums.length-1, nums);
            output[i] = prefixProduct*suffixProduct;
        }
        return output;
    }
    public static int product(int i, int j, int[] nums){
        int prod = 1;
        if(j < 0){
            return 1;
        }
        for(int k = i; k <= j; k++){
            prod *= nums[k];
        }
        return prod;
    }

    public static int[] productExceptSelfWithNSpace(int[] nums) {
        int n = nums.length;
        int[] output = new int[n];
        int[] leftProduct = new int[n];
        int[] rightProduct = new int[n];

        int l = 1;
        for(int i = 0; i < n; i++){
            leftProduct[i] = l;
            l *= nums[i];
        }
        int r =1;
        for(int i = n-1; i >= 0; i--){
            rightProduct[i] = r;
            r *= nums[i];
        }

        for(int i = 0; i < n; i++){
            output[i] = leftProduct[i] * rightProduct[i];
        }

        return output;
    }

    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] output = new int[n];

        int l = 1;
        for(int i = 0; i < n; i++){
            output[i] = l;
            l *= nums[i];
        }
        int r =1;
        for(int i = n-1; i >= 0; i--){
            output[i] *= r;
            r *= nums[i];
        }
        return output;
    }


    public static void main(String[] args) {
        int[] nums1 = {1,2,3,4};
        int[] nums2 = {-1,1,0,-3,3};
        int[] nums3 = {-1,2,1,-3,3};
        System.out.println("Product Of Array Except Self {1,2,3,4} : ");
        int[] prod =  productExceptSelf(nums1);
        for(int i : prod){
            System.out.print(i + " ");
        }
        System.out.println("Product Of Array Except Self {-1,1,0,-3,3} : ");
        prod =  productExceptSelfWithNSpace(nums2);
        for(int i : prod){
            System.out.print(i + " ");
        }

        System.out.println("Product Of Array Except Self {-1,2,1,-3,3} : ");
        prod =  productExceptSelf_WithN2(nums3);
        for(int i : prod){
            System.out.print(i + " ");
        }
    }
}
