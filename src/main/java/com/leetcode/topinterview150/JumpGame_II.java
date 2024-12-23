package com.leetcode.topinterview150;
/*
You are given a 0-indexed array of integers nums of length n. You are initially positioned at nums[0].
Each element nums[i] represents the maximum length of a forward jump from index i. In other words, if you are at nums[i], you can jump to any nums[i + j] where:
0 <= j <= nums[i] and
i + j < n
Return the minimum number of jumps to reach nums[n - 1]. The test cases are generated such that you can reach nums[n - 1].
Example 1:

Input: nums = [2,3,1,1,4]
Output: 2
Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
Example 2:

Input: nums = [2,3,0,1,4]
Output: 2
Constraints:
1 <= nums.length <= 104
0 <= nums[i] <= 1000
It's guaranteed that you can reach nums[n - 1].
 */
public class JumpGame_II {

    public static void main(String[] args) {
        JumpGame_II jumpGame_ii = new JumpGame_II();
        int[] case1 = {2,3,1,1,4};
        System.out.println("Jump Steps ({2,3,1,1,4}) through Normal way: " + jumpGame_ii.jump(case1));
        System.out.println("Jump Steps (2,3,1,1,4) : " + jumpGame_ii.jumpStep(case1));
        int[] case2 = {2,3,0,1,4};
        System.out.println("Jump Steps (nums1) through Normal way: " + jumpGame_ii.jump(case2));
        System.out.println("Jump Steps (2,3,0,1,4) : " + jumpGame_ii.jumpStep(case2));
        int[] case3 = {0};
        System.out.println("Jump Steps (nums1) through Normal way: " + jumpGame_ii.jump(case3));
        System.out.println("Jump Steps (0) : " + jumpGame_ii.jumpStep(case3));
    }

    public int jump(int[] nums){
        int count = 0;
        int maxReachIndex = 0;
        int jumpIndex = 0;
        if(nums.length < 2)
            return 0;
        for(int i = 0; i < nums.length; i++){
            if(i > maxReachIndex)
                return count;
            for(int j = maxReachIndex; j >= 0; j--){
                jumpIndex = Math.max(jumpIndex, nums[j]+j);
            }
            maxReachIndex = Math.max(maxReachIndex, jumpIndex);
            if(maxReachIndex >= nums.length-1){
                count = count + 1;
                return count;
            }
            count++;
        }
        return count;

    }

    public int jumpStep(int[] nums){
        int count = 0;
        int maxReachIndex = 0;
        int currentIndex = 0;
        for(int i = 0; i < nums.length - 1; i++){
            maxReachIndex = Math.max(maxReachIndex, nums[i]+i);
            if(i == currentIndex){
                count++;
                currentIndex = maxReachIndex;
            }
        }
        return count;
    }
}
