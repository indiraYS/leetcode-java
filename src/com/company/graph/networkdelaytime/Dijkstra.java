package com.company.graph.networkdelaytime;
import java.util.*;

public class Dijkstra {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<Integer>[] link = new List[n]; // int [2][parent_id, id times, int prevcost]
        for (int i = 0; i < times.length; i++) {
            List<Integer> lnk = link[times[i][0]-1];
            if (lnk == null) {
                lnk = new ArrayList<Integer>();
                link[times[i][0]-1] = lnk;
            }
            lnk.add(i);
        }
        if (link[k-1]==null) return -1;
        int[][] cost = new int[n][];
        // parent, finalcost, isFinal
        cost[k-1] = new int[] {-1, 0, 0};
        LinkedList<Integer> q = new LinkedList<>();
        q.add(k-1);
        int[] time;
        while (!q.isEmpty()) {
            int node = q.removeFirst();

            List<Integer> links = link[node];
            int isFinal = 1;
            if (links != null) {
                for (int i = 0; i < links.size(); i++) {
                    time = times[links.get(i)];

                    if (cost[time[1]-1] == null) {
                        cost[time[1]-1] = new int[] {node, time[2] + cost[node][1], 1};
                        q.add(time[1]-1);
                        isFinal = 0;
                    }  else {
                        if (cost[time[1]-1][1] > cost[node][1] + time[2]) {
                            cost[time[1]-1][0] = node;
                            cost[time[1]-1][1] = time[2] + cost[node][1];
                            q.add(time[1]-1);
                            isFinal = 0;
                        }
                    }
                }
            }
            cost[node][2] = isFinal;
        }

        int amount = -1;
        for (int[] c: cost) {
            if (c==null) return -1;
            if (c[2] == 1) {
                if (c[1] > amount) {
                    amount = c[1];
                }
            }
        }
        return amount;
    }
}
