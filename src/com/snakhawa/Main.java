package com.snakhawa;

import com.snakhawa.homework.*;
import com.snakhawa.crackingthecode.*;


public class Main {

    public static void main(String[] args) {
        //System.out.println(IsHappy.isHappy_sol1(19));

        TwoSum.UsingHashMap(new int[]{2, 7, 11, 15}, 9);
        IsHappy.usingHashset(19);
        HasUniqueCharacters.usingArray("1oqiw");
        //System.out.println(RemoveDuplicateCharacters.withAdditionalMemory(new char[]{'a','b'}));
        IsomorphicStrings.isIsomorphic("a1w2e3r4", "q1w2e3r9");

    }
}
