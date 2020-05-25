package com.snakhawa.homework.heap;

import java.util.Iterator;
import java.util.PriorityQueue;

/**
 * You're given a list of n integers arr[0..(n-1)].
 * You must compute a list output[0..(n-1)] such that, for each index i (between 0 and n-1, inclusive),
 * output[i] is equal to the product of the three largest elements out of arr[0..i]
 * (or equal to -1 if i < 2, as arr[0..i] then includes fewer than three elements).
 *
 * Note that the three largest elements used to form any product may have the same values as one another, but they must be at different indices in arr.
 * Example 1
 * n = 5
 * arr = [1, 2, 3, 4, 5]
 * output = [-1, -1, 6, 24, 60]
 * The 3rd element of output is 3*2*1 = 6, the 4th is 4*3*2 = 24, and the 5th is 5*4*3 = 60.
 */
public class LargestTripleProducts {

    public static void main(String[] args) {
        findMaxProduct(new int[]{1, 2, 3, 4, 5});

    }

    static int product(PriorityQueue<Integer> queue) {
        int product = 1;
        Iterator value = queue.iterator();
        while (value.hasNext()) {
            product = product * (int) value.next();
        }
        return product;
    }

    static int[] findMaxProduct(int[] arr) {
        // Write your code here
        int[] result = new int[arr.length];
        if (arr == null || arr.length == 0) return result;
        PriorityQueue<Integer> maxHeap = new PriorityQueue();

        for (int i = 0; i < arr.length; i++) {
            maxHeap.add(arr[i]);
            if (maxHeap.size() > 3) {
                maxHeap.poll();
            }
            if (i + 1 - 3 >= 0) {
                result[i] = product(maxHeap);
            } else {
                result[i] = -1;
            }
        }
        return result;

    }
}
