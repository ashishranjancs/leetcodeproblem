package com.leetcode.leetcode75;

/**
 * You have a long flowerbed in which some of the plots are planted, and some are not. However, flowers cannot be planted in adjacent plots.
 *
 * Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1 means not empty, and an integer n, return true if n new flowers can be planted in the flowerbed without violating the no-adjacent-flowers rule and false otherwise.
 */
public class Can_Place_Flower {

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        for(int i = 0; i < flowerbed.length; i++){
            if(flowerbed[i] == 0 && (i == 0 || flowerbed[i-1] == 0) && (i == flowerbed.length-1 || flowerbed[i+1] == 0)){
                flowerbed[i] = 1;
                n--;
            }
            if(n == 0){
                return true;
            }
        }
        return n <= 0;
    }

    public static void main(String[] args) {
        int[] flowerbed1 = {1,0,0,0,1};
        int n1 = 1;

        int[] flowerbed2 = {1,0,0,0,1};
        int n2 = 2;

        int[] flowerbed3 = {};
        int n3 = 2;
        int[] flowerbed4 = {1,0,0,0,0,1};
        int n4 = 2;
        System.out.println(" Can Place Flower {1,0,0,0,1}  & n1 = 1: " + canPlaceFlowers(flowerbed1, n1));
        System.out.println(" Can Place Flower {1,0,0,0,1}  & n2 = 2: " + canPlaceFlowers(flowerbed2, n2));
        System.out.println(" Can Place Flower {}  & n3 = 2: " + canPlaceFlowers(flowerbed3, n3));
        System.out.println(" Can Place Flower {1,0,0,0,0,1}  & n3 = 2: " + canPlaceFlowers(flowerbed4, n4));

    }

}
