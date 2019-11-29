package com.snakhawa.homework.slidingwindow;

public class GrumpyBookstoreOwner {

  /*
    Test Cases
    GrumpyBookstoreOwner.maxSatisfied_2(new int[]{1, 0, 1, 2, 1, 1, 7, 5}, new int[]{0, 1, 0, 1, 0, 1, 0, 1}, 3);
    GrumpyBookstoreOwner.maxSatisfied(new int[]{4, 10, 10}, new int[]{1, 1, 0}, 2);
    GrumpyBookstoreOwner.maxSatisfied(new int[]{2,6,6,9}, new int[]{0,0,1,1}, 1);
   */

  public static int maxSatisfied(int[] customers, int[] grumpy, int X) {

    /*
    1 <= X <= customers.length == grumpy.length <= 20000
    0 <= customers[i] <= 1000
    0 <= grumpy[i] <= 1
    */
    if (customers == null || grumpy == null) return 0;
    if (customers.length != grumpy.length) return 0;
    if (customers.length < 1 || grumpy.length < 1 || X < 0) return 0;

    int startIndex = 0;
    int endIndex = 0;
    int unhappyCust = 0;
    int maxUnhappyCust = 0;
    int maxSatisfiedCust = 0;

    //Find the max unhappy customer window
    for (int i = 0; i < customers.length; i++) {
      unhappyCust += customers[i] * grumpy[i];

      if (i >= X) {
        //Here we are removing the previous unhappy customer which is not in the range.
        unhappyCust -= customers[i - X] * grumpy[i - X];
      }
      if (unhappyCust > maxUnhappyCust) {
        maxUnhappyCust = unhappyCust;
        endIndex = i;
      }
    }
    //The window where max customer are unhappy is between startIndex and endIndex
    startIndex = endIndex - X;
    for (int j = 0; j < customers.length; j++) {
      // If in maxUnhappyCust window, make owner NOT grumpy
      if (j > startIndex && j <= endIndex) {
        maxSatisfiedCust += customers[j];
      } else {
        //add customer when owner not grumpy
        if (grumpy[j] == 0) {
          maxSatisfiedCust += customers[j];
        }
      }
    }
    System.out.println(maxSatisfiedCust);
    return maxSatisfiedCust;

  }

}

/*
https://leetcode.com/problems/grumpy-bookstore-owner/

Today, the bookstore owner has a store open for customers.length minutes.  Every minute, some number of customers (customers[i]) enter the store, and all those customers leave after the end of that minute.

On some minutes, the bookstore owner is grumpy.  If the bookstore owner is grumpy on the i-th minute, grumpy[i] = 1, otherwise grumpy[i] = 0.  When the bookstore owner is grumpy, the customers of that minute are not satisfied, otherwise they are satisfied.

The bookstore owner knows a secret technique to keep themselves not grumpy for X minutes straight, but can only use it once.

Return the maximum number of customers that can be satisfied throughout the day.



Example 1:

Input: customers = [1,0,1,2,1,1,7,5], grumpy = [0,1,0,1,0,1,0,1], X = 3
Output: 16
Explanation: The bookstore owner keeps themselves not grumpy for the last 3 minutes.
The maximum number of customers that can be satisfied = 1 + 1 + 1 + 1 + 7 + 5 = 16.
 */
