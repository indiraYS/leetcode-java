package com.company.easy;

public class FindIfPathExists {
    private int[] parent;

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        this.parent = new int[n];

        for (int i = 0; i < n; i++) {
            this.parent[i] = i;
        }
        for (int[] edge : edges) {
            if (root(edge[0]) == root(edge[1])) continue;

            if (this.parent[edge[0]] != edge[0]) {
                int from = this.parent[edge[0]];
                int to = edge[0];

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
            this.parent[edge[0]] = edge[1];
        }
        return root(source) == root(destination);
    }

    private int root(int a) {
        if (this.parent[a] == a) {
            return a;
        }
        return a = root(this.parent[a]);
    }

}
