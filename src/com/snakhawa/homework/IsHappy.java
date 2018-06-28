package com.snakhawa.homework;

import java.util.*;

public class IsHappy {

    /**
     * https://leetcode.com/problems/happy-number/description/
     * Hint : Use HashSet
     */

    // Fails due to infinite loop
    public static boolean isHappy_sol1(int n) {
        if (n == 0) return false;
        if (n == 1) return true;
        boolean result = false;

        char[] strDigits = String.valueOf(n).toCharArray();
        int[] arrInt = new int[strDigits.length];
        for (int i = 0; i < strDigits.length; i++) {
            arrInt[i] = strDigits[i] - '0';
        }

        int sumdigitSquare = 0;
        for (int j = 0; j < arrInt.length; j++) {
            sumdigitSquare = sumdigitSquare + (arrInt[j] * arrInt[j]);
        }
        if (sumdigitSquare == 1) {
            result = true;
        } else {
            return isHappy_sol1(sumdigitSquare);
        }

        return result;

    }

    // Using hashset to break the loop
    public static boolean usingHashset(int n) {

        int initNumber = n;
        HashSet<Integer> num = new HashSet<Integer>();

        while (n != 1) {
            n = numSquareSum(n);

            if (num.contains(n)) {
                return false;
            }
            num.add(n);

        }
        System.out.println(String.format("The number %s is happy", initNumber));
        return true;
    }

    private static int numSquareSum(int n) {
        //System.out.println(String.format("Calculating square sum of number %s", n));
        int squareSum = 0;
        while (n != 0) {
            squareSum = squareSum + ((n % 10) * (n % 10));
            n = n / 10;

        }
        //System.out.println(String.format("The square sum of number is = %s", squareSum));
        return squareSum;
    }
}
