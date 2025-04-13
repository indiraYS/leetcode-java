package com.company.medium;

public class RemoveDuplicates2 {
    public int removeDuplicates(int[] nums) {
        int dups = 0;
        int cnt = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i-1]) {
                cnt++;
                if (cnt > 2) {
                    dups++;
                }
            } else {
                cnt=1;
            }
            nums[i-dups] = nums[i];
        }

        return nums.length-dups;
    }
}
