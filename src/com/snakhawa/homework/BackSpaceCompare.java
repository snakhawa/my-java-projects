package com.snakhawa.homework;

import java.util.Stack;

public class BackSpaceCompare {

    public static boolean backSpaceCompare(String S, String T) {

        //return buildUsingStack(S).equals(buildUsingStack(T));

        return buildUsingSB(S).equals(buildUsingSB(T));

    }

    private static String buildUsingStack(String S) {
        Stack<Character> ans = new Stack();
        for (char c : S.toCharArray()) {
            if (c != '#') {
                ans.push(c);
            } else {
                if (!ans.empty()) {
                    ans.pop();
                }
            }
        }

        return ans.toString();
    }

    private static String buildUsingSB(String S) {
        StringBuilder ans = new StringBuilder();
        for (char c : S.toCharArray()) {
            if (c != '#') {
                ans.append(c);
            } else {
                if (ans.length() != 0) {
                    ans.deleteCharAt(ans.length() - 1);
                }
            }
        }

        return ans.toString();
    }
}

