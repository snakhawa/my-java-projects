package com.snakhawa.homework.twopointer;

/**
 * Given an array of integers A sorted in non-decreasing order, return an array of the squares of each number, also in sorted non-decreasing order.
 * Example 1:
 *
 * Input: [-4,-1,0,3,10]
 * Output: [0,1,9,16,100]
 */
public class SortedSquare {

  public static int[] usingTwoPointer(int[] arr){
    //Step 1. Find the index where -ve integer ends i.e
    int leftIdx =0;
    int rightIdx= 0;
    while(arr[rightIdx] < 0){
      rightIdx++;
    }
    leftIdx = rightIdx-1;

    //Create a new array to fill in the sorted Square of Integers
    int[] sortedSum = new int[arr.length];
    int t =0;

    // Compare Square of leftIdx and rightIdx
    while( leftIdx >= 0 && rightIdx < arr.length){
      if(arr[leftIdx] * arr[leftIdx] > arr[rightIdx] * arr[rightIdx]){
        sortedSum[t++] = arr[rightIdx] * arr[rightIdx];
        rightIdx++;
      }else
      {
        sortedSum[t++] = arr[leftIdx] * arr[leftIdx];
        leftIdx--;
      }
    }
    // Sort the remaining integer before leftIdx
    while(leftIdx > 0){
      sortedSum[t++] = arr[leftIdx] * arr[leftIdx];
      leftIdx--;
    }

    //Sort the remaining integer after rightIdx
    while(rightIdx< arr.length){
      sortedSum[t++] = arr[rightIdx] * arr[rightIdx];
      rightIdx++;
    }

    return sortedSum;

  }
}
