package com.leetcode.leetcode75;

import java.util.Arrays;

public class StringCompression {
    public static int compress(char[] chars) {
        int i = 0, count = 0;
        char p = chars[0];
        if(chars.length == 0)
            return 0;
        for(int k = 0; k < chars.length; k++){
            if(p == chars[k]){
                count++;
            }else{
                p = chars[k];
                if(count > 1){
                    i += 2;
                }else{
                    i++;
                }
                count = 1;
            }
            if(k == chars.length-1 ){
                if(count > 1){
                    i += 2;
                }else{
                    i++;
                }
            }
        }
        return i;
    }

    public static int compressGroup(char[] chars) {
        int write = 0; // Write pointer for the compressed array
        int read = 0;  // Read pointer to traverse the array

        while (read < chars.length) {
            char currentChar = chars[read];
            int count = 0;

            // Count the occurrences of the current character
            while (read < chars.length && chars[read] == currentChar) {
                read++;
                count++;
            }

            // Write the character
            chars[write++] = currentChar;

            // Write the count if greater than 1
            if (count > 1) {
                for (char c : Integer.toString(count).toCharArray()) {
                    chars[write++] = c;
                }
            }
        }

        return write; // The new length of the compressed array
    }

    public static void main(String[] args) {
        char[] ch = {'a','a','b','b','c','c','c'};
        char[] ch1 = {'a'};
        char[] ch2 = {'a','b','b','b','b','b','b','b','b','b','b','b','b'};
        char[] ch3 = {'a','a','a','b','b','b','c'};
        char[] ch4 = {'a','a','a','b','b','b','c','d','d'};
        System.out.println("String Compression {'a','a','b','b','c','c','c'} : " + compress(ch));
        System.out.println("String Compression Group {'a','a','b','b','c','c','c'} : " + compressGroup(ch));
        System.out.println("String Compression {'a'} : " + compress(ch1));
        System.out.println("String Compression Group {'a'} : " + compressGroup(ch1));
        System.out.println("String Compression {'a','b','b','b','b','b','b','b','b','b','b','b','b'} : " + compress(ch2));
        System.out.println("String Compression Group {'a','b','b','b','b','b','b','b','b','b','b','b','b'} : " + compressGroup(ch2));
        System.out.println("String Compression {'a','a','a','b','b','b','c'} : " + compress(ch3));
        System.out.println("String Compression Group {'a','a','a','b','b','b','c'} : " + compressGroup(ch3));
        System.out.println("String Compression {'a','a','a','b','b','b','c','d','d'} : " + compress(ch4));
        System.out.println("String Compression Group {'a','a','a','b','b','b','c','d','d'} : " + compressGroup(ch4));
    }
}
