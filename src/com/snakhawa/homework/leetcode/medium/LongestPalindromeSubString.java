package com.snakhawa.homework.leetcode.medium;

/*
https://leetcode.com/problems/longest-palindromic-substring/
Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example 1:

Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.
Example 2:

Input: "cbbd"
Output: "bb"
 */
public class LongestPalindromeSubString {

    public static String bruteForce(String s) {

        if (s == null || s.length() < 1) return "";

        String maxP = "";

        for (int i = 0; i < s.length(); i++) {

            for (int j = i; j <= s.length(); j++) {
                String subString = s.substring(i, j);
                if (isPalindrome(subString)) {
                    if (subString.length() > maxP.length()) {
                        maxP = subString;
                    }
                }
            }
        }
        return maxP;

    }

    public static String expandAroundCenter(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int oddLength = expandAroundCenter(s, i, i);
            int evenLength = expandAroundCenter(s, i, i + 1);
            int maxLength = Math.max(oddLength, evenLength);
            if (maxLength > end - start) {
                start = i - (maxLength - 1) / 2;
                end = i + maxLength / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private static int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }

    private static boolean isPalindrome(String s) {

        int l = 0;
        int r = s.length() - 1;

        while (l < r) {

            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }

        return true;
    }

    public static String longestPalindrome(String s) {
        if (s == null || s.isEmpty()) return "";

        if (s.length() % 2 == 0) {
            return evenExpandAroundCenter(s);
        } else {
            return oddExpandAroundCenter(s);
        }
    }

    public static String evenExpandAroundCenter(String s) {
        int longest = 1;
        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++) {
            int offset = 0;
            while (isValidIndex(s, i - offset) && isValidIndex(s, i + 1 + offset) && s.charAt(i - offset) == s.charAt(i + 1 + offset)) {
                offset++;
            }

            int currLongest = offset * 2;
            if (currLongest > longest) {
                longest = currLongest;
                start = i - offset + 1;
                end = i + offset;
            }
        }

        return s.substring(start, end);
    }

    public static String oddExpandAroundCenter(String s) {
        int longest = 1;
        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++) {
            int offset = 0;
            while (isValidIndex(s, i - 1 - offset) && isValidIndex(s, i + 1 + offset) && s.charAt(i - 1 - offset) == s.charAt(i + 1 + offset)) {
                offset++;
            }

            int currLongest = offset * 2 + 1;
            if (currLongest > longest) {
                longest = currLongest;
                start = i - offset;
                end = i + offset;
            }
        }

        return s.substring(start, end + 1);
    }


    public static boolean isValidIndex(String s, int index) {
        return index >= 0 && index < s.length();
    }

}
