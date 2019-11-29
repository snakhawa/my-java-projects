package com.snakhawa.homework.slidingwindow;
import java.util.Arrays;

public class PermutationInString {

  /**
   * Test Cases :
   * PermutationInString.usingSort("egr", "sageer");
   * PermutationInString.usingSort("ega", "sageer");
   *
   */
  public static boolean usingSort(String s1, String s2){

    if (s1.length() > s2.length()) return false;
    String sortedS1 = sort(s1);

    for (int i=0; i <= s2.length() - s1.length(); i++){
      String subS2 = s2.substring(i, i+ s1.length());
      if(sortedS1.equals(sort(subS2))) return true;
    }
    return false;

  }

  public static boolean usingSlidingWindow(String s1, String s2){
    if (s1.length() > s2.length()) return false;
    int[] s1Map = new int[26];
    int[] s2Map = new int[26];
    for (int i=0; i< s1.length(); i++){
      s1Map[s1.charAt(i) - 'a']++;
      s2Map[s2.charAt(i) - 'a']++;
    }

    for (int j=0; j < s2.length() - s1.length(); j++){
      if(compare(s1Map,s2Map)){
        return true;
      }
      s2Map[s2.charAt(j) - 'a']--;
      s2Map[s2.charAt(j + s1.length()) - 'a']++;
    }
    return compare(s2Map,s1Map);

  }

  public static boolean compare(int[] s1, int[] s2){
    for(int i=0; i< 26; i++){
      if(s1[i] != s2[i]){
        return false;
      }
    }
    return true;
  }

  public static String sort(String input){
    char[] inputArr = input.toCharArray();
    Arrays.sort(inputArr);
    return new String(inputArr);
  }
}
