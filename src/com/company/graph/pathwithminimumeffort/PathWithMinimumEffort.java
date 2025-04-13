package com.company.graph.pathwithminimumeffort;

import java.util.LinkedList;

public class PathWithMinimumEffort {
    int[][] directories = new int[][]{new int[]{-1, 0}, new int[]{1, 0}, new int[]{0, 1}, new int[]{0, -1}};

    public int minimumEffortPath(int[][] heights) {
        LinkedList<Pair> q = new LinkedList<>();


        int[][] efforts = new int[heights.length][heights[0].length];
        for (int i = 1; i < heights.length; i++) {
            for (int j = 1; j < heights[0].length; j++) {
                efforts[i][j] = Integer.MAX_VALUE;
            }
        }
        q.add(new Pair(0, 0));

        while (!q.isEmpty()) {
            Pair dot = q.poll();
            for (int[] dir : directories) {
                if ((dot.i + dir[0]) < heights.length &&
                        dot.i + dir[0] > -1 &&
                        (dot.j + dir[1]) < heights[0].length &&
                        dot.j + dir[dot.j] > -1) {
                    int current = efforts[dot.i + dir[0]][dot.j + dir[1]];

                    int next = Math.max(efforts[dot.i][dot.j],
                            Math.abs(heights[dot.i][dot.j] - heights[dot.i + dir[0]][dot.j + dir[1]])
                    );

                    if (next < current) {
                        efforts[dot.i + dir[0]][dot.j + dir[1]] = next;
                        q.add(new Pair(dot.i + dir[0], dot.j + dir[1]));
                    }
                }
            }
        }
        return efforts[heights.length - 1][heights[0].length - 1];
    }

    class Pair {
        Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public int i;
        public int j;
    }
}
