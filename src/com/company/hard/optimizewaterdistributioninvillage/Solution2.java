package com.company.hard.optimizewaterdistributioninvillage;

import java.util.*;

public class Solution2 {
    List<DSU> nodes = new LinkedList<>();
    // stupid but works
    // 1719586
    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        int[] parent = new int[n];
        System.out.println("---");
        System.out.println(Arrays.toString(wells));
        System.out.println("---");
        for (int i=0; i < wells.length; i++) {
            parent[i] = i;
        }

        nodes.add(new DSU(wells, parent));
        Arrays.sort(pipes, Comparator.comparingInt(x -> x[2]));

        for (int [] pipe: pipes) {
            pipe[0] = pipe[0]-1;
            pipe[1] = pipe[1]-1;

            ArrayList<DSU> newDsus = new ArrayList<>();
            for (DSU dsu: nodes) {
                if (dsu.root(pipe[0]) == dsu.root(pipe[1])) {
                    System.out.println("here 1");
                    continue;
                }

                //todo сделать втупую
                if (dsu.cost[pipe[0]] > pipe[2] && dsu.cost[pipe[1]] > pipe[2]) {
                    dsu.parent[pipe[0]] = pipe[1];

                    int prevcost = dsu.cost[pipe[0]];
                    dsu.cost[pipe[0]] = pipe[2];
                    DSU newDsu = new DSU(dsu.cost, dsu.parent);

                    newDsu.cost[pipe[0]] = prevcost;
                    newDsu.cost[pipe[1]] = pipe[2];
                    newDsus.add(newDsu);
                } else if (dsu.cost[pipe[0]] > pipe[2]) {
                    dsu.parent[pipe[0]] = pipe[1];
                    dsu.cost[pipe[0]] = pipe[2];
                } else if (dsu.cost[pipe[1]] > pipe[2]) {
                    dsu.parent[pipe[0]] = pipe[1];
                    dsu.cost[pipe[1]] = pipe[2];
                }
            }
            nodes.addAll(newDsus);
        }


System.out.println("-------------");

        int min =  Integer.MAX_VALUE;
        int idx = 0;
        for (DSU dsu: nodes) {
            int cur = Arrays.stream(dsu.cost).sum();
            if (cur < min || cur== 1698310) {
                min = cur;
                System.out.println(cur);
                System.out.println(Arrays.toString(dsu.parent));
                System.out.println(Arrays.toString(dsu.cost));
                System.out.println("-------------");
            }
            System.out.println(cur);
            idx++;
        }
        // 11653, 13613, 38026, 20988, 24745, 63921, 2696, 551, 8331, 90816, 39145, 27535, 38548, 26329, 56884, 61337, 23634, 43503, 51565, 21487, 8146, 59100, 58291, 17526, 26113, 49779, 17595, 69716, 32588, 4917, 14854, 54266, 43304, 16139, 40380, 6076, 19520, 40417, 10838, 38815, 17422, 22943, 56259, 109, 69872, 12420, 21717, 4707, 68733, 70199
        // 62693, 87782, 78682, 81671, 24745, 65255, 78647, 44719, 8331, 90816, 72429, 27535, 38548, 26329, 56884, 61337, 54924, 89648, 60045, 68882, 8146, 86370, 88355, 17526, 26113, 49779, 43781, 88498, 92375, 4917, 14854, 54266, 55725, 75875, 40380, 56552, 19520, 40417, 10838, 38815, 17422, 22943, 96316, 109, 92321, 12420, 21717, 4707, 68733, 70199
        // 62693, 11653, 38026, 20988, 13613, 63921, 2696, 551, 8331, 90816, 39145, 27535, 38548, 26329, 56884, 61337, 23634, 43503, 51565, 17595, 8146, 59100, 58291, 17526, 26113, 49779, 43781, 69716, 32588, 4917, 14854, 54266, 43304, 16139, 40380, 6076, 19520, 40417, 10838, 38815, 17422, 22943, 56259, 109, 69872, 12420, 21717, 4707, 68733, 70199
        return min;
    }

    private class DSU {
        public int[] parent;
        public int[] cost;

        public DSU(int[] cost, int[] parent) {
            this.parent = Arrays.copyOf(parent, parent.length);
            this.cost = Arrays.copyOf(cost, cost.length);
        }

        public int root(int a) {
            if (parent[a] != a) {
                return root(parent[a]);
            }
            return a;
        }
    }
}
