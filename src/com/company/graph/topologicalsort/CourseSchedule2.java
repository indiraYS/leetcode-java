package com.company.graph.topologicalsort;

import java.util.*;

public class CourseSchedule2 {
    private int[] used;
    private int[] path;
    private int offset = 0;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        this.path = new int[numCourses];
        if (prerequisites.length > 0) {
            List<Integer>[] dependencies;

            this.offset = 0;
            this.used = new int[numCourses];

            dependencies = new List[numCourses];
            // todo use another structure instead this
            List<Integer> lnk;
            for (int[] pr : prerequisites) {
                lnk = dependencies[pr[0]];
                if (lnk == null) {
                    lnk = new ArrayList<Integer>();
                    dependencies[pr[0]] = lnk;
                }
                lnk.add(pr[1]);
            }

            for (int i = 0; i < numCourses; i++) {
                if (!walk(i, i, new boolean[numCourses], dependencies)) {
                    return new int[0];
                }
            }
            for (int i = 0; i < numCourses; i++) {
                if (used[i] == 0) {
                    this.path[this.offset++] = i;
                }
            }
        } else {
            for (int i = 0; i < numCourses; i++) {
                this.path[i] = i;
            }
        }
        return this.path;
    }

    private boolean walk(int node, int from, boolean[] visited,  List<Integer>[] dependencies) {
        if (this.used[node] == 0) {
            if (visited[node]) {
                return false;
            }
        } else {
            return true;
        }


        visited[node] = true;
        int left = 0;

        if (dependencies[node] != null) {
            for (int nextDest : dependencies[node]) {
                if (this.used[nextDest] != 1) {
                    if (!walk(nextDest, node, visited, dependencies)) {
                        return false;
                    }
                    left++;
                }
            }
        }

        if (left == 0 && this.used[node] == 0) {
            this.path[this.offset++] = node;
            this.used[node] = 1;

            if (from != node && this.used[from] == 0) {
                int ll = 0;
                for (int nextDest : dependencies[from]) {
                    if (this.used[nextDest] == 0) {
                        ll++;
                    }
                }

                if (ll == 0) {
                    this.path[this.offset++] = from;
                    this.used[from] = 1;
                }
            }
        }


        return true;
    }
}
