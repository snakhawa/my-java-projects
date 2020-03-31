package com.snakhawa.homework.recursion.auxBuffer;

import java.util.Stack;

public class CoinsCombination {

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
