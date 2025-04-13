package com.company.medium;

import java.util.Arrays;
import java.util.LinkedList;

public class ShortestPathInBinaryMatrix {
    public int shortestPathBinaryMatrix(int[][] grid) {
        LinkedList<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0});
        int[] next;
        int i,j;
        while (!q.isEmpty()) {
            next = q.removeFirst();
            i = next[0]; j= next[1];
            //if (i < 0 || j < 0 || i > grid.length-1 || j > grid.length-1) continue;
            if (grid[i][j] == 0 || i==j && i==grid.length-1) {
                if (i==0 && j==0) {
                    grid[i][j]=1;
                    continue;
                }

                int min = Integer.MAX_VALUE;
                int cur;
                if (i < grid.length-1 && j < grid[0].length-1)  {
                    cur = grid[i+1][j+1];
                    if (cur == 0) {
                        q.add(new int[]{i+1,j+1});
                    } else if (cur > 1) {
                        min = Math.min(cur, min);
                    }
                }
                if (i > 0 && j > 0) {
                    cur = grid[i-1][j-1];
                    if (cur == 0) {
                        q.add(new int[]{i-1, j-1});
                    } else if (cur > 1 || i==1 && j==1) {
                        min = Math.min(cur, min);
                    }
                }
                if (i > 0 && j < grid[0].length-1)  {
                    cur = grid[i-1][j+1];
                    if (cur == 0) {
                        q.add(new int[]{i-1, j+1});
                    } else if (cur > 1 || i==1 && j==1) {
                        min = Math.min(cur, min);
                    }
                }

                if (i < grid.length-1 && j > 0) {
                    cur = grid[i+1][j-1];
                    if (cur == 0) {
                        q.add(new int[]{i+1, j-1});
                    } else if (cur > 1 || i==1 && j==1) {
                        min = Math.min(cur, min);
                    }
                }

                if (i > 0 ) {
                    cur = grid[i-1][j];
                    if (cur == 0) {
                        q.add(new int[]{i-1, j});
                    } else if (cur > 1 || i==1 && j==1) {
                        min = Math.min(cur, min);
                    }
                }
                if (i < grid.length-1 ) {
                    cur = grid[i+1][j];
                    if (cur == 0) {
                        q.add(new int[]{i+1, j});
                    } else if (cur > 1 || i==1 && j==1) {
                        min = Math.min(cur, min);
                    }
                }

                if (j > 0 ){
                    cur = grid[i][j-1];
                    if (cur == 0) {
                        q.add(new int[]{i, j-1});
                    } else if (cur > 1 || i==1 && j==1) {
                        min = Math.min(cur, min);
                    }
                }
                if (j < grid[0].length-1)  {
                    cur = grid[i][j+1];
                    if (cur == 0) {
                        q.add(new int[]{i, j+1});
                    } else if (cur > 1 || i==1 && j==1) {
                        min = Math.min(cur, min);
                    }
                }

                grid[i][j] = min;
            }
        }
        //bfs(0,0, grid);
        int res = grid[grid.length-1][grid.length-1];
        if (res == 0 || res == 1&& grid.length>1) return -1;
        return res;

    }
}
