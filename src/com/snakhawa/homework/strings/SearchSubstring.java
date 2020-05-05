package com.snakhawa.homework.strings;

public class SearchSubstring {

    public static int usingSubString(String s, String target) {
        if (s == null || target == null) return -1;
        if (target.length() == 0) return 0;
        if (target.length() > s.length()) return -1;
        int k = target.length();
        for (int i = 0; i <= s.length() - k; i++) {
            String subString = s.substring(i, i + k);
            if (target.equals(subString)) {
                return i;
            }
        }
        return -1;
    }
}
