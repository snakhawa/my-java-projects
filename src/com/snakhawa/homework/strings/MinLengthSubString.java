package com.snakhawa.homework.strings;

import java.util.HashMap;

/**
 * You are given two strings s and t. You can select any substring of string s and rearrange the characters of the selected substring.
 * Determine the minimum length of the substring of s such that string t is a substring of the selected substring.
 * <p>
 * Example
 * s = "dcbefebce"
 * t = "fd"'
 * output = 5
 * Explanation:
 * Substring "dcbef" can be rearranged to "cfdeb", "cefdb", and so on. String t is a substring of "cfdeb". Thus, the minimum length required is 5.
 */
public class MinLengthSubString {

    static int minLengthSubstring(String s, String t) {
        // Write your code here
        HashMap<Character, Integer> map = new HashMap<>();
        int minIndex = Integer.MAX_VALUE;
        int maxIndex = Integer.MIN_VALUE;
        int tindex = -1;
        for (char ch : t.toCharArray()) {
            if (map.containsKey(ch)) {
                tindex = s.indexOf(ch, map.get(ch) + 1);
                if (tindex == -1) {
                    return -1;
                } else {
                    map.put(ch, tindex);
                    minIndex = Math.min(minIndex, tindex);
                    maxIndex = Math.max(maxIndex, tindex);
                }

            } else {
                tindex = s.indexOf(ch);
                if (tindex == -1) {
                    return -1;
                } else {
                    map.put(ch, tindex);
                    minIndex = Math.min(minIndex, tindex);
                    maxIndex = Math.max(maxIndex, tindex);
                }

            }
        }

        return maxIndex - minIndex + 1;

    }
}
