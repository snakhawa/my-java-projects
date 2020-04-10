package com.snakhawa.homework.recursion.auxBuffer;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {

    public static List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        genParenthesisHelper(ans, "", 0, 0, n);
        return ans;
    }

    public static void genParenthesisHelper(List<String> output, String current, int open, int close, int max) {

        if (current.length() >= max * 2) {
            output.add(current);
            return;
        }

        if (open < max) {
            genParenthesisHelper(output, current + "(", open + 1, close, max);
        }
        if (close < open) {
            genParenthesisHelper(output, current + ")", open, close + 1, max);
        }
    }
}
