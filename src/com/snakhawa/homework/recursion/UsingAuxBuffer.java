package com.snakhawa.homework.recursion;

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
    public static void printCombosHelper(int[] a, int[] buffer, int startIndex, int bufferIndex) {
        // termination cases - buffer full
        // printArray(buffer, bufferIndex);

        if (bufferIndex == buffer.length) {
            printArray(buffer);
            return;
        }
        if (startIndex == a.length) {
            return;
        }
        // find candidates that go into current buffer index
        for (int i = startIndex; i < a.length; i++) {
            // place item into buffer
            //System.out.println(String.format("i= %s, startIndex=%s, bufferIndex=%s, bufferArray=%s", i,startIndex,bufferIndex,toArrayString(buffer)));
            buffer[bufferIndex] = a[i];
            // recurse to next buffer index
            printCombosHelper(a, buffer, i + 1, bufferIndex + 1);
        }
    }

    public static void printArray(int[] arr) {
        System.out.println(toArrayString(arr));
    }

    public static void printArray(int[] arr, int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(arr[i]);
            sb.append(",");

        }
        System.out.println(sb.toString().trim());
    }

    private static String toArrayString(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i : arr) {
            sb.append(i);
            sb.append(",");
        }
        return sb.toString().trim();
    }

    /**
     * Technique: Permutations/Combinations using Auxiliary BufferLevel: MediumCoin Change Problem: Given a set of coin denominations,
     * print out the different ways you can make a target amount.
     * You can use as many coins of each denomination as you like.
     *
     *  For example:
     * If coins are [1,2,5] and the target is 5, output will be:[1,1,1,1,1][1,1,1,2][1,2,2][5]
     * Questions to Clarify:
     * Q. Does [1,2] and [2,1] count as one, i.e, do we care about permutations?A. No, we only care about combinations, so [1,2] and [2,1] will count as the same.
     * Q. Can we assume that all coins will be integers greater than 0?A. Yes
     *
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

    public static void printCoinsHelper(int[] coins, int target, int startIndex, Stack<Integer> buffer, int sum) {    // termination cases
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
