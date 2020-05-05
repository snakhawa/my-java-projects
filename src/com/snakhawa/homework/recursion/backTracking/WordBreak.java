package com.snakhawa.homework.recursion.backTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;


public class WordBreak {

    public static void main(String[] args) {

        HashSet<String> dict = new HashSet<>();
        dict.add("i");
        dict.add("am");
        List<String> result = wordBreakII("iamthe", dict);
        System.out.println("Done");

    }

    /**
     * WordBreakProblem​: Given a String S, which contains letters and no spaces, determine if youcan break it into valid words.
     * Return one such combination of words.
     * You can assume that you are provided a dictionary of English words.For example:S = "ilikemangotango"Output:
     * Return any one of these:"i like mango tango""i like man go tan go""i like mango tan go""i like man go tango
     *
     *"Questions to Clarify:
     * Q. Can I return the result as a list of strings (each string is a word)?A. Yes
     * Q. What to return if no result is found?A. Just return null.Q. What if there are multiple possible results?A. Return any one valid result.
     * Q. What if the String is empty or null?A. Return null.
     *
     * Solution:We use the following recursion: iterate ​i​ from 0 to the end of the string, and
     * check if ​s[0..i]​is a valid word. If it’s a valid word, do the same for the remainder of the string.
     * For example:We first iterate from 0. When ​i​ is 0, we find the first word - just "i".i​ l i k e m a n g o t a n g
     * We then repeat the process with the rest of the string:result = ["i"]©
     */
    //https://leetcode.com/problems/word-break-ii/
    public static List<String> wordBreakII(String s, HashSet<String> dictionary) {
        if (s == null || s.isEmpty()) return null;
        State[] memo = new State[s.length()];
        Arrays.fill(memo, State.UNVISITED);
        List<String> result = new ArrayList<String>();
        if (isWordII(s, 0, memo, result, dictionary)) {
            return result;
        }
        return null;
    }

    public static boolean isWordII(String s, int start, State[] memo, List<String> result,
                                      HashSet<String> dictionary) {
        if (start == s.length()) return true;
        if (memo[start] == State.NOT_FOUND) return false;
        for (int i = start; i < s.length(); i++) {
            String candidate = s.substring(start, i + 1);
            if (dictionary.contains(candidate)) {
                result.add(candidate);
                if (isWordII(s, i + 1, memo, result, dictionary)) {
                    return true;
                } else {
                    result.remove(result.size() - 1);
                    memo[i + 1] = State.NOT_FOUND;
                }
            }
        }

        return false;
    }

    public enum State {UNVISITED, NOT_FOUND;}

}