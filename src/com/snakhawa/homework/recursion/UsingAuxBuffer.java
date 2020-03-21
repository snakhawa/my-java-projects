package com.snakhawa.homework.recursion;

import com.snakhawa.homework.util.Util;

import java.util.Stack;

public class UsingAuxBuffer {

    /**
     * Given an array of integers, print all combinations of size X.
     *
     * @param a
     * @param x
     */
    public static void printCombos(int[] a, int x) {
        if (a == null || a.length == 0 || x > a.length)
            return;
        int[] buffer = new int[x];
        printCombosHelper(a, buffer, 0, 0);
    }

    //Given an array of integers, print all combinations of size X.
    private static void printCombosHelper(int[] a, int[] buffer, int startIndex, int bufferIndex) {
        // termination cases - buffer full
        // printArray(buffer, bufferIndex);

        if (bufferIndex == buffer.length) {
            Util.printArray(buffer, buffer.length);
            return;
        }
        if (startIndex == a.length) {
            return;
        }
        // find candidates that go into current buffer index
        for (int i = startIndex; i < a.length; i++) {
            // place item into buffer
            buffer[bufferIndex] = a[i];
            System.out.println(String.format("i= %s, startIndex=%s, bufferIndex=%s, bufferArray=%s", i, startIndex, bufferIndex, Util.toArrayString(buffer)));

            // recurse to next buffer index
            printCombosHelper(a, buffer, i + 1, bufferIndex + 1);
        }
    }

    /***
     * Phone Number Mnemonics: Given an N digit phone number, print all the strings that canbe made from that phone number.
     * Since 1 and 0 don't correspond to any characters, ignorethem.
     * For example:
     * 213 => AD, AE, AF, BD, BE, BF, CE, CE, CF
     * 456 => GJM, GJN, GJO, GKM, GKN, GKO,.. etc.Q
     * Print phone number mnemonics combination
     * @param phoneNumber
     */
    public static void printPhoneWords(int[] phoneNumber) {
        if (phoneNumber == null || phoneNumber.length == 0) return;

        char[] buffer = new char[phoneNumber.length];
        printWordHelper(phoneNumber, buffer, 0, 0);
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


    /**
     * Technique: Permutations/Combinations using Auxiliary BufferLevel: MediumCoin Change Problem: Given a set of coin denominations,
     * print out the different ways you can make a target amount.
     * You can use as many coins of each denomination as you like.
     * <p>
     * For example:
     * If coins are [1,2,5] and the target is 5, output will be:[1,1,1,1,1][1,1,1,2][1,2,2][5]
     * Questions to Clarify:
     * Q. Does [1,2] and [2,1] count as one, i.e, do we care about permutations?A. No, we only care about combinations, so [1,2] and [2,1] will count as the same.
     * Q. Can we assume that all coins will be integers greater than 0?A. Yes
     * <p>
     * Solution:
     * This problem is similar to generating combinations, except that a number can be repeatedseveral times.
     * So, while picking candidates that go into the buffer, we will also considerthe previous candidate that went in.Note​: ​
     * In this solution, we are using a stack as a buffer. You can also use an array of size target.
     *
     * @param coins
     * @param target
     */
    public static void printCoins(int[] coins, int target) {
        if (coins == null || coins.length == 0 || target <= 0) return;
        printCoinsHelper(coins, target, 0, new Stack<Integer>(), 0);
    }

    private static void printCoinsHelper(int[] coins, int target, int startIndex, Stack<Integer> buffer, int sum) {    // termination cases
        if (sum > target) {
            return;
        }
        if (sum == target) {
            //print(buffer);
            return;
        }
        // find candidates that go into buffer
        for (int i = startIndex; i < coins.length; i++) {
            // place candidate into buffer and recurse
            buffer.push(coins[i]);
            printCoinsHelper(coins, target, i, buffer, sum + coins[i]);
            buffer.pop();
        }
    }


}
