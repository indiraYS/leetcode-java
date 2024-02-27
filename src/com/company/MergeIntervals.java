package com.company;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        int intersections = 0;
        boolean search = true;
        int tmp;
        while (search) {
            search = false;
            for (int i = 0; i < intervals.length - 1; i++) {

                    if (intervals[i][0] > intervals[i+1][0]) {
                        tmp = intervals[i + 1][0];
                        intervals[i + 1][0] = intervals[i][0];
                        intervals[i][0] = tmp;
                        tmp = intervals[i + 1][1];
                        intervals[i + 1][1] = intervals[i][1];
                        intervals[i][1] = tmp;
                        search = true;
                    }
                //}
                if (intervals[i][0] == -1) {
                    continue;
                }
                if (intervals[i][1] >= intervals[i + 1][0]) {

                        if (intervals[i + 1][0] > intervals[i][0]) {
                            intervals[i + 1][0] = intervals[i][0];
                        }

                        if (intervals[i + 1][1] < intervals[i][1]) {
                            intervals[i + 1][1] = intervals[i][1];
                        }
                        intervals[i][1] = -1;
                        intervals[i][0] = -1;
                        intersections++;
                        search = true;
                }
            }
        }

        if (intersections == 0) return intervals;
        int[][] res = new int[intervals.length-intersections][];
        for (int i = 0; i < res.length; i++) {
            res[i] = intervals[i+intersections];
        }
        return res;
    }
}
