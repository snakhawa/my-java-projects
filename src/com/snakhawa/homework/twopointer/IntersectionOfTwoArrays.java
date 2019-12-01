package com.snakhawa.homework.twopointer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Given two arrays, write a function to compute their intersection.
 *
 * Example 1:
 *
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2]
 * Example 2:
 *
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [9,4]
 */
public class IntersectionOfTwoArrays {

  public static int[] usingTwoPointers(int[] nums1, int[] nums2) {
    //Sort the array first
    //nums1 = [1,2,2,1], nums2 = [2,2]
    Arrays.sort(nums1); //[1,1,2,2]
    Arrays.sort(nums2); //[2,2]

    HashSet<Integer> set = new HashSet<>();
    int i = 0;
    int j = 0;

    while (i < nums1.length && j < nums2.length) {
      if (nums1[i] > nums2[j]) {
        j++;
      } else if (nums1[i] < nums2[j]) {
        i++;
      } else {
        set.add(nums1[i]);
        i++;
        j++;
      }
    }

    int[] result = new int[set.size()];
    int k = 0;
    for (int num : set) {
      result[k++] = num;
    }
    return result;

  }

  public static int[] usingHashSet(int[] nums1, int[] nums2) {
    HashSet<Integer> set1 = new HashSet<>();
    HashSet<Integer> set2 = new HashSet<>();


    for (int i : nums1) {
      set1.add(i);
    }

    for (int j : nums2) {
      if (set1.contains(j)) {
        set2.add(j);
        set1.remove(j);
      }
    }

    int[] result = new int[set2.size()];
    int k = 0;
    for (int num : set2) {
      result[k++] = num;
    }
    return result;

  }
}
