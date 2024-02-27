package com.company;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.
 * Return true if you can reach the last index, or false otherwise.
 */
public class JumpGame {
    AtomicInteger cnt = new AtomicInteger(0);
    Map<Integer, Boolean> st = new HashMap<>();
    public boolean canJump(int[] nums) {
        try {
            return has(0, nums[0], nums);
        } catch (Throwable e) {
            System.out.println(cnt.get());
            throw e;
        }
    }

    private boolean has(int i, int j,  int[] nums) {
        if (i >= nums.length-1 || j >= nums.length-1 ) return true;
        if (nums[i] == 0) return false;

        while (j > i)
        {
            if (st.get(j) == null) {
                st.put(j, false);
                if (has(j, j + nums[j], nums)) {
                    return true;
                }
            }
            j--;
        }
        return false;
    }

    private boolean has(int[] nums) {
        if (0 >= nums.length-1 || nums[0] >= nums.length-1 ) return true;
        if (nums[0] == 0) return false;

        int idx = maxIdx(nums, 0, nums[0]);
        int limit = idx + nums[idx];
        while (idx <= limit) {
            if (idx >= nums.length-1 || idx + nums[idx] >= nums.length-1 ) return true;
            if (nums[idx] == 0) return false;

            idx = maxIdx(nums, idx, idx + nums[idx]);
            idx = idx + nums[idx];
            limit = idx + nums[idx];
        }
        return false;
    }

    private int maxIdx(int[] nums, int st, int end) {
        int max = nums[st];
        int idx = st;
        for (int i = st+1; i <= end; i++) {
            if (nums[i] >= max) {
                max = nums[i];
                idx = i;
            }
        }
        return idx;
    }
}
