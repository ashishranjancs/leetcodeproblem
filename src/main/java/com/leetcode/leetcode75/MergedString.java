package com.leetcode.leetcode75;

/**
 * You are given two strings word1 and word2. Merge the strings by adding letters in alternating order, starting with word1.
 * If a string is longer than the other, append the additional letters onto the end of the merged string.
 *
 *  Return the merged string.
 *  Example :
 *  Input: word1 = "ab", word2 = "pqrs"
 *  Output: "apbqrs"
 */
public class MergedString {
    public static String mergedTwoString(String w1, String w2){
        StringBuilder mergedString = new StringBuilder();
        int i = 0 , j = 0;
        while(i < w1.length() && j < w2.length()){
            mergedString.append(w1.charAt(i++));
            mergedString.append(w2.charAt(j++));
        }
        while(i < w1.length())
            mergedString.append(w1.charAt(i++));
        while(j < w2.length())
            mergedString.append(w2.charAt(j++));

        return mergedString.toString();
    }

    public static String mergedTwoStringWithOnePointer(String w1, String w2){
        StringBuilder mergedString = new StringBuilder();
        int i = 0;
        int totalLength = w1.length() + w2.length();
        while(i < totalLength){
            if(i < w1.length()){
                mergedString.append(w1.charAt(i));
            }
            if(i < w2.length()){
                mergedString.append(w2.charAt(i));
            }
            i++;
        }
        return mergedString.toString();
    }

    public static void main(String[] args) {
        String w1 = "abc", w2 = "pqr";
        System.out.println("merged String : " + mergedTwoString(w1, w2));
        String w3 = "ab", w4 = "pqrs";
        System.out.println("merged String( w3 = ab, w4 = pqrs) : " + mergedTwoString(w3, w4));
        String w5 = "", w6 = "pqrs";
        System.out.println("merged String( w5 = , w6 = pqrs) : " + mergedTwoString(w5, w6));

        System.out.println("merged String with single Pointer: " + mergedTwoStringWithOnePointer(w1, w2));
        System.out.println("merged String( w3 = ab, w4 = pqrs) with single Pointer:: " + mergedTwoStringWithOnePointer(w3, w4));
        System.out.println("merged String( w5 = , w6 = pqrs) with single Pointer: : " + mergedTwoStringWithOnePointer(w5, w6));

    }
}
