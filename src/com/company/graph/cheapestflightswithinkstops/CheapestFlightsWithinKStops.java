package com.company.graph.cheapestflightswithinkstops;

import java.util.*;

public class CheapestFlightsWithinKStops {

    // Bellman Ford Algorithm
    public int findCheapestPrice11(int n, int[][] flights, int src, int dst, int k) {
        if (src == dst) {
            return 0;
        }

        int[] previous = new int[n];
        int[] current = new int[n];
        for (int i = 0; i < n; i++) {
            previous[i] = Integer.MAX_VALUE;
            current[i] = Integer.MAX_VALUE;
        }
        previous[src] = 0;
        for (int i = 1; i < k + 2; i++) {
            current[src] = 0;
            for (int[] flight : flights) {
                int previous_flight = flight[0];
                int current_flight = flight[1];
                int cost = flight[2];

                if (previous[previous_flight] < Integer.MAX_VALUE) {
                    current[current_flight] = Math.min(current[current_flight],
                            previous[previous_flight] + cost);
                }
            }
            previous = current.clone();
        }
        return current[dst] == Integer.MAX_VALUE ? -1 : current[dst];
    }

    // 4, {sf}, 0, 3, 1
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<Integer>[] adj = new List[n];
        List<Integer> lnk;

        LinkedList<Integer> p = new LinkedList<>();
        int[] dp = new int[n];
        int[] dp1 = new int[n];
        p.add(src);
        for (int i = 0; i < flights.length; i++) {
            lnk = adj[flights[i][0]];
            if (lnk == null) lnk = new ArrayList<>();
            adj[flights[i][0]] = lnk;
            lnk.add(i);
        }

        int j, m;

        m = adj[src] != null ? 1 : 0;

        for (int i = 1; i < k+2; i++) {
            int z = 0;
            while (p.size() > 0 && m > 0) {
                int point = p.poll();
                lnk = adj[point];
                m--;
                if (lnk != null) {
                    for (int ln : lnk) {
                        int dest = flights[ln][1];
                        if (dp1[dest] == 0 || dp[point] + flights[ln][2] < dp1[dest]) {
                            dp1[dest] = dp[point] + flights[ln][2];
                            p.add(dest);
                            z++;
                        }
                    }
                }
            }
            dp = dp1.clone();
            m = z;
        }
        return dp1[dst] == 0 ? -1 : dp1[dst];
    }
}
