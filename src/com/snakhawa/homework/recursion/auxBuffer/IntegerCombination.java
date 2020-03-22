package com.snakhawa.homework.recursion.auxBuffer;

import com.snakhawa.homework.util.Util;

public class IntegerCombination {

    /**
     * Given an array of integers, print all combinations of size X.
     *
     * @param a
     * @param x
     */
    public static void printCombos(int[] a, int x) {
        if (a == null || a.length == 0 || x > a.length)
            return;
        int[] buffer = new int[x];
        printCombosHelper(a, buffer, 0, 0);
    }

    //Given an array of integers, print all combinations of size X.
    private static void printCombosHelper(int[] a, int[] buffer, int startIndex, int bufferIndex) {
        // termination cases - buffer full
        // printArray(buffer, bufferIndex);

        if (bufferIndex == buffer.length) {
            Util.printArray(buffer, buffer.length);
            return;
        }
        if (startIndex == a.length) {
            return;
        }
        // find candidates that go into current buffer index
        for (int i = startIndex; i < a.length; i++) {
            // place item into buffer
            buffer[bufferIndex] = a[i];
            System.out.println(String.format("i= %s, startIndex=%s, bufferIndex=%s, bufferArray=%s", i, startIndex, bufferIndex, Util.toArrayString(buffer)));

            // recurse to next buffer index
            printCombosHelper(a, buffer, i + 1, bufferIndex + 1);
        }
    }

}
