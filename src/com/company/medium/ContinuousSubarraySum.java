package com.company.medium;

public class ContinuousSubarraySum {
    public boolean checkSubarraySum(int[] nums, int k) {
        int[] pf = new int[nums.length];
        pf[0] = nums[0];

        for (int i = 1; i < nums.length ; i++) {
            if (nums[i] == 0 && nums[i-1]==0) return true;

            pf[i] = pf[i-1] + nums[i];

            if (pf[i] > 0 && ((double)pf[i])%k == 0) {
                return true;
            }

            for (int j = i-2;  j > 0; j--)
            {
                if ((pf[i] - pf[j]) < k) break;
                // if ((pf[i] - pf[j]) == 0 && k > 0) continue;
                if (((double)(pf[i] - pf[j]))%k == 0)
                {
                    return true;
                }
            }
        }
        return false;
    }
}
