package com.company.medium;

public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int target, int[] nums) {
        if (nums[0] >=target) {
            return 1;
        }
        int min = Integer.MAX_VALUE;
        int[] pf = new int[nums.length];
        int lst = 0;

        for (int i=1; i < nums.length; i++) {
            pf[i] = nums[i-1] + pf[i-1];
            int res = nums[i] + pf[i] - pf[lst];

            while (res > target) {
                min = Math.min(min, i-lst+1);  // 1-0+1 == 2;
                lst++;
                res = nums[i] + pf[i] - pf[lst];
            }

            //System.out.println("nums["+i+"]="+nums[i]+", p["+i+"]="+pf[i]+", lst["+lst+"]="+pf[lst]+", res="+res);

            if (res == target) {
                min = Math.min(min, i-lst+1); //4-2+1
            }
        }

        return min == Integer.MAX_VALUE ? 0: min;
    }
}
