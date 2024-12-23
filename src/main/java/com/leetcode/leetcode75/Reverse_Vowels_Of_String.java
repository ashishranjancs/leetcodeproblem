package com.leetcode.leetcode75;

import java.util.*;

/**
 * Given a string s, reverse only all the vowels in the string and return it.
 *
 * The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases, more than once.
 * Example:
 * Input: s = "IceCreAm"
 *
 * Output: "AceCreIm"
 */
public class Reverse_Vowels_Of_String {
    public static  String reverseVowels(String s){
        StringBuilder output = new StringBuilder();
        int i = 0;
        List<Character> stringChar = new ArrayList<>();
        List<Character> vowels = new ArrayList<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        //find the vowels
        for(char t : s.toCharArray()){
            if(vowels.contains(Character.toLowerCase(t))){
                stringChar.add(i++,t);
            }
        }
        //Reversing vowel
        for(char t : s.toCharArray()){
            if(vowels.contains(Character.toLowerCase(t))){
                output.append(stringChar.get(--i));
            }else{
                output.append(t);
            }
        }
        System.out.println(" Reverse String: " + output.toString() );
        return output.toString();
    }

    public static  String reverseVowels_UsingTwoPointer(String s){
        int i = 0, j = s.length()-1;
        Set<Character> vowels = new HashSet<>(Arrays.asList('a','e','i','o','u'));
        char[] chars = s.toCharArray();
        while(i < j){
            //increment i till vowel
            while(i < j && !vowels.contains(Character.toLowerCase(chars[i]))){
                i++;
            }
            while(i < j && !vowels.contains(Character.toLowerCase(chars[j]))){
                j--;
            }

            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
            i++;
            j--;
        }
        String output = new String(chars);
        System.out.println(" Reverse String: " + output );
        return output;
    }

    public static void main(String[] args) {
        String s1 = "IceCreAm";
        String s2 = "leetcode";

        System.out.println(" Reverse Vowels Of String(IceCreAm) : " + reverseVowels(s1));
        System.out.println(" Reverse Vowels Of String(leetcode) : " + reverseVowels(s2));
        System.out.println(" Reverse Vowels Of String(IceCreAm) : " + reverseVowels_UsingTwoPointer(s1));
        System.out.println(" Reverse Vowels Of String(leetcode) : " + reverseVowels_UsingTwoPointer(s2));
    }
}
