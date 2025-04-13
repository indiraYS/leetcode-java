package com.company.medium;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/minimized-maximum-of-products-distributed-to-any-store/
 */
public class MinimizedMaximumOfProductDistributed {
    public int minimizedMaximum(int n, int[] quantities) {
        Arrays.sort(quantities);
        int mid;
        int left = 1;
        int right = quantities[quantities.length-1];

        while (left < right)
        {
            mid = (left + right) / 2;
            int count = n;

            for (int i = quantities.length-1; i >-1 ;i--) {
                if (quantities[i] < mid ) {
                    count -= i+1;
                    break;
                } else {
                    count -= (int) Math.ceil((float) quantities[i] / mid);
                }
            }

            if (count < 0) {
                left=mid+1;
            } else {
                right=mid;
            }
        }

        return left;
    }
}
