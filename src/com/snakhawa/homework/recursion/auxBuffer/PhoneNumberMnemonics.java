package com.snakhawa.homework.recursion.auxBuffer;

import com.snakhawa.homework.util.Util;

import java.util.LinkedList;
import java.util.List;

public class PhoneNumberMnemonics {

    /***
     * Phone Number Mnemonics: Given an N digit phone number, print all the strings that canbe made from that phone number.
     * Since 1 and 0 don't correspond to any characters, ignorethem.
     * For example:
     * 213 => AD, AE, AF, BD, BE, BF, CE, CE, CF
     * 456 => GJM, GJN, GJO, GKM, GKN, GKO,.. etc.Q
     * Print phone number mnemonics combination
     * @param phoneNumber
     */
    public static void printUsingAuxBuffer(int[] phoneNumber) {
        if (phoneNumber == null || phoneNumber.length == 0) return;

        char[] buffer = new char[phoneNumber.length];
        printWordHelper(phoneNumber, buffer, 0, 0);
    }

    public static List<String> printUsingIteration(String phoneNumber) {
        LinkedList<String> result = new LinkedList<>();
        if (phoneNumber.isEmpty()) return result;
        result.add("");
        String[] map = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        while (result.peek().length() != phoneNumber.length()) {
            String top = result.remove();
            int i = phoneNumber.charAt(top.length()) - '0';
            String letters = map[i];
            for (char ch : letters.toCharArray()) {
                result.addLast(top + ch);
            }
        }
        return result;
    }

    private static void printWordHelper(int[] n, char[] buffer, int nIndex, int bufferIndex) {
        if (bufferIndex >= buffer.length || nIndex >= n.length) {
            Util.printArray(buffer, bufferIndex);
            return;
        }

        char[] letters = getLetters(n[nIndex]);

        if (letters.length == 0) {
            printWordHelper(n, buffer, nIndex + 1, bufferIndex);
        }

        for (char c : letters) {
            buffer[bufferIndex] = c;
            System.out.println(String.format("c= %s, nIndex=%s, bufferIndex=%s, bufferArray=%s", c, nIndex, bufferIndex, Util.toArrayString(buffer)));
            printWordHelper(n, buffer, nIndex + 1, bufferIndex + 1);
        }


    }

    private static char[] getLetters(int digit) {
        switch (digit) {
            case 0:
                return new char[]{};
            case 1:
                return new char[]{};
            case 2:
                return new char[]{'a', 'b', 'c'};
            case 3:
                return new char[]{'d', 'e', 'f'};
            case 4:
                return new char[]{'g', 'h', 'i'};
            case 5:
                return new char[]{'j', 'k', 'l'};
            case 6:
                return new char[]{'m', 'n', 'o'};
            case 7:
                return new char[]{'p', 'q', 'r', 's'};
            case 8:
                return new char[]{'t', 'u', 'v'};
            case 9:
                return new char[]{'w', 'x', 'y', 'z'};
        }
        throw new IllegalArgumentException("Invalid Digit " + digit);
    }
}
