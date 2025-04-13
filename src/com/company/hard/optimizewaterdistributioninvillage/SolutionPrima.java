package com.company.hard.optimizewaterdistributioninvillage;

import java.util.*;

public class SolutionPrima {
    private int[] parent;


    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        parent = new int[wells.length];

        HashMap<Integer, Integer> minMap = new HashMap<>();

        for (int i = 0; i < wells.length; i++) {
            parent[i] = i;
            minMap.put(i, wells[i]);
        }

        Arrays.sort(pipes, Comparator.comparingInt(x -> x[2]));

        int amount = 0;
        for (int i = 0; i < pipes.length; i++) {

            int a = pipes[i][0] - 1;
            int b = pipes[i][1] - 1;
            int rootA = root(a);
            int rootB = root(b);
            if (rootA == rootB) continue;

            int minAUnion = minMap.get(rootA);
            int minBUnion = minMap.get(rootB);

            if (pipes[i][2] > minAUnion && pipes[i][2] > minBUnion) {
                continue;
            }
            int curMin = Math.min(minAUnion, minBUnion);

            if (b == rootB) {
                parent[b] = a;
                minMap.remove(b);
                minMap.compute(rootA, (k, v) -> curMin);
            } else if (a==rootA) {
                parent[a] = b;
                minMap.remove(a);
                minMap.compute(rootB, (k, v) -> curMin);
            } else {
                int from;
                int to;

                if (minAUnion > minBUnion) {
                    from = a;
                    to = b;
                    minMap.remove(rootA);
                } else {
                    minMap.remove(rootB);
                    from = b;
                    to = a;
                }

                int nextFrom;
                int nextTo;
                while (from != -1) {
                    nextFrom = from;
                    nextTo = to;
                    if (parent[nextFrom] != nextFrom) {
                        to = from;
                        from = parent[from];
                    } else {
                        from = -1;
                    }
                    parent[nextFrom] = nextTo;
                }
            }

            amount += pipes[i][2];
        }


        for (Map.Entry<Integer, Integer> entry : minMap.entrySet()) {
            amount += entry.getValue();
        }

        return amount;
    }


    private int root(int a) {
        if (a == parent[a]) return a;
        return root(parent[a]);
    }
}
