package com.snakhawa.interview;

import java.util.Arrays;
import java.util.List;

public class plusMult {
    public static void main(String[] args) {

        Integer[] test1 = {1,2,3,4,5,6,7,8,9,10};
        Integer[] test2 ={1,3 ,5 ,7 ,9 ,11, 13 ,15 ,17 ,19};
        Integer[] test3 ={};
        Integer[] test4 ={1};
        Integer[] test5 ={1,2};
        Integer[] testOdd ={1,3 ,5 ,7 ,9 };


        System.out.println(plusMult(null));
        System.out.println(plusMult(Arrays.asList(test1)));
        System.out.println(plusMult(Arrays.asList(test2)));
        System.out.println(plusMult(Arrays.asList(test3)));
        System.out.println(plusMult(Arrays.asList(test4)));
        System.out.println(plusMult(Arrays.asList(test5)));
        System.out.println(plusMult(Arrays.asList(testOdd)));

    }


    public static String plusMult(List<Integer> A) {
        // Write your code here
        int evenProduct = calculate(A, true);
        int oddProduct = calculate(A, false);
        if(evenProduct % 2 > oddProduct %2){
            return "EVEN";
        }else if (oddProduct % 2 > evenProduct %2){
            return "ODD";
        }else{
            return "NEUTRAL";
        }


    }

    public static int calculate(List<Integer> A, boolean isEven){
        if(A == null || A.isEmpty()) return 0;

        if(A.size() == 1){
            if(isEven) return A.get(0);
            return 0;
        }
        int i = isEven? 0:1;

        int product = A.get(i);
        int sum = 0;
        i= i+2;
        while (i < A.size()){
            product = product * A.get(i);
            i = i+2;
            if(i >= A.size()) break;
            sum = product + A.get(i);
            product = sum;
            i = i+2;
        }
        return product;
    }
}
