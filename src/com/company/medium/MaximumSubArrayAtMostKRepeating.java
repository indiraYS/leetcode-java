package com.company.medium;

import java.util.HashMap;

public class MaximumSubArrayAtMostKRepeating {
    public int maxSubarrayLength(int[] nums, int k) {
        int res = 0;
        Integer found = null;
        HashMap<Integer, Integer> mp = new HashMap<>();
        int length = 0;
        int i = 0, j =0;
        int downTo;
        do {
            downTo = i;
            for (; j < nums.length; j++) // right window
            {
                found = mp.get(nums[j]);
                if (found != null) {
                    if (found == k) {
                        break;
                    }
                    found++;
                } else {
                    found = 1;
                }
                mp.put(nums[j], found);
                length++;
            }

            if (length > res) res = length;

            mp.compute(nums[i], (key, v) -> {
                return v-1;
            });
            length--;
            i++; // left window
        }
        while (i < nums.length);
        return res;
    }
    public int maxSubarrayLength11(int[] nums, int k) {
        int res = 0;
        Integer found;
        int length = 0;
        for (int i = 0; i < nums.length;i++) {
            HashMap<Integer, Integer> mp = new HashMap<>();
            length = 0;
            for (int j = i; j < nums.length; j++) {
                found =  mp.get(nums[j]);
                if (found == null) {
                    mp.put(nums[j], 1);
                } else {
                    if (found == k) {
                        break;
                    }
                    mp.compute(nums[j], (key,v) -> {
                        return v + 1;
                    });
                }
                length++;
            }
            if (length > res) res = length;
        }
        return res;
    }
}
