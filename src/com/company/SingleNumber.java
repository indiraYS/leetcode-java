package com.company;

import java.util.Arrays;

public class SingleNumber {
    /**
     * Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
     * You must implement a solution with a linear runtime complexity and use only constant extra space.
     * Example 1:
     *
     * Input: nums = [2,2,1]
     * Output: 1
     * Example 2:
     *
     * Input: nums = [4,1,2,1,2]
     * Output: 4
     * Example 3:
     *
     * Input: nums = [1]
     * Output: 1
     * @param nums
     * @return
     */
    public int singleNumberXor(int[] nums) {
        int xor = nums[0];

        for (int i = 1; i < nums.length ; i++) {
            xor = xor ^ nums[i];
        }
        return xor;
    }
    public int singleNumber(int[] nums) {
        Arrays.parallelSort(nums);

        int cnt = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i-1]) {
                if (cnt == 1) {
                    return nums[i-1];
                } else if (i == nums.length-1){
                    return nums[i];
                }
                cnt=1;
            } else {
                cnt++;
            }
        }
        return nums[0];
    }
}
