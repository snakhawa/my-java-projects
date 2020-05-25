package com.snakhawa.homework.heap;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Magical Candy Bags
 * You have N bags of candy. The ith bag contains arr[i] pieces of candy, and each of the bags is magical!
 * It takes you 1 minute to eat all of the pieces of candy in a bag (irrespective of how many pieces of candy are inside),
 * and as soon as you finish, the bag mysteriously refills. If there were x pieces of candy in the bag at the beginning of the minute,
 * then after you've finished you'll find that floor(x/2) pieces are now inside.
 *
 * You have K minutes to eat as much candy as possible. How many pieces of candy can you eat?
 *
 * Example 1
 * N = 5
 * K = 3
 * arr = [2, 1, 7, 4, 2]
 * output = 14
 * In the first minute you can eat max 7 pieces of candy. That bag will refill with floor(7/2) = 3 pieces.
 * In the second minute you can eat max 4 pieces of candy from another bag. That bag will refill with floor(4/2) = 2 pieces.
 * In the third minute you can eat max 3 pieces of candy that have appeared in the first bag that you ate.
 * In total you can eat 7 + 4 + 3 = 14 pieces of candy.
 */
public class MaxCandyBags    {
    public static void main(String[] args) {
        maxCandies(new int[]{19, 78, 76, 72, 48, 8, 24, 74, 29}, 9, 3);
    }

    static int maxCandies(int[] arr, int n, int k) {
        // Write your code here
        if(arr == null || arr.length==0) return 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0; i< arr.length; i++){
            queue.add(arr[i]);
        }

        int sum = 0;
        for(int j=1;  j<=k; j++){
            int curr = queue.remove();
            sum += curr;
            queue.add((int)Math.floor(curr/2));

        }
        return sum;
    }

}
