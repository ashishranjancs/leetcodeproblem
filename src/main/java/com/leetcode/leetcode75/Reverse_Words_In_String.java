package com.leetcode.leetcode75;

/**
 * Given an input string s, reverse the order of the words.
 *
 * A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.
 *
 * Return a string of the words in reverse order concatenated by a single space.
 *
 * Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.
 *
 * Example 1:
 * Input: s = "the sky is blue"
 * Output: "blue is sky the"
 *
 * Example 2:
 * Input: s = "  hello world  "
 * Output: "world hello"
 */
public class Reverse_Words_In_String {
    public static  String reverseWords(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        String[] str = cleanSpace(s);
        int i = 0, j = str.length-1;
        while( i < j){
            String temp = str[i];
            str[i] = str[j];
            str[j] = temp;
            i++;
            j--;
        }

        for(int k = 0; k < str.length; k++){
            stringBuilder.append(str[k]);
            if(k < str.length-1){
                stringBuilder.append(" ");
            }
        }
        return stringBuilder.toString();
    }

    public static String[] cleanSpace(String s){
        return s.trim().split("\\s+");
    }

    public static  String reverseWords_Normal(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        String[] str = s.trim().split("\\s+");


        for(int k = str.length-1; k >= 0; k--){
            stringBuilder.append(str[k]);
            if(k > 0){
                stringBuilder.append(" ");
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String s1 = "the sky is    blue";
        String s2 = "  hello world  ";
        String s3 = "a good   example      ";
        System.out.println("the sky is    blue: " + reverseWords(s1));
        System.out.println("  hello world  : " + reverseWords(s2));
        System.out.println("a good   example      : " + reverseWords(s3));
        System.out.println("the sky is    blue:reverseWords_Normal " + reverseWords_Normal(s1));
        System.out.println("  hello world  :reverseWords_Normal " + reverseWords_Normal(s2));
        System.out.println("a good   example      :reverseWords_Normal " + reverseWords_Normal(s3));
    }
}
