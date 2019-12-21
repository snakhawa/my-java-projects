package com.snakhawa.homework;

/**
 * https://leetcode.com/problems/isomorphic-strings/description/
 */
public class IsomorphicStrings {

  public static boolean isIsomorphic(String input1, String input2) {

    if (input1.isEmpty() || input2.isEmpty()) return false;
    if (input1.length() != input2.length()) return false;

    //rel format is a1b2c3
    String input1_rle = RunlengthEncoding(input1);
    String input2_rle = RunlengthEncoding(input2);
    boolean isIso = true;
    int i = 1;
    while (i <= input1_rle.length()) {
      if (input1_rle.charAt(i) != input2_rle.charAt(i)) {
        isIso = false;
        break;
      }
      // Increase by 2,
      // since we need to compare the integer value in the rle output i.e a1b2c3
      i = i + 2;
    }
    // Adding some log information
    if (isIso) {
      System.out.println(String.format("The string '%s' and '%s' are isomorphic", input1, input2));

    } else {
      System.out.println(String.format("The string '%s' and '%s' are not isomorphic", input1, input2));
    }

    return isIso;

  }

  /*
  The idea is that we need to map a char to another one, for example, "egg" and "add", we need to constract the mapping 'e' -> 'a' and 'g' -> 'd'.
  Instead of directly mapping 'e' to 'a', another way is to mark them with same value,
  for example, 'e' -> 1, 'a'-> 1, and 'g' -> 2, 'd' -> 2, this works same.

  So we use two arrays here m1 and m2, initialized space is 256 (Since the whole ASCII size is 256, 128 also works here).
  Traverse the character of both s and t on the same position, if their mapping values in m1 and m2 are different,
  means they are not mapping correctly, returen false; else we construct the mapping,
  since m1 and m2 are both initialized as 0, we want to use a new value when i == 0, so i + 1 works here.
   */
  public static boolean isIsomorphic2(String s, String t) {
    int[] m1 = new int[256];
    int[] m2 = new int[256];
    int n = s.length();
    for (int i = 0; i < n; i++) {
      if (m1[s.charAt(i)] != m2[t.charAt(i)]) return false;
      m1[s.charAt(i)] = i + 1;
      m2[t.charAt(i)] = i + 1;
    }
    return true;
  }

  private static String RunlengthEncoding(String input) {
    int strLength = input.length();
    if (strLength < 2) return input + '1';

    StringBuilder rle = new StringBuilder();
    int count = 1;
    for (int i = 0; i < strLength - 1; i++) {
      if (input.charAt(i) == input.charAt(i + 1)) {
        count++;
      } else {
        rle.append(input.charAt(i + 1));
        rle.append(count);
        count = 1;
      }
    }
    // For the last char in the inut string add the RLE
    rle.append(input.charAt(strLength - 1));
    rle.append(count);

    return rle.toString();

  }
}
