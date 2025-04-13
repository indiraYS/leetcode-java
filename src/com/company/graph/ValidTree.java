package com.company.graph;

import java.util.Arrays;
import java.util.Comparator;

public class ValidTree {
    public boolean validTree(int n, int[][] edges) {
        DJS djs = new DJS(n);
        for (int i=0; i < edges.length; i++) {
            if (djs.connected(edges[i][0], edges[i][1])) return false;
            djs.union(edges[i][0], edges[i][1]);
        }

        Arrays.sort(edges, Comparator.comparingInt(o -> o[0]));

        return djs.isTree();
    }

    class DJS {
        private int[] parent;

        public DJS(int n)
        {
            parent = new int[n];
            for (int i=0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int x)
        {
            if (parent[x] == x) {
                return parent[x];
            }
            return find(parent[x]);
        }

        public boolean isTree() {
            for (int i = 1 ; i < parent.length; i++) {
                if (parent[i] != parent[i-1] && find(i) != find(i-1)) {
                    return false;
                }
            }
            return true;
        }

        public void union(int x, int y) {
            if (parent[y] != y) {
                parent[x] = y;
            } else parent[y] = x;
        }

        public boolean connected(int x, int y) {
            return find(x) == find(y);
        }
    }
}
