package com.snakhawa.homework.twopointer;

public class ReverseAString {

  public static void usingTwoPointer(char[] s) {
        if(s.length <= 1){
          return;
        }
        int left = 0;
        int right = s.length -1;

        while (left < right){
          char temp = s[left];
          s[left] = s[right];
          s[right] = temp;
          left++;
          right--;
        }

  }
}
