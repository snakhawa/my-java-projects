package com.snakhawa.crackingthecode;

/**
 * Design an algorithm and write code to remove the duplicate characters in a string without using any additional buffer.
 * NOTE: One or two additional variables are fine. An extra copy of the array is not.
 * FOLLOW UP : Write the test cases for this method.
 */
public class RemoveDuplicateCharacters {


    public static String mysolution(String input) {
        if (input.isEmpty()) return input;
        if (input.length() < 2) return input;
        boolean[] boolArray = new boolean[256];

        StringBuilder newStr = new StringBuilder();
        for (char c : input.toCharArray()) {
            if (boolArray[(int) c]) continue;
            newStr.append(c);
            boolArray[(int) c] = true;
        }
        System.out.println(String.format("The new string is: %s", newStr.toString()));
        return newStr.toString();

    }

    /**
     * Should not use any additional memory.. like array, stringbuffer etc..
     *
     * @param input
     */
    public static String withAdditionalMemory(char[] input) {
        if (input == null) return "";
        int len = input.length;
        if (input.length < 2) return input.toString();
        boolean[] boolArray = new boolean[256];
        boolArray[0] = true;
        int tail = 1;
        for (int i = 1; i < len; ++i) {
            if (!boolArray[(int) input[i]]) {
                input[tail] = input[i];
                ++tail;
                boolArray[(int) input[i]] = true;
            }

        }
        input[tail] = 0;
        return input.toString();

    }
}

/***
 * Test Cases
 * 1. null value
 * 2. single character string
 * 3. unique value
 * 4. duplicate value
 * 5. alphabetic
 * 6. nummeric
 * 7. alphanumeric
 * 8. symbols
 * 9. long string
 *
 */
