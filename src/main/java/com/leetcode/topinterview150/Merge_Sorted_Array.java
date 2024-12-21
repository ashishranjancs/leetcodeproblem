package com.leetcode.topinterview150;

import java.util.Scanner;

/**
 * You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.
 *
 * Merge nums1 and nums2 into a single array sorted in non-decreasing order.
 *
 * The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
 *
 * Example 1:
 *
 * Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * Output: [1,2,2,3,5,6]
 * Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
 * The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
 */
public class Merge_Sorted_Array {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the first array");
        int size = sc.nextInt();
        System.out.println("Enter the size of the second array");
        int size2 = sc.nextInt();
        int n = size + size2;
        int[] nums1 = new int[n];
        System.out.println("Enter the elements of the first array: ");
        for(int i = 0; i < size; i++)
        {
            //reading array elements from the user
            nums1[i]=sc.nextInt();
        }

        int[] nums2 = new int[size2];
        System.out.println("Enter the elements of the second array: ");
        for(int i = 0; i < size2; i++)
        {
            //reading array elements from the user
            nums2[i]=sc.nextInt();
        }
        merge(nums1,size,nums2,size2);
        System.out.println("Array after merge: ");
        for(int i =0; i< n; n++){
            System.out.println(nums1[i]);
        }
    }
    public static void merge(int[] nums1, int m, int[] nums2, int n){
        int i = m-1;
        int j = n-1;
        int k = m=n-1;
        while(i >= 0 && j >= 0){
            if(nums1[i] > nums2[j]){
                nums1[k] = nums1[i];
                i--;
            }else{
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }
        while( j >= 0){
            nums1[k] = nums2[j];
            j--;
            k--;
        }
    }
}