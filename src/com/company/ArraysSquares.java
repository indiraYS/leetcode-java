package com.company;

import java.util.Arrays;

public class ArraysSquares {
    public static int[] sortedSquares(int[] nums) {
        return Arrays.stream(nums)
                .peek( x->
                        System.out.println(x))
                .filter( x -> x <= 10000)
                .map(x -> x*x)
                .peek( x->
                        System.out.println(x)
                ).sorted().toArray();
//                Arrays.stream(nums)
//                        .filter( x -> x < 10000)
//                        .map(x -> x*x)
//                .sorted().toArray();
    }
}
