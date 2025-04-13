package com.company.graph.mincosttoconnectallpoints;

import java.util.List;

import java.util.ArrayList;
import java.util.Comparator;

public class DjsSolution {
    public int minCostConnectPoints(int[][] points) {
        List<int[]> pipes = new ArrayList<>();
        for (int i=0; i < points.length-1; i++) {
            for (int j =i+1; j< points.length; j++) {
                pipes.add(new int[] {i, j, (Math.abs(points[i][0] -  points[j][0]) + Math.abs(points[i][1] -  points[j][1])) } );
            }
        }

        int cost = 0;

        pipes.sort(Comparator.comparingInt(x -> x[2]));

        DJS djs = new DJS(points.length);
        for (int[] pipe: pipes) {
            if (djs.connect(pipe[0], pipe[1])) {
                cost+=pipe[2];
            }
        }
        return cost;
    }

    class DJS {
        private int[] root;

        public DJS(int n)
        {
            this.root = new int[n];
            for (int i =0; i < root.length; i++) {
                root[i] = i;
            }
        }

        public boolean connect(int a , int b) {
            int rootA = root(a);
            int rootB = root(b);

            if (rootA == rootB) {
                return false;
            } else {
                for (int i =0; i < root.length; i++) {
                    if(root[i]==rootB) {
                        root[i] = rootA;
                    }
                }
            }
            return true;
        }
        private int root(int a) {
            if (this.root[a] != a) {
                return this.root[a] = root(this.root[a]);
            }
            return a;
        }

    }
}
