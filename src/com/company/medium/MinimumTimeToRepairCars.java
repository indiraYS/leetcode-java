package com.company.medium;

import java.util.Arrays;

public class MinimumTimeToRepairCars {
    public long repairCars(int[] ranks, int cars) {
        Arrays.sort(ranks);
        long left = 1;
        long right = (long) ranks[ranks.length-1] * cars * cars;
        long res = right;
        //long nmb = Arrays.;
        while (left < right) {

            long time = (long) (left + right)/2;
            if (canRepairAll(ranks, cars, time)) {
                right = time;
                res = Math.min(res, time);
            } else {
                left = time+1;
            }

        }
        return res;
    }

    private boolean canRepairAll(int[] ranks, int cars, long time) {
        int cnt = 0;
        for (int r: ranks) {
            long left = (time / r); // 3/2 =1
            double sqrt = Math.sqrt(left); // 1
            cnt += (int) sqrt;
            if (cnt >= cars) return true;
        }
        return cnt >= cars;
    }
}
