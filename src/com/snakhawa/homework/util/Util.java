package com.snakhawa.homework.util;

public class Util {

    public static void printArray(int[] arr, int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(arr[i]);
            sb.append(",");

        }
        System.out.println(sb.toString().trim());
    }

    public static void printArray(char[] arr, int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(arr[i]);
            sb.append(",");

        }
        System.out.println(sb.toString().trim());
    }

    public static String toArrayString(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i : arr) {
            sb.append(i);
            sb.append(",");
        }
        return sb.toString().trim();
    }

    public static String toArrayString(char[] arr) {
        StringBuilder sb = new StringBuilder();
        for (char i : arr) {
            sb.append(i);
            sb.append(",");
        }
        return sb.toString().trim();
    }
}
