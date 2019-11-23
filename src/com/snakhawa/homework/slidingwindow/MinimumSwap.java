package com.snakhawa.homework.slidingwindow;

public class MinimumSwap {


    public static int slidingWindow(int[] arr){

        if(arr.length < 1) return 0;

        int maxOnes=0;
        for(int i: arr){
            if(i==1) maxOnes++;
        }

        int minZero =0;
        int runZero =0;
        int right =0;

        for(int left=right; right < arr.length; right++){
            if(arr[right]==0) runZero++;

            if(right-left+1 >= maxOnes){
                if(minZero == 0){
                    minZero = runZero;
                }
                minZero = Math.min(runZero, minZero);
                if(arr[left]==0) runZero--;
                left++;
            }
        }
        return minZero;
    }

    public static int minSwaps(int[] data) {
        int numOfOnes = 0;
        for(int num : data) {
            if(num == 1) {
                numOfOnes++;
            }
        }

        int left = 0, right = 0, counter = 0, max = 0;   // max # of 1s in current window
        while(right < data.length) {
            while(right < data.length && right - left < numOfOnes) {  // window size of numOfOnes
                if(data[right++] == 1) {
                    counter++;
                }
            }
            max = Math.max(max, counter);
            if(right == data.length) {
                break;
            }

            if(data[left++] == 1) {
                counter--;
            }
        }
        return numOfOnes - max;
    }

  /*
    Given a binary array data, return the minimum number of swaps required to group all 1’s present in the array together in any placein the array.
Example 1:

Input: [1,0,1,0,1]
Output: 1
Explanation:
There are 3 ways to group all 1's together:
[1,1,1,0,0] using 1 swap.
[0,1,1,1,0] using 2 swaps.
[0,0,1,1,1] using 1 swap.
The minimum is 1.
Example 2:

Input: [0,0,0,1,0]
Output: 0
Explanation:
Since there is only one 1 in the array, no swaps needed.
Example 3:

Input: [1,0,1,0,1,0,0,1,1,0,1]
Output: 3
Explanation:
One possible solution that uses 3 swaps is [0,0,0,0,0,1,1,1,1,1,1].


Note:

1 <= data.length <= 10^5
0 <= data[i] <= 1
     */
}
