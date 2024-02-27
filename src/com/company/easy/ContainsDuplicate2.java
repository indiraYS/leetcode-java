package com.company.easy;

public class ContainsDuplicate2 {
    /**
     * Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int tmp;
        for (int i = 1; i < nums.length; i++)
        {
            if (nums[i-1] > nums[i]) {
                tmp = nums[i-1];
                nums[i-1] = nums[i];
                nums[i] = tmp;
            }
            if (Math.abs(nums[i-1] - nums[i]) <= k) return true;
        }
        return nums.length==1;
    }
}
