package com.snakhawa.homework.slidingwindow;

public class MaxConsecutiveOnesIII {

  public static int longestOnes(int[] A, int K) {
  //The main logic here is there should not be more then K zeroes in a given window to get the max consecutive one's
    int zeroCount =0;
    int startIndex =0;
    int maxSum =0;
    for(int endIndex=0; endIndex < A.length; endIndex++){
      //Count the number of zeroes
      if(A[endIndex]== 0) zeroCount++;
      //If the zeroCount is > K
      if(zeroCount > K){
        // and id A[startIndex] is zero, then deduct the zero from the zeroCount
        if(A[startIndex] ==0) zeroCount--;
        // else move the startIndex index by 1 count .. This is where you are sliding the window

        startIndex++;
      }
      // IN here you can checking the max different between the endIndex and startIndex index.
      maxSum = Math.max(maxSum, endIndex-startIndex+1);
    }
    return maxSum;
  }
}
