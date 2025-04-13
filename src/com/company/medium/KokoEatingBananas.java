package com.company.medium;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/koko-eating-bananas/
 */
public class KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int h) {
        int speed = 0;
        int left =1;
        int right = 1000_000_000;
        int res = right;

        while (left < right)
        {
            //speed+=1;
            speed =  (left + right) / 2; // 500_0000
            int count = 0;

            boolean flag = false;
            for (int pile : piles) {
                double devresult = ((double) pile) / speed;
                double ceilres = Math.ceil(devresult);
                count += (int) ceilres;
            }

            if (count > h) {
                left = speed+1;
                //left = speed;
            } else { // if you faster
                res = Math.min(res, speed);
                //50001
                right = speed;
            }

        }

        //System.out.println("left+" + left);
        return res;
    }
}
