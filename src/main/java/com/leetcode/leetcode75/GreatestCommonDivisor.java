package com.leetcode.leetcode75;

/**
 * 1071. Greatest Common Divisor of Strings
 * For two strings s and t, we say "t divides s" if and only if s = t + t + t + ... + t + t (i.e., t is concatenated with itself one or more times).
 *
 * Given two strings str1 and str2, return the largest string x such that x divides both str1 and str2.
 * Example:
 * Input: str1 = "ABABAB", str2 = "ABAB"
 * Output: "AB"
 */
public class GreatestCommonDivisor {
    public static String gcdOfStrings(String str1, String str2){
        if(!(str1+str2).equals(str2+str1)){
            return "";
        }
        int gcdLength = gcd(str1.length(), str2.length());

        return str1.substring(0, gcdLength);
    }
    public static int gcd(int a, int b){
       return  b == 0 ? a : gcd(b, a%b);
    }

    public static void main(String[] args) {
        String str1 = "ABCABC", str2 = "ABC";
        String str3 = "ABABAB", str4 = "ABAB";
        String str5 = "LEET", str6 = "CODE";

        System.out.println("Greatest Common Divisor (str1 = ABCABC, str2 = ABC) " + gcdOfStrings(str1, str2));
        System.out.println("Greatest Common Divisor (str1 = ABABAB, str2 = ABAB) " + gcdOfStrings(str3, str4));
        System.out.println("Greatest Common Divisor (str1 = LEET, str2 = CODE) " + gcdOfStrings(str5, str6));
    }
}
