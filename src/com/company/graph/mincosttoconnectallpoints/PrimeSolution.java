package com.company.graph.mincosttoconnectallpoints;

public class PrimeSolution {
    public int minCostConnectPoints(int[][] points) {
        int[][] pipes = new int[points.length][];
        int cost;
        int amount = 0;
        int[] prev;

        for (int i = 0; i < points.length; i++)
        {
            prev = pipes[i];
            for (int j = i + 1; j < points.length; j++)
            {
                cost = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);

                int[] p = new int[]{i, j, cost};

                if (prev == null) {
                    if (pipes[j]!= null && pipes[j][2] < p[2]) {
                        prev = pipes[j];
                    } else {
                        prev = p;
                    }
                } else if (prev[2] > cost) {
                    if (pipes[prev[1]] == null || pipes[prev[1]][2] < prev[2]) {
                        pipes[prev[1]] = prev;
                    }
                    prev = p;
                }

                if (pipes[j] == null || pipes[j][2] > cost) {
                    pipes[j] = p;
                }

                if (pipes[j][2] < prev[2]) {
                    prev = pipes[j];
                }

            }

            if (prev != null) {
                if ((prev[1] - i) > 1) {
                    int[] tmp;
                    int dist = prev[1];

                    for (int k = dist; k > i+1; k--) {
                        // exchange points
                        tmp = points[k-1];
                        points[k-1] = points[k];
                        points[k] = tmp;

                        // exchange distances
                        if (pipes[k-1][0] == i+1) {
                            pipes[k-1][0] = i+2;
                        }
                        tmp = pipes[k-1];
                        pipes[k-1] = pipes[k];
                        pipes[k] = tmp;
                        pipes[k-1][1] = k-1;
                        pipes[k][1] = k;
                    }

                    prev = pipes[i+1];
                }

                    amount += prev[2];
                    pipes[prev[1]] = null;
            }
        }
        return amount;
    }
}
