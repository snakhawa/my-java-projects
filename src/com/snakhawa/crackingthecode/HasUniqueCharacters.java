package com.snakhawa.crackingthecode;

import java.util.HashSet;
import java.util.Set;

/***
 * Implement an algorithm to determine if a string has all unique characters.
 * What if you can not use additional data structures?
 *
 * Assumption : All the character in the string are in ASCII range
 *
 * Test cases -
 * 1. Unique character strings
 * 2. duplicate character strings
 * 3. all alphabetic
 * 4. all numeric
 * 5. alphanumeric
 * 6. 1 character string
 * 7. null
 * 8.
 */
public class HasUniqueCharacters {

    public static boolean usingArray(String input) {

        if (input.isEmpty()) return false;
        if (input.length() < 2) return true;

        char[] inputArr = input.toCharArray();

        boolean[] boolArr = new boolean[256];
        for (int i = 0; i < inputArr.length; i++) {
            int charIndex = inputArr[i];
            if (boolArr[charIndex]) {
                System.out.println(String.format("The string %s doesn't have unique character", input));
                return false;
            }
            boolArr[charIndex] = true;
        }
        System.out.println(String.format("The string %s has unique character", input));
        return true;
    }

}
