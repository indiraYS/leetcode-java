package com.company.graph;

import java.util.*;

public class EvaluateDivision {
    private HashMap<String, Integer> dictionary = new HashMap<>();
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        double[] responses = new double[queries.size()];

        int i=0;
        int idx=0;
        for (List<String> pair: equations) {
            if (dictionary.get(pair.get(0)) == null) {
                dictionary.put(pair.get(0), idx);
                idx++;
            }
            if (dictionary.get(pair.get(1)) == null) {
                dictionary.put(pair.get(1), idx);
                idx++;
            }

            //djs.union(dictionary.get(pair.get(0)), dictionary.get(pair.get(1)), values[i]);
            i++;
        }
        DJS djs = new DJS(dictionary.size());
        i=0;
        for (List<String> pair: equations) {
            djs.union(dictionary.get(pair.get(0)), dictionary.get(pair.get(1)), values[i]);
            i++;
        }

        i=-1;
        for (List<String> pair: queries) {
            i++;
            if (dictionary.get(pair.get(0)) == null || dictionary.get(pair.get(1)) == null )
            {
                responses[i] = -1; continue;
            }

            if (!djs.connected(dictionary.get(pair.get(0)), dictionary.get(pair.get(1)))) {
                responses[i] = -1; continue;
            }

            responses[i] = djs.calc(dictionary.get(pair.get(0)), dictionary.get(pair.get(1)));
        }

        return responses;
    }

    class DJS {
        private int[] parent;

        private double[] rank;

        public DJS(int n)
        {
            parent = new int[n];
            rank= new double[n];
            for (int i=0; i < n; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        public int find(int x)
        {
            if (parent[x] == x) {
                return parent[x];
            }
            return find(parent[x]);
        }

        public void union(int x, int y, double cost) {
            if (parent[y]!=y && parent[x]==x) {
                rank[x] = 1/cost;
                parent[x] = y;
            } else {
                if (parent[y] != y) {
                    int par = y;
                    LinkedList<int[]> lst = new LinkedList<>();
                    do {
                        lst.push(new int[]{parent[par], par});
                        par = parent[par];
                    } while (par != parent[par]);

                    do {
                        int[] pair = lst.pop();
                        parent[pair[0]] = pair[1];
                        rank[pair[0]] = 1/rank[pair[1]];
                    } while (lst.size() >0);
                }

                parent[y] = x;
                rank[y] = cost;
            }
        }

        public double calc(int x, int y) {
            //if (x < y) {
            return cost(y) / cost(x);
        }

        private double cost(int x) {
            if (x == parent[x]) {
                return 1;
            }
            return rank[x] * cost(parent[x]);
        }

        public boolean connected(int x, int y) {
            return find(x) == find(y);
        }
    }
}
