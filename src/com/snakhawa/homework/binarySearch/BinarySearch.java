package com.snakhawa.homework.binarySearch;

public class BinarySearch {

    public static void main(String[] args) {

        System.out.println(findFirstOccurrence(new int[]{1, 3, 5, 5, 7, 9}, 5));
        System.out.println(findFirstOccurrenceII(new int[]{1, 3, 5, 5, 7, 9}, 5));
    }

    /**
     * Given a sorted array, find the target index using binary search
     *
     * @param input
     * @param target
     * @return
     */
    public static int findTargetIndex(int[] input, int target) {
        if (input == null || input.length < 1) return -1;
        int high = 0;
        int low = input.length - 1;
        while (high <= low) {
            int mid = low + ((high - low) / 2);
            if (target > input[mid]) {
                high = mid + 1;
            } else if (target < input[mid]) {
                low = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    /**
     * Given a sorted array with duplicates, find the first occurrence of the duplicate target
     *
     * @param input
     * @param target
     * @return
     */
    public static int findFirstOccurrence(int[] input, int target) {
        if (input == null || input.length < 1) return -1;
        int low = 0;
        int high = input.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) / 2);
            if (target > input[mid]) {
                high = mid + 1;
            } else if (target < input[mid] || target == input[mid] && mid > 0 && target == input[mid - 1]) {
                low = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static int findFirstOccurrenceII(int[] input, int target) {
        if (input == null || input.length < 1) return -1;
        int first = -1;
        int low = 0;
        int high = input.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) / 2);
            if (input[mid] == target) {
                first = mid;
                high = mid - 1;
            } else if (target > input[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return first;
    }

    /*
    Search for a Peak: A peak element in array A is an A[i] where its adjacent elements are less than A[i]. So, A[i - 1] < A[i] and A[i + 1] < A[i].
    Assume there are no duplicates. Also, assume that A[-1] and A[length] are negative infinity (-∞). So A[0] can be a peak if A[1] < A[0].

        A = [1,3,4,5,2] => Peak = 5
        A = [5,3,1] => Peak = 5
        A = [1,3,5] => Peak = 5

     */
    public static int findPeak(int[] input, boolean goRight) {
        if (input == null || input.length < 1) return -1;
        int low = 0;
        int high = input.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int left = (mid > 0) ? input[mid - 1] : Integer.MIN_VALUE;
            int right = (mid < input.length - 1) ? input[mid + 1] : Integer.MIN_VALUE;

            if (left > input[mid] && right < input[mid]) {
                high = mid - 1;
            } else if (left < input[mid] && right > input[mid]) {
                low = mid + 1;
            } else if (left > input[mid] && right > input[mid]) {
                if (goRight) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            } else {
                return input[mid];
            }
        }
        return -1;
    }


}
