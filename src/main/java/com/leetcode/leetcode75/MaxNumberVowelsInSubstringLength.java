package com.leetcode.leetcode75;

import java.util.Set;

/**
 * Given a string s and an integer k, return the maximum number of vowel letters in any substring of s with length k.
 * Vowel letters in English are 'a', 'e', 'i', 'o', and 'u'.
 *
 * Example 1:
 * Input: s = "abciiidef", k = 3
 * Output: 3
 * Explanation: The substring "iii" contains 3 vowel letters.
 *
 * Example 2:
 * Input: s = "aeiou", k = 2
 * Output: 2
 * Explanation: Any substring of length 2 contains 2 vowels.
 *
 * Example 3:
 * Input: s = "leetcode", k = 3
 * Output: 2
 * Explanation: "lee", "eet" and "ode" contain 2 vowels.
 */
public class MaxNumberVowelsInSubstringLength {
    public static int maxVowels(String s, int k) {
        Set<Character> vowels = Set.of('a','e','i','o','u');
        int maxVowel = 0, vowelCount = 0;
        for( int i = 0; i < k; i++){
            if(vowels.contains(s.charAt(i))){
                vowelCount++;
            }
        }
        maxVowel = vowelCount;

        for(int i = k; i < s.length(); i++){
            if(vowels.contains(s.charAt(i))){
                vowelCount++;
            }
            if(vowels.contains(s.charAt(i-k))){
                vowelCount--;
            }
            maxVowel = Math.max(maxVowel, vowelCount);
        }
        return maxVowel;
    }

    public static void main(String[] args) {
        String s = "abciiidef";
        int k = 3;
        System.out.println("Maximum Number of Vowels in a Substring of Given Length: abciiidef k =3 : "+ maxVowels(s,k));
        String s1 = "aeiou";
        int k1 = 2;
        System.out.println("Maximum Number of Vowels in a Substring of Given Length: aeiou k =2 : "+ maxVowels(s1,k1));
        String s2 = "leetcode";
        int k2 = 3;
        System.out.println("Maximum Number of Vowels in a Substring of Given Length: leetcode k =3 : "+ maxVowels(s2,k2));
    }
}
