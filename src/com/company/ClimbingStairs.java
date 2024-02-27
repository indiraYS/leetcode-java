package com.company;

import java.util.Arrays;

public class ClimbingStairs {
    private Integer count = 0;

    /**
     * You are climbing a staircase. It takes n steps to reach the top.
     *
     * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
     * @param n
     * @return
     */
    public int climbStairs(int n)
    {
        int[] paths = new int[n];
        Arrays.fill(paths, 1);
        if (n > 1) {
            paths[n-2] = 2;
        }

        for (int i = n-3; i > -1; i--) {
            paths[i] = paths[i+1] + paths[i+2];
        }
        return paths[0];
    }

    private void climb(int cur, int amount, int target) {
        cur+= amount;
        if (cur == target) {
            count++;
            return;
        }
        if (cur > target) return;
        climb(1, cur, target);
        climb(2, cur, target);
    }
}
