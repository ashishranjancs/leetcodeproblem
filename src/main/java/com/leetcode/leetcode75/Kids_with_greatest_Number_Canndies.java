package com.leetcode.leetcode75;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * There are n kids with candies. You are given an integer array candies, where each candies[i] represents the number of candies the ith kid has, and an integer extraCandies, denoting the number of extra candies that you have.
 *
 * Return a boolean array result of length n, where result[i] is true if, after giving the ith kid all the extraCandies, they will have the greatest number of candies among all the kids, or false otherwise.
 *
 * Note that multiple kids can have the greatest number of candies.
 */
public class Kids_with_greatest_Number_Canndies {

    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> kidsWithCandy = new ArrayList<>();
        int i = 0;
        int maxCandyInKids = findMaxCandyInKids(candies);
        for(int candy : candies){
            kidsWithCandy.add(i++, maxCandyInKids <= (candy+extraCandies));
        }
        return kidsWithCandy;
    }

    public static int findMaxCandyInKids(int[] candies){
        int max = 0;
        for(int i : candies){
            if(max < i ){
                max = i;
            }
        }
        return max;
    }
    public static void main(String[] args) {
        int[] candies = {2,3,5,1,3};
        int extraCandies = 3;

        System.out.println(" Kids with candies = [2,3,5,1,3], extraCandies = 3 " + kidsWithCandies(candies, extraCandies));
    }

}
