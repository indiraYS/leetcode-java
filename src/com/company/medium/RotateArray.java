package com.company.medium;

import java.util.Arrays;

public class RotateArray {
    public void rotate(int[] nums, int k) {
        int d = k;
        if (k > nums.length) {
            d = k%nums.length;
        }
        if (d==0) return ;

       int[] mem = Arrays.copyOf(nums, nums.length);

        for(int i =0; i < nums.length; i++)
        {
            int idx = i - d; //0+3
            if (idx < 0) {
                idx = nums.length + idx;
            }
            nums[i] = mem[idx];
        }
    }
}
