package com.company.medium;

public class RottingOranges {
    private int[][] directions = new int[][]{
            new int[]{-1, 0}, new int[]{1, 0}, new int[]{0, 1}, new int[]{0, -1}
    };

    public int orangesRotting(int[][] grid) {
        bfs(0, 0, 0, grid);
        int min = 0;
        for (int i =0 ; i< grid.length;i++) {
            for(int j=0; j<grid[0].length;j++) {
                if (grid[i][j] == 0) {
                    min = -1; break;
                }
                if (grid[i][j] > min) min = grid[i][j];
            }
        }
        return min;
    }

    private void bfs(int x, int y, int cnt, int[][] grid) {
        if (grid[x][y] == 1 || x==0&&y==0&&grid[x][y]==2) {
            grid[x][y] = cnt;
            for (int[] dir : directions) {
                if (dir[0] + x < 0 || dir[0] + x > grid.length || dir[1] + y < 0 || dir[1] + y > grid[0].length) {
                    continue;
                }
                bfs(x+dir[0], y+dir[1], cnt+1, grid);
            }
        }
    }
}
