package com.company.easy;

/**
 * look here
 * https://leetcode.com/problems/minimum-time-visiting-all-points/?envType=daily-question&envId=2023-12-03
 */
public class MinimumTimeVisitingAllPoints {
    public int minTimeToVisitAllPoints(int[][] points)
    {
        int num = 0;

        for (int i = 1; i < points.length; i++)
        {
            if (points[i][0] == points[i-1][0]) {
                num += Math.abs(points[i][1] - points[i-1][1]);
            } else {
                if (points[i][1] == points[i-1][1]) {
                    num += Math.abs(points[i][0] - points[i-1][0]);
                } else {
                    int diffx = Math.abs(points[i][0] - points[i-1][0]);
                    int diffy = Math.abs(points[i][1] - points[i-1][1]);

                    if (diffx > diffy) {
                        num+= diffx;
                    } else {
                        num+= diffy;
                    }
                }
            }
        }

        return num;
    }
}
