package com.company.graph;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class NumberOfConnectedComponentsInAnUndirectedGraph {

    public int countComponents(int n, int[][] edges) {
        DJS djs = new DJS(n);

        for (int[] ed: edges) {
            if (!djs.connected(ed[0], ed[1])) {
                djs.union(ed[0], ed[1]);
            }
        }
        return djs.count();
    }

    class DJS {
        private int[] root;
        private int[] rank;

        public DJS(int n)
        {
            root = new int[n];
            rank = new int[n];

            for (int i=0; i < n; i++) {
                root[i] = i;
                rank[i] = 1;
            }
        }

        public int find(int x)
        {
            if (x == root[x]) {
                return x;
            }
            // Some ranks may become obsolete so they are not updated
            return root[x] = find(root[x]);
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX != rootY) {
                if (rank[rootX] > rank[rootY]) {
                    root[rootY] = rootX;
                } else if (rank[rootX] < rank[rootY]) {
                    root[rootX] = rootY;
                } else {
                    root[rootY] = rootX;
                    rank[rootX] += 1;
                }
            }
        }

        public boolean connected(int x, int y) {
            return find(x) == find(y);
        }

        public int count() {
            Set<Integer> set = new HashSet<>();
            for (int i=1; i  < root.length; i++) {
                if (root[i] != root[i-1]) {
                    set.add(find(i));
                }
            }
            return set.size();
        }
    }
}
