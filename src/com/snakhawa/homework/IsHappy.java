package com.snakhawa.homework;

import java.util.*;

public class IsHappy {

    /**
     * https://leetcode.com/problems/happy-number/description/
     * Hint : Use HashSet
     */

    public static HashSet<Integer> nset = new HashSet<Integer>();

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

    public static boolean usingRecur(int n){

        int numSum = numSquareSum(n);
        if(numSum == 1){
            System.out.println(String.format("The number is happy"));
            return true;
        }
        if(nset.contains(numSum)){
            System.out.println(String.format("The number is not happy"));
            return false;
        }
        nset.add(numSum);

        return usingRecur(numSum);
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
