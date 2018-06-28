package com.snakhawa.homework;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an crackingthecode of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * Given nums = [2, 7, 11, 15], target = 9,
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */
public class TwoSum {

    public static int[] BruteForce(int[] nums, int target){
        for(int i =0; i< nums.length; i++){
            for(int j = i +1; j< nums.length; j++){
                if(nums[j] == target - nums[i]){
                    return new int[] {i,j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static int[] UsingHashMap(int[] nums, int target){

        Map<Integer, Integer> numsMap = new HashMap<Integer, Integer>();
        /*
        for(int i =0; i< nums.length; i++){
            numsMap.put(nums[i],i);
        }*/
        for(int j=0; j< nums.length; j++){
            int diff = target - nums[j];
            if(numsMap.containsKey(diff)){
                System.out.println(String.format("Success: The indices are %s and %s", j, numsMap.get(diff)));
                return new int[]{j,numsMap.get(diff)};
            }else
            {
                numsMap.put(nums[j],j);
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }


}
