package com.snakhawa.homework.leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

Find all the elements of [1, n] inclusive that do not appear in this array.

Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.

Example:

Input:
[4,3,2,7,8,2,3,1]

Output:
[5,6]
 */
public class FindDisappearedNumbers {


  public static List<Integer> usingIndexOf(int[] nums) {

    String input = Arrays.toString(nums);
    List<Integer> output = new ArrayList<Integer>();
    for(int i =1; i <= nums.length ; i++){
      String c = Integer.toString(i);
      if(input.indexOf(c) < 0){
        output.add(i);
      }
    }

    return output;

  }

  public static List<Integer> usingCounters(int[] nums) {

    int[] counter = new int[nums.length + 1];
    for(int i= 0; i < nums.length ; i++){
      counter[nums[i]] = counter[nums[i]] + 1;
    }

    List<Integer> result = new ArrayList<Integer>();

    for(int i=1; i < counter.length ; i++){
      if (counter[i] == 0){
        result.add(i);
      }
    }

    return result;

  }
}
