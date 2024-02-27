package com.company.easy;

import java.util.Arrays;

public class DivideArrayIntoArraysWithMaxDifference {
    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);
        int[][] arrs = new int[nums.length/3][];
        arrs[0] = new int[] {nums[0],0,0};
        for (int i = 1; i < nums.length; i++) {
            if (i%3==0) {
                arrs[i/3] = new int[3];
                arrs[i/3][0] = nums[i];
            } else if (nums[i] - nums[i-1] <= k) {
                if (i/3>0 && arrs[i/3][1]>0
                        && arrs[i/3-1][0] == arrs[i/3][0] && arrs[i/3][0] == nums[i]) {
                    return new int[0][];
                }
                arrs[i/3][i-i/3*3 ] = nums[i];
            } else {
                return new int[0][];
            }
        }
        return arrs;
    }
}
