package com.company;

import java.util.Arrays;

public class ArrayRemoves {
    public static int removeElement(int[] nums, int val) {
        int idx = 0;

        for (int x = 0; x < nums.length; x ++) {
            if (nums[x]!=val) {
                nums[idx]=nums[x];
                idx += 1;
            }
        }
        for (int x = idx; x < nums.length; x++ ) {
            nums[x] = 0;
        }
        return idx;
    }

    public static int removeDuplicates(int[] nums) {
        int idx = 1;
        for (int x = 1; x < nums.length; x++) {
            if (nums[x]!=nums[x-1]) {
                nums[idx]=nums[x];
                idx += 1;
            }
        }
        for (int x = idx; x < nums.length; x++ ) {
            nums[x] = 0;
        }
        return idx;
    }
}
