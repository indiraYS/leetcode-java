package com.company.graph.findifpathexist;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
public class BFSSolution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        int prev = -1;
        boolean[] visited = new boolean[n];
        LinkedList<List<Integer>> queue = new LinkedList<>();
        List<Integer>[] adj = new List[n];

        List<Integer> lnk;
        for (int i=0; i < edges.length; i++) {
            lnk = adj[edges[i][0]];
            if (lnk == null) {
                lnk = new ArrayList<Integer>();
                lnk.add(edges[i][1]);
                adj[edges[i][0]] = lnk;
            } else {
                lnk.add(edges[i][1]);
            }


            lnk = adj[edges[i][1]];
            if (lnk == null) {
                lnk = new ArrayList<Integer>();
                lnk.add(edges[i][0]);
                adj[edges[i][1]] = lnk;
            } else {
                lnk.add(edges[i][0]);
            }
        }


        List<Integer> path;
        List<Integer> npath;
        int next;
        npath = new ArrayList<Integer>();
        npath.add(source);
        queue.add (npath);

        while (!queue.isEmpty()) {
            path =  queue.poll();
            if (path.contains(destination)) return true;
            next = path.get(path.size()-1);

            if (visited[next]) continue;

            lnk = adj[next];
            if (lnk != null) {
                for (int i = 0; i < lnk.size() ; i++) {
                    //if (lnk[i]) continue;
                    if (path.contains(lnk.get(i))) continue;
                    npath = new ArrayList<Integer>(path);
                    npath.add(lnk.get(i));
                    queue.add(npath);
                }
            }
            visited[next] = true;
        }
        return false;
    }
}
