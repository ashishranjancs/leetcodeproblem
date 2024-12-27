package com.leetcode.leetcode75;

public class IsSubsequence {
    public static boolean isSubsequence(String s, String t){
        int sPointer = 0, tPointer = 0;
        while(sPointer < s.length() && tPointer < t.length()){
            if(s.charAt(sPointer) == t.charAt(tPointer)){
                sPointer++;
                tPointer++;
            }else{
                tPointer++;
            }
        }
        return s.length() == sPointer;
    }

    public static void main(String[] args) {
        String s = "abc", t = "ahbgdc";
        System.out.println("Is Subsequence s = \"abc\", t = \"ahbgdc\" : " + isSubsequence(s,t));
        String s1 = "axc", t1 = "ahbgdc";
        System.out.println("Is Subsequence s = \"axc\", t = \"aahbgdc\" : " + isSubsequence(s1, t1));


    }
}
