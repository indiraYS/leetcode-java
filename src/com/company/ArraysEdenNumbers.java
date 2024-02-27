package com.company;

public class ArraysEdenNumbers {
    public int sortedSquares(int[] nums) {
        int cnt, totalCnt = 0;
        int xdiv;

        for (int num : nums) {
            if (num >= 1 /*&& num <= (5 * 10)*/) {
                cnt = 0;
                xdiv = num / 10;

                while (xdiv >= 1) {
                    cnt += 1;
                    xdiv = xdiv / 10;
                }

                cnt += 1;

                if (cnt % 2 == 0) {
                    totalCnt += 1;
                    System.out.println(num + " - " + cnt);
                }
            }
        }
        System.out.println(totalCnt);
        return totalCnt;
    }
}
