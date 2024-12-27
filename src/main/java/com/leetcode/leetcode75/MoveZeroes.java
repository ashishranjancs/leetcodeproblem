package com.leetcode.leetcode75;

import java.util.Arrays;

public class MoveZeroes {
    public static int[] moveZeros(int[] nums){
        int index = 0, count = 0;
        for(int i : nums){
            if(i == 0){
                count++;
            }else{
                nums[index++] = i;
            }
        }
        while(count > 0){
            nums[index++] = 0;
            count--;
        }
        return nums;
    }

    public static void main(String[] args) {
        int [] nums1 = {0,1,0,3,12};
        int [] nums2 = {0};
        System.out.println("Move Zeroes {0,1,0,3,12} : " + Arrays.toString(moveZeros(nums1)));
        System.out.println("Move Zeroes {0} : " + Arrays.toString(moveZeros(nums2)));
    }
}
