package com.snakhawa.homework.twopointer;

/**
 * Given an array nums and a value val, remove all instances of that value in-place and return the new length.
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.

 * Example 1:
 * Given nums = [3,2,2,3], val = 3,
 * Your function should return length = 2, with the first two elements of nums being 2.
 * It doesn't matter what you leave beyond the returned length.
 */
public class RemoveElements {

  public static int removeElement(int[] nums, int val) {

    int left =0;

    for(int right=0; right< nums.length; right++){
      if(nums[right] != 3){
        nums[left] = nums[right];
        left++;
      }
    }
    return left;

  }

  public static int removeElement2(int[] nums, int val) {
    int i = 0;
    int n = nums.length;
    while (i < n) {
      if (nums[i] == val) {
        nums[i] = nums[n - 1];
        // reduce array size by one
        n--;
      } else {
        i++;
      }
    }
    return n;
  }
}
