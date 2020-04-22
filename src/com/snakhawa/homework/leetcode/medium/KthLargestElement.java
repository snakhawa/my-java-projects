package com.snakhawa.homework.leetcode.medium;

import java.util.Random;

public class KthLargestElement {
    public static void main(String[] args) {
//        int[] input = {3,2,3,1,2,4,5,5,6};
        int[] input = {3, 7, 4, 6, 5, 4, 3};
        int k = 3;
        int result = findKthLargest(input, k);
        System.out.println(result);
    }

    public static int findKthLargest(int[] nums, int k) {

        return partition(nums, 0, nums.length - 1, nums.length - k);
    }

    public static int findKthSmallest(int[] nums, int k) {

        return partition(nums, 0, nums.length - 1, k - 1);
    }


    public static int partition(int[] nums, int start, int end, int target) {

        int pivot = start + (end - start) / 2;
        int result = singlePartition(nums, start, end, pivot);

        if (result < target) {
            return partition(nums, result + 1, end, target);
        } else if (result > target) {
            return partition(nums, start, result - 1, target);
        } else {
            return nums[result];
        }
    }

    public static int singlePartition(int[] nums, int start, int end, int pivot) {
        swap(nums, start, pivot);
        int less = start;
        for (int i = start + 1; i <= end; i++) {
            if (nums[i] <= nums[start]) {
                swap(nums, i, ++less);
            }
        }
        swap(nums, start, less);
        return less;
    }


    public static void swap(int[] a, int i, int j) {

        int temp = a[j];
        a[j] = a[i];
        a[i] = temp;
    }

    public static int getRandom(int start, int end) {
        if (start > end)
            System.out.println();
        return new Random().nextInt(end - start + 1) + start;
    }
}
