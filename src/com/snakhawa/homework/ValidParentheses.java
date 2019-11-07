package com.snakhawa.homework;

import java.util.HashMap;
import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Note that an empty string is also considered valid.
 * @param s
 * @return
 *
 * - check for empty and null string
 * - check for even length of the string
 *
 */
public class ValidParentheses {

  public static boolean isValid(String s){
    if (s.isEmpty()) return true;
    if (s.length() % 2 != 0) return false;

    HashMap<Character, Character> symbolsMap = new HashMap<>();
    symbolsMap.put(')', '(');
    symbolsMap.put(']', '[');
    symbolsMap.put('}', '{');
    symbolsMap.put(' ', ' ');

    Stack<Character> stack = new Stack<Character>();

    char[] charArr = s.toCharArray();
    for (char c: charArr) {
      if(symbolsMap.containsKey(c)){
        char topElement = stack.empty() ?  '#' : stack.pop();

        if (topElement != symbolsMap.get(c)){
          return false;
        }
      }
      else
      {
        stack.push(c);
      }

    }
    return stack.empty();
  }
}
